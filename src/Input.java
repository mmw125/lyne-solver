import java.util.Scanner;
import java.util.ArrayList;

public class Input {

	public static void main(String[] args) {
		new Input();
	}
	
	public Input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter in the Lyne puzzle");
		System.out.println("Use numbers for nodes with multiple connections");
		System.out.println("and letters for color blocks captial if start or end");
		System.out.println("Type done to finish");
		ArrayList<String> strings = new ArrayList<String>();
		String string = sc.nextLine();
		while(!string.equals("done"))
		{
			strings.add(string);
			string = sc.nextLine();
		}
		LyneLevel level = new LyneLevel(strings);
		level.generateSolution();
		sc.close();
	}

}
