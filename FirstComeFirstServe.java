import java.util.*;
public class FirstComeFirstServe {

	static Scanner in = new Scanner(System.in);

	public static ArrayList <Integer> waiting_time( ArrayList<Integer> proc,  ArrayList <Integer> brust_time ) { 
		ArrayList <Integer> wait_time = new ArrayList <Integer> ();

		if ( proc.size() == brust_time.size() ) {
			wait_time.add(0, 0);
			int counter = 0;
			
			for (int i = 1; i < proc.size(); i++) {
				wait_time.add(i, wait_time.get(i-1) + brust_time.get(counter));
				counter++;
			}
		return wait_time;
		}

		else 
			return wait_time;
	}

	public static int avWaitingTime( ArrayList<Integer> proc, ArrayList <Integer> brust_time, int size ) {
		int av_wait_time = 0;
		ArrayList <Integer> temp = new ArrayList<Integer> (waiting_time(proc, brust_time)); 
			for (int i = 0; i < temp.size(); i++)
				av_wait_time += temp.get(i);
		return av_wait_time;
	}

	public static int isValidateInput() {
		boolean continueLoop = true;
		int number = 0;

		do {

			try {
				number = in.nextInt();
				continueLoop = false;
			}
			catch (InputMismatchException e) {
				System.out.println("enter valid number");
				in.nextLine();
			}

		}	while (continueLoop);

		return number;
	}

	public static String insertValues( ArrayList<Integer> proc, ArrayList <Integer> brust_time ) {
		int selection = isValidateInput();
		int insert = 0;
		while (selection != -1) {
			
			switch (selection) {
				case 1 :
					System.out.println("you have selected process ");
						while (insert != -1) {			
							if (insert > 0)
								proc.add(insert);
							insert = isValidateInput();
						}
						insert = 0;
					break;
				case 2 :
					System.out.println("you have selected brust time ");
						while (insert != -1) {
							if (insert > 0)
								brust_time.add(insert);
							insert = isValidateInput();
						}
						insert = 0;
					break;
			}
			selection = isValidateInput();
		}
		waiting_time(proc, brust_time);		
		return "process " + proc.toString() + "\n brust_time " + brust_time.toString();
	}

	public static void main(String...asdf) {
		ArrayList <Integer> proc = new ArrayList <Integer> ();
		ArrayList <Integer> brust_time = new ArrayList <Integer> ();
		int size = proc.size();
		
		boolean continueLoop = true;
		System.out.println("enter any value");
		System.out.printf("press 1 to insert process and press 2 to insert brust time%n%npress -1 to quit%n");

		System.out.println(insertValues(proc, brust_time));
		System.out.printf("average waiting time : %d%n", avWaitingTime(proc, brust_time, size));
		// int insert = isValidateInput();
				
		// while (insert != -1) {			
		// 	proc.add(insert);
		// 	insert = validateInput();
		// 	// do {
		// 	// 	try {
		// 	// 			insert = in.nextInt();
		// 	// 			continueLoop = false;
		// 	// 		}
		// 	// 	catch (InputMismatchException e) {
		// 	// 		System.out.println("enter valid number");
		// 	// 		in.nextLine();
		// 	// 	}
		// 	// } while (continueLoop);
		// }

		//System.out.println(insert + "Process " + proc.toString() + proc.size());
	}
}
