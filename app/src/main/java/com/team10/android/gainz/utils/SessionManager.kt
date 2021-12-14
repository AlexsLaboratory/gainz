package com.team10.android.gainz.utils

import android.content.Context
import com.team10.android.gainz.BuildConfig

class SessionManager(context: Context) {
  private var preferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID + ".preferences", Context.MODE_PRIVATE)
  private var editor = preferences.edit()

  companion object {
    const val USER_TOKEN = "user_token"
  }

  fun saveAuthToken(token: String?) {
    editor.putString(USER_TOKEN, token)
    editor.apply()
  }

  fun getAuthToken(): String? {
    return preferences.getString(USER_TOKEN, null)
  }

  fun deleteAuthToken() {
    editor.remove(USER_TOKEN)
    editor.apply()
  }
}