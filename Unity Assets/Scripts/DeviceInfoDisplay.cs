using System.Collections;
using UnityEngine;
using UnityEngine.UI;

public class DeviceInfoDisplay : MonoBehaviour
{
    // texts to be used in a scene canvas or where developer desires 
    public Text deviceInfoText;
    public Text memoryUsageText;
    public Text averageMemoryUsageText;

    private float updateInterval = 1.0f;

    void Start()
    {
        // initialize plugin 
        AndroidPluginApi.Init();
        // run coroutine to get memory usage and keep tracking
        StartCoroutine(UpdateMemoryUsage());
        // combine device mutiple info into one string
        string deviceInfo = $"Device Model: {AndroidPluginApi.GetDeviceModel()}\n" +
                            $"OS Version: {AndroidPluginApi.GetOSVersion()}\n" +
                            $"CPU Model: {AndroidPluginApi.GetCPUModel()}\n" +
                            $"Total RAM: {AndroidPluginApi.GetTotalRAM()} bytes";
        //Debug.Log("Hello: DeviceInfo are " + deviceInfo);
        deviceInfoText.text = deviceInfo;
    }

    void Update()
    {
    }

    private IEnumerator UpdateMemoryUsage()
    {
        while (true)
        {
            string memoryUsage = $"Current System Memory Usage: {AndroidPluginApi.GetCurrentSystemMemoryUsage()/1000000} Mbytes\n" +
                                 $"Current App Memory Usage: {AndroidPluginApi.GetCurrentAppMemoryUsage()/1000000} Mbytes";

            memoryUsageText.text = memoryUsage;

            string averageMemoryUsage = $"Average App Memory Usage: {AndroidPluginApi.GetAverageMemoryUsage()/1000000} Mbytes";

            averageMemoryUsageText.text = averageMemoryUsage;

            //Debug.Log("Hello: memoryUsage are " + memoryUsage + ", and average app usage " + averageMemoryUsage);

            yield return new WaitForSeconds(updateInterval);
        }
    }
}