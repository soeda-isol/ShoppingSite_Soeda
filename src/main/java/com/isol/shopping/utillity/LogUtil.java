package com.isol.shopping.utillity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

	private static final Logger logger = LoggerFactory.getLogger("ApplicationLogger");

	public static void info(String message, Object... args) {
		logger.info(message, args);//正常系の情報提供
	}

	public static void warn(String message, Object... args) {
		logger.warn(message, args);//間違っているがエラーにはならない情報
	}

	public static void error(String message, Object... args) {
		logger.error(message, args);//エラーが起こって中断する情報
	}

	public static void debug(String message, Object... args) {
		logger.debug(message, args);//開発者向けに情報提供
	}

}
