package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.stardeos.stardeos.ui.navigation.preferencesScreenNavName
import com.stardeos.stardeos.ui.util.StardeosButtonColors
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import com.stardeos.stardeos.ui.viewmodel.stardeos.PreferencesViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun PreferencesScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel,
    viewModel: PreferencesViewModel
) {
    val theme = if (stardeosViewModel.darkTheme.value == true) "Night Mode" else "Light Mode"
    Text(text = "$preferencesScreenNavName: Current theme -> $theme")
    Button(colors = StardeosButtonColors(), onClick = { stardeosViewModel.toggleDarkTheme() }) {
        Text(text = "Toggle Theme")
    }

}