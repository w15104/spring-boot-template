package com.w15104.demo.study.basic.util;

import com.w15104.demo.study.basic.exception.CommonException;
import com.w15104.demo.study.basic.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/*
 *
 * @Description RestUtils工具类，用户发起http及https请求
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
public class RestUtils {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(RestUtils.class);

    /**
     * RestTemplate template
     */
    private static final RestTemplate template = new RestTemplate();

    /**
     * 发送Request请求
     * @param url URL
     * @param httpMethod 请求方法
     * @param requestEntity 携带的数据
     * @param responseType 返回类型
     * @param uriVariables 参数
     * @param <T> T
     * @return T
     */
    public static <T> T sendRequest(String url, HttpMethod httpMethod, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) {
        try {
            logger.info("begin send request by RestTemplate");
            SslUtil.ignoreSsl();
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            //连接超时时长
            requestFactory.setConnectTimeout(1500);
            requestFactory.setReadTimeout(1000);
            template.setRequestFactory(requestFactory);
            return template.exchange(url, httpMethod, requestEntity, responseType, uriVariables).getBody();
        }catch (Exception e){
            throw new CommonException(ErrorCode.E_00013, e);
        }
    }

}
