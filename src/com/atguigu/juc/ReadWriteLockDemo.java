package com.atguigu.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wxy
 * @create 2019-12-16 19:2 8
 */
//读共享 写排它
class Mycache{
  // private Lock lock=new ReentrantLock();
  ReentrantReadWriteLock rwl =new ReentrantReadWriteLock();
   private volatile Map<String,String> map= new HashMap<>();
   public  void  put(String key,String value){
       rwl.writeLock().lock();
       try{
           System.out.println(Thread.currentThread().getName()+"\t"+"写入开始");
           map.put(key,value);
           System.out.println(Thread.currentThread().getName()+"\t"+"写入结束");
       }catch(Exception e){
          e.printStackTrace();
       }finally{
           rwl.writeLock().unlock();
       }


   }
    public  void get(String key)
    {
        rwl.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t"+"读取开始");
            String result = map.get(key);

            System.out.println(Thread.currentThread().getName()+"\t"+"读取结束"+"\t"+result);
        }catch(Exception e){
           e.printStackTrace();
        }finally{
            rwl.readLock().unlock();
        }



    }
}
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        Mycache mycache = new Mycache();

         for (int i = 1; i <=10; i++) {
             final int tempI=i;
                     new Thread(() -> {
                            mycache.put(tempI+"",tempI+"");
                     },String.valueOf(i)).start();
                 }
        for (int i = 1; i <=10; i++) {
            final int tempI=i;
            new Thread(() -> {
                mycache.get(tempI+"");
            },String.valueOf(i)).start();
        }
                 }

}
