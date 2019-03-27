package com.hyf.testdesignpattern.strategy.calprice;

import com.hyf.testdesignpattern.strategy.annotation.TotalValidRegion;
import com.hyf.testdesignpattern.strategy.annotation.ValidRegion;

/**
 * 超级会员
 */
@TotalValidRegion(@ValidRegion(min = 2000,max = 3000))
public class SuperVip implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.6;
    }
}
