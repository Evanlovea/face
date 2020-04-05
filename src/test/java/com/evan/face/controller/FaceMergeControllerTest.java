package com.evan.face.controller;

import cn.xsshome.taip.face.TAipFace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 22:56 2018/6/2
 * @Modified By:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FaceMergeControllerTest {
    @Autowired
    public static final String AppID = "\t\n" +
            "10134361";
    @Autowired
    public static final String AppKey = "RhpmbTIvSp11pYxZJQNBnDSWO762nOpB";
        @Test
        public static void main(String[] args) {
            // 初始化一个TAipFace
            TAipFace client = new TAipFace(AppID,AppKey);

    }


}