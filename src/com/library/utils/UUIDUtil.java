package com.library.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String getUUID(){
		return UUID.randomUUID().toString();//获取一个随机数
	}
	
//	public static void main(String[] args) {
//		System.out.println(getUUID());
//	}
}
