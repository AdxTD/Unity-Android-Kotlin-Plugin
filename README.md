👋 Hi there! Just a few words about what to expect to see in this project

1- To build and run the Unity project: (Tested with Unity 2021.3.10 )

* Copy the Unity Assets folder content to your Unity project assets, or simply import the GAUnityAndroidPluginR1.0.unitypackage into your project, this unity package can be found inside the ReleasePackages folder
* Then use the SampleAndroidDeviceInfoPluginScene which is already prepared to test the plugin
* Make sure to have an Android device or emulator connected, and to have Unity Android Support installed for your engine
* Make sure to add the scene into the Scenes in Build from Build Settings
* Build and Run, the application should show you device info and memory usage
* You can also refer to the readme file found with the assets, it explains a bit more on using plugin prefab in your own scene if you like

2- To build and run the Android native kotlin project:


* Just exclude the Unity Assets folder from the project, open in Android Studio (Jellyfish or newer, older versions might work too)
* Sync build scripts with gradle (Gradle 8.6 or newer, but older versions are also expected to work without problem, down to minimum 7.5)
* Build the project and check the outputs folder, it will contain aar folder, which contains native library aar that can be copied to Unity -> Plugin -> Android folder