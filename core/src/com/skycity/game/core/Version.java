package com.skycity.game.core;

public  class Version {

    // 主版本，表示有大的更新,api 不兼容
    public int major;

    // 添加新功能，兼容旧版本
    public double minor;

    public Version(int major,double minor){
        this.major=major;
        this.minor=minor;
    }

    public  String getVersion(){
        return this.toString();
    }

    // 显示 x.x.x
    @Override
    public String toString() {
        return "v."+this.major+"."+this.minor;
    }
}
