package com.tlias.controller;


import com.tlias.pojo.Result;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ResponseController {
    @RequestMapping("/dateParam")
    public String dataParam (@DateTimeFormat(pattern = "yyyy-MM-dd") Date updateTime) {
        System.out.println(updateTime);
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
        String formatTime = sf.format(updateTime);
        System.out.println(formatTime);
        return "ok";
    }

    @GetMapping("/hello")
    public Result hello () {
        return Result.SUCCESS("hello Java ~");
    }
}
