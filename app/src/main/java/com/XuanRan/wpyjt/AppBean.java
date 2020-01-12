package com.XuanRan.wpyjt;
import java.util.*;

/**
*
*    Created by XuanRan on 2020/01/12
*
*/
public class AppBean
{
    String Package_Name;
    String App_Name;
    boolean ischeck;
    List<AppBean> list=new ArrayList<AppBean>();
    
    public AppBean(){
        
    }
    
    public AppBean(String PackageName,String AppName,boolean ischeck){
        this.Package_Name=PackageName;
        this.App_Name=AppName;
        this.ischeck=ischeck;
        //list.add(Package_Name,App_Name,ischeck);
    }

    public void setList(List<AppBean> list)
    {
        this.list = list;
    }

    public List<AppBean> getList()
    {
        return list;
    }
    public void setPackage_Name(String package_Name)
    {
        Package_Name = package_Name;
    }

    public String getPackage_Name()
    {
        return Package_Name;
    }

    public void setApp_Name(String app_Name)
    {
        App_Name = app_Name;
    }

    public String getApp_Name()
    {
        return App_Name;
    }

    public void setIscheck(boolean ischeck)
    {
        this.ischeck = ischeck;
    }

    public boolean getischeck()
    {
        return ischeck;
    }
    
}
