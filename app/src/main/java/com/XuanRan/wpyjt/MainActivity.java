package com.XuanRan.wpyjt;

import android.content.*;
import android.content.pm.*;
import android.graphics.drawable.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import com.XuanRan.wpyjt.adapter.*;
import com.XuanRan.wpyjt.model.bean.*;
import java.util.*;

public class MainActivity extends AppCompatActivity
{

    private ListView appInfoListView = null;
    private List<AppInfo> appInfos = null;
    private AppInfosAdapter infosAdapter = null;
    private TextView installAppCounts = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		getWindow().setFlags(8192,8192);
        setContentView(R.layout.activity_main);
        appInfoListView = (ListView) this.findViewById(R.id.appinfo_list);
        installAppCounts = (TextView) this.findViewById(R.id.tv_install_app_counts);
        init();
        
    }
	
    private void init()
	{
        appInfos = getAppInfos();
        if (null != appInfos && 0 != appInfos.size())
		{
            updateUI(appInfos);
			
        }
		
    }

    public void updateUI(List<AppInfo> appInfos)
	{
        infosAdapter = new AppInfosAdapter(getApplication(), appInfos);
        installAppCounts.setText(appInfos.size() + "个");
        appInfoListView.setAdapter(infosAdapter);
		
		appInfoListView.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					int itemnumbet=1+p3;
					Toast.makeText(MainActivity.this,"已选择第"+itemnumbet+"个",Toast.LENGTH_LONG).show();
				}
			});
		
    }

    public List<AppInfo> getAppInfos()
	{
//        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
//        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//        List<ResolveInfo> resolveInfoList = packageManager.queryIntentActivities(mainIntent, PackageManager.MATCH_DEFAULT_ONLY);
//        Collections.sort(resolveInfoList, new ResolveInfo.DisplayNameComparator(packageManager));
//        if (appInfos != null) {
//            appInfos.clear();
//            for (ResolveInfo reInfo : resolveInfoList) {
//                String activityName = reInfo.activityInfo.name; // 获得该应用程序的启动Activity的name
//                String pkgName = reInfo.activityInfo.packageName; // 获得应用程序的包名
//                String appLabel = (String) reInfo.loadLabel(packageManager); // 获得应用程序的Label
//                Drawable icon = reInfo.loadIcon(packageManager); // 获得应用程序图标
//                // 为应用程序的启动Activity 准备Intent
//                Intent launchIntent = new Intent();
//                launchIntent.setComponent(new ComponentName(pkgName,
//                        activityName));
//                // 创建一个AppInfo对象，并赋值
//                AppInfo appInfo = new AppInfo();
//                appInfo.setAppName(appLabel);
//                appInfo.setPackageName(pkgName);
//                appInfo.setDrawable(icon);
//                appInfo.setAppIntent(launchIntent);
//                appInfos.add(appInfo); // 添加至列表中
//            }
//        }

//        PackageManager pm = getApplication().getPackageManager();
//        List<PackageInfo>  packgeInfos = pm.getInstalledPackages(0);
//        appInfos = new ArrayList<AppInfo>();
//        /* 获取应用程序的名称，不是包名，而是清单文件中的labelname
//            String str_name = packageInfo.applicationInfo.loadLabel(pm).toString();
//            appInfo.setAppName(str_name);
//         */
//        for(PackageInfo packgeInfo : packgeInfos){
//            String appName = packgeInfo.applicationInfo.loadLabel(pm).toString();
//            String packageName = packgeInfo.packageName;
//            Drawable drawable = packgeInfo.applicationInfo.loadIcon(pm);
//            AppInfo appInfo = new AppInfo(appName, packageName,drawable);
//            appInfos.add(appInfo);
//        }
//        return appInfos;

        PackageManager packageManager = getApplication().getPackageManager();
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(0);
        appInfos = new ArrayList<AppInfo>();
        for (int i = 0; i < packageInfoList.size(); i++)
		{
            PackageInfo pak = packageInfoList.get(i);
            ApplicationInfo applicationInfo = pak.applicationInfo;
            //判断是否为系统预装的应用
            if ((pak.applicationInfo.flags & pak.applicationInfo.FLAG_SYSTEM) <= 0)
			{
                // 第三方应用
                String appName = pak.applicationInfo.loadLabel(packageManager).toString();
                String packageName = pak.packageName;
                String appIntent = applicationInfo.name;
                Drawable drawable = pak.applicationInfo.loadIcon(packageManager);
                AppInfo appInfo = new AppInfo(appName, packageName, drawable, appIntent);
                appInfos.add(appInfo);
            }
        }

        return appInfos;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
	{
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
	{
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
	{
        int id = item.getItemId();
        if (id == R.id.settings)
		{
            Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
//			Intent intent=new Intent();
//			intent.setClass(this,Test.class);
//			startActivity(intent);

        }
		else if (id == R.id.abouts)
		{
            Toast.makeText(this, "关于软件", Toast.LENGTH_SHORT).show();
        }
		else if (id == R.id.exportData)
		{
            if (null == appInfos)
			{
                init();
            }
			else
			{
                throw new RuntimeException("测试");
            }
        }
		
        return super.onOptionsItemSelected(item);
    }
	
}
