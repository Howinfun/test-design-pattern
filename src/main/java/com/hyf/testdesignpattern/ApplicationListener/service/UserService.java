package com.hyf.testdesignpattern.ApplicationListener.service;

import com.hyf.testdesignpattern.ApplicationListener.entity.User;
import com.hyf.testdesignpattern.ApplicationListener.event.UserEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author Howinfun
 * @desc 用户Service
 * @date 2019/5/13
 */
@Service
@AllArgsConstructor
public class UserService {

    private ApplicationContext applicationContext;
    //private MessageService messageService;
    //private MailService mailService;

    /**
     * 用户注册
     * @param user
     */
    public void registerUser(User user){
        System.out.println("用户："+user.getName()+"注册成功");
        applicationContext.publishEvent(new UserEvent(this,user.getName(),user.getPhone(),user.getMail()));

        // 发送短信&邮件
        //messageService.sendMessage(user);
        //mailService.sendEMail(user);
    }
}
