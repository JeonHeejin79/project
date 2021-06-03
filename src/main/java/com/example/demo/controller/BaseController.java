package com.example.demo.controller;

import com.example.demo.vo.UrlInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BaseController {

//    @GetMapping("")
//    public String index() {
//        return "index";
//    }

    @PostMapping("/goToUrl")
    public RedirectView goToUrl(@RequestBody UrlInfoVO urlInfoVO) {

        String originUrl = urlInfoVO.getReqUrl();

        RedirectView redirectView = new RedirectView();

        redirectView.setUrl(originUrl);

        return redirectView;
    }

}
