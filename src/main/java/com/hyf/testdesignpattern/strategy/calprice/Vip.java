package com.hyf.testdesignpattern.strategy.calprice;

import com.hyf.testdesignpattern.strategy.annotation.TotalValidRegion;
import com.hyf.testdesignpattern.strategy.annotation.ValidRegion;

/**
 * 普通会员
 */
@TotalValidRegion(@ValidRegion(min = 1000,max = 2000))
public class Vip implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }
}
