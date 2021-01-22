package com.collection.demo;

import com.collection.demo.task.AsyncTask;
import com.collection.demo.task.OrderCreateTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangwn
 * @date 2020/11/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Autowired
    AsyncTask asyncTask;

    @Autowired
    OrderCreateTask orderCreateTask;

    @Test
    public void testApi(){

        for (int i = 0; i < 50; i++) {
            asyncTask.stringTask();
        }

    }

    @Test
    public void testOrderCreate(){
        for (int i = 0; i < 20; i++) {
            orderCreateTask.stringTask();
        }

    }
}
