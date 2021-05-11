package com.ballot.rigging.groupValid;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * 患者表
 *
 * @author wkd
 * @since 2021-04-15
 */
@Data
public class PatientBO {

    //用@Validated({Insert.class,Default.class})可以既校验默认的限制，又校验groups为Insert.class的限制
    //如果只有Insert.class的@Validated({Insert.class})只能校验birthday，medicalInstitution字段其他校验不起作用

    private String id;

    @NotBlank(message = "患者姓名不能为空")
    private String name;


    @NotNull(message = "性别不能为空")
    private Integer sex;


    @NotNull(message = "出生日期不能为空",groups = Insert.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;


    @NotBlank(message = "医疗机构不能为空",groups = Insert.class)
    private String medicalInstitution;


    @NotBlank(message = "联系方式不能为空")
    @Pattern(regexp = "^1([38][0-9]|4[579]|5[^4]|6[6]|7[0135678]|9[89])\\d{8}$", message = "手机号格式错误")
    private String phone;

    @NotNull(message = "来源情况不能为空")
    private Integer sourceType;

}
