package study;

import java.util.Scanner;

import study.Account.Account;
import study.Account.LoggerForAccount;
import study.Account.Player;
import study.Desk.Desk;
import study.Desk.IDesk;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		LoggerForAccount logger = new LoggerForAccount();
		Account player1 = null;
		
		int choise;
		boolean in = true;
		//choise = scan.nextInt();
		
		System.out.println("Hello, it's the best game in world.");
		
		while (in)
		{
			System.out.println("Enter 1 to login:");
			System.out.println("Enter 2 to register:");
			System.out.println("Enter 3 to exit:");
			choise = scan.nextInt();
			switch (choise)
			{
			case 1:
				//login
				System.out.println("Enter name: ");
				String Name = scan.next();
				
				System.out.println("Enter password: ");
				String password = scan.next();
				
				if ((player1 = logger.searchAccount(Name, password)) != null)
				{
					in = false;
				}
				else
				{
					System.out.println("You have entered incorrect login or password");
				}
				break;
			case 2:
				//create_new_account
				System.out.println("Enter name: ");
				Name = scan.next();
				
				System.out.println("Enter chip(1 symbol): ");
				String chip = scan.next();
				char chip_ch = chip.charAt(0);
				
				System.out.println("Enter password: ");
				password = scan.next();
				
				player1 = new Account(Name, chip_ch, password);
				logger.createAccount(player1);
				in = false;
				break;
			case 3:
				return;
			}
		
		}
		
		in = true;
		
		System.out.println("Successful\n");
		System.out.println("Your score: " + player1.getScore() + "\n");
		
		while (in)
		{
			System.out.println("Enter 1 to play game:");
			System.out.println("Enter 2 to exit:");
			choise = scan.nextInt();
			switch(choise)
			{
			case 1:
				Account bot = null;
				if (player1.getChip() == 'O')
				{
					bot = new Account("Bot", 'X', "123");
				}
				else
				{
					bot = new Account("Bot", 'O', "123");
				}
				GameManager gm1 = new GameManager();
				gm1.play(player1, bot);
				System.out.println("\tGame over");
				in = false;
				break;
				
			case 2:
				System.out.println("Bye bye.");
				return;
		}
	}
}
}