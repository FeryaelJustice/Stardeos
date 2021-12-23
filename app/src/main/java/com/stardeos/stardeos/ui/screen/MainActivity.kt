package com.stardeos.stardeos.ui.screen

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.Observer
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.stardeos.stardeos.ui.navigation.NavigationHost
import com.stardeos.stardeos.ui.theme.StardeosTheme
import com.stardeos.stardeos.ui.util.LockScreenOrientation
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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

            // App View model
            val stardeosViewModel: StardeosViewModel by viewModels()
            //val darkMode by stardeosViewModel.darkTheme.observeAsState(false)
            val darkMode = rememberSaveable { mutableStateOf(false) }
            stardeosViewModel.darkTheme.observe(this, {
                it?.let {
                    darkMode.value = it
                    Log.d("night","DarkMode observer:${darkMode.value}")
                }
            })
            // Initialize with current theme mode
            stardeosViewModel.setDarkTheme(isSystemInDarkTheme())

            // STARDEOS APP
            StardeosTheme(useDarkTheme = darkMode.value, content = {
                // Lock screen to portrait orientation
                LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                // App
                NavigationHost(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    scope = scope,
                    stardeosViewModel = stardeosViewModel
                )
            })
        }
    }
}