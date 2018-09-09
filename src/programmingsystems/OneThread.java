package programmingsystems;

import static programmingsystems.Main.StringArray;

import java.io.IOException;

public class OneThread implements Runnable {
	static long Characters = 0;
	
	@Override
    public void run() {    
		long start = System.nanoTime();
		for (int i = 0; i < StringArray.length; i++) {
            Characters += StringArray[i].length();
        }    
		long time = System.nanoTime() - start;
		System.out.println("Running time: "+time+" nanoseconds");
        System.out.println("Characters: " +Characters);
    }
	
	public static void singleThread() throws IOException, InterruptedException {
		OneThread ST = new OneThread();
		Thread thread = new Thread(ST);
		thread.start();		  
	}

}
