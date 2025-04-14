/*
@ASSESSME.USERID: hh3283 
@ASSESSME.AUTHOR: 
@ASSESSME.DESCRIPTION: 
@ASSESSME.ANALYZE: YES
*/
public class FunWithThreads1 {


    //Constructor of FunWithThreads
    public FunWithThreads1(){
        System.out.println("MAIN START");
       
        System.out.println("MAIN END");
    }

    public static class MyThread implements Runnable{
        private String name;
        private int counter = 0;
        private Object lock = new Object();

        MyThread(String name,int counter){
            this.name = name;
            this.counter = counter;
        }

        @Override
        public void run() {
            while (counter<10) {
                synchronized(lock){
                    System.out.println(this.name+" "+counter);
                    counter++;
                    lock.notify();
                }
            }
        }
        
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread 1", 0);
        MyThread t2 = new MyThread("Thread 2", 0);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();


    }
    /*
     * 
     * 
     * Main Thread START
        Main Thread END
        Thread 1 0
        Thread 2 0
        Thread 1 1
        Thread 2 1
        Thread 1 2
        Thread 2 2
        Thread 1 3
        Thread 2 3
        Thread 1 4
        Thread 2 4
        Thread 1 5
        Thread 2 5
        Thread 1 6
        Thread 2 6
        Thread 1 7
        Thread 2 7
        Thread 1 8
        Thread 2 8
        Thread 1 9
        Thread 2 9
     */


}
