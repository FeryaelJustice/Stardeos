package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.stardeos.stardeos.data.provider.local.SettingsSharedPreferences
import com.stardeos.stardeos.ui.navigation.editProfileScreenNavName
import com.stardeos.stardeos.ui.viewmodel.stardeos.EditProfileViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun EditProfileScreen(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    viewModel: EditProfileViewModel,
    settingsSharedPreferences: SettingsSharedPreferences
) {
    val context = LocalContext.current
    Text(text = editProfileScreenNavName(context))
}