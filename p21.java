import java.util.*;
class p21
{
	public static void main(String [] args)
	{
		System.out.println(p21(10000));
	}
	
	public static int p21(int n)
	{
	
		int [] map = new int[n+1];
		for(int i =1;i<n+1;i++)
		{
			map[i] = sum(divisors(i));			
		}
		int sum =0;
		for(int a =1;a<n+1;a++)
		{
			int da, b, db;
			b=map[a];
			if(b<n+1) 
			{
				if(a==map[b])
				if(a==b)
					{sum+=a+b;
						System.out.printf("a:%d , b:%d\n",a,b);
					}
					
			}
		}
		return sum/2;
	}
	
	public static LinkedList<Integer> divisors(int n)
	{
		LinkedList<Integer> v = new LinkedList<Integer>();
		for(int i=n-1;i>0;i--)
		{
			if(n%i==0) v.add(i);
		}
		return v;
	}
	
	static int sum(LinkedList<Integer> v)
	{
		Iterator<Integer> iterator =  v.iterator();
		Integer sum=0;
		while(iterator.hasNext())
		sum+=iterator.next();
		return sum;
	}
}