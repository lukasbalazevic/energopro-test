package com.energopro.android.ui.screen.rewards

import app.futured.arkitekt.core.event.Event

sealed class RewardsEvent : Event<RewardsViewState>()
data object NavigateBackEvent : RewardsEvent()
data class RewardItemSelectedEvent(val itemId: String) : RewardsEvent() 