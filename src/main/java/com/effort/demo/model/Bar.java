package com.effort.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Component
@Validated
public class Bar {
    public String validString(
            @Size(min = 1, max = 3)
                    String vStr) {
        return vStr;
    }
}
