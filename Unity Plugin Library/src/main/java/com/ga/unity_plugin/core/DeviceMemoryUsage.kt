package com.ga.unity_plugin.core

import android.app.ActivityManager
import android.content.Context
import android.os.Debug
import com.ga.unity_plugin.JNIInterface

// Provides current memory usage (RAM) for the whole system and of
// the application,
// Keeping track of the average memory usage across the application’s lifetime
object DeviceMemoryUsage {
    // accumulates memory usage over time
    private var totalMemoryUsage: Long = 0
    private var memoryUsageCount: Long = 0

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
        val newTotalMemoryUsage = totalMemoryUsage + currentAppMemoryUsage
        // Overflow detected, reset counters
        if (newTotalMemoryUsage < totalMemoryUsage) {
            totalMemoryUsage = currentAppMemoryUsage
            memoryUsageCount = 1
        } else { // otherwise just accumulate current usage to calculate avg
            totalMemoryUsage = newTotalMemoryUsage
            memoryUsageCount++
        }
        return currentAppMemoryUsage
    }

    // Device: application memory usage over time
    @JvmStatic
    fun getAverageMemoryUsage(): Long {
        return if (memoryUsageCount == 0L) {
            0
        } else {
            totalMemoryUsage / memoryUsageCount
        }
    }
}