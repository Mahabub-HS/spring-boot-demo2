package com.example.demolibrary.controller;

import com.example.demolibrary.model.MyInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyInfoController {
    @GetMapping("/myinfo")
    public MyInfo getMyInfo(){
        MyInfo myInfo = new MyInfo("MHS Demo Library","1.0.0","Md Mahabub Hossain Shozib",2017000000128l);
        return myInfo;
    }
}
