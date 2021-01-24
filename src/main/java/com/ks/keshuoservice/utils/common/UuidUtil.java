package com.ks.keshuoservice.utils.common;

import java.util.UUID;

/**
 * UUID 32位
 * 
 * @author renzq
 *
 */
public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "").toUpperCase();
		return uuid;
	}
//	public static void main(String[] args) {
//		System.out.println(get32UUID());
//	}
}

