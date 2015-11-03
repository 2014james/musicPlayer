package com.android.musicplayer.utils;

import java.util.Stack;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

/**
 * 
 * @author James
 * @Package com.framework.util
 * @Title: AppManager.java
 * @Description Activity管理类
 * @date 2015-11-2
 * @version 1.0
 * 
 */
public class AppManager {
	//所有Activity集合
	public static Stack<Activity> mActivityStack;
	private static AppManager mAppManager;
	private static Stack<Activity> mFinishActivityStack = new Stack<Activity>();

	private AppManager() {
	}

	/**
	 * 单一实例
	 */
	public static AppManager getInstance() {
		if (mAppManager == null) {
			mAppManager = new AppManager();
		}
		return mAppManager;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (mActivityStack == null) {
			mActivityStack = new Stack<Activity>();
		}
		mActivityStack.add(activity);
	}

	/**
	 * 获取栈顶Activity（堆栈中最后一个压入的）
	 */
	public Activity getTopActivity() {
		Activity activity = mActivityStack.lastElement();
		return activity;
	}

	/**
	 * 结束栈顶Activity（堆栈中最后一个压入的）
	 */
	public void killTopActivity() {
		Activity activity = mActivityStack.lastElement();
		killActivity(activity);
	}

	/**
	 * 结束指定的Activity
	 */
	public void killActivity(Activity activity) {
		if (activity != null) {
			mActivityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void killActivity(Class<?> cls) {
		if (mActivityStack != null) {
			for (Activity act : mActivityStack) {
				if (act.getComponentName().getClassName().equals(cls.getName())) {
					act.finish();
					mActivityStack.remove(act);
				}
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void killAllActivity() {
		for (int i = 0, size = mActivityStack.size(); i < size; i++) {
			if (null != mActivityStack.get(i)) {
				mActivityStack.get(i).finish();
			}
		}
		mActivityStack.clear();
	}

	/**
	 * finish除了主activity的所有activity
	 */
	public void backHomeActivity() {
		if (mActivityStack == null || mActivityStack.size() == 0) {
			return;
		}
		synchronized (mActivityStack) {
			for (Activity act : mActivityStack) {
				if (act.isTaskRoot()) {
					continue;
				} else {
					act.finish();
					mFinishActivityStack.add(act);
				}
			}

			mActivityStack.removeAll(mFinishActivityStack);
			mFinishActivityStack.clear();
		}
	}

	/**
	 * 判断Activity是否打开过
	 * */
	protected boolean isActvityHaveOpen(Class<?> sub) {
		if (mActivityStack == null || mActivityStack.size() == 0) {
			return false;
		}
		synchronized (mActivityStack) {
			for (Activity act : mActivityStack) {
				if (act.getComponentName().getClassName().equals(sub.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 退出应用程序
	 */
	public void appExit(Context context) {
		try {
			killAllActivity();
			android.os.Process.killProcess(android.os.Process.myPid());
			// System.exit(0);
		} catch (Exception e) {
		}
	}
}
