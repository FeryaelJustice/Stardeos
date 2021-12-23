package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.stardeos.stardeos.R
import com.stardeos.stardeos.ui.navigation.Screen
import com.stardeos.stardeos.ui.util.StardeosButtonColors
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import com.stardeos.stardeos.ui.viewmodel.stardeos.TrendsViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun TrendsScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel,
    viewModel: TrendsViewModel
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(1) {
            Button(colors = StardeosButtonColors(), onClick = {
                navController.navigate(Screen.Video.route)
            }) {
                Text(text = stringResource(id = R.string.video))
            }
        }
    }
}