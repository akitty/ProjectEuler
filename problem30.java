
import java.lang.Math;
class problem30
{
	public static void main(String[]argv)
	{
		int sumf=0;
		for(int i = 10;i<59049*5;i++)
		{
			String s = String.valueOf(i);
			char[] a= s.toCharArray();
			int sum = 0;
			for(char b: a)
			{
				int d = Integer.parseInt(Character.toString(b));
				sum+=Math.pow(d,5);
			}
			if(sum == i)
				{	System.out.println(i);
					sumf+=i;
				}
			
	
			
		}
		System.out.println(sumf);
	}
}