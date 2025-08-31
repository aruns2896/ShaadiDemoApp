package com.example.shaadidemoapp.network

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shaadidemoapp.models.response.UserResult
import com.example.shaadidemoapp.utils.toEntity
import com.example.shaadidemoapp.utils.toProfileUiState
import com.practice.demo.db.MatchProfileRepository
import com.practice.demo.db.ProfileEntity
import com.practice.demo.profileMatch.MatchProfileContract
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val repo: MatchProfileRepository
) {

    private val matchesLiveData = MutableLiveData<List<ProfileEntity>>()
    var state by mutableStateOf(MatchProfileContract.state())

    val matches: LiveData<List<ProfileEntity>>
        get() = matchesLiveData

    suspend fun getUsers(
        count: Int
    ) {
        try {
            state = state.copy(isLoading = true)

            val response = apiService.getUsers(count = count)

            if (response.isSuccessful) {
                val apiProfiles = response.body()?.results ?: emptyList()
                val entities = apiProfiles.map { it.toEntity() }
                matchesLiveData.postValue(entities)

                repo.insertProfiles(entities)

            } else {
                state = state.copy(
                    error = true,
                    errorMessage = "Error fetching data: ${response.message()}",
                    isLoading = false
                )
            }

        } catch (e: Exception) {
            val cached = repo.getProfilesFromDb()
            if (cached.isNotEmpty()) {
                state = state.copy(
                    listOfProfile = cached.map { it.toProfileUiState() },
                    isLoading = false,
                    error = false
                )
                matchesLiveData.postValue(cached)
            } else {
                state = state.copy(
                    error = true,
                    errorMessage = "Something went wrong, please try again",
                    isLoading = false
                )
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

        state = state.copy(
            listOfProfile = state.listOfProfile.map {
                if (it.profile.login?.uuid == uuid) it.copy(interactionStatus = status)
                else it
            }
        )
    }

}