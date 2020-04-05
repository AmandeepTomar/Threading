package thread;

import thread.design.MyTask;
import thread.design.MyThread;

public class Main {

    public static void main(String[] args) {

        MyThread thread=new MyThread();
        thread.start();

        Thread thread1=new Thread(new MyTask());
        thread1.start(); // submit task to thread for execution


        for (int i = 0; i <1000 ; i++) {
            System.out.print("Main");
        }
    }
}
