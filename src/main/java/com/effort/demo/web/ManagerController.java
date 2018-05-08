package com.effort.demo.web;

import com.effort.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String list() {
        return "manager/list";
    }
}
