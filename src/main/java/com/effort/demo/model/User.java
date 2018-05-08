package com.effort.demo.model;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@TableName("ef_user")
public class User implements Serializable {
    private Long id;
    private String userName;
    private String passWord;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
