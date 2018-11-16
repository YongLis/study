/**
 * 
 */
package com.sh.guessgame.utils.common;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author John Lee
 * 
 */
public class ObjectUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(ObjectUtil.class);

	/**
	 * 将对象中的值拷贝到map中
	 *
	 * @param object
	 * @return Map
	 */
	public static Map build(Object object) {
		if (null == object) {
			return null;
		}
		if (object instanceof Map) {
			return (Map) object;
		}
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			PropertyDescriptor pds[] = PropertyUtils.getPropertyDescriptors(object.getClass());
			for (PropertyDescriptor pd : pds) {
				Method read = pd.getReadMethod();
				if (read != null) {
					Object value = read.invoke(object);
					if (value != null && value.getClass() != Class.class) {
						map.put(pd.getDisplayName(), value);
					}
				}
			}
			return map;
		} catch (Exception e) {
			LOGGER.error("object build exception",e);
		}
		return null;
	}
	
	/**
	 * 批量将对象中的值拷贝到map中
	 *
	 * @param List<Object>
	 * @return List<Map>
	 */
	public static List<Map> buildBatch(List<? extends Object> objects) {
		List<Map> list = new ArrayList<Map>();
		for (Object object : objects) {
			Map map = build(object);
			if (null != map) {
				list.add(map);
			}
		}
		return list;
	}
	

	private static Object getFieldValue(Object object, String fieldName) throws Exception {
		PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(object, fieldName);
		if (propertyDescriptor != null) {
			Method reader = propertyDescriptor.getReadMethod();
			if (reader != null) {
				Object value = reader.invoke(object);
				if (value != null && value.getClass() != Class.class) {
					return value;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param entityClass
	 * @param object
	 * @return
	 */
	public static <T> T build(Class<T> entityClass, Object object) {

		if (null == entityClass || null == object) {
			return null;
		}
		if (object instanceof Map) {
			return buildFromMap(entityClass, (Map) object);
		}

		try {
			T obj = entityClass.newInstance();

			PropertyDescriptor pd1[] = PropertyUtils.getPropertyDescriptors(entityClass);
			PropertyDescriptor pd2[] = PropertyUtils.getPropertyDescriptors(object);

			Map<String, PropertyDescriptor> map = new HashMap<String, PropertyDescriptor>();
			for (PropertyDescriptor pd : pd1) {
				map.put(pd.getDisplayName(), pd);
			}
			for (PropertyDescriptor pd : pd2) {
				PropertyDescriptor _pd = map.get(pd.getDisplayName());
				if (null != _pd) {
					Method write = _pd.getWriteMethod();
					Method read = pd.getReadMethod();
					if (null != write && null != read && _pd.getPropertyType().isAssignableFrom(pd.getPropertyType())) {
						Object value = read.invoke(object);
						if (null == value) {
							continue;
						}
						write.invoke(obj, value);
					}
				}
			}
			return obj;
		} catch (Exception e) {
			LOGGER.error("build exception",e);
		}
		return null;
	}

	/**
	 * 
	 * @param entityClass
	 * @param map
	 * @return
	 */
	public static <T> T buildFromMap(Class<T> entityClass, Map object) {

		if (null == entityClass || null == object) {
			return null;
		}

		try {
			T obj = entityClass.newInstance();

			PropertyDescriptor pd1[] = PropertyUtils.getPropertyDescriptors(entityClass);
			Map<String, PropertyDescriptor> map = new HashMap<String, PropertyDescriptor>();
			for (PropertyDescriptor pd : pd1) {
				map.put(pd.getDisplayName(), pd);
			}

			for (Object key : object.keySet()) {
				Object value = object.get(key);
				if (key == null || value == null) {
					continue;
				}
				PropertyDescriptor _pd = map.get(key.toString());
				if (null != _pd) {
					Method write = _pd.getWriteMethod();
					if (null != write && _pd.getPropertyType().isAssignableFrom(value.getClass())) {
						write.invoke(obj, value);
					}
				}
			}
			return obj;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}

	/**
	 * 
	 * @param entityClass
	 * @param objects
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> buildBatch(Class<T> entityClass, List objects) {
		List<T> list = new ArrayList<T>();
		for (Object object : objects) {
			T t = build(entityClass, object);
			if (null != t) {
				list.add(t);
			}
		}

		return list;
	}

}
