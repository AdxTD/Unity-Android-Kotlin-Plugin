package com.ga.unity_plugin.core

import android.app.ActivityManager
import android.content.Context
import android.os.Debug
import com.ga.unity_plugin.JNIInterface

// Provides current memory usage (RAM) for the whole system and of
// the application
object DeviceMemoryUsage {

    // Device: system memory usage
    @JvmStatic
    fun getCurrentSystemMemoryUsage(context: Context): Long {
        val mi = ActivityManager.MemoryInfo()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(mi)
        return mi.availMem
    }

    // Device: application memory usage
    @JvmStatic
    fun getCurrentAppMemoryUsage(): Long {
        val mi = Debug.MemoryInfo()
        Debug.getMemoryInfo(mi)
        val currentAppMemoryUsage = mi.totalPss.toLong() * 1024L // Convert to bytes
        return currentAppMemoryUsage
    }
}