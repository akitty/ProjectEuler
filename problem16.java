import java.math.BigInteger;
class problem16
{
	public static void main(String[]argv)
	{
		BigInteger num = new BigInteger("2");
		num = num.pow(1000);
		String s = num.toString();
		int sum = 0;
		for(int i =0;i<s.length();i++)
		{
			sum+=Integer.parseInt(s.substring(i,i+1));
		}
		System.out.println(sum);
	}
}