package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxy
 * @create 2019-12-16 18:37
 */

class ShareResource1{
    private  int flag =1;
    private  Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();

    public void print() {
        lock.lock();
        try{
               if(flag==1){

                   for (int i = 0; i < 5; i++) {
                       System.out.println(Thread.currentThread().getName()+"\t"+i);
                   }
                   flag=2;
                   c2.signalAll();
               }else if(flag==2){

                   for (int i = 0; i < 10; i++) {
                       System.out.println(Thread.currentThread().getName()+"\t"+i);
                   }
                   flag=3;
                   c3.signalAll();
               }
               else {

                   for (int i = 0; i < 15; i++) {
                       System.out.println(Thread.currentThread().getName() + "\t" + i);
                   }
                   flag=1;
                   c1.signalAll();
               }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }


}
public class TheadOrderAccess1 {
    public static void main(String[] args) {
        ShareResource1 resource = new ShareResource1();

        for (int i = 1; i <= 3; i++) {
            final int tempI = i;
            new Thread(() -> {
                for (int j = 1; j <= 10; j++) {
                    try {
                        resource.print();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, String.valueOf(i)).start();
        }
    }
}



