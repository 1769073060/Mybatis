package com.rzk.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int tid;
    //  关联一个老师
    private Teacher teacher;
}
