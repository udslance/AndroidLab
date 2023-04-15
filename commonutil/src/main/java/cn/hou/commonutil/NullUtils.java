package cn.hou.commonutil;

import java.util.List;
import java.util.Map;

/**
 * NullUtils 是一个工具类，提供了一些用于检查对象是否为空的静态方法。
 * 
 * @author H 
 * @since 2023-04-15
 */
public class NullUtils {

    /**
     * 检查 CharSequence 对象是否为空。
     *
     * @param str 要检查的 CharSequence 对象。
     * @return 如果 CharSequence 对象为 null 或长度为 0，则返回 true，否则返回 false。
     */
    public static boolean isNull(CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * 检查字符串是否为空。
     *
     * @param str 要检查的字符串。
     * @return 如果字符串为 null 或长度为 0，则返回 true，否则返回 false。
     */
    public static boolean isNull(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 检查 List 对象是否为空。
     *
     * @param list 要检查的 List 对象。
     * @return 如果 List 对象为 null 或元素个数为 0，则返回 true，否则返回 false。
     */
    public static boolean isNull(List<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * 检查 Map 对象是否为空。
     *
     * @param map 要检查的 Map 对象。
     * @return 如果 Map 对象为 null 或元素个数为 0，则返回 true，否则返回 false。
     */
    public static boolean isNull(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 检查数组是否为空。
     *
     * @param array 要检查的数组对象。
     * @return 如果数组对象为 null 或长度为 0，则返回 true，否则返回 false。
     */
    public static boolean isNull(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 检查对象是否为 null。
     *
     * @param object 要检查的对象。
     * @return 如果对象为 null，则返回 true，否则返回 false。
     */
    public static boolean isNull(Object object) {
        return object == null;
    }
}

