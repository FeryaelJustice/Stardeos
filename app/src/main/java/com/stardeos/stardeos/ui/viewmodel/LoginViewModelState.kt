package com.stardeos.stardeos.ui.viewmodel

data class LoginViewModelState(
    val user: String = "",
    val password: String = "",
    val checking: Boolean = false
)
