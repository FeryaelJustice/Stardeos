package com.stardeos.stardeos.ui.screen.app

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.stardeos.stardeos.R
import com.stardeos.stardeos.data.provider.local.SettingsSharedPreferences
import com.stardeos.stardeos.ui.navigation.loginScreenRoute
import com.stardeos.stardeos.ui.navigation.navigateToClearingBackstack
import com.stardeos.stardeos.ui.viewmodel.app.SplashViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    viewModel: SplashViewModel,
    settingsSharedPreferences: SettingsSharedPreferences
) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 2f,
            animationSpec = tween(
                durationMillis = 500,
                easing = { OvershootInterpolator(2f).getInterpolation(it) })
        )
        delay(1000L)
        navigateToClearingBackstack(navController, loginScreenRoute)
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.stardeos),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}