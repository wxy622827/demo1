package com.atguigu.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author wxy
 * @create 2019-12-16 21:09
 */
//抢车位
public class SemphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟有3个车位
        for (int i = 1 ;i <=6; i++)  {//模拟6部汽车站车位
                     new Thread(() -> {
                         boolean flag=false;//还没抢到
                         try {
                             semaphore.acquire( );//获取
                             flag=true;
                             System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                             try {
                                 TimeUnit.SECONDS.sleep(3);//停3秒
                                 System.out.println(Thread.currentThread().getName()+"\t离开车位");

                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }finally {
                             if(flag){
                                 semaphore.release();
                             }
                         }
                     },String.valueOf(i)).start();
                 }
    }
}
