package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.stardeos.stardeos.data.provider.local.SettingsSharedPreferences
import com.stardeos.stardeos.ui.navigation.preferencesScreenNavName
import com.stardeos.stardeos.ui.util.StardeosButtonColors
import com.stardeos.stardeos.ui.viewmodel.stardeos.PreferencesViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun PreferencesScreen(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    viewModel: PreferencesViewModel,
    settingsSharedPreferences: SettingsSharedPreferences
) {
    val context = LocalContext.current
    val isDarkTheme = settingsSharedPreferences.getBoolean(SettingsSharedPreferences.isDarkThemeKey)
    val theme = if (isDarkTheme) "Night Mode" else "Light Mode"
    Row {
        Button(colors = StardeosButtonColors(), onClick = {
            settingsSharedPreferences.setBoolean(
                SettingsSharedPreferences.isDarkThemeKey,
                isDarkTheme
            )
            //ProcessPhoenix.triggerRebirth(context)
        }) {
            Text(text = "Toggle Theme")
        }
        Text(text = "${preferencesScreenNavName(context = context)}: Current theme -> $theme")
    }


}