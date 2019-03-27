package com.hyf.testdesignpattern.strategy.calprice;

import com.hyf.testdesignpattern.strategy.annotation.OnceValidRegion;
import com.hyf.testdesignpattern.strategy.annotation.ValidRegion;

/**
 * 满xxx减200
 */
@OnceValidRegion(@ValidRegion(min = 1000,max = 2000,order = 40))
public class ReduceTwoH implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice - 200d;
    }
}
