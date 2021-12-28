package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.stardeos.stardeos.data.provider.local.SettingsSharedPreferences
import com.stardeos.stardeos.ui.navigation.Screen
import com.stardeos.stardeos.ui.navigation.configScreenNavName
import com.stardeos.stardeos.ui.util.StardeosButtonColors
import com.stardeos.stardeos.ui.viewmodel.stardeos.ConfigViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun ConfigScreen(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    viewModel: ConfigViewModel,
    settingsSharedPreferences: SettingsSharedPreferences
) {
    Text(text = configScreenNavName)
    Button(
        colors = StardeosButtonColors(),
        onClick = { navController.navigate(Screen.Preferences.route) }) {
        Text(text = "Preferences")
    }
}