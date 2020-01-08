package com.ballot.rigging.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ballot.rigging.pojo.ProductAccept;
import com.ballot.rigging.pojo.ProductSend;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wkd
 * @Date: 2020/1/8 11:17
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class FastJsonTest {

    ProductSend productSend = new ProductSend();
    ProductSend productSendOne = new ProductSend();
    ProductSend productSendTwo = new ProductSend();

    @Before
    public void init() {
        productSend.setProductId("123");
        productSend.setProductName("衣服");
        productSend.setCreateTime(new Date());
        productSend.setUpdateTime(new Date());

        productSendOne.setProductId("222");
        productSendOne.setProductName("酒");
        productSendOne.setCreateTime(new Date());
        productSendOne.setUpdateTime(new Date());

        productSendTwo.setProductId("333");
        productSendTwo.setProductName("鞋子");
        productSendTwo.setCreateTime(new Date());
        productSendTwo.setUpdateTime(new Date());
    }


    @Test
    public void test() {
        //productSend对象转换为JsonString
        String productSendJSONString = JSON.toJSONString(productSend);
        System.out.println(productSendJSONString);
        //{"createTime":1578454254518,"productId":"123","productName":"衣服","updateTime":1578454254518}

        //productSendJsonString转换为ProductAccept对象
        ProductAccept productAccept = JSONObject.parseObject(productSendJSONString, ProductAccept.class);
        System.out.println(productAccept);
        //ProductAccept(productId=123, productName=衣服)
    }

    @Test
    public void testTwo() {
        //productSend对象 --> JsonObject
        JSONObject productSendJsonObject = (JSONObject) JSONObject.toJSON(productSend);
        System.out.println(productSendJsonObject);
        //{"productId":"123","createTime":1578461577330,"updateTime":1578461577330,"productName":"衣服"}

        //JsonObject --> productSend对象
        ProductSend productSendObject = productSendJsonObject.toJavaObject(ProductSend.class);
        System.out.println(productSendObject);
        //ProductSend(productId=123, productName=衣服, createTime=Wed Jan 08 13:34:56 CST 2020, updateTime=Wed Jan 08 13:34:56 CST 2020)

        //or
        ProductSend productSendObject2 = JSON.toJavaObject(productSendJsonObject, ProductSend.class);
        System.out.println(productSendObject2);
        //ProductSend(productId=123, productName=衣服, createTime=Wed Jan 08 13:36:46 CST 2020, updateTime=Wed Jan 08 13:36:46 CST 2020)


        //JsonObject --> ProductAccept对象
        //toJavaObject方法和JSON.toJavaObject都可以这里只演示一种
        ProductAccept productAccept = productSendJsonObject.toJavaObject(ProductAccept.class);
        System.out.println(productAccept);
        //ProductAccept(productId=123, productName=衣服)
    }

    @Test
    public void testThree() {
        List<ProductSend> productSendList = new ArrayList<>();
        productSendList.add(productSend);
        productSendList.add(productSendOne);
        productSendList.add(productSendTwo);

        //List --> JSONString
        String listJsonString = JSON.toJSONString(productSendList);
        System.out.println(listJsonString);

        //JsonString --> JsonArray
        JSONArray productSendJsonArray = JSONArray.parseArray(listJsonString);
        System.out.println(productSendJsonArray);

        //JsonString --> List
        List<ProductSend> list = JSONObject.parseArray(listJsonString, ProductSend.class);
        System.out.println(list);

        //JsonArray --> List
        List<ProductSend> productSends = productSendJsonArray.toJavaList(ProductSend.class);
        System.out.println(productSends);
    }
}
