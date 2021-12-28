package com.stardeos.stardeos.ui.screen

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.stardeos.stardeos.data.provider.local.SettingsSharedPreferences
import com.stardeos.stardeos.ui.navigation.NavigationHost
import com.stardeos.stardeos.ui.theme.StardeosTheme
import com.stardeos.stardeos.ui.util.LockScreenOrientation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var settingsSharedPreferences: SettingsSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Skip reinitialization phoenix
            /*
            if (ProcessPhoenix.isPhoenixProcess(this)) {
                return@setContent;
            }
             */

            // App (nav, state, scope and controllers)
            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()

            // STARDEOS APP
            StardeosTheme(
                useDarkTheme = settingsSharedPreferences.getBoolean(
                    SettingsSharedPreferences.isDarkThemeKey
                ), content = {
                    // Lock screen to portrait orientation
                    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                    // App
                    NavigationHost(
                        scaffoldState = scaffoldState,
                        navController = navController,
                        scope = scope,
                        settingsSharedPreferences = settingsSharedPreferences
                    )
                })
        }
    }
}