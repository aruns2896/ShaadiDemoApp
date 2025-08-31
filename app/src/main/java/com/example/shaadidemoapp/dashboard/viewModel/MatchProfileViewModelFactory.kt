package com.example.shaadidemoapp.dashboard.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shaadidemoapp.network.MainRepository
import com.practice.demo.db.MatchProfileRepository

class MatchProfileViewModelFactory(
    private val repository: MainRepository,
    private val repo: MatchProfileRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MatchProfileViewModel(repository, repo) as T
    }
}