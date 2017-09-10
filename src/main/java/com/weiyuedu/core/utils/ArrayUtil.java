package com.weiyuedu.core.utils;

import org.apache.commons.lang3.ArrayUtils;
/**
 * 描述:数组操作工具类
 * 创建人: w349037273@163.com
 * 日期: 2017-09-05
 * 时间: 08:12
 */
public class ArrayUtil {

    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

    /**
     * 连接数组
     */
    public static Object[] concat(Object[] array1, Object[] array2) {
        return ArrayUtils.addAll(array1, array2);
    }

    /**
     * 判断对象是否在数组中
     */
    public static <T> boolean contains(T[] array, T obj) {
        return ArrayUtils.contains(array, obj);
    }
}
