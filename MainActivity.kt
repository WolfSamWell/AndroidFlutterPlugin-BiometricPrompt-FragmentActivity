package com.example.flutter_plugin_example  // 此处为你的Example包名

import io.flutter.embedding.android.FlutterFragmentActivity;

// java
//public class MainActivity extends FlutterFragmentActivity {}


// 此处继承 即可 在没有添加新的Engine的情况下。会使用反射找到你的插件主类
class MainActivity: FlutterFragmentActivity()

