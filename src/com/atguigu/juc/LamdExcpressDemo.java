package com.atguigu.juc;

/**
 * @author wxy
 * @create 2019-12-15 19:35
 */
interface  Foo
{
 //    public void  sayHello();
    public int add(int x,int y);

}



public class LamdExcpressDemo {
    public static void main(String[] args) {
//       Foo foo1 = new Foo() {
//           public void sayHello() {
//               System.out.println("******2");
//           }
//       };
//        foo1.sayHello();
//
//      Foo foo2=()->{
//          System.out.println("******lamdba");
//      };
//      foo2.sayHello();
        Foo foo2=(x,y)->{
          System.out.println("******lamdba");
           return  x+y;
     };
        System.out.println(foo2.add(3,5));
    }
}
