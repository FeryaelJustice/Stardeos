package com.stardeos.stardeos.ui.navigation

import androidx.annotation.StringRes
import com.stardeos.stardeos.R

// ALL INSIDE A MAINACTIVITY Kotlin Class Container

// NESTED

const val stardeos = "stardeos"
const val app = "app"

// SCREENS

// MAIN
const val splashScreen = "splashScreen"
const val loginScreen = "loginScreen"
const val signOut = "Sign Out"
const val registerScreen = "registerScreen"
const val recoverPasswordScreen = "recoverPasswordScreen"

// APP SCREENS
// Videos screen (main in-app)
const val trendsScreen = "trendsScreen"
const val trendsScreenNavName = "Trends"

// Following (user or creator)
const val followingScreen = "followingScreen"
const val followingScreenNavName = "Following"

// Edit Profile (user or creator)
const val editProfileScreen = "editProfileScreen"
const val editProfileScreenNavName = "Profile"

// Video screen
const val videoScreen = "videoScreen"
const val videoScreenNavName = "Video"

// Search screen
const val searchScreen = "searchScreen"
const val searchScreenNavName = "Search"

// Config screen (container for preferencesScreen and editProfileScreen)
const val configScreen = "configScreen"
const val configScreenNavName = "Config"

// Preferences screen (app related, not user)
const val preferencesScreen = "preferencesScreen"
const val preferencesScreenNavName = "Preferences"

// STILL NOT USED
/*
// Edit Channel (creator)
const val editChannelScreen = "editChannelScreen"
// Creator profile screen (channel)
const val channelScreen = "channelScreen"
// User profile screen (no creator)
const val profileScreen = "profileScreen"
*/

// resourceId: For BottomNavigation
sealed class Screen(val route: String, @StringRes val resourceId: Int?) {

    // Stardeos
    object Splash : Screen(splashScreen, R.string.splashScreen)
    object Login : Screen(loginScreen, R.string.loginScreen)
    object Register : Screen(registerScreen, R.string.registerScreen)
    object RecoverPassword : Screen(recoverPasswordScreen, R.string.recoverPasswordScreen)

    // App
    object Trends : Screen(trendsScreen, R.string.trendsScreen)
    object Following : Screen(followingScreen, R.string.followingScreen)
    object EditProfile : Screen(editProfileScreen, R.string.editProfileScreen)
    object Video : Screen(videoScreen, R.string.videoScreen)
    object Search : Screen(searchScreen, R.string.searchScreen)
    object Config : Screen(configScreen, R.string.configScreen)
    object Preferences : Screen(preferencesScreen, R.string.preferencesScreen)

    // Still unused
    /*
    object EditChannel : Screen(editChannelScreen, R.string.editChannelScreen)
    object Channel : Screen(channelScreen, R.string.channelScreen)
    object Profile : Screen(profileScreen, R.string.profileScreen)
    */
}