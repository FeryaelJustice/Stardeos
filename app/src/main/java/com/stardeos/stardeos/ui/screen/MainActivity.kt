package com.stardeos.stardeos.ui.screen

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.stardeos.stardeos.ui.navigation.NavigationHost
import com.stardeos.stardeos.ui.navigation.Screen
import com.stardeos.stardeos.ui.navigation.navigateTo
import com.stardeos.stardeos.ui.theme.StardeosTheme
import com.stardeos.stardeos.ui.util.LockScreenOrientation
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

// DataStore data
const val DB_NAME = "settings"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DB_NAME)
val KEY_ISLOGGED = booleanPreferencesKey("isLogged")
val KEY_ISDARKTHEME = booleanPreferencesKey("isDarkTheme")

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

            // App ViewModel init
            val stardeosViewModel: StardeosViewModel by viewModels()
            val context = LocalContext.current

            // App (nav, state, scope and controllers)
            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            // Dark Theme init State Holder across the App
            val darkMode = rememberSaveable { mutableStateOf(false) }

            // Observe theme configChanges from viewModel
            stardeosViewModel.darkTheme.observe(this, { isDarkTheme ->
                isDarkTheme?.let {
                    darkMode.value = isDarkTheme
                    Log.d("night", "DarkMode observer:${darkMode.value}")
                }
            })
            stardeosViewModel.state.observe(this, { state ->
                state?.let {
                    Log.d("logged", "Logged observer:${it.logged}")
                    CoroutineScope(Dispatchers.IO).launch {
                        dbSetLogged(context, it.logged)
                    }
                }
            })

            val isInDarkMode = isSystemInDarkTheme() // Check theme by system (not apply)
            lifecycleScope.launchWhenCreated {
                // CHECKS
                // Theme
                val isDarkTheme = dbIsDarkTheme(context)
                var userChangedTheme = false
                // If localstorage has not null value, user changed the theme, initialize theme state with localStorage
                isDarkTheme.let {
                    darkMode.value = it
                    userChangedTheme = true
                }
                // Initialize theme state with system theme check
                if (!userChangedTheme) {
                    darkMode.value = isInDarkMode
                }
                // Save theme mode (by system or user) into local storage and view model
                dbSetIsDarkTheme(context, darkMode.value)
                stardeosViewModel.setDarkTheme(darkMode.value)

                // Check logged
                val isLogged = dbIsLogged(context)
                isLogged.let { logged ->
                    if (logged) {
                        navigateTo(navController, Screen.Trends.route)
                        stardeosViewModel.setStateLogged(true)
                    }
                }
            }

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


// DataStore

suspend fun dbIsLogged(context: Context): Boolean {
    var isLogged = false
    val flow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[KEY_ISLOGGED] ?: false
    }
    flow.collectLatest {
        isLogged = it
    }
    return isLogged
}

suspend fun dbSetLogged(context: Context, isLogged: Boolean) {
    context.dataStore.edit { settings ->
        settings[KEY_ISLOGGED] = isLogged
    }
}

suspend fun dbIsDarkTheme(context: Context): Boolean {
    var isDarkTheme = false
    val flow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[KEY_ISDARKTHEME] ?: false
    }
    flow.collectLatest {
        isDarkTheme = it
    }
    return isDarkTheme
}

suspend fun dbSetIsDarkTheme(context: Context, isDarkTheme: Boolean) {
    context.dataStore.edit { settings ->
        settings[KEY_ISDARKTHEME] = isDarkTheme
    }
}

// Read
/*
val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
val exampleCounterFlow: Flow<Int> = context.dataStore.data
  .map { preferences ->
    // No type safety.
    preferences[EXAMPLE_COUNTER] ?: 0
}
 */

// Write
/*
suspend fun incrementCounter() {
  context.dataStore.edit { settings ->
    val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
    settings[EXAMPLE_COUNTER] = currentCounterValue + 1
  }
}
 */