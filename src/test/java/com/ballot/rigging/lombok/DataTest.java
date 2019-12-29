package com.ballot.rigging.lombok;

import lombok.Data;

/**
 * @Data注解 大而全的注解：包含@Getter，@Setter，@ToString，@EqualsAndHashCode
 * @Data = @Setter + @Getter + @EqualsAndHashCode + @NoArgsConstructor + @ToString
 * （@Data会getter所有的变量）
 */
@Data
public class DataTest {

    private String field1;

    private String field2;

    private final String field3;

}
