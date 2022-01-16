package com.example.financecontrol.presentation.auth.register

data class RegisterData (
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var passwordRepeat: String = "",
)