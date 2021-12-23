package com.stardeos.stardeos.ui.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.stardeos.stardeos.model.Comment

@Composable
fun Comment(comment: Comment) {
    Text(text = "Comment with ID:${comment.id}")
}