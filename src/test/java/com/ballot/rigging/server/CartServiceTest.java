package com.ballot.rigging.server;

import com.alibaba.fastjson.JSON;
import com.ballot.rigging.enums.SkuCategoryEnum;
import com.ballot.rigging.pojo.Sku;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Auther: wkd
 * @Date: 2019/12/20 13:56
 * @Description:
 */
class CartServiceTest {

    @Test
    void filterSkusByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 查找购物车中图书类商品集合
        List<Sku> result = CartService.filterSkusByCategory(
                cartSkuList, SkuCategoryEnum.BOOKS);

        System.out.println(JSON.toJSONString(
                result, true));
    }

    @Test
    public void filterSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤商品总价大于2000的商品
        List<Sku> result = CartService.filterSkus(
                cartSkuList, new SkuTotalPricePredicate());

        System.out.println(JSON.toJSONString(
                result, true));
    }

    @Test
    public void filterSkusLambda() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 过滤商品单价大于1000的商品
        List<Sku> result = CartService.filterSkus(
                cartSkuList,
                (Sku sku) -> sku.getSkuPrice() > 1000);

        System.out.println(JSON.toJSONString(result, true));

        List<Sku> result2 = CartService.filterSkus(
                cartSkuList,
                (Sku sku) ->SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()));
        System.out.println(JSON.toJSONString(result2, true));

    }
}