package study;

import java.util.Random;
import java.util.Scanner;

import study.Account.Account;
import study.Account.Iplayer;
import study.Account.LoggerForAccount;
import study.Account.Player;
import study.Desk.Desk;
import study.Desk.IDesk;

public class GameManager {

	public void play(Account player_1 , Account player_2)
	{
		Player player1_t = player_1;
		Player player2_t = player_2;
		
		
		Scanner scan = new Scanner(System.in);
		LoggerForAccount logg = new LoggerForAccount();
		
		IDesk desk = new Desk();
		Random rand = new Random();
		int rand_choose = ( rand.nextInt(10) % 2 );
		
		
		Iplayer player1 = player1_t;
		Iplayer player2 = player2_t;
		int i = 0;
		boolean normal_hit = true;
		System.out.println("Let's play");
		while ( desk.deskIsPlayeble())
		{
			desk.printDesk();
			normal_hit = true;
			
			if ( i%2 == rand_choose)
			{
				System.out.println("Player " + player1.getName() + " choose cell:");
				int x;
				int y;
				x = scan.nextInt();
				y = scan.nextInt();
				if ( desk.hit(x, y, player1.getChip()))
				{
					if (desk.ckechWin(x, y, player1.getChip()))
							{
						desk.printDesk();
						System.out.println("Win player " + player1.PrintName() + ".");
						logg.deleteAccount(player_1);
						player_1.addScore();
						logg.createAccount(player_1);
						return;
							}
				}
				else
				{
					System.out.println("Please, choose another cell.");
					normal_hit = false;
				}
			}
			
			
			if ( i%2 != rand_choose)
			{
				System.out.println("Player" + " " + player2.getName() + " " + "choose cell:");
				int x;
				int y;
				x = scan.nextInt();
				y = scan.nextInt();
				if ( desk.hit(x, y, player2.getChip()))
				{
					if (desk.ckechWin(x, y, player2.getChip()))
							{
						desk.printDesk();
						System.out.println("Win player " + player2.PrintName() + ".");
						logg.deleteAccount(player_2);
						player_2.addScore();
						logg.createAccount(player_2);
						return;
							}
				}
				else
				{
					System.out.println("Please, choose another cell.");
					normal_hit = false;
				}
			}
			if (normal_hit == true)
			{
				i++;
			}
			}
		}
		
		
		
		
	}
	
	
