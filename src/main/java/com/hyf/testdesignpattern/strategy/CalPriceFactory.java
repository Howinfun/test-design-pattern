package com.hyf.testdesignpattern.strategy;

import com.hyf.testdesignpattern.strategy.calprice.*;

/**
 * 策略工厂
 */
public class CalPriceFactory {

    private CalPriceFactory(){}

    public static CalPrice handleCalPrice(Consumer consumer){
        if(consumer.getTotalAmount() >  3000){
            return new GoldVip();
        }else if(consumer.getTotalAmount() >  2000){
            return new SuperVip();
        }else if(consumer.getTotalAmount() > 1000){
            return new Vip();
        }else{
            return new Common();
        }

    }
}
