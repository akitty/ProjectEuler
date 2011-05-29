public class log2{
	public static void main(String[] args){
	
		
		System.out.println(logbase2(16));
		System.out.println(logbase2(15));
		System.out.println(logbase2(14));
		System.out.println(logbase2(13));
		System.out.println(3/2);
	}
	
	
	
	static int logbase2(int n){
		int log2=0;
		do{	
			n=n/2;
			log2++;
		}while(n!=1);

		return log2;
	}
		
}