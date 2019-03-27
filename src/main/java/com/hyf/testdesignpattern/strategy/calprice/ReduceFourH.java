package com.hyf.testdesignpattern.strategy.calprice;

import com.hyf.testdesignpattern.strategy.annotation.OnceValidRegion;
import com.hyf.testdesignpattern.strategy.annotation.ValidRegion;

/**
 * 满xxx减400
 */
@OnceValidRegion(@ValidRegion(min = 2000,order = 40))
public class ReduceFourH implements CalPrice{
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice - 400d;
    }
}
