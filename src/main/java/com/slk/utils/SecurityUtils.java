package com.slk.utils;

import com.slk.exception.ServiceException;
import com.slk.pojo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        // SecurityContextHolder中持有的是当前用户的SecurityContext
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /*
    * 获取登录用户
    * */
    public static LoginUser getLoginUser() {
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new ServiceException(20001, "用户信息获取异常");
        }
    }
}
