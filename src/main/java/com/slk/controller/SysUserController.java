package com.slk.controller;

import com.slk.pojo.AjaxResult;
import com.slk.utils.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SysUserController {

    @GetMapping(value = "/user/info")
    public AjaxResult getUserInfo(@RequestParam String token) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", "Super Admin");
        userInfo.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");

        return AjaxResult.success(userInfo);
    }

    @GetMapping(value = "/table/list")
    public AjaxResult getTableList() {
        System.out.println("userName:" + SecurityUtils.getLoginUser().getUserName());

        List<Map<String, Object>> taleInfo = new ArrayList<>();

        Map<String, Object> bookMap = new HashMap<>();
        bookMap.put("id", "book_0001");
        bookMap.put("title", "Security在前后端分离中不好用");
        bookMap.put("author", "Super Cui");
        bookMap.put("display_time", "2022-10-13");
        bookMap.put("pageviews", "999+");
        bookMap.put("status", "火爆");

        taleInfo.add(bookMap);
        return AjaxResult.success(taleInfo);
    }
}
