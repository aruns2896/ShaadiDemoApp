package com.practice.demo.profileMatch

import com.example.shaadidemoapp.models.response.UserResult


class MatchProfileContract{

    data class state(
        val listOfProfile: List<ProfileUiState> = emptyList(),
        val isLoading: Boolean = false,
        val error: Boolean = false,
        val errorMessage: String = "",
        val userInteractions: Map<String, InteractionStatus> = emptyMap()
    )

    data class ProfileUiState(
        val profile: UserResult,
        val interactionStatus: InteractionStatus = InteractionStatus.NONE
    )

    enum class InteractionStatus { NONE, ACCEPTED, DECLINED }
}