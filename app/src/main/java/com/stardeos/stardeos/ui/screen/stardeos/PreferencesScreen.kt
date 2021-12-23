package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.jakewharton.processphoenix.ProcessPhoenix
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
    val context = LocalContext.current
    val theme = if (stardeosViewModel.darkTheme.value == true) "Night Mode" else "Light Mode"
    Row {
        Button(colors = StardeosButtonColors(), onClick = {
            stardeosViewModel.toggleDarkTheme()
            //ProcessPhoenix.triggerRebirth(context)
        }) {
            Text(text = "Toggle Theme")
        }
        Text(text = "$preferencesScreenNavName: Current theme -> $theme")
    }


}