

To resolve the issue of passing the FragmentActivity parameter in the biometric API during Android development of a Flutter plugin, two steps need to be taken.

为了解决在Flutter插件安卓开发中，生物识别API传入参数FragmentActivity的问题。 需要做2步操作。


Step 1: Modify the host project's MainActivity to extend FlutterFragmentActivity.
Step 2: In the plugin class, retrieve the main activity through the ActivityAware interface. Below is the code implementation.

第一步修改宿主工程的MainActivity为 FlutterFragmentActivity继承关系。
第二步。在插件类通过ActivityAware接口获取该主activity。以下是代码实现。



