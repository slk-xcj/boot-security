package com.slk.controller;

import com.slk.constant.Constants;
import com.slk.pojo.AjaxResult;
import com.slk.pojo.LoginFormVo;
import com.slk.security.service.SysLoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SysLoginController {

    @Resource
    private SysLoginService loginService;

    @PostMapping(value = "/login")
    public AjaxResult login(@RequestBody LoginFormVo loginForm) {
        AjaxResult result = AjaxResult.success();
        // 生成token令牌
        String token = loginService.login(loginForm.getUsername(), loginForm.getPassword());
        result.put(Constants.TOKEN, token);
        return result;
    }
}
