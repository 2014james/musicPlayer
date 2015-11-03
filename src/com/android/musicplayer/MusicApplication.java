package com.android.musicplayer;

import com.android.musicplayer.utils.MyLog;

import android.app.Application;

/***
 * @author James
 * @Package com.android.musicplayer
 * @Title: MusicApplication.java
 * @Description
 * @date 2015-11-2
 * @version 1.0
 * 
 */
public class MusicApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		
		// 打开log打印
		MyLog.setLog(true);

	}

}
