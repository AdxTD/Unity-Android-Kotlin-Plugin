using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

public class AndroidPluginApi
{
    private static AndroidJavaClass unityPlayer;
    private static AndroidJavaObject activity;
    private static AndroidJavaClass jniInterface;

    public static void Init()
    {
        unityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
        activity = unityPlayer.GetStatic<AndroidJavaObject>("currentActivity");
        jniInterface = new AndroidJavaClass("com.ga.unity_plugin.JNIInterface");
    }

    public static string GetDeviceModel()
    {
        try
        {
            return jniInterface.CallStatic<string>("getDeviceModel");
        }
        catch (Exception e)
        {
            Debug.LogError($"Error getting device model: {e.Message}");
            return "Unknown";
        }
    }

    public static string GetOSVersion()
    {
        try
        {
            return jniInterface.CallStatic<string>("getOSVersion");
        }
        catch (Exception e)
        {
            Debug.LogError($"Error getting OS Version: {e.Message}");
            return "Unknown";
        }
    }

    public static string GetCPUModel()
    {
        try
        {
            return jniInterface.CallStatic<string>("getCPUModel");
        }
        catch (Exception e)
        {
            Debug.LogError($"Error getting CPU model: {e.Message}");
            return "Unknown";
        }
    }

    public static long GetTotalRAM()
    {
        try
        {
            return jniInterface.CallStatic<long>("getTotalRAM", activity);
        }
        catch (Exception e)
        {
            Debug.LogError($"Error getting Total Ram: {e.Message}");
            return 0L;
        }
    }

    public static long GetCurrentSystemMemoryUsage()
    {
        try{
            return jniInterface.CallStatic<long>("getCurrentSystemMemoryUsage", activity);
        }
        catch (Exception e)
        {
            Debug.LogError($"Error getting current system memory usage: {e.Message}");
            return 0L;
        }
    }

    public static long GetCurrentAppMemoryUsage()
    {
        try{
            return jniInterface.CallStatic<long>("getCurrentAppMemoryUsage");
        }
        catch (Exception e)
        {
            Debug.LogError($"Error getting current app memory usage: {e.Message}");
            return 0L;
        }
    }

    public static long GetAverageMemoryUsage()
    {
        try 
        {
            return jniInterface.CallStatic<long>("getAverageMemoryUsage");
        }
        catch (Exception e)
        {
            Debug.LogError($"Error getting average memory usage: {e.Message}");
            return 0L;
        }
    }
}