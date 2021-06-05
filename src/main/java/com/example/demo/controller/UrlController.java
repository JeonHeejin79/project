package com.example.demo.controller;

import com.example.demo.service.UrlService;
import com.example.demo.vo.UrlInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/getShorteningUrl")
    public UrlInfoVO getUrl(@RequestBody UrlInfoVO urlInfoVO) {

        UrlInfoVO res = null;

        res = urlService.getShorteningUrl(urlInfoVO);

        return res;
    }

}
