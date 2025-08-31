package com.example.shaadidemoapp.dashboard.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shaadidemoapp.models.response.UserResult
import com.example.shaadidemoapp.network.MainRepository
import com.practice.demo.db.MatchProfileRepository
import com.practice.demo.db.ProfileEntity
import com.practice.demo.profileMatch.MatchProfileContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchProfileViewModel(
    private val repository: MainRepository
) : ViewModel() {
    private val pageSize = 10

    val matches: LiveData<List<ProfileEntity>>
        get() = repository.matches

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsers(pageSize)
        }
    }


    fun updateInteraction(uuid: String, status: MatchProfileContract.InteractionStatus) {
        viewModelScope.launch {
            repository.updateInteractionStatus(uuid, status)
        }
    }


}