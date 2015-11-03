package com.android.musicplayer.activity;

import com.android.musicplayer.MusicApplication;
import com.android.musicplayer.utils.AppManager;
import com.android.musicplayer.utils.AppUtils;
import com.android.musicplayer.utils.ToastUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

/***
 * @author James
 * @Package com.android.musicplayer.activity
 * @Title: BaseActivity.java
 * @Description Activity基类，所有Activity继承此类
 * @date 2015-11-2
 * @version 1.0
 * 
 */
public class BaseActivity extends Activity {

	private AppUtils app_util;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	private long exitTime = 0;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// 第一次弹出提醒
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000
					&& AppManager.mActivityStack.contains(getActivityName())) {
				ToastUtil.showToastShort(this, "再按一次退出程序");
				exitTime = System.currentTimeMillis();
				// 再按，退出程序
			} else if (AppManager.mActivityStack.contains(getActivityName())) {
				if (getApplication() instanceof MusicApplication) {
					AppManager.getInstance().appExit(this);
				}
			}
		}
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& AppManager.mActivityStack.contains(getActivityName())) {
			return true;

			// 关闭Activity
		} else if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (getApplication() instanceof MusicApplication) {
				AppManager.getInstance().killActivity(this);
			}
			return true;
		}
		return onKeyDown(keyCode, event);
	}

	/**
	 * 获取当前正在运行的Activity
	 * 
	 * @return
	 */
	private String getActivityName() {
		return app_util.getActivityName();
	}

}
