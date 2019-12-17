package com.atguigu.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wxy
 * @create 2019-12-17 18:04
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //抛异常
       // System.out.println(blockingQueue.add("x"));
       // 取到队首元素
        //System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/
       /* System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //false
        //System.out.println(blockingQueue.offer("d"));

       // 取到队首元素
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //null
        System.out.println(blockingQueue.poll());System.out.println("**********211");
*/
        blockingQueue.offer("a",3L, TimeUnit.SECONDS);//过时不候
        blockingQueue.put("b");
        blockingQueue.put("c");
//        System.out.println("**********211");
//        blockingQueue.put("x");
        System.out.println(  blockingQueue.take());
        System.out.println(  blockingQueue.take());
        System.out.println(  blockingQueue.take());
        System.out.println(  blockingQueue.take());
        System.out.println("/*****");



        //false
        //System.out.println(blockingQueue.offer("d"));

        // 取到队首元素
//        System.out.println(blockingQueue.peek());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        //null
//        System.out.println(blockingQueue.poll());

    }
}
