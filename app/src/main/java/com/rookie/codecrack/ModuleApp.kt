package com.rookie.codecrack

import com.highcapable.yukihookapi.hook.xposed.application.ModuleApplication
import com.rookie.codecrack.utils.Debug.Companion.log

class ModuleApp : ModuleApplication() {
    override fun onCreate() {
        super.onCreate()
        log("ModuleApp 启动成功")
    }
}