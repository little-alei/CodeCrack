package com.rookie.codecrack.utils

import android.util.Log
import android.widget.Toast
import com.highcapable.yukihookapi.hook.xposed.application.ModuleApplication

class Debug {

    companion object {
        private const val TAG = "TestHook"

        fun log(msg: String) {
            Log.d(TAG, msg)
        }

        fun toast(message: String) {
            Toast.makeText(ModuleApplication.appContext, message, Toast.LENGTH_SHORT).show()
        }
    }
}