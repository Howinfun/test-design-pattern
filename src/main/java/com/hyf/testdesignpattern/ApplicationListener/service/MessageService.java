package com.hyf.testdesignpattern.ApplicationListener.service;

import com.hyf.testdesignpattern.ApplicationListener.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Howinfun
 * @desc 短信Service
 * @date 2019/5/13
 */
@Service
public class MessageService {

    /**
     * 发送短信
     * @param user
     */
    public void sendMessage(User user){
        System.out.println("给用户"+user.getName()+"发送短信，手机号码为："+user.getPhone());
    }
}
