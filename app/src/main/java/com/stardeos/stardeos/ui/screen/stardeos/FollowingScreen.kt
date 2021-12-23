package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.stardeos.stardeos.ui.navigation.followingScreenNavName
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import com.stardeos.stardeos.ui.viewmodel.stardeos.FollowingViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun FollowingScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel,
    viewModel: FollowingViewModel
) {
    Text(text = followingScreenNavName)
}