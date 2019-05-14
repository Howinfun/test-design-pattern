package com.hyf.testdesignpattern.ApplicationListener.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author Howinfun
 * @desc
 * @date 2019/5/13
 */
@Data
public class UserEvent extends ApplicationEvent {
    private String name;
    private String phone;
    private String mail;
    public UserEvent(Object source,String name,String phone,String mail) {
        super(source);
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }
}
