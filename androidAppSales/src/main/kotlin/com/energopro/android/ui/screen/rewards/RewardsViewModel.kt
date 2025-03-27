package com.energopro.android.ui.screen.rewards

import com.energopro.android.tools.arch.BaseViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class RewardsViewModel(
    override val viewState: RewardsViewState,
) : BaseViewModel<RewardsViewState>(), Rewards.Actions {
    override fun onNavigateBack() {
        sendEvent(NavigateBackEvent)
    }
    
    override fun onRewardItemSelected(itemId: String) {
        sendEvent(RewardItemSelectedEvent(itemId))
    }
} 