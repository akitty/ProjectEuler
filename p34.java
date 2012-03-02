class p34
{
	public static void main(String [] args)
	{
		int allsum =0;
		int [] f = {1,1,2,6,24,120,720,5040,40320,362880};
		for(int i=3;i<10000000;i++)
		{
			int sum =0;
			char[] s = Integer.toString(i).toCharArray();
			for(int j = 0; j< s.length;j++)
			{
				sum+=f[(int)(s[j]-48)];
			}
			if(sum==i)
			{
				System.out.println(sum);
				allsum+=i;
			}
			
		}
		System.out.println(allsum);
		
	}
}