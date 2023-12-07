package com.brice.reversegeocoding.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

class KeyboardUtils {
    companion object {
        fun hideKeyboard(activity: Activity) {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            if (activity.currentFocus != null) {
                imm.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
            }
        }
    }
}