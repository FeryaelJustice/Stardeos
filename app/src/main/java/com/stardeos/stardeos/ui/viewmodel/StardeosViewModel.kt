package com.stardeos.stardeos.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StardeosViewModel @Inject constructor() : ViewModel() {

    // Dark Theme
    private val _darkTheme = MutableLiveData(false)
    val darkTheme = _darkTheme
    fun toggleDarkTheme() {
        _darkTheme.value = !_darkTheme.value!!
    }
}