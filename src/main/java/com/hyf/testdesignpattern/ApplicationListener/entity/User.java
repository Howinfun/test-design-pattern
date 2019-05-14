package com.hyf.testdesignpattern.ApplicationListener.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Howinfun
 * @desc
 * @date 2019/5/13
 */
@Data
public class User implements Serializable {
    private String name;
    private String phone;
    private String mail;
}
