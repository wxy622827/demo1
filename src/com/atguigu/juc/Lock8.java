package com.atguigu.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author wxy
 * @create 2019-12-15 21:56
 */
class Phone{
    public  static synchronized  void sendEmail() throws InterruptedException {
       TimeUnit.SECONDS.sleep(3);
        System.out.println("*****sendEmail");

    }
    public  synchronized  void sendSMS(){
        System.out.println("*****sendSms");
    }
    public void hello(){
        System.out.println("hello");
    }

}

public class Lock8 {
    public static void main(String[] args) throws Exception {
        Phone phone=new Phone();
        Phone phone2=new Phone();
        new Thread(()->{
            try{
                phone .sendEmail();
            }catch(Exception e){
                e.printStackTrace();
            }
        },"A").start();
         Thread.sleep(100);
        new Thread(()->{
            try{
                //phone .sendSMS();
                //phone.hello();
               phone2 .sendSMS();
            }catch(Exception e){
                e.printStackTrace();
            }
        },"B").start();
    }


}

