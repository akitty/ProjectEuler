import java.util.GregorianCalendar;
class p19
{
	public static void main(String[]args)
	{
		GregorianCalendar c = new GregorianCalendar(1901,0,1);
		GregorianCalendar end = new GregorianCalendar(2000,11,31);
		//GregorianCalendar b = end;
		//while(c!=end)
		//System.out.println(end==b);
		/*
		while(!c.equals(end))
		{
			
			
			c.add(
		}
		*/
		//c.set(c.DAY_OF_WEEK,1);
	//	System.out.println(c);
		System.out.println("year: "+c.get(c.YEAR));
		System.out.println("month: "+c.get(c.MONTH));
		//System.out.println(c.get(c.DAY_OF_MONTH));
		System.out.println("date: "+c.get(c.DATE));
		System.out.println("dayofyear: "+c.get(c.DAY_OF_YEAR));
		System.out.println("dayofweek: "+c.get(c.DAY_OF_WEEK));
		//c.add(c.DAY_OF_YEAR,1);
		/*
		System.out.println();
			System.out.println("year: "+c.get(c.YEAR));
		System.out.println("month: "+c.get(c.MONTH));
		//System.out.println(c.get(c.DAY_OF_MONTH));
		System.out.println("date: "+c.get(c.DATE));
		System.out.println("dayofyear: "+c.get(c.DAY_OF_YEAR));
		System.out.println("dayofweek: "+c.get(c.DAY_OF_WEEK));
		*/
		int sum=0;
		while(!c.equals(end))
		{
			if( c.get(c.DATE)==1 && c.get(c.DAY_OF_WEEK)==1)
			{
				sum++;
				System.out.println(
					c.get(c.DATE)
					+"/"+
					(c.get(c.MONTH)+1)+"/"+
					c.get(c.YEAR)
					);
			}
			
			c.add(c.DAY_OF_YEAR,1);
		}
		System.out.println(sum);
	}
}