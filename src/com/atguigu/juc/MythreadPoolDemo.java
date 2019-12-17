package com.atguigu.juc;

import java.util.concurrent.*;

/**
 * @author wxy
 * @create 2019-12-17 18:25
 */
public class MythreadPoolDemo {
    public static void main(String[] args) {
  //ExecutorService threadPool= Executors.newFixedThreadPool(5);
 // ExecutorService threadPool= Executors.newSingleThreadExecutor();
    // ExecutorService threadPool= Executors.newCachedThreadPool();
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
               // new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()//可能9
                //new ThreadPoolExecutor.DiscardOldestPolicy()//可能9
                new ThreadPoolExecutor.DiscardPolicy()
                );
        try{

                   for (int i = 1; i <=11 ; i++) {
                       final  int tempI=i;
                       threadPool.execute(()->{ System.out.println(Thread.currentThread().getName()+"\t受理业务"+"\t客户号"+tempI);

                       });
                   }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                   threadPool.shutdown();
                }
    }
}
