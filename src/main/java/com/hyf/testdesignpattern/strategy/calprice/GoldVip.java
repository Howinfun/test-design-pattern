package com.hyf.testdesignpattern.strategy.calprice;

import com.hyf.testdesignpattern.strategy.annotation.TotalValidRegion;
import com.hyf.testdesignpattern.strategy.annotation.ValidRegion;

/**
 * 黄金会员
 */
@TotalValidRegion(@ValidRegion(min = 3000))
public class GoldVip implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }
}
