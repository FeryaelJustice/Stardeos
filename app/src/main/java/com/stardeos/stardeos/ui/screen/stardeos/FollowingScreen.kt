package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.stardeos.stardeos.data.provider.local.SettingsSharedPreferences
import com.stardeos.stardeos.ui.navigation.followingScreenNavName
import com.stardeos.stardeos.ui.viewmodel.stardeos.FollowingViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun FollowingScreen(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    viewModel: FollowingViewModel,
    settingsSharedPreferences: SettingsSharedPreferences
) {
    Text(text = followingScreenNavName)
}