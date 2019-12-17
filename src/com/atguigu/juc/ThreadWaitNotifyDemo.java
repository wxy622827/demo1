package com.atguigu.juc;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxy
 * @create 2019-12-15 20:29
 */
class AirConditioner {//资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        //判断
        lock.lock();
        try {
            while (number != 0) {

                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);//当前线程的名字
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void decrement() throws InterruptedException {
        //判断
        lock.lock();
        try {
            while (number == 0) {

                condition.await();
            }
            //干活
            --number;
            System.out.println(Thread.currentThread().getName() + "\t" + number);//当前线程的名字
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        new Thread(()->{

            for (int i = 1; i <=10; i++) {

                try{
                     airConditioner.increment();
                }catch(InterruptedException e){
                   e.printStackTrace();
                }
            }
        },"A").start();


        new Thread(()->{

            for (int i = 1; i <=10; i++) {

                try{
                    airConditioner.decrement();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{

            for (int i = 1; i <=10; i++) {

                try{
                    airConditioner.increment();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"C").start();


        new Thread(()->{

            for (int i = 1; i <=10; i++) {

                try{
                    airConditioner.decrement();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"D").start();
    }

}