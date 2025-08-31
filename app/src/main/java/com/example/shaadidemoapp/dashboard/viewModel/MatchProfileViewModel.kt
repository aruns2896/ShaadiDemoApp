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
    private val repository: MainRepository,
    private val repo: MatchProfileRepository
) : ViewModel() {

    var state by mutableStateOf(MatchProfileContract.state())
    private var currentPage = 1
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


    fun smartTruncate(text: String?, desiredPrefixLength: Int, maxLengthWithEllipsis: Int): String {
        if (text == null) return ""
        if (desiredPrefixLength < 0 || maxLengthWithEllipsis < 0) throw IllegalArgumentException("Lengths cannot be negative")
        if (maxLengthWithEllipsis < 3 && text.length > maxLengthWithEllipsis) return "...".take(
            maxLengthWithEllipsis
        ) // Edge case: max length too small for ellipsis
        if (maxLengthWithEllipsis < 3) return text.take(maxLengthWithEllipsis)


        if (text.length <= maxLengthWithEllipsis) {
            return text // Fits entirely
        }

        // Try to keep the desired prefix
        val prefix = text.take(desiredPrefixLength)

        if (prefix.length + 3 <= maxLengthWithEllipsis) { // Prefix + "..." fits
            // Check if the original string was actually longer than the prefix
            if (text.length > prefix.length) {
                return prefix + "..."
            } else {
                return prefix // Original string was just the prefix
            }
        } else {
            // Prefix + "..." doesn't fit, so truncate to maxLengthWithEllipsis - 3 and add "..."
            if (maxLengthWithEllipsis <= 3) return "...".take(maxLengthWithEllipsis) // Not enough space even for "..."
            return text.take(maxLengthWithEllipsis - 3) + "..."
        }
    }


}