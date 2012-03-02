import java.util.*;
import java.io.*;
public class sudoku
{
	static int  sudoku[];
	static LinkedList<Integer>[] guesses;
	public static void main(String[]args)
		throws IOException
	{
		sudoku = new int[81];
		//read in file
		String filename= "sudoku.in";
		readfile(filename);
		//fill possibilities
		guesses = new LinkedList<Integer>[81];
		for(int i = 0; i<81;i++)
		{
			
		}
		
	}
	//returns the row as a array
	//param b 0-8
	int[] getRow(int b)
	{
		int a[]=new int[9];
		b = b*9;
		for(int i =0;i<9;i++)
		{
			a[i]=sudoku[b++];
		}
		return a;
	}	
	
	int[] getCol(int b)
	{
		int a[]=new int[9];
		for(int i =0;i<9;i++)
		{
			a[i]=sudoku[b];
			b+=9;
		}
		
		return a;
	}
	
	int[] getBox(int b)
	{
		int a[]=new int[9];
		switch(b)
		{
			case 0: break;
			case 1: b = 3; break;
			case 2: b = 5; break;
			case 3: b = 27; break;
			case 4: b = 30; break;
			case 5: b = 33; break;
			case 6: b = 54; break;
			case 7: b = 57; break;
			case 8: b = 60; break;
		}
		for(int i=0;i<9;i++)
		{
			int row = i/3;
			int col = i%3;
			int c;
			c = b+9*row+col;
			a[i]=sudoku[c];
		}
		return a;
	}
	static void readfile(String filename) throws IOException
	{
		FileInputStream fin;
		int i;
		int j =0;
		//int sudoku[]= new int[81];
		try
		{
			fin = new FileInputStream(filename);
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			return;
		}
		do
		{
			i = fin.read();
			//a = fin.readline();
			if(i!=-1&&i>=48) 
			{
				System.out.print((char) i);
				sudoku[j++]=i-48;
			}
		}while(i!=-1);
		fin.close();
	}
	
	void finish(){}
	void guess(){}
}
