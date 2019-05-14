package com.hyf.testdesignpattern.ApplicationListener.listener;

import com.hyf.testdesignpattern.ApplicationListener.entity.User;
import com.hyf.testdesignpattern.ApplicationListener.event.UserEvent;
import com.hyf.testdesignpattern.ApplicationListener.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Howinfun
 * @desc 发送短信ApplicationListener
 * @date 2019/5/13
 */
@Component
@Async
public class MessageApplicatinoListener implements ApplicationListener<UserEvent> {

    @Autowired
    private MessageService messageService;

    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        User user = new User();
        BeanUtils.copyProperties(userEvent,user);
        // 发送短信
        messageService.sendMessage(user);
    }
}
