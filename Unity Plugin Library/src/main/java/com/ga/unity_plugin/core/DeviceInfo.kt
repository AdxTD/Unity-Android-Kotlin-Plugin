package com.ga.unity_plugin.core


import android.app.ActivityManager
import android.content.Context
import android.os.Build

// Provides functionality to query common information about the device: model, OS version,
// cpu model/chipset, total RAM
object DeviceInfo {

    // Device: model
    @JvmStatic
    fun getDeviceModel(): String {
        return Build.MODEL
    }

    // Device: OS version
    @JvmStatic
    fun getOSVersion(): String {
        return Build.VERSION.RELEASE
    }

    // Device: cpu model/chipset
    @JvmStatic
    fun getCPUModel(): String {
        return Build.HARDWARE
    }

    // Device: total RAM
    @JvmStatic
    fun getTotalRAM(context: Context): Long {
        val mi = ActivityManager.MemoryInfo()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(mi)
        return mi.totalMem
    }
}