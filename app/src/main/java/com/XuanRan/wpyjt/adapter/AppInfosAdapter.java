package com.XuanRan.wpyjt.adapter;


import android.content.*;
import android.view.*;
import android.widget.*;
import com.XuanRan.wpyjt.*;
import com.XuanRan.wpyjt.model.bean.*;
import java.util.*;
import android.graphics.*;

/**
 * Created by XuanRan on 2020/1/01.
 */
public class AppInfosAdapter extends BaseAdapter
{

    Context context;
    List<AppInfo> appInfos;

    List<AppBean> appbean=new ArrayList<AppBean>();

    public AppInfosAdapter()
    {
    }

    public AppInfosAdapter(Context context, List<AppInfo> infos)
    {
        this.context = context;
        this.appInfos = infos;
    }

    public Context getContext()
    {
        return context;
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public List<AppInfo> getAppInfos()
    {
        return appInfos;
    }

    public void setAppInfos(List<AppInfo> appInfos)
    {
        this.appInfos = appInfos;
    }

    @Override
    public int getCount()
    {
        int count = 0;
        if (null != appInfos)
        {
            return appInfos.size();
        }
        return count;
    }

    @Override
    public Object getItem(int index)
    {
        return appInfos.get(index);
    }

    @Override
    public long getItemId(int index)
    {
        return index;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2)
    {
        ViewHolder viewHolder = null;

        if (null == convertView)
        {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.tezt2, null);
            viewHolder.appIconImg = (ImageView) convertView.findViewById(R.id.app_icon);
            viewHolder.appNameText = (TextView) convertView.findViewById(R.id.app_info_name);
            viewHolder.appPackageText = (TextView) convertView.findViewById(R.id.app_info_package_name);
            viewHolder.mSwitch = convertView.findViewById(R.id.tezt2Switch);
            //  viewHolder.mSwitch.setChecked(false);
			//viewHolder.appcheck=convertView.findViewById(R.id.testCheckBox);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (null != appInfos)
        {
            viewHolder.appIconImg.setBackground(appInfos.get(position).getDrawable());
            viewHolder.appNameText.setText(appInfos.get(position).getAppName());
            viewHolder.appPackageText.setText(appInfos.get(position).getPackageName());
        }

        final ViewHolder viewHolder2=viewHolder;
        viewHolder.mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton p1, boolean p2)
                {
                    //String app_pkg=viewHolder2.appPackageText.getText().toString();
                    AppBean appbean_add=new AppBean(viewHolder2.appPackageText.getText().toString(), viewHolder2.appNameText.getText().toString(), p2);
                    appbean.add(appbean_add);
                    if (p2)
                    {
                        viewHolder2.appNameText.setTextColor(Color.RED);
                        viewHolder2.appPackageText.setTextColor(Color.RED);
                        viewHolder2.mSwitch.setChecked(true);
                    }
                    else
                    {
                        viewHolder2.appNameText.setTextColor(Color.BLACK);
                        viewHolder2.appPackageText.setTextColor(Color.BLACK);
                        viewHolder2.mSwitch.setChecked(false);
                        appbean.remove(appbean_add);
                    }
                }
            });
        // Toast.makeText(getContext(),"Toast",Toast.LENGTH_LONG).show();
        for (int i=0;i < appbean.size();i++)
        {
            if (appbean.get(i).getischeck())
            {


                if (viewHolder.appPackageText.getText().toString().equals(appbean.get(i).getPackage_Name()))
                {
                    viewHolder.appNameText.setTextColor(Color.RED);
                    viewHolder.appPackageText.setTextColor(Color.RED);
                    viewHolder.mSwitch.setChecked(true);
                }
                else
                {
                    viewHolder.appNameText.setTextColor(Color.BLACK);
                    viewHolder.appPackageText.setTextColor(Color.BLACK);
                    viewHolder.mSwitch.setChecked(false);
                }
            }
            else
            {
                viewHolder.appNameText.setTextColor(Color.BLACK);
                viewHolder.appPackageText.setTextColor(Color.BLACK);
                viewHolder.mSwitch.setChecked(false);
            }
        }

        return convertView;
    }

    private class ViewHolder
    {
        ImageView appIconImg;
        TextView appNameText;
        TextView appPackageText;
		Switch mSwitch;
    }

}
