package com.mj.time.controller;

import com.mj.time.common.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time/version")
public class VersionController {
    @GetMapping
    CommonResponse<String> getAllMenu() {
        return new CommonResponse<>("20201115");
    }
}
