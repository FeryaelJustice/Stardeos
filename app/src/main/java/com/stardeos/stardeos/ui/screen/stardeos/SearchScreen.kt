package com.stardeos.stardeos.ui.screen.stardeos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stardeos.stardeos.model.*
import com.stardeos.stardeos.ui.navigation.Screen
import com.stardeos.stardeos.ui.navigation.searchScreenNavName
import com.stardeos.stardeos.ui.viewmodel.StardeosViewModel
import com.stardeos.stardeos.ui.viewmodel.stardeos.SearchViewModel
import kotlinx.coroutines.CoroutineScope

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    scaffoldState: ScaffoldState,
    navController: NavController,
    scope: CoroutineScope,
    stardeosViewModel: StardeosViewModel,
    viewModel: SearchViewModel
) {
    //val query = viewModel.query.value
    val query = remember { mutableStateOf("") }
    val videos = listOf(
        Video(
            0, "Bienvenidos a Stardeos", "Hola", "", "", listOf(Tag(0)), 60, listOf(
                VideoQuality(0, VideoResolution.FULL_HD, VideoFrameRate.FLUID)
            ), listOf(
                VideoSpeed.SUPER_SLOW,
                VideoSpeed.SLOW,
                VideoSpeed.NORMAL,
                VideoSpeed.FAST,
                VideoSpeed.VERY_FAST,
                VideoSpeed.ULTRA_FAST
            ), 0, 100000, 1000, 10, listOf(Comment(0)), listOf(Stardust(0)), 1
        ),
        Video(
            1, "Stardeos, la mejor plataforma.", "<3", "", "", listOf(Tag(1)), 120, listOf(
                VideoQuality(0, VideoResolution.FULL_HD, VideoFrameRate.FLUID)
            ), listOf(
                VideoSpeed.SUPER_SLOW,
                VideoSpeed.SLOW,
                VideoSpeed.NORMAL,
                VideoSpeed.FAST,
                VideoSpeed.VERY_FAST,
                VideoSpeed.ULTRA_FAST
            ), 1, 10000, 100, 1, listOf(Comment(1)), listOf(Stardust(1), Stardust(2)), 2
        )
    )
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            items(1) {
                Text(
                    text = "Back", modifier = Modifier
                        .clickable {
                            navController.navigate(
                                Screen.Trends.route
                            ) {
                                // Clear backstack
                                popUpTo(0)
                                launchSingleTop = true
                            }
                        }
                        .fillMaxWidth()
                        .padding(end = 10.dp)
                )
                TextField(
                    value = query.value,
                    onValueChange = { newValue ->
                        query.value = newValue
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    label = { Text(text = "Search") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            // viewmodel.newSearch(query)
                            keyboardController?.hide()
                        }
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    },
                    singleLine = true,
                    maxLines = 1
                )
            }
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(
                items = videos
            ) { index, video ->
                //RecipeCard(recipe = recipe, onClick = {})
                Card {
                    LazyRow {
                        items(1) {
                            Text(text = "Index:$index $searchScreenNavName - ${video.title}")
                            Text(text = video.description)
                        }
                    }
                }
            }
        }
    }
}