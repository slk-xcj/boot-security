package com.slk.controller;

import com.slk.pojo.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class SysUserController {

    @GetMapping(value = "/info")
    public AjaxResult getUserInfo(@RequestParam String token) {
        System.out.println("--->>>" + token);

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", "Super Admin");
        userInfo.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");

        return AjaxResult.success(userInfo);
    }
}
