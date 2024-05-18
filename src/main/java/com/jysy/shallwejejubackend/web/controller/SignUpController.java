package com.jysy.shallwejejubackend.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @PostMapping("/api/SignUp")
    public String signUp() {
        return "4321";
    }

}
