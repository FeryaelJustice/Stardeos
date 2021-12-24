package com.stardeos.stardeos.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import coil.annotation.ExperimentalCoilApi
import com.stardeos.stardeos.ui.screen.app.LoginScreen
import com.stardeos.stardeos.ui.screen.app.RecoverPasswordScreen
import com.stardeos.stardeos.ui.screen.app.RegisterScreen
import com.stardeos.stardeos.ui.screen.app.SplashScreen
import com.stardeos.stardeos.ui.screen.stardeos.*
import com.stardeos.stardeos.R
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import kotlinx.coroutines.CoroutineScope

// MAIN NAVIGATION
@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun NavigationHost(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel
) {
    // Current destination
    val currentDestination = currentDestination(navController)
    if ((currentDestination?.route == Screen.Trends.route) || (currentDestination?.route == Screen.Following.route) || (currentDestination?.route == Screen.EditProfile.route)) {
        Scaffold(scaffoldState = scaffoldState, topBar = {
            StardeosTopBar(navController = navController, stardeosViewModel = stardeosViewModel)
        }, bottomBar = {
            StardeosBottomNav(
                items = stardeosBottomNavItems(),
                navController = navController,
                onItemClick = {
                    // Prevent recreating the screen if we are already in it
                    if (currentDestination.route != it.route) {
                        navController.navigate(it.route)
                    }
                })
        }, backgroundColor = MaterialTheme.colors.background) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = stardeos,
                modifier = Modifier.padding(innerPadding)
            ) {
                graph(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    scope = scope,
                    stardeosViewModel = stardeosViewModel
                )
            }
        }
    } else if (currentDestination?.route == Screen.Video.route) {
        Scaffold(scaffoldState = scaffoldState, topBar = {
            StardeosTopBar(navController = navController, stardeosViewModel = stardeosViewModel)
        }, backgroundColor = MaterialTheme.colors.background) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = stardeos,
                modifier = Modifier.padding(innerPadding)
            ) {
                graph(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    scope = scope,
                    stardeosViewModel = stardeosViewModel
                )
            }
        }
    } else if (currentDestination?.route == Screen.Config.route) {
        Scaffold(scaffoldState = scaffoldState, topBar = {
            StardeosSecondaryTopBar(
                navController = navController,
                screenName = configScreenNavName,
                stardeosViewModel = stardeosViewModel
            )
        }, backgroundColor = MaterialTheme.colors.background) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = stardeos,
                modifier = Modifier.padding(innerPadding)
            ) {
                graph(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    scope = scope,
                    stardeosViewModel = stardeosViewModel
                )
            }
        }
    } else if (currentDestination?.route == Screen.Preferences.route) {
        Scaffold(scaffoldState = scaffoldState, topBar = {
            StardeosSecondaryTopBar(
                navController = navController,
                screenName = preferencesScreenNavName,
                stardeosViewModel = stardeosViewModel
            )
        }, backgroundColor = MaterialTheme.colors.background) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = stardeos,
                modifier = Modifier.padding(innerPadding)
            ) {
                graph(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    scope = scope,
                    stardeosViewModel = stardeosViewModel
                )
            }
        }
    } else {
        Scaffold(
            scaffoldState = scaffoldState,
            backgroundColor = MaterialTheme.colors.background
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = stardeos,
                modifier = Modifier.padding(innerPadding)
            ) {
                graph(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    scope = scope,
                    stardeosViewModel = stardeosViewModel
                )
            }
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalCoilApi
fun NavGraphBuilder.graph(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel
) {
    navigation(startDestination = Screen.Splash.route, route = stardeos) {
        composable(route = Screen.Splash.route) {
            SplashScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.Login.route) {
            LoginScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.Register.route) {
            RegisterScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.RecoverPassword.route) {
            RecoverPasswordScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
    }
    navigation(startDestination = Screen.Trends.route, route = app) {
        composable(route = Screen.Trends.route) {
            TrendsScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.Following.route) {
            FollowingScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.EditProfile.route) {
            EditProfileScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.Video.route) {
            VideoScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.Search.route) {
            SearchScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.Config.route) {
            ConfigScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
        composable(route = Screen.Preferences.route) {
            PreferencesScreen(
                scaffoldState = scaffoldState,
                navController = navController,
                scope = scope,
                stardeosViewModel = stardeosViewModel,
                viewModel = viewModel()
            )
        }
    }
}

// Navigations
@Composable
fun currentDestination(navController: NavHostController): NavDestination? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination
}

fun navigateTo(
    currentDestination: NavDestination?,
    navController: NavHostController,
    navigateToRoute: String
) {
    if (currentDestination?.route != navigateToRoute) {
        navController.navigate(navigateToRoute) {
            // Clear backstack
            popUpTo(0)
            launchSingleTop = true
        }
    }
}

fun navigateTo(navController: NavHostController, navigateTo: String){
    navController.navigate(navigateTo) {
        // Clear backstack
        popUpTo(0)
        launchSingleTop = true
    }
}

// TopBar
@Composable
fun StardeosTopBar(navController: NavHostController, stardeosViewModel: StardeosViewModel) {
    val currentDestination = currentDestination(navController)
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.stardeos_banner_nologo),
                contentDescription = "Banner",
                modifier = Modifier
                    .clickable {
                        navigateTo(currentDestination, navController, Screen.Trends.route)
                    }
            )
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.stardeos),
                contentDescription = "Logo",
                modifier = Modifier
                    .clickable {
                        navigateTo(currentDestination, navController, Screen.Trends.route)
                    }
            )
        },
        elevation = 12.dp,
        actions = {
            if (currentDestination?.route != Screen.Video.route) {
                IconButton(onClick = { navController.navigate(Screen.Search.route) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }

                Image(
                    painter = painterResource(R.drawable.stardeos),
                    contentDescription = "ProfileIcon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(
                            1.dp,
                            MaterialTheme.colors.surface, CircleShape
                        )
                        .clickable {
                            navController.navigate(Screen.Config.route)
                        }
                )

                /*IconButton(onClick = { navController.navigate(Screen.Config.route) }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "ProfileIcon",
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(
                                2.dp,
                                Color.Black, CircleShape
                            )
                    )
                }*/

            }
        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Composable
fun StardeosSecondaryTopBar(
    navController: NavHostController,
    screenName: String,
    stardeosViewModel: StardeosViewModel
) {
    val currentDestination = currentDestination(navController)
    TopAppBar(
        title = {
            Text(text = screenName)
        },
        navigationIcon = {
            IconButton(onClick = {
                when (currentDestination?.route) {
                    Screen.Config.route -> {
                        navigateTo(currentDestination, navController, Screen.Trends.route)
                    }
                    Screen.Preferences.route -> {
                        navigateTo(currentDestination, navController, Screen.Config.route)
                    }
                    else -> {
                        navigateTo(currentDestination, navController, Screen.Trends.route)
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        elevation = 12.dp,
        actions = {
            if (currentDestination?.route == Screen.Config.route) {
                Text(
                    text = signOut,
                    modifier = Modifier.clickable {
                        stardeosViewModel.setStateLogged(false)
                        navController.navigate(Screen.Login.route) {
                            // Clear backstack
                            popUpTo(0)
                            launchSingleTop = true
                        }
                        // SharedPreferences logout
                    })
            }
        },
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.primary
    )
}

// BottomNavigation
data class StardeosBottomNavItem(val name: String, val route: String, val icon: ImageVector)

@Composable
fun StardeosBottomNav(
    items: List<StardeosBottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (StardeosBottomNavItem) -> Unit
) {
    val currentDestination = currentDestination(navController)
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 12.dp
    ) {
        items.forEach { item ->
            val selected = item.route == currentDestination?.route ?: false
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.secondaryVariant,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(imageVector = item.icon, contentDescription = item.name)
                        if (selected) {
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }
                    }
                }
            )
        }
    }
}

fun stardeosBottomNavItems(): List<StardeosBottomNavItem> {
    return listOf(
        StardeosBottomNavItem(
            name = trendsScreenNavName,
            route = trendsScreen,
            Icons.Default.Favorite
        ),
        StardeosBottomNavItem(
            name = followingScreenNavName,
            route = followingScreen,
            Icons.Default.Face
        ),
        StardeosBottomNavItem(
            name = editProfileScreenNavName,
            route = editProfileScreen,
            Icons.Default.Person
        )
    )
}