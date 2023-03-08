package fr.toxy.passwordsgenerator;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.println(Colors.RESET + "Enter the password's length: ");
			
			while (!scanner.hasNextInt()) {
				
				System.out.println(Colors.RED + "Invalid number!");
				scanner.nextLine();
				System.out.print(Colors.RESET);
				
			}
			
			int passwordLength = scanner.nextInt();
			
			System.out.println("Enter the number of passwords: ");
			
			while (!scanner.hasNextInt()) {
				
				System.out.println(Colors.RED + "Invalid number!");
				scanner.nextLine();
				System.out.print(Colors.RESET);
				
			}
			
			int numberOfPasswords = scanner.nextInt();
			
			scanner.close();
			
			ArrayList<String> passwords = GeneratePasswords(passwordLength, numberOfPasswords);
			SavePasswords(passwords);
			
			System.out.println(Colors.GREEN + "Successful!");
			
			break;
			
		}
		
	}

	private static ArrayList<String> GeneratePasswords(int passwordLength, int numberOfPasswords) {
		
		ArrayList<String> passwords = new ArrayList<String>();
		
		for (int i = 0; i < numberOfPasswords; i++) {
			
			StringBuilder password = new StringBuilder();
			
			for (int ii = 0; ii < passwordLength; ii++) {
				
				int randomIndex = (int) Math.floor(Math.random() * Characters.list.length);
				String randomCharacter = Characters.list[randomIndex];
				
				password.append(randomCharacter);
				
			}
			
			passwords.add(password.toString());
			
		}
		
		return passwords;
		
	}
	
	private static void SavePasswords(ArrayList<String> passwords) {
		
		File passwordFile = new File("passwords.txt");
		
		if (!passwordFile.exists()) {
			
			try {
				
				passwordFile.createNewFile();
				
			} catch (IOException err) {}
			
		}
		
		try {
			
			FileWriter writer = new FileWriter(passwordFile);
			BufferedWriter bw = new BufferedWriter(writer);
			
			for (String password: passwords) {
				
				bw.write(password + "\n");
				
			}
			
			bw.close();
			writer.close();
			
		} catch (IOException err) {}
		
	}

}
