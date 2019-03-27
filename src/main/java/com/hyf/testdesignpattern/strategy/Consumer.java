package com.hyf.testdesignpattern.strategy;

import com.hyf.testdesignpattern.strategy.calprice.CalPrice;
import lombok.Data;

/**
 * 消费者
 */
@Data
public class Consumer {

    private Double totalAmount = 0d; // 总消费额
    private Double lastAmount = 0d;  // 当前消费额
    private CalPrice calPrice;  // 消费策略

    // 进行消费打折处理
    public void buy(Double amount){
        this.lastAmount = amount;
        this.totalAmount += amount;
        //calPrice = CalPriceFactory.handleCalPrice(this);
        calPrice = CalPriceFactoryS.getInstance().handleCalPrice(this);
    }

    // 最后需要付费金额
    public Double callLastAmount(){
        return calPrice.calPrice(lastAmount);
    }
}
