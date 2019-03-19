package com.w15104.demo.study.basic.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *
 * @Description Json工具类
 *
 * @author w15654
 * @data: 2019-3-15
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class JsonUtil {

	private JsonUtil() {
	}
	
    /**
     *  bean对象转json
     * @param object bean对象
     * @return  json字符串
     */
    public static String beanToJson(Object object){
        if(null!=object){
            return JSON.toJSONString(object);
        }
        return null;
    }

    /**
     *  string转json
     * @param key   键
     * @param value 值
     * @return  json字符串
     */
    public static String stringToJson(String key, String value){
        if(StringUtils.isEmpty(key) || StringUtils.isEmpty(value)){
            return null;
        }
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        return beanToJson(map);
    }

    /**
     *  json转对象
     * @param json   json字符串
     * @param clazz  对象类型
     * @return  bean对象
     */
    public static <T> T jsonToBean(String json, Class<T> clazz){
        if(StringUtils.isEmpty(json) || null == clazz){
            return null;
        }
        return JSON.parseObject(json, clazz);
    }

    /**
     *  json转对象数组
     * @param json   json字符串
     * @param clazz  对象类型
     * @return  bean对象数组
     */
    public static <T> List<T> jsonToBeanList(String json, Class<T> clazz){
        if(StringUtils.isEmpty(json) || null == clazz){
            return Collections.emptyList();
        }
        return JSON.parseArray(json, clazz);
    }

    /**
     *  json转map
     * @param json json字符串
     * @return  map对象
     */
    @SuppressWarnings("unchecked")
    public static <T> Map<String, T> jsonToMap(String json){
        if(StringUtils.isEmpty(json)){
            return null;
        }
        return JSON.parseObject(json, Map.class);
    }

    /**
     *  json转map数组
     * @param json json字符串
     * @return  map对象数组
     */
    public static <T> List<Map<String, T>> jsonToMapList(String json){
        if(StringUtils.isEmpty(json)){
            return Collections.emptyList();
        }
        return JSON.parseObject(json, new TypeReference<List<Map<String, T>>>(){
        });
    }
}
