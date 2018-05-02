package com.lzx.listenmovieapp.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * json解析
 *
 * @version [版本号, 2015-7-22]
 */
public class JsonUtil {
    /**
     * 对象转json
     *
     * @param entity
     * @return String
     * @author Desmond 2014-10-15 上午10:40:06
     */
    public static String entityToJson(Object entity) {
        String json = null;
        try {
            json = new Gson().toJson(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * json转单个对象
     *
     * @param <T>
     * @param <T>
     * @param json
     * @param clazz
     * @return Object
     * @author Desmond 2014-10-15 上午10:40:16
     */
    public static <T> T jsonToEntity(String json, Class<T> clazz) {
        T t = null;
        try {
            t = new Gson().fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * json转对象集合
     *
     * @param json
     * @param typeToken 例：new TypeToken<List<Person>>(){}
     * @param <T>
     * @return Object
     * @author Desmond 2014-10-15 上午10:40:31
     */
    public static <T> T jsonToEntity(String json, TypeToken<T> typeToken) {
        T t = null;
        try {
            t = new Gson().fromJson(json, typeToken.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

}
