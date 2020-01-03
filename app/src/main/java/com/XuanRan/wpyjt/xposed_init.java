package com.XuanRan.wpyjt;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.*;
import de.robv.android.xposed.XC_MethodHook.*;

public class xposed_init implements IXposedHookLoadPackage
{

	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam pack) throws Throwable
	{
		if(pack.packageName.equals("com.XuanRan.Jietu")){
			XposedHelpers.findAndHookMethod("android.view.Window",pack.classLoader,"setFlags",int.class,int.class,new HookFlagd());
			XposedHelpers.findAndHookMethod("android.view.Window",pack.classLoader,"addFlags",int.class,new HookaddFlags());
		}
		if(pack.packageName.equals("com.XuanRan.wpyjt")){
			XposedHelpers.findAndHookMethod("android.view.Window",pack.classLoader,"setFlags",int.class,int.class,new HookFlagd());
			XposedHelpers.findAndHookMethod("android.view.Window",pack.classLoader,"addFlags",int.class,new HookaddFlags());
		}
		if(pack.packageName.equals("in.zhaoj.shadowsocksrr")){
			XposedHelpers.findAndHookMethod("android.view.Window",pack.classLoader,"setFlags",int.class,int.class,new HookFlagd());
			XposedHelpers.findAndHookMethod("android.view.Window",pack.classLoader,"addFlags",int.class,new HookaddFlags());
		}
	}
	class HookFlagd extends XC_MethodHook
	{

		@Override
		protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable
		{
			// TODO: Implement this method
			super.beforeHookedMethod(param);
			int param1=param.args[0];
			int param2=param.args[1];
			if(param1==8192){
				param.args[0]=2097152;
				if(param2==8192){
					param.args[1]=2097152;
				}
			}
		}
		
	}
	class HookaddFlags extends XC_MethodHook
	{

		@Override
		protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable
		{
			// TODO: Implement this method
			super.beforeHookedMethod(param);
			if(param.args[0]==8192){
				param.args[0]=2097152;
			}
		}
		
	}
}
