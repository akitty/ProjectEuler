class p17
{
	public static String w []= new String[1001];
	
	
	public static void main(String [] args)
	{
		int sum = 0;
		w[1]="one";
		w[2]="two";
		w[3]="three";
		w[4]="four";
		w[5]="five";
		w[6]="six";
		w[7]="seven";
		w[8]="eight";
		w[9]="nine";
		w[10]="ten";
		w[11]="eleven";
		w[12]="twelve";
		w[13]="thirteen";
		w[14]="fourteen";
		w[15]="fifteen";
		w[16]="sixteen";
		w[17]="seventeen";
		w[18]="eighteen";
		w[19]="nineteen";
		w[20]="twenty";
		w[30]="thirty";
		w[40]="forty";
		w[50]="fifty";
		w[60]="sixty";
		w[70]="seventy";
		w[80]="eighty";
		w[90]="ninety";
		w[100]="hundred";
		w[0]="and";
		w[1000]="thousand";
		for(int i = 1;i<=1000;i++)
		{
			//System.out.println(word(i));
			sum+=word(i).length();
		}
		System.out.println( sum);
	}
	
	static String word(int n)
	{
		if(n<20) return w[n];
		if(n<100)
		{
			String o;
			if(n%10==0)
			o="";
			else
			o=w[n%10];
			
			
			String s = 
				w[(n/10)*10]+o;
			return s;
		}
		if(n<1000)
		{
			String h,t;
			
			if(n%100==0) return w[n/100]+w[100];
			h=w[n/100]+w[100]+w[0];
			t=word(n%100);
			return h+t;
		}
		if(n<10000)
		{
			if(n%1000==0) return w[n/1000]+w[1000];
			if(n%1000<=100) return w[n/1000]+w[1000]+w[0]+word(n%100);
			return w[n/1000]+w[1000]+word(n%1000);
		}
		
		return null;
	}
	

}