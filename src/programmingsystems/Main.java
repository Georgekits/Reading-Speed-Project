package programmingsystems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static programmingsystems.AsynchronousThreads.asyncThreads;
import static programmingsystems.SynchronizedThreads.threads;
import static programmingsystems.OneThread.singleThread;

public class Main {

	static Scanner input = new Scanner(System.in);
	static String[] StringArray = new String[592610];

	// Check if user's input is an integer
	public static void checkUserInput() {
		while (!input.hasNextInt()) {
			System.out.println("Not an option!");
			input.next();
		}
	}

	// Read log file
	public static void ReadFile() throws FileNotFoundException, IOException {
		FileReader input = new FileReader("RC_2008-07");
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;
		int i = 0;
		while ((myLine = bufRead.readLine()) != null) {
			StringArray[i] = myLine;
			i++;
		}

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// Read file and copy characters to string array
		ReadFile();
		// option menu
		System.out.println("Select an option:\n1.Count using one thread\n"
				+ "2.Count using many synchronized threads.\n3.Count using many asynchronous threads.\n");
		checkUserInput();
		int answer = input.nextInt();
		switch (answer) {
			case 1:
				// run application using one thread
				singleThread();
				break;
			case 2:
				// run using synchronized threads
				threads();
				break;
			case 3:
				// run using asynchronous threads
				asyncThreads();
				break;
			default:
				System.out.println("Not an option!");
				break;
			}
		}
}