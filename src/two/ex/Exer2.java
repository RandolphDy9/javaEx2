package two.ex;

import java.io.IOException;
import java.util.Scanner;

public class Exer2 {

	public static void main(String[] args) throws IOException {
		
		
		String fileName = "C:\\Users\\Randolph D\\Desktop\\data.txt";
		Scanner reader = new Scanner(System.in);
		int size = 3;
		int option = 0;
		
		KeyVal kVal = new KeyVal(size);
		
		System.out.println("---------------------");
		System.out.println("Inside file: ");
		System.out.println("---------------------");
		
		System.out.println(kVal.firstRead(fileName));
			
		do {
			
			System.out.println("\n---------------------");
			System.out.println("Table size: " + size);
			System.out.println("---------------------");
			System.out.println("[1] - Display");
			System.out.println("[2] - Edit");
			System.out.println("[3] - Search");
			System.out.println("[4] - Reset");
			System.out.println("[5] - Exit");
			System.out.println("---------------------\n");	
			
			do {
				System.out.println("Select option: ");
			    while (!reader.hasNextInt()) {
			        System.out.println("Oops! That's not a number!\nPlease enter a valid Option value: ");
			        reader.next(); 
			    }
			    option = reader.nextInt();
			} while ((option <= 0) || (option > 5));
			
			switch(option) {
				case 1:
					//read file and display
					System.out.println(kVal.readerOutput(fileName));
					
					break;
				case 2:
					//choose a coordinate and edit key or value
					System.out.println("Enter Key and Value: ");
					kVal.insert(reader.next(), reader.next(), fileName); 
					
					break;
				case 3:
					//search (whether key or value)
					System.out.println("Enter String: ");
					kVal.search(reader.next());
					break;
				case 4:
					//reset hashMap<>
					System.out.println("Reset Successful!");
					kVal = new KeyVal(size);
					kVal.resetAll(fileName);
					break;
			}
		} while (option != 5);
		reader.close();

	}

}
