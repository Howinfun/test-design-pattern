package com.hyf.testdesignpattern.ApplicationListener.service;

import com.hyf.testdesignpattern.ApplicationListener.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Howinfun
 * @desc 短信Service
 * @date 2019/5/13
 */
@Service
@Slf4j
public class MessageService {

    /**
     * 发送短信
     * @param user
     */
    public void sendMessage(User user){
        log.info("给用户"+user.getName()+"发送短信，手机号码为："+user.getPhone());
    }
}
