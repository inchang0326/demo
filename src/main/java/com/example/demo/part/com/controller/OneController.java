package com.example.demo.part.com.controller;

import ch.qos.logback.classic.Logger;
import com.example.demo.part.com.service.OneService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
public class OneController {

    // 기본적으로 com.example.javademo.part.com.controller 패키지 내 controller 로깅
    private static Logger log = (Logger) LoggerFactory.getLogger(OneController.class);

    @Autowired
    OneService oneService;

    @GetMapping
    public String one() {

        log.info("log info");
        log.debug("log debug");

        return oneService.one();
    }
}