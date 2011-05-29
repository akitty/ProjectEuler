import java.util.Vector;
class P24{
	public static void main(String[] argv){
		String [] alphabet = {"0","1","2","3","4","5","6","7","8","9"};
		int i=0;
		//alphabet = alphabet.
		Vector<String> alphabet2 = new Vector<String>();
		alphabet2.add(" ");
		//for(String c:alphabet)
		//	alphabet2.add(c);
		while(i<=1000000){
			for(String s: alphabet2)
			{
				if(i>999999){
				System.out.println(s);
				System.exit(1);
				}
				if(i>999996){
				System.out.println(s);}
				//System.out.println("i:"+i);}
			
				if(s.compareTo("0123456789") >= 0)
					i++;
				//System.out.println("loop1");
			}
			Vector<String> alphabet3 = new Vector<String>();
			for(String s:alphabet2){
				//System.out.println("loop2");
				for(String n : alphabet){
				 //System.out.println("loop3");
					alphabet3.add(s+n);
					//System.out.println(s+n);
				}
			}
			alphabet2=alphabet3;
			//System.out.println("loop4");
		}
	
		
	}
}
