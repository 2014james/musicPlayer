package com.android.musicplayer.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 自定义toast
 * 
 * @author James 2015-7-2
 * 
 */
public class ToastUtil {

	public static void showToastShort(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}

	public static void showToastLength(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}

}
