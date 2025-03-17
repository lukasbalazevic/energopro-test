package com.energopro.android.ui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.energopro.android.ui.screen.ProfileScreenUi
import com.energopro.android.ui.screen.ThirdScreenUi
import com.energopro.feature.navigation.profile.ProfileChild
import com.energopro.feature.navigation.profile.ProfileConfig
import com.energopro.feature.navigation.profile.ProfileNavHost
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.androidPredictiveBackAnimatable
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.router.stack.ChildStack

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun ProfileNavHostUi(
    navHost: ProfileNavHost,
    modifier: Modifier = Modifier,
) {
    val stack: ChildStack<ProfileConfig, ProfileChild> by navHost.stack.collectAsStateWithLifecycle()
    val actions = navHost.actions

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.navigationBars,
        content = { paddings ->
            Children(
                stack = stack,
                modifier = Modifier.padding(paddings),
                animation = predictiveBackAnimation(
                    backHandler = navHost.backHandler,
                    onBack = actions::pop,
                    selector = { backEvent, _, _ -> androidPredictiveBackAnimatable(backEvent) },
                ),
            ) { child ->
                when (val childInstance = child.instance) {
                    is ProfileChild.Profile -> ProfileScreenUi(screen = childInstance.screen, modifier = Modifier.fillMaxSize())
                    is ProfileChild.Third -> ThirdScreenUi(screen = childInstance.screen, modifier = Modifier.fillMaxSize())
                }
            }
        },
    )
}
