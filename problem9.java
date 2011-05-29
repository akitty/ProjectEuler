class problem9
{
	public static void main(String [] argv)
	{
		System.out.println("problem9");
		int limit = 1000;
		int a,b,c;
		a=b=c=1;
		for(;a<1000;a++)
		{
			b=c=0;
			for(;b<1000;b++)
			{
				c=0;
				for(;c<1000;c++)
				{
					if(isPy(a,b,c)){
					System.out.println("Answer:");
					System.out.println(a);
					System.out.println(b);
					System.out.println(c);
					System.out.println(a*b*c);
					System.exit(1);
					}
				}
			}
			
		}
	}
	public static boolean isPy(int a, int b, int c)
	{
		if(a*a+b*b==c*c)
			if(a+b+c==1000)
				return true;
		return false;
	}
}