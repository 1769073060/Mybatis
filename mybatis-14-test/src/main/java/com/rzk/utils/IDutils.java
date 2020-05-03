package com.rzk.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")//镇压警告
public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");

    }

    @Test
    public void test(){
        System.out.println(getId());
    }

}
