package com.ballot.rigging.pojo;

import lombok.Data;

/**
 * @Auther: wkd
 * @Date: 2019/12/26 14:39
 * @Description:
 */
@Data
public class Book {

    private String name;
    private int price;

    public Book() {

    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
