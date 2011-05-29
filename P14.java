public class P14
{
	public static void main(String [] args)
	{
		int chaincount = 0;
		long longestchainer=0;
		long i = 1000000;
		while(i!=1)
		{
			int tempcount=0;
			long j=i;
			while(j!=1)
				if(j%2==0)
			{
					j=j/2;
				else
					j=j*3+1;
				tempcount++;
			}
			if(tempcount>chaincount)
			{
				chaincount=tempcount;
				longestchainer=i;
			}
			i--;
			
		}
		System.out.println(chaincount);
		System.out.println(longestchainer);
	}
}