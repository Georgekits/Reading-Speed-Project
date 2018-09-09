package programmingsystems;

import static programmingsystems.Main.StringArray;

public class SynchronizedThreads implements Runnable {

    final private int minIndex;
    final private int maxIndex;
    static long Characters = 0;
    static long totalTime = 0;

    public SynchronizedThreads(int minIndex, int maxIndex) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex; 
    }

    @Override
    public void run() {  	
        for (int i = minIndex; i < maxIndex; i++) {
            Characters += StringArray[i].length();
        }

    }

    public static void threads() throws InterruptedException {
        //Split array to 190 different parts
        int increment = StringArray.length / 190;

        //Create 190 threads
        long start = System.nanoTime();
        for (int i = 0; i < 190; i++) {
            SynchronizedThreads SyncThread = new SynchronizedThreads(i * increment, (i + 1) * increment);
            Thread thread = new Thread(SyncThread);
            thread.start();
            //Wait for current thread to finish
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }        
        long time = System.nanoTime() - start;
        //Print thread time
        System.out.println("Running time: " + time +" nanoseconds");
        System.out.println("Characters: " + Characters);
    }

}