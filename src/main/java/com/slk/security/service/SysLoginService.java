package com.slk.security.service;

import com.slk.exception.ServiceException;
import com.slk.pojo.LoginUser;
import com.slk.token.TokenService;
import org.apache.juli.logging.Log;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SysLoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenService tokenService;

    public String login(String username, String password) {
        // 用户验证
        Authentication authentication = null;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof BadCredentialsException)
            {
                throw new RuntimeException("user.password.not.match");
            }
            else
            {
                throw new ServiceException(e.getMessage());
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 生成token
        return tokenService.createToken(loginUser);
    }
}
