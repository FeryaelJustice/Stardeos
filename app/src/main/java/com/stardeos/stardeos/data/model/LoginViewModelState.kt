package com.stardeos.stardeos.data.model

data class LoginViewModelState(
    val user: String = "",
    val password: String = "",
    val checking: Boolean = false,
    val logged: Boolean = false
)
