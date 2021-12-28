package com.stardeos.stardeos.data.provider.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsSharedPreferences @Inject constructor(@ApplicationContext context: Context) {

    companion object {
        const val SETTINGS_KEY = "settings"
        const val isDarkThemeKey = "isDarkTheme"
        const val isLoggedKey = "isLogged"
    }

    private val sharedPreferences: SharedPreferences =
        context.applicationContext.getSharedPreferences(
            SETTINGS_KEY,
            Context.MODE_PRIVATE
        )

    // Get
    fun getBoolean(key: String) = sharedPreferences.getBoolean(key, false)

    // Set

    fun setBoolean(key: String, value: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean(key, value)
            commit()
        }
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}