package com.practice.demo.profileMatch

import com.example.shaadidemoapp.models.response.UserResult


class MatchProfileContract{

    data class ProfileUiState(
        val profile: UserResult,
        val interactionStatus: InteractionStatus = InteractionStatus.NONE
    )

    enum class InteractionStatus { NONE, ACCEPTED, DECLINED }
}