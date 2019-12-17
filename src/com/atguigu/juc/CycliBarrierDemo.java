package com.atguigu.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wxy
 * @create 2019-12-16 20:42
 */
public class CycliBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐7颗龙珠，召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            final int tmpI=i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"\t收集到第"+tmpI+"\t颗龙珠");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
