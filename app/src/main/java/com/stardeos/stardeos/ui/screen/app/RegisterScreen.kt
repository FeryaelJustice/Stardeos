package com.stardeos.stardeos.ui.screen.app

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stardeos.stardeos.R
import com.stardeos.stardeos.ui.navigation.Screen
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import com.stardeos.stardeos.ui.viewmodel.app.RegisterViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun RegisterScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel,
    viewModel: RegisterViewModel
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(1) {
            var email by rememberSaveable { mutableStateOf("Email") }
            var password by rememberSaveable { mutableStateOf("Password") }
            var repeatPassword by rememberSaveable { mutableStateOf("RepeatPassword") }
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
            TextField(
                value = repeatPassword,
                onValueChange = {
                    repeatPassword = it
                },
                label = { Text(text = stringResource(id = R.string.repeatPassword)) }
            )

            Button(onClick = {
                if (register(email, password, repeatPassword)) {
                    navController.navigate(Screen.Trends.route) {
                        // Clear backstack
                        popUpTo(0)
                        launchSingleTop = true
                    }
                } else {
                    Toast.makeText(
                        context,
                        "Invalid credentials!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
                Text(text = stringResource(id = R.string.register))
            }
        }
    }
}

fun register(email: String, password: String, repeatPassword: String): Boolean {
    return email.isNotBlank() && password.isNotBlank() && repeatPassword.isNotBlank()
}