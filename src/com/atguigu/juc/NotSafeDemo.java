package com.atguigu.juc;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wxy
 * @create 2019-12-15 23:12
 */
public class NotSafeDemo {

    public static void main(String[] args) {
        List list = new CopyOnWriteArrayList();//Collections.synchronizedList(new ArrayList<>()); //new Vector() ;// new ArrayList<>();
       /* Set<String> set =new copyOnWriteArraySet//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(set);
            },"A").start();
        }*/
       /*Map<Object, Object> map = new ConcurrentHashMap<>();//new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,6));
                System.out.println(map);
            },String.valueOf(i)).start();
        }*/
       for (int i = 0; i < 10; i++) {
                    new Thread(() -> {
                         list.add(UUID.randomUUID().toString().substring(0,6));
                        System.out.println(list);
                    },"input thread name").start();
                }

    }
}
