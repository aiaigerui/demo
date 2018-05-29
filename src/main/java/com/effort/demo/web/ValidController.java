package com.effort.demo.web;


import com.effort.demo.javabean.Bar;
import com.effort.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@RestController
@Validated
public class ValidController {

    @Autowired
    Bar bar;
    @Value("${example.message}")
    private String message;

    @RequestMapping(value = "/validString", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex(@Min(value = 3, message = "最少3位")
                            @RequestParam int a) {
        //return message;
        return bar.validString("123");
    }

    @RequestMapping(value = "validObject", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public User validObject(
            @RequestBody User user) {

        return user;
    }

    @RequestMapping(value = "validString", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String validString(
            @RequestBody
            @Size(min = 1, max = 3)
                    String vStr) {
        return vStr;
    }

}