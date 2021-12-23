package com.stardeos.stardeos.ui.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.material.ButtonColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun LockScreenOrientation(orientation: Int) {
    val context = LocalContext.current
    DisposableEffect(Unit) {
        val activity = context.findActivity() ?: return@DisposableEffect onDispose {}
        val originalOrientation = activity.requestedOrientation
        activity.requestedOrientation = orientation
        onDispose {
            // restore original orientation when view disappears
            activity.requestedOrientation = originalOrientation
        }
    }
}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

class StardeosButtonColors : ButtonColors {

    @Composable
    override fun backgroundColor(enabled: Boolean): State<Color> {
        return remember {
            mutableStateOf(Color.White)
        }
    }

    @Composable
    override fun contentColor(enabled: Boolean): State<Color> {
        return remember {
            mutableStateOf(Color.Black)
        }
    }

}