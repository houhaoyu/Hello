package com.example.helloworld.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tbl_employee") // 声明表名称
public class Employee {

    private Long id;
    private String lastName;
    private String email;
    private Integer age;

    public Employee(String lastName, String email, Integer age) {
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
