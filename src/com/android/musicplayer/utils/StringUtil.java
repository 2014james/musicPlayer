package com.android.musicplayer.utils;

import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 
 * 字符串和处理
 * 
 * @author James 2015-6-16
 * 
 */
public class StringUtil {

	/**
	 * 字符串是否为空
	 * 
	 * @param object
	 * 
	 * @return
	 */
	public static boolean isValidString(String str) {
		if (null != str && !"".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * 字符串是否是纯数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 
	 * @param length
	 * @param value
	 * @return
	 */
	public static String subStr(int length, String value) {
		String testValue = null;
		if (value.length() > length) {
			testValue = value.substring(0, length) + "..";
		} else {
			testValue = value;
		}
		return testValue;
	}

	/**
	 * 过滤标点符号
	 * 
	 * @param str
	 * @return
	 */
	public static String deleteSymbol(String str) {

		String result = "";
		try {
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			result = m.replaceAll("").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * int 转字节
	 * 
	 * @param aint
	 * @return
	 */
	public static byte[] getBytes(int aint) {

		byte[] bytes = ByteBuffer.allocate(4).putInt(aint).array();
		byte tmp = bytes[0];
		bytes[0] = bytes[3];
		bytes[3] = tmp;

		tmp = bytes[1];
		bytes[1] = bytes[2];
		bytes[2] = tmp;

		return bytes;
	}

	/***
	 * 转成2个字节
	 * 
	 * @param sh
	 * @return
	 */
	public static byte[] getBytes2(short sh) {
		byte[] bytes = ByteBuffer.allocate(2).putShort(sh).array();

		byte tmp = bytes[0];
		bytes[0] = bytes[1];
		bytes[1] = tmp;

		return bytes;
	}

	/**
	 * 判断字符串是否含有数字
	 * 
	 * @param content
	 * @return
	 */
	public static boolean hasDigit(String content) {
		boolean flag = false;
		Pattern p = Pattern.compile(".*\\d+.*");
		Matcher m = p.matcher(content);
		if (m.matches())
			flag = true;
		return flag;

	}

	/**
	 * 截取字符串数字部分
	 * 
	 * @param content
	 * @return
	 */
	public static String getNumbers(String content) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return matcher.group(0);
		}
		return "";
	}

	/***
	 * 
	 * 获取数字
	 * 
	 * @return
	 */
	public static int getNumberFromStr(String text) {
		int num = 0;
		try {
			if (hasDigit(text)) {
				String str = getNumbers(text);
				num = Integer.valueOf(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;

	}

	/***
	 * 返回当前str在整个字符串的位置
	 * 
	 * @param text
	 *            整个字符串
	 * @param str
	 *            “查”等关键词
	 * @return
	 */
	public static int getIndexStr(String text, String str) {
		if (text.contains(text)) {
			return text.indexOf(str);
		}
		return -1;
	}

	/**
	 * 
	 * @author James
	 * @Description 中文转换成utf-8
	 * @param str
	 * @return
	 */
	public static String getUTFStr(String str) {
		try {
			return URLEncoder.encode(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @author James
	 * @Description 解析音乐url
	 * @param url
	 * @return
	 */
	public static String getMusicDownLoadHost(String url) {

		int index = url.lastIndexOf("/");
		url = url.substring(0, index + 1);

		return url;
	}

	/**
	 * 
	 * @author James
	 * @Description 获取DVR拍照返回的path
	 * @param path
	 * @return
	 */
	public static String[] getPicPath(String path) {
		String[] str = new String[2];
		if (StringUtil.isValidString(path)) {
			int index = path.indexOf(",");
			if (index != -1) {
				String path1 = path.substring(0, index);
				String path2 = path.substring(index + 1, path.length());
				str[0] = path1;
				str[1] = path2;

			}
		}
		return str;
	}
}
