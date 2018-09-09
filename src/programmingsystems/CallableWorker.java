package programmingsystems;

import static programmingsystems.Main.StringArray;
import java.util.concurrent.Callable;

public class CallableWorker implements Callable<Long>{
    
	final private int maxIndex;
    final private int minIndex;  
    static double totalTime = 0;
   
    public CallableWorker(int minIndex, int maxIndex) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    } 
 
   
    @Override
    public Long call() throws Exception {
    	long sum = 0;
        //Calculate characters count from every part of the array
        for (int i = minIndex; i < maxIndex; i++) {
            sum += StringArray[i].length();
        }
        //Return processing time         
        return sum;
    }
}