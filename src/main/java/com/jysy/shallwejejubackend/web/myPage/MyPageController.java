package com.jysy.shallwejejubackend.web.myPage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPageController {

    @GetMapping("/api/MyPage")
    public String myPage(){
        return "myPAge";
    }

}
