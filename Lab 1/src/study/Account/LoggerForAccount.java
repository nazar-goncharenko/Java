package study.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.io.File;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoggerForAccount {

	public void createAccount(Account acc) {

		try (FileWriter fr_t = new FileWriter("Account.txt", true)) {
			BufferedWriter fr = new BufferedWriter(fr_t);
			fr.write(acc.getName());
			fr.write("\t");
			fr.write(acc.getChip());
			fr.write("\t");
			fr.write(acc.getPassword());
			fr.write("\t");
			fr.write(Integer.toString(acc.getScore()));
			fr.write("\n");
			fr.close();
			fr_t.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public Account searchAccount(String Name, String password)
	{
			FileReader fr = null;
			try {
			fr = new FileReader("Account.txt");
			Scanner scan = new Scanner(fr);
			String Name_t;
			String password_t;
			String chip;
			int score;
			while ( scan.hasNext())
			{
				Name_t = scan.next();
				chip = scan.next();
				password_t = scan.next();
				score = scan.nextInt();				
				//System.out.println(Name_t + " " + password_t + "\n");
				if ( Name.equals(Name_t) && password.equals(password_t))
				{
					scan.close();
					try 
					{
						fr.close();
					} 
					catch (IOException e)
					{
						System.out.println("Something went wrong");
					}
					return new Account(Name , chip.charAt(0) , password,score);
				}
				
			}
			scan.close();
			}
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
				System.out.println("Something went wrong");
			}
			try 
			{
				fr.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Something went wrong");
			}
			return null;
		
		
	}
	
	public void deleteAccount(Account account)
	{
		FileReader fr = null;
		FileWriter fw = null;
		try
		{
			fr = new FileReader("Account.txt");
			fw = new FileWriter("Account_tmp.txt");
			Scanner scan = new Scanner(fr);
			
			while(scan.hasNext())
			{
			String Name_t;
			String password_t;
			String chip;
			int score;
			while ( scan.hasNext())
			{
				Name_t = scan.next();
				chip = scan.next();
				password_t = scan.next();
				score = scan.nextInt();				
				if ( account.getName().equals(Name_t) && account.getPassword().equals(password_t))
					{
					//System.out.println(account.getName() + " " + account.getPassword() + "\n");
					}
				else
				{
					fw.write(Name_t + "\t");
					fw.write(chip + "\t");
					fw.write(password_t + "\t");
					fw.write(score + "\n");
				}
			}
			}
			scan.close();
			fr.close();
			fw.close();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file1 = new File("Account_tmp.txt");
		File file2 = new File("Account.txt");
		file2.delete();
		file1.renameTo(new File("Account.txt"));
		
		
	}

}
