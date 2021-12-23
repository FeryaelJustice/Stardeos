package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.stardeos.stardeos.ui.navigation.videoScreenNavName
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import com.stardeos.stardeos.ui.viewmodel.stardeos.VideoViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun VideoScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel,
    viewModel: VideoViewModel
) {
    Text(text = videoScreenNavName)
}