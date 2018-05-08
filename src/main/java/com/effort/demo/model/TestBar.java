package com.effort.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBar {

    @Autowired
    Bar bar;

    public TestBar() {
        //
    }
}