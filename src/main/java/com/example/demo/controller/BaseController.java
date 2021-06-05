package com.example.demo.controller;

import com.example.demo.service.UrlService;
import com.example.demo.vo.UrlInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BaseController {

    private final UrlService urlService;

    public BaseController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/favicon.ico")
    public String favicon() {
        return "forward:/resources/favicon.ico";
    }

    @GetMapping("/{shortUrl}")
    public RedirectView goToUrl(@PathVariable String shortUrl) {
        UrlInfoVO request = new UrlInfoVO();
        request.setReqRedirectUrl(shortUrl);

        UrlInfoVO response = urlService.getRedirectUrl(request);

        RedirectView redirectView = new RedirectView();

        redirectView.setUrl(response.getResRedirectUrl());

        return redirectView;
    }

}
