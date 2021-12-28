package com.stardeos.stardeos.ui.screen.app

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stardeos.stardeos.R
import com.stardeos.stardeos.data.provider.local.SettingsSharedPreferences
import com.stardeos.stardeos.ui.navigation.Screen
import com.stardeos.stardeos.ui.navigation.navigateToClearingBackstack
import com.stardeos.stardeos.ui.navigation.trendsScreen
import com.stardeos.stardeos.ui.util.StardeosButtonColors
import com.stardeos.stardeos.ui.viewmodel.app.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    viewModel: LoginViewModel,
    settingsSharedPreferences: SettingsSharedPreferences
) {
    val context = LocalContext.current
    checkIsLogged(settingsSharedPreferences, navController)
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(1) {
            var email by rememberSaveable { mutableStateOf("Email") }
            var password by rememberSaveable { mutableStateOf("Password") }
            Image(
                painter = painterResource(id = R.drawable.stardeos),
                contentDescription = "",
                modifier = Modifier
                    .scale(1.5f)
                    .padding(40.dp)
            )
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text(text = stringResource(id = R.string.email)) }
            )
            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text(text = stringResource(id = R.string.password)) }
            )
            Button(colors = StardeosButtonColors(), onClick = {
                if (checkCredentials(email, password)) {
                    navigateToClearingBackstack(navController, trendsScreen)
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Welcome to Stardeos")
                    }
                    settingsSharedPreferences.setBoolean(
                        SettingsSharedPreferences.isLoggedKey,
                        true
                    )
                } else {
                    Toast.makeText(
                        context,
                        "Invalid credentials!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text(text = stringResource(id = R.string.login))
            }
            Text(
                text = stringResource(id = R.string.forgotpassword),
                modifier = Modifier.clickable {
                    navController.navigate(Screen.RecoverPassword.route)
                })
            Text(text = stringResource(id = R.string.registerAd), modifier = Modifier.clickable {
                navController.navigate(Screen.Register.route)
            })
        }
    }
}

fun checkCredentials(email: String, password: String): Boolean {
    return email.isNotBlank() && password.isNotBlank()
}

private fun checkIsLogged(
    settingsSharedPreferences: SettingsSharedPreferences,
    navController: NavHostController
) {
    val isLogged =
        settingsSharedPreferences.getBoolean(SettingsSharedPreferences.isLoggedKey)
    if (isLogged) {
        navigateToClearingBackstack(navController, trendsScreen)
    }
}