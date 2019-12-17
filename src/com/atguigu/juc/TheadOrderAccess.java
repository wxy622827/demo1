package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxy
 * @create 2019-12-16 18:37
 */

class ShareResource{
    private  int flag =1;
    private  Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();

    public void print5() {
        lock.lock();
        try{

            //精确通知
            //判断
            while(flag!=1){
                c1.await();

            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=2;
            c2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try{
            //精确通知
            //判断
            while(flag!=2){
                c2.await();

            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=3;
            c3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try{
            //精确通知
            //判断
            while(flag!=3){
                //c系统停止
                c3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            flag=1;
            c1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
public class TheadOrderAccess {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    resource.print5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <=10; i++) {
                try {
                    resource.print10();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    resource.print15();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}
