class problem4
{
	public static void main(String [] args)
	{
		int a = 999;
		int b = 999;
		int palindrome=0;
		
		for(;a>0;a--)
		{
			
			for(b=999; b>0;b--)
			{
				int c = a*b;
				if(c==99999)
					System.out.println(99999);
				String d = Integer.toString(c);
				if(isPalindrome(d))
					if(c > palindrome)
						palindrome = c;
				//System.out.println(d);
			}
			
		}
		System.out.println("palindrome is " + palindrome);
		System.out.println(isPalindrome(Integer.toString(palindrome)));
		
	}
	
	static boolean isPalindrome(String a)
	{
		for(int i = 0; i < a.length()/2;i++)
		{
			if(a.charAt(i)!=a.charAt(a.length()-i-1))
				return false;
		}
		return true;
	}
}
