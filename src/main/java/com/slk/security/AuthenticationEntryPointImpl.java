package com.slk.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slk.pojo.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    private static final Long serialVersionUID = -8970718410437077606L;

    ObjectMapper objectMapper = new ObjectMapper();

    // 认证失败或者Redis中存储用户数据过期导致重新登录会在这里进行处理
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        int code  = 401;
        String msg = "请求访问：" + request.getRequestURI() + "，认证失败，无法访问系统资源";

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().print(objectMapper.writeValueAsString(AjaxResult.error(code, msg)));
    }
}
