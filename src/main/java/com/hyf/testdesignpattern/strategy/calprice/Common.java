package com.hyf.testdesignpattern.strategy.calprice;

import com.hyf.testdesignpattern.strategy.annotation.TotalValidRegion;
import com.hyf.testdesignpattern.strategy.annotation.ValidRegion;

/**
 * 普通顾客
 */
@TotalValidRegion(@ValidRegion(max = 1000))
public class Common implements CalPrice{

    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }
}
