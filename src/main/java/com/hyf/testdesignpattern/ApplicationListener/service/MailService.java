package com.hyf.testdesignpattern.ApplicationListener.service;

import com.hyf.testdesignpattern.ApplicationListener.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Howinfun
 * @desc 邮件Service
 * @date 2019/5/13
 */
@Service
public class MailService {

    /**
     * 发送邮件
     * @param user
     */
    public void sendEMail(User user){
        System.out.println("给用户"+user.getName()+"发送邮件，EMail为："+user.getMail());
    }
}
