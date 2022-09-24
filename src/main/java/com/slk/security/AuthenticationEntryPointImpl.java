package com.slk.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slk.pojo.AjaxResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    private static final Long serialVersionUID = -8970718410437077606L;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        int code  = 401;
        String msg = "请求访问：" + request.getRequestURI() + "，认证失败，无法访问系统资源";

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().print(objectMapper.writeValueAsString(AjaxResult.error(code, msg)));
    }
}
