package com.atguigu.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Ticket
    {
    private int  number = 30;
    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+"\t 卖出"+(number--)+"\t剩余 "+number);
        }
    }

        }
public class SaleTicket extends Thread{
    public  static void main(String[] args){
       Ticket ticket = new Ticket();


      /* new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=30;i++){
                    ticket.sale();
                }

            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=30;i++){
                    ticket.sale();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=30;i++){
                    ticket.sale();
                }
            }
        },"C").start();*/
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        try{
            for (int i =1; i <=30; i++) {
                final  int tempI=i;
                threadPool.execute(()->{
                    ticket.sale();
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }




}
