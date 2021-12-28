package com.stardeos.stardeos.ui.navigation

import android.content.Context
import androidx.annotation.StringRes
import com.stardeos.stardeos.R

// ALL INSIDE A MAIN ACTIVITY Kotlin Class Container
// NOTE: fun for variable international adaptation, const val ROUTERS for internal names

// Providing common names for navigation:
// NESTED

// "stardeos"
const val stardeos = "stardeos"
const val app = "app"

// SCREENS

// MAIN
const val splashScreenRoute = "splashScreen"
const val loginScreenRoute = "loginScreen"
fun logoutText(context: Context) = context.getString(R.string.logout)
const val registerScreenRoute = "registerScreen"
const val recoverPasswordScreenRoute = "recoverPasswordScreen"

// APP SCREENS
// Videos screen (main in-app)
const val trendsScreenRoute = "trendsScreen"
fun trendsScreenNavName(context: Context) = context.getString(R.string.trendsScreenNavName)

// Following (user or creator)
const val followingScreenRoute = "followingScreen"
fun followingScreenNavName(context: Context) = context.getString(R.string.followingScreenNavName)

// Edit Profile (user or creator)
const val editProfileScreenRoute = "editProfileScreen"
fun editProfileScreenNavName(context: Context) =
    context.getString(R.string.editProfileScreenNavName)

// Video screen
const val videoScreenRoute = "videoScreen"
fun videoScreenNavName(context: Context) = context.getString(R.string.videoScreenNavName)

// Search screen
const val searchScreenRoute = "searchScreen"
fun searchScreenNavName(context: Context) = context.getString(R.string.searchScreenNavName)

// Config screen (container for preferencesScreen and editProfileScreen)
const val configScreenRoute = "configScreen"
fun configScreenNavName(context: Context) = context.getString(R.string.configScreenNavName)

// Preferences screen (app related, not user)
const val preferencesScreenRoute = "preferencesScreen"
fun preferencesScreenNavName(context: Context) =
    context.getString(R.string.preferencesScreenNavName)

// STILL NOT USED
/*
// Edit Channel (creator)
fun editChannelScreenRoute(context: Context) = "editChannelScreen"
// Creator profile screen (channel)
fun channelScreenRoute(context: Context) = "channelScreen"
// User profile screen (no creator)
fun profileScreenRoute(context: Context) = "profileScreen"
*/


// SCREEN ROUTES
// resourceId: Can be used for BottomNavigation (optional)
sealed class Screen(val route: String, @StringRes val resourceId: Int?) {

    // Stardeos
    object Splash : Screen(splashScreenRoute, R.string.splashScreen)
    object Login : Screen(loginScreenRoute, R.string.loginScreen)
    object Register : Screen(registerScreenRoute, R.string.registerScreen)
    object RecoverPassword : Screen(recoverPasswordScreenRoute, R.string.recoverPasswordScreen)

    // App
    object Trends : Screen(trendsScreenRoute, R.string.trendsScreen)
    object Following : Screen(followingScreenRoute, R.string.followingScreen)
    object EditProfile : Screen(editProfileScreenRoute, R.string.editProfileScreen)
    object Video : Screen(videoScreenRoute, R.string.videoScreen)
    object Search : Screen(searchScreenRoute, R.string.searchScreen)
    object Config : Screen(configScreenRoute, R.string.configScreen)
    object Preferences : Screen(preferencesScreenRoute, R.string.preferencesScreen)

    // Still unused
    /*
    object EditChannel : Screen(editChannelScreen, R.string.editChannelScreen)
    object Channel : Screen(channelScreen, R.string.channelScreen)
    object Profile : Screen(profileScreen, R.string.profileScreen)
    */
}