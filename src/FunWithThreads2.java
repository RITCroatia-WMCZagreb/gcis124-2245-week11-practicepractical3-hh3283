/*
@ASSESSME.USERID: hh3283 
@ASSESSME.AUTHOR: 
@ASSESSME.DESCRIPTION: 
@ASSESSME.ANALYZE: YES
*/
public class FunWithThreads2 {


    //Constructor of FunWithThreads
    public FunWithThreads2(){
        System.out.println("MAIN START");

        Thread t1 = new Thread(new MyThread("Thread 1", 0));
        Thread t2 = new Thread(new MyThread("Thread 2", 0));
        t1.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        System.out.println("MAIN END");
    }


    public static class MyThread implements Runnable{
        private String name;
        private int counter = 0;

        MyThread(String name,int counter){
            this.name = name;
            this.counter = counter;
            
        }

        @Override
        public void run() {
            System.out.println("Thread start: "+this.name);
            
            while (counter<10) {

                System.out.println(this.name+" "+counter);
                counter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("Thread finish: "+this.name);
        }

        public static void main(String[] args) {
            new FunWithThreads2();
    
    
        }
    }
}

/*
 * 
 * 
 * Main Thread START
Thread start:Thread 1
Thread 1 0
Thread 1 1
Thread 1 2
Thread 1 3
Thread start:Thread 2
Thread 1 4
Thread 2 0
Thread 1 5
Thread 2 1
Thread 2 2
Thread 1 7
Thread 2 3
Thread 1 8
Thread 2 4
Thread 1 9
Thread end:Thread 1
Main Thread END
Thread 2 5
Thread 2 6
Thread 2 7
Thread 2 8
Thread 2 9
Thread end:Thread 2
 */