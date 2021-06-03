package com.example.demo.service;

import com.example.demo.vo.UrlInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Shortening Service
 * 예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro
 */
@Service
public class UrlService {

    private static Logger logger = LoggerFactory.getLogger(UrlService.class);

    static Map<String, String> urlMap = new ConcurrentHashMap<>();

    /*
     * - Shortening URL
     * @param urlInfoVO
     * @return
     */
    public UrlInfoVO getShorteningUrl(UrlInfoVO urlInfoVO) {

        String reqUrl = urlInfoVO.getReqUrl();

        String resUrl = "";

        if (urlMap.containsKey(reqUrl)) {
            logger.debug("UrlService > getShorteningUrl > req url saved already");
            resUrl = urlMap.get(reqUrl);

            int originCnt = urlInfoVO.getEqualsReqUrlCnt();
            urlInfoVO.setEqualsReqUrlCnt(originCnt + 1);

        } else {
            logger.debug("UrlService > getShorteningUrl > req url not found, will be saved");

            String randomString = getRandomAlphaStringByN(8);  // 8자리
            String backAddress = InetAddress.getLoopbackAddress().getHostAddress();

            String shorteningUrl = "http://" + backAddress + "/" + randomString;

            logger.debug("UrlService > getShorteningUrl > shorteningUrl : " + shorteningUrl);

            urlMap.put(reqUrl, shorteningUrl);
            resUrl = shorteningUrl;
        }

        urlInfoVO.setResUrl(resUrl);

        return urlInfoVO;
    }

    /*
     * @param N : return random character length
     * @return : random chracter result string
     */
    public String getRandomAlphaStringByN(int N) {

        String alphaStrings = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz";

        StringBuffer sb = new StringBuffer();

        for (int i=0; i<N; i++) {
            int index = (int) (alphaStrings.length() * Math.random());
            sb.append(alphaStrings.charAt(index));
        }

        return sb.toString();
    }


}
