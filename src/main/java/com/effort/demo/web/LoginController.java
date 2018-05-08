package com.effort.demo.web;

import com.effort.demo.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String login() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (!StringUtils.isEmpty(user)) {
            return "manager/list";
        }
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(
            @RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,
            HttpServletRequest request) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (!StringUtils.isEmpty(user)) {
            return "manager/list";
        }
        String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        logger.info(userName + "---" + error);

        return "login";
    }
}
