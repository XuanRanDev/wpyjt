package com.XuanRan.wpyjt.adapter;


import android.content.*;
import android.view.*;
import android.widget.*;
import com.XuanRan.wpyjt.*;
import com.XuanRan.wpyjt.model.bean.*;
import java.util.*;
import android.graphics.*;

/**
 * Created by Administrator on 2017/6/24.
 */
public class AppInfosAdapter extends BaseAdapter {

    Context context;
    List<AppInfo> appInfos;

    public AppInfosAdapter() {
    }

    public AppInfosAdapter(Context context, List<AppInfo> infos) {
        this.context = context;
        this.appInfos = infos;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<AppInfo> getAppInfos() {
        return appInfos;
    }

    public void setAppInfos(List<AppInfo> appInfos) {
        this.appInfos = appInfos;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (null != appInfos) {
            return appInfos.size();
        }
        return count;
    }

    @Override
    public Object getItem(int index) {
        return appInfos.get(index);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.tezt2, null);
            viewHolder.appIconImg = (ImageView) convertView.findViewById(R.id.app_icon);
            viewHolder.appNameText = (TextView) convertView.findViewById(R.id.app_info_name);
            viewHolder.appPackageText = (TextView) convertView.findViewById(R.id.app_info_package_name);
			viewHolder.appcheck=convertView.findViewById(R.id.testCheckBox);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (null != appInfos) {
            viewHolder.appIconImg.setBackground(appInfos.get(position).getDrawable());
            viewHolder.appNameText.setText(appInfos.get(position).getAppName());
            viewHolder.appPackageText.setText(appInfos.get(position).getPackageName());
			if(appInfos.get(position).getPackageName().equals("com.XuanRan.wpyjt")){
				viewHolder.appNameText.setTextColor(Color.RED);
				viewHolder.appPackageText.setTextColor(Color.RED);
			}
        }
        return convertView;
    }
	
    private class ViewHolder {
        ImageView appIconImg;
        TextView appNameText;
        TextView appPackageText;
		CheckBox appcheck;
    }
}
