

package com.example.flutter_plugin



import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity


import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import org.json.JSONObject




/** FlutterPlugin */
class FlutterPlugin: FlutterPlugin, MethodCallHandler, ActivityAware {
    private lateinit var channel : MethodChannel
    private var activity: Activity? = null


  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    activity = binding.activity
  }

  override fun onDetachedFromActivityForConfigChanges() {
    TODO("Not yet implemented")
  }

  override fun onDetachedFromActivity() {
    activity = null
  }

  // 其他生命周期方法保持空实现
  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {}
  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {}


  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {

    // 设置方法通道
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_plugin_name")
    channel.setMethodCallHandler(this)
  }



  override fun onMethodCall(call: MethodCall, result: Result) {

    try {
        when(call.method) {
          "getPlatformVersion" -> {
            result.success("Android${Build.VERSION.RELEASE}")
          }
          else -> {
            result.notImplemented()
          }
        }
    }catch (e:Exception) {
      result.error("ERROR MethodCall",e.message,null)
    }


  }



  fun getActivity(){
    // 类型判断
    if (activity is FragmentActivity) {

      // null 检查
      if (activity == null) {
        result.error("NO_ACTIVITY", "Activity is not available", null)
        return
      }
      val fragmentActivity = activity  as FragmentActivity;
      // 此处去使用fragmentActivity 就好

    } else {

      result.error("9991","Activity is not a FragmentActivity.The plugin requires an Activity to host the biometric page","The host Activity must inherit from FragmentActivity。")
      Log.e("Plugin", "The host Activity must inherit from FragmentActivity。需要宿主Activity必须继承自FragmentActivity。" );
      Log.e("Plugin", "The plugin requires an Activity to host the biometric page" );
    }
  }

}
