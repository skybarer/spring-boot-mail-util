package inkollu.akash.mail.util.http.client;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @author : akashdhar
 * @date : 08-10-2019
 * @time : 09:10 PM
 */
public class NoopHostnameVerifier implements HostnameVerifier {
    public static final NoopHostnameVerifier INSTANCE = new NoopHostnameVerifier();


    @Override
    public boolean verify(String s, SSLSession sslSession) {
        return false;
    }

    @Override
    public final String toString() {
        return "NO_OP";
    }
}
