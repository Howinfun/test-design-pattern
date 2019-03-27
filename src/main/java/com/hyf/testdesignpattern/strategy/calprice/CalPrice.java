package com.hyf.testdesignpattern.strategy.calprice;

public interface CalPrice {
    // 根据等级返回优惠后价格
    Double calPrice(Double originalPrice);
}
