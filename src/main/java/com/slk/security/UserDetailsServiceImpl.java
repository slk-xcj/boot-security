package com.slk.security;

import com.slk.exception.ServiceException;
import com.slk.pojo.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟数据库查询
        LoginUser loginUser = null;
        if (username.equals("admin")) {
            // admin admin123
            loginUser = new LoginUser("admin", "$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2", "");
        }

        if (loginUser == null) {
            log.info("登录用户：{}不存在", username);
            throw new ServiceException("登录用户：" + username + "不存在");
        }
        return loginUser;
    }
}
