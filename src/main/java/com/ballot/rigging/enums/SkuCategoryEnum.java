package com.ballot.rigging.enums;

/**
 * @Auther: wkd
 * @Date: 2019/12/20 11:38
 * @Description:
 */
public enum SkuCategoryEnum {
    /**
     *
     */
    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "数码类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类");

    /**
     * 商品类型的编号
     */
    private Integer code;

    /**
     * 商品类型的名称
     */
    private String name;

    /**
     * 构造函数
     *
     * @param code
     * @param name
     */
    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    SkuCategoryEnum() {

    }
}
