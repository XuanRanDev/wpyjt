package com.XuanRan.wpyjt;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class ExceptionActivity extends Activity
{

	private String log;
	private String savepath;
	private boolean issave=true;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_DeviceDefault);
		getActionBar().setTitle("程序异常");
		Intent intent=getIntent();
		savepath = intent.getStringExtra("Error_Log_Path");
		ScrollView mScrollView=new ScrollView(this);

		HorizontalScrollView mHorizontalScrollView = new HorizontalScrollView(this);
		TextView mMessage = new TextView(this);

		mHorizontalScrollView.addView(mMessage);
		mScrollView.addView(mHorizontalScrollView, -1, -1);

		setContentView(mScrollView);

		log = getIntent().getStringExtra(Intent.EXTRA_TEXT);
		mMessage.setText(log);
		mMessage.setTextIsSelectable(true);

		int padding=dp2px(16);
		mMessage.setPadding(padding, padding, padding, padding);

		mScrollView.setFillViewport(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add("保存日志").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

				@Override
				public boolean onMenuItemClick(MenuItem p1)
				{
					if (issave)
					{
						String savepath2=saveErrorMessage(log, savepath);
						AlertDialog.Builder alert=new AlertDialog.Builder(ExceptionActivity.this);
						alert.setTitle("保存错误日志");
						alert.setMessage("日志已保存到：" + savepath2);
						alert.setCancelable(false);
						alert.setNegativeButton("删除", new DialogInterface.OnClickListener(){

								@Override
								public void onClick(DialogInterface p1, int p2)
								{
									deleteAllFiles(new File(savepath));
									Toast.makeText(ExceptionActivity.this, "所有日志已删除", Toast.LENGTH_LONG).show();
								}
							});
						alert.setPositiveButton("取消", null);
						alert.show();
						issave = false;
					}
					else
					{
						Toast.makeText(ExceptionActivity.this, "日志已保存", Toast.LENGTH_LONG).show();
					}
					return false;
				}
			}).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		menu.add("重新启动").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

				@Override
				public boolean onMenuItemClick(MenuItem p1)
				{
					startActivity(new Intent(ExceptionActivity.this, MainActivity.class));
					finish();
					return false;
				}
			}).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

		return super.onCreateOptionsMenu(menu);
	}


	public static int dp2px(float dpValue)
	{
        float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


	public static String saveErrorMessage(String message, String path)
	{
		String filepath=path + getnowtime() + ".log";
		try
		{
			FileWriter fw = new FileWriter(filepath);
			fw.write(message);
			fw.flush();
			fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return filepath;
	}
	/**
     * @获取系统当前时间
     * @return
     */
    
	private static  String getnowtime()
	{
		//得到long类型当前时间

		long l = System.currentTimeMillis();
//new日期对
		Date date = new Date(l);
//转换提日期输出格式

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return (dateFormat.format(date));
	}
	static void deleteAllFiles(File root)
	{  
		File files[] = root.listFiles();  
		if (files != null)  
			for (File f : files)
			{  
				if (f.isDirectory())
				{ // 判断是否为文件夹  
					deleteAllFiles(f);  
					try
					{  
						f.delete();  
					}
					catch (Exception e)
					{  
					}  
				}
				else
				{  
					if (f.exists())
					{ // 判断是否存在  
						deleteAllFiles(f);  
						try
						{  
							f.delete();  
						}
						catch (Exception e)
						{  
						}  
					}  
				}  
			}  
	}} 
