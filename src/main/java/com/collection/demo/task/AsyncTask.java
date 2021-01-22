package com.collection.demo.task;

import com.collection.demo.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Autowired
    OrderService orderService;

    @Async("taskExecutor")
    public void stringTask(){

        orderService.getToken();

    }
}