package thread;

import thread.design.DaemonThreadExample;
import thread.design.MyTask;
import thread.design.MyThread;

public class Main {

    public static void main(String[] args) {

        MyThread thread=new MyThread();
     //   thread.start();

        Thread thread1=new Thread(new MyTask());
      //  thread1.start(); // submit task to thread for execution

        DaemonThreadExample th=new DaemonThreadExample();
        /**
         * f we do not make this thread daemon thread it will run infinite
         * After finish the main thread or application task this will thread run and con not stop the application */
       // th.startThreadWithDaemon(false);

        // just make this thread daemon and let see the result
        th.startThreadWithDaemon(true);

        for (int i = 0; i <1000 ; i++) {
            System.out.print("Main");
        }
    }
}
