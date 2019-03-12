package com.w15104.dataengine.study.utils;

import com.w15104.dataengine.study.basic.CommonException;
import com.w15104.dataengine.study.basic.ErrorCode;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * 将java对象转换成xml格式的字符串
 * 
 * @author cKF7748
 * @date: 2017年11月13日
 * @see: XMLutil
 * @since:
 */
public class XMLutil {
	public static String convertToXml(Object obj) {
		StringWriter sw = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	/**
	 * Description：XML解析为Bean对象
	 * 
	 * @param xmlPath XML路径
	 * @param object  生成Bean类型
	 * @return
	 * @throws CommonException
	 */
	public static Object convertFromXml(String xmlPath, Object object) throws CommonException {
		File file = new File(xmlPath);
		try {
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			object = unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new CommonException(ErrorCode.E_00000);
		}
		return object;
	}
}