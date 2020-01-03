package com.XuanRan.wpyjt.utils;

import android.os.Environment;

import java.io.File;
import com.XuanRan.wpyjt.common.*;

/**
 * Created by Administrator on 2017/6/21.
 */
public class SDCardUtil {

    public boolean checkSDCard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    public String getMainDirPath() {
        return Environment.getExternalStorageDirectory() + File.separator;
    }

    public String createAppFolder() {
        String appRootDirPath = null;
        if (checkSDCard()) {
            String mainDirPath = getMainDirPath();
            appRootDirPath = mainDirPath + ParamterConstant.MAIN_FOLDER_NAME;
            File appRootPath = new File(appRootDirPath);
            if (!appRootPath.exists() && !appRootPath.isDirectory()) {
                appRootPath.mkdirs();
            }
        }
        return appRootDirPath;
    }


}
