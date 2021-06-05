package com.example.demo.service;

import com.example.demo.vo.UrlInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UrlServiceTest {

    @Autowired
    UrlService urlService;

    @Test
    public void getShorteningUrlTest() {
        UrlInfoVO request = new UrlInfoVO();
        int reqCnt = 0;
        String reqUrl = "https://en.wikipedia.org/wiki/URL_shortening";

        //첫번째 요청
        request.setReqUrl(reqUrl);
        reqCnt++;

        UrlInfoVO response1 = urlService.getShorteningUrl(request);

        String resUrl1 = response1.getResUrl();

        // 두번째 요청
        request.setReqUrl(reqUrl);
        reqCnt++;

        UrlInfoVO response2 = urlService.getShorteningUrl(request);

        String resUrl2 = response2.getResUrl();

        // test case 1 )
        // 같은 url 로 두번 요청시, 다시 랜던값을 안받아오고
        // 기존맵에서 찾아와서 값이 같은지 확인
        assertEquals(resUrl1, resUrl2);

        // test case 2 )
        // 같은  url 로 요청시 카운트 체크
        assertEquals(reqCnt, response2.getEqualsReqUrlCnt());

    }

}