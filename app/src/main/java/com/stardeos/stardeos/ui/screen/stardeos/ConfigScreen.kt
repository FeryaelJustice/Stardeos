package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.stardeos.stardeos.ui.navigation.Screen
import com.stardeos.stardeos.ui.navigation.configScreenNavName
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import com.stardeos.stardeos.ui.viewmodel.stardeos.ConfigViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun ConfigScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel,
    viewModel: ConfigViewModel
) {
    Text(text = configScreenNavName)
    Button(onClick = { navController.navigate(Screen.Preferences.route) }) {
        Text(text = "Preferences")
    }
}