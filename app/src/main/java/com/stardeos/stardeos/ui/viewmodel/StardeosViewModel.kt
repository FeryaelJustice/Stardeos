package com.stardeos.stardeos.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StardeosViewModel @Inject constructor() : ViewModel() {

    // Dark Theme
    private val _darkTheme = MutableLiveData(false)
    val darkTheme: LiveData<Boolean> get() = _darkTheme
    fun setDarkTheme(isDarkTheme: Boolean) {
        _darkTheme.value = isDarkTheme
        Log.d("night", "DarkMode Init:${darkTheme.value}")
    }

    fun toggleDarkTheme() {
        Log.d("toggle", "toggling")
        Log.d("night", "DarkMode before toggle:${darkTheme.value}")
        _darkTheme.value = !_darkTheme.value!!
        Log.d("night", "DarkMode after toggle:${darkTheme.value}")
    }

    // LoginViewModelState
    private val _state = MutableLiveData<LoginViewModelState>()
    val state: LiveData<LoginViewModelState> get() = _state
    // Emit new state like this: _state.value = _state.value!!.copy(checking = true)

    // Init
    init {
        _state.value = LoginViewModelState()
    }
}