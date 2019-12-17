import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author wxy
 * @create 2019-12-16 22:41
 */
 /* class MyThread implements Runnable{

    @Override
    public void run() {

    }
}*/
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("********come in call");
        return 1024;
    }
}



public class CallableDemo {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new MyThread());

        new Thread(futureTask,"A").start();
    }
}
