package com.ballot.rigging.lombok;

import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

/**
 * @ToString注解
 * 生成toString方法
 */
@ToString(
        //是否在生成的toString（）中生成属性名
        includeFieldNames = false,
//        此处列出的任何字段都不会在生成的{@code toString}实现中打印。
//        exclude = {"field1"},
        //如果存在，则显式列出要打印的字段。
//        of = {"field1"},
        //false调用属性时调用属性的get方法
        doNotUseGetters = false
)
public class ToStringTest {

    @Setter
    private String field1;

    @Setter
    private String field2;

    public String getField2() {
        System.out.println("调用get方法！");
        return this.field2;
    }

    @Test
    public void test() {
        ToStringTest toStringTest = new ToStringTest();
        toStringTest.setField1("zhang");
        toStringTest.setField2("xiaoxi");

        System.out.println(toStringTest.toString());
    }

}
