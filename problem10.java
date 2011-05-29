import java.lang.Math; 
import java.math.BigInteger;
class problem10
{
	public static void main(String[] args)
	{
		BigInteger sum = new BigInteger("5");
		int b=5;
		BigInteger c = new BigInteger("5");
		/*
		while( Integer.parseInt(c.toString()) < 2000000)
		{
			sum=sum.add(c);
			c = c.nextProbablePrime();
			//System.out.println(c);
		}
		*/
		
		while(b<=2000000)
		{
			if(isPrime(b))
			{	sum = sum.add(new BigInteger(Integer.toString(b)));
				//System.out.println(b);
			}
			b+=2;
		}
		
		System.out.println(sum);
	}
	
	
	static boolean isPrime(int a)
	{
	 if(a==1) return false;
	 else if(a<4) return true;
	 else if(a%2==0) return false;
	 else if(a<9) return true;
	 else if(a%3==0) return false;
	 else	
	 {
		double t = Math.sqrt((double)a);
		double r = Math.floor(t);
		int f = 5;
		while(f<=r)
		{
			if(a%f==0) return false;
			if(a%(f+2)==0) return false;
			f=f+6;
		}
		String p1 = Integer.toString(a);
		BigInteger test = new BigInteger(p1);
		if(!test.isProbablePrime(1))
		{
			System.out.println(a + " is not prime");
			return false;
		}
		return true;
	 }
	 
	}
}