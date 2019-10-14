package inkollu.akash.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : akashdhar
 * @date : 13-10-2019
 * @time : 01:25 PM
 */
public class ConfigurationLoader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationLoader.class);
    public static ConcurrentHashMap<String,String> configData;
    public static ConcurrentHashMap<String,String> sourceKeyVsId;
    public static ConcurrentHashMap<String,String> countryMap;

    public void init(){

    }
}
