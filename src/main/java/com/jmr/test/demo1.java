package com.jmr.test;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){list.add(Thread.currentThread().getName());}
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
