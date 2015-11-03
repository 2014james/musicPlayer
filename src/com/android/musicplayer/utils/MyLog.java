package com.android.musicplayer.utils;


/***
 * @author James
 * @Package com.android.musicplayer.utils
 * @Title: MyLog.java
 * @Description
 * @date 2015-11-2
 * @version 1.0
 * 
 */
public class MyLog {

	// 默认打印
	public static boolean log = true;

	/**
	 * 
	 * @author James
	 * @Description 设置是否打印
	 * @param l
	 */
	public static void setLog(boolean l) {
		log = l;
	}

	public static void v(String tag, String msg) {
		if (log) {
			android.util.Log.v(tag, msg);
		}
	}

	public static void v(String tag, String msg, Throwable tr) {
		if (log) {
			android.util.Log.v(tag, msg, tr);
		}
	}

	public static void d(String tag, String msg) {
		if (log) {
			android.util.Log.d(tag, msg);
		}
	}

	public static void d(String tag, String msg, Throwable tr) {
		if (log) {
			android.util.Log.d(tag, msg, tr);
		}
	}

	public static void i(String tag, String msg) {
		if (log) {
			android.util.Log.i(tag, msg);
		}
	}

	public static void i(String tag, String msg, Throwable tr) {
		if (log) {
			android.util.Log.i(tag, msg, tr);
		}
	}

	public static void w(String tag, String msg) {
		if (log) {
			android.util.Log.w(tag, msg);
		}
	}

	public static void w(String tag, String msg, Throwable tr) {
		if (log) {
			android.util.Log.w(tag, msg, tr);
		}
	}

	public static void w(String tag, Throwable tr) {
		if (log) {
			android.util.Log.w(tag, tr);
		}
	}

	public static void e(String tag, String msg) {
		if (log) {
			android.util.Log.e(tag, msg);
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (log) {
			android.util.Log.e(tag, msg, tr);
		}
	}

}
