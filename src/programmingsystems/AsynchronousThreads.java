package programmingsystems;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import static programmingsystems.Main.StringArray;

public class AsynchronousThreads {
    
    public static void asyncThreads() {
        //Split array to 190 different parts
        int increment = StringArray.length / 190;
        
        //Create a list to hold the Future object associated with Callable
        ArrayList<Future> futures = new ArrayList<>();
        //Get ExecutorService for Executors utility class, thread pool size is 5
        ExecutorService mService = Executors.newFixedThreadPool(5);
        long start = System.nanoTime();
        for (int i = 0; i < 190; i++) {
            //Create MyCallable instance
        	Callable<Long> callable = new CallableWorker(i * increment, (i+1)*increment);
            //Submit Callable tasks to be executed by thread pool
            Future<Long> result = mService.submit(callable);
            //Add Future to the list, we can get return value using Future
            futures.add(result);
        }     
        long time = System.nanoTime() - start;
        System.out.println("Running time is: "+time+" nanosec");

        long sum = 0;
        for (Future<Long> result : futures) {
            try {
                //Add all the threads' results
                sum = sum + result.get();
            } catch (InterruptedException ex) {
                Logger.getLogger(AsynchronousThreads.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(AsynchronousThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Print thread time
        System.out.println("Characters: " + sum);
        //Shut down the executor service now
        mService.shutdown();
    }
}