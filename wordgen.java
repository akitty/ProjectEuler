import java.io.*;
class wordgen
{
	public static void main(String[]args)
	{
		//generate 4 length words
		//stream writer
		
		
		Charset charset = Charset.forName("US-ASCII");
		String s= " ";
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			writer.write(s, 0, s.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
}