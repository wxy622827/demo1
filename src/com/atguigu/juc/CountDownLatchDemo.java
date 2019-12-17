package com.atguigu.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author wxy
 * @create 2019-12-16 20:33
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
                     new Thread(() -> {
                         System.out.println(Thread.currentThread().getName()+"\t"+"离开教室");
                         countDownLatch.countDown();
                     },String.valueOf(i)).start();
                 }
              countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+"\t"+"班长离开教室");
    }
}
