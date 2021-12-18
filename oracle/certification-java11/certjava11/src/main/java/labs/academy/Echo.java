package labs.academy;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Echo {

//	public static void main(String... args){
//		
//		Scanner scanner = new Scanner(System.in);
//		String txt =  null;
//		System.out.println("To quit type: exit");
//		System.out.println("Type value and press enter:");
//		while(!(txt = scanner.nextLine()).equals("exit")) {
//			System.out.println("Echo: " + txt);
//		}
//		scanner.close();
//		
//		new ArrayList<Integer>().removeIf(x -> { return x == 1;});
//		var sb = new StringBuilder("radcical").del
//		
//	}

	public final static void main(String... args) {
		var flavors = 30;
		int eaten = 0;
		switch (flavors) {
		case 50:
			eaten++;
		case 40:
			eaten += 2;
		default:
			eaten--;
		}
		System.out.print(eaten);
	}

}
