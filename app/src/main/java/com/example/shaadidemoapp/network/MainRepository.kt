package com.example.shaadidemoapp.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shaadidemoapp.utils.toEntity
import com.practice.demo.db.MatchProfileRepository
import com.practice.demo.db.ProfileEntity
import com.practice.demo.profileMatch.MatchProfileContract
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val repo: MatchProfileRepository
) {

    private val matchesLiveData = MutableLiveData<List<ProfileEntity>>()

    private var isError = false
    private var errorMessage = ""

    val matches: LiveData<List<ProfileEntity>>
        get() = matchesLiveData

    suspend fun getUsers(
        count: Int
    ) {
        try {
            val response = apiService.getUsers(count = count)
            if (response.isSuccessful) {
                isError = false
                val apiProfiles = response.body()?.results ?: emptyList()
                val entities = apiProfiles.map { it.toEntity() }
                matchesLiveData.postValue(entities)

                repo.insertProfiles(entities)

            } else {
                isError = true
                errorMessage = "Failed while fetching data: ${response.message()}"
            }

        } catch (e: Exception) {
            val cached = repo.getProfilesFromDb()
            if (cached.isNotEmpty()) {
                isError = false
                matchesLiveData.postValue(cached)
            } else {
                isError = true;
                errorMessage =
                    "No offline data available, please turn on your internet and try again"
            }
        }
    }

    suspend fun updateInteractionStatus(
        uuid: String,
        status: MatchProfileContract.InteractionStatus
    ) {
        repo.updateInteraction(uuid, status)

        matchesLiveData.postValue(matchesLiveData.value?.map {
            if (it.uuid == uuid)
                it.copy(interactionStatus = status)
            else it
        })
    }

}