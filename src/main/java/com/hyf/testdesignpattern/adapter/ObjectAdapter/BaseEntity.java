package com.hyf.testdesignpattern.adapter.ObjectAdapter;

import java.time.LocalDateTime;

/**
 * @author Howinfun
 * @desc baseEntity，假设每个entity都必须继承它。
 * @date 2019/3/28
 */
public class BaseEntity {
    private Integer id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
}
