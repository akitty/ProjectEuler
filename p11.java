import java.io.*;
class p11{
	public static void main(String[]args)
	{
		int grid[][]= new int[20][20];
		try{
			FileInputStream fstream = new FileInputStream("p11.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while((strLine=br.readLine())!=null) {
				System.out.println(strLine);
				
			}
			in.close();
		}
		catch(Exception  e){
		System.err.println("error: " + e.getMessage() ); 
		}
		
	}

}