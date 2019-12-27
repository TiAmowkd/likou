package com.ballot.rigging.lombok;

import lombok.AccessLevel;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @Getter注解
 * 为属性生成get方法
 */
public class GetterTest {

    @Getter(
            //作用于final字段，懒加载
            lazy = true
    )
    private final String field1 = "zhangxiaoxi";

    @Getter(
            //生成方法访问级别设置
            value = AccessLevel.PRIVATE,
            //为生成的get方法添加其他的注解
            onMethod_={@NotNull}
    )
    private String field2;

}
