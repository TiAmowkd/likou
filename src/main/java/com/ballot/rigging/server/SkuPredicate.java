package com.ballot.rigging.server;

import com.ballot.rigging.pojo.Sku;

/**
 * Sku选择谓词接口
 */
@FunctionalInterface
public interface SkuPredicate {

    /**
     * 选择判断标准
     * @param sku
     * @return
     */
    boolean test(Sku sku);

}
