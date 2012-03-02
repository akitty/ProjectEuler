import java.util.*;
import java.io.*;
public class p18
{
	public static void main(String [] args)
	{
		FileInputStream fin;
		LinkedList<Vector<int>> levels = new LinkedList<Vector<int>>();
		if(args.length()!=1) System.exit(1);
		try{
			fin = new FileInputStream(args[0]);
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		String i;
		do
		{
			Vector<int> items=new Vector<int>();
			i=fin.readline();
			for(String s:i.split(" "))
				items.add(Integer.parseInt(s));
			levels.add(items);
		}while(i!=-1);
		
		Vector<int> maxes = new Vector<int>();
		maxes.add(levels.pop()[0]);
		maxes= solve(levels,maxes);
	}
	
	
	public static void solve(LinkedList<Vector<int>> triangle,Vector<int> maxes)
	{
		Vector<int> next_maxes= new Vector<int>();
		Vector<int> top = triangle.pop();
		for(int i =0;i<top.length();i++)
		{
			next_maxes.add(maxes[i]+top[i]);
			next_maxes.add(maxes[i]+top[i+1]);
			
		}
		solve(
	}
}