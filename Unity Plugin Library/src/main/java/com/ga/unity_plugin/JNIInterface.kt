package com.ga.unity_plugin

import android.content.Context
import com.ga.unity_plugin.core.DeviceInfo
import com.ga.unity_plugin.core.DeviceMemoryUsage

// JNI Interface to Expose the functionality of the native library
// so it can be used inside Unity engine Android plugin
object JNIInterface {

    @JvmStatic
    fun getDeviceModel(): String {
        return DeviceInfo.getDeviceModel()
    }

    @JvmStatic
    fun getOSVersion(): String {
        return DeviceInfo.getOSVersion()
    }

    @JvmStatic
    fun getCPUModel(): String {
        return DeviceInfo.getCPUModel()
    }

    @JvmStatic
    fun getTotalRAM(context: Context): Long {
        return DeviceInfo.getTotalRAM(context)
    }

    @JvmStatic
    fun getCurrentSystemMemoryUsage(context: Context): Long {
        return DeviceMemoryUsage.getCurrentSystemMemoryUsage(context)
    }

    @JvmStatic
    fun getCurrentAppMemoryUsage(): Long {
        return DeviceMemoryUsage.getCurrentAppMemoryUsage()
    }

    @JvmStatic
    fun getAverageMemoryUsage(): Long {
        return DeviceMemoryUsage.getAverageMemoryUsage()
    }

}
