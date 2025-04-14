/*
@ASSESSME.USERID: hh3283 
@ASSESSME.AUTHOR: 
@ASSESSME.DESCRIPTION: 
@ASSESSME.ANALYZE: YES
*/
public class FunWithThreads3 {

    //One common counter, two threads are adding 1 40,000 times
    //fimal result 80000

    private int counter;
    private static Object lock = new Object();


    //Constructor of FunWithThreads
    public FunWithThreads3(){
        System.out.println("MAIN START");
        Thread thread1 = new Thread(()->{
            for(int i=0;i<40000;i++){
                synchronized(lock){
                    counter++;
                }
                
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i=0;i<40000;i++){
                synchronized(lock){
                    counter++;
                }
                
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
        System.out.println(counter);
        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads3();

    }

    
}

