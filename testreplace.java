class testreplace
{
	public static void main(String[] args)
	{
		String b = "\n";
		String a = "test \n abc";
		System.out.println(a);
		a = a.replaceAll(b, "	`");
		System.out.println(a);
	}
	
}
