package com.example.demo.service;

import com.example.demo.vo.UrlInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Shortening Service
 * 예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro
 */
@Service
public class UrlService {

    private static Logger logger = LoggerFactory.getLogger(UrlService.class);

    private final String BASIC_URL = "http://localhost:8080";
    private final Map<String, String> urlMap = new ConcurrentHashMap<>();
    private final Map<String, String> shortUrlMap = new ConcurrentHashMap<>();

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

            while(true) {
                if(shortUrlMap.get(randomString) == null) {
                    shortUrlMap.put(randomString, reqUrl);
                    break;
                }
            }


            String shorteningUrl = BASIC_URL + "/" + randomString;

            logger.debug("UrlService > getShorteningUrl > shorteningUrl : " + shorteningUrl);

            urlMap.put(reqUrl, shorteningUrl);
            resUrl = shorteningUrl;
        }

        urlInfoVO.setResUrl(resUrl);

        return urlInfoVO;
    }

    public UrlInfoVO getRedirectUrl(UrlInfoVO urlInfoVO) {

        logger.debug("UrlService > getRedirectUrl > start ");

        String reqRedirectUrl = urlInfoVO.getReqRedirectUrl();


//        String findedKey = urlMap.entrySet()
//                            .stream()
//                            .filter(e -> e.getValue().contains(reqRedirectUrl)).findFirst().get().getKey();

        String resRedirectUrl = shortUrlMap.get(urlInfoVO.getReqRedirectUrl());

        logger.debug("UrlService > getRedirectUrl :" + resRedirectUrl);

        urlInfoVO.setResRedirectUrl(resRedirectUrl);

        logger.debug("UrlService > getRedirectUrl > start ");
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
