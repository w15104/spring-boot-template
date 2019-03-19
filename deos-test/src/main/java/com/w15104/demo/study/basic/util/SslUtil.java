package com.w15104.demo.study.basic.util;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.extern.slf4j.Slf4j;


/*
 *
 * @Description 忽略Java请求HTTPS证书认证类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@Slf4j
public class SslUtil {

    /**
     * 忽略所有HTTPS请求证书，必须在openConnection调用之前
     * @throws Exception 异常
     */
    public static void ignoreSsl() throws Exception{

        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
               log.info("Warning: URL Host: {} vs. {}", urlHostName, session.getPeerHost());
               return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    /**
     * 信任所有HTTPS证书
     * @throws Exception 异常
     */
    private static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        TrustManager tm = new MiTM();
        trustAllCerts[0] = tm;
        SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    /**
     * miTM类
     */
    static class MiTM implements TrustManager, X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException { }

        public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {  }
    }

}
