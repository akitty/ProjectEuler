import java.util.*;
import java.io.*;
public class SudokuSolver
{
	static int  sudoku[];
	static Vector<Integer>[] guesses;
	static boolean changed;
	static int unknowns;
	public SudokuSolver(String filename)
	{
		sudoku = new int[81];
		unknowns=0;
		//read in file
		//String filename= "sudoku.in";
		try {
			if(!readfile(filename))
				System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fill possibilities
		//guesses = new LinkedList<Integer>[81];
		guesses= new Vector[81];
		
		for(int i = 0; i<81;i++)
		{
			guesses[i]=new Vector<Integer>();
			if(sudoku[i]!=0)
				guesses[i].add(sudoku[i]);
			else
			{
				for(int j =1;j<=9;j++)
					guesses[i].add(j);
				unknowns++;
			}
		}

	}
	//returns the row as a array
	//param b 0-8
	private int[] getRow(int b)
	{
		b=b/9;
		int a[]=new int[9];
		b = b*9;
		for(int i =0;i<9;i++)
		{
			a[i]=sudoku[b++];
		}
		return a;
	}	

	private int[] getCol(int b)
	{
		b=b%9;
		int a[]=new int[9];
		for(int i =0;i<9;i++)
		{
			a[i]=sudoku[b];
			b+=9;
		}
		
		return a;
	}
	
	
	private int divide3(int b)
	{
		b=b&9;
		while(b>3)
			b/=3;
		return b;
	}
	private int[] getBox(int b)
	{
		int col;
		int row;
		col=b%9/3;//divide3(b);
		row=b/27;
		b=row*3+col;
		int a[]=new int[9];
		switch(b)
		{
			case 0: break;
			case 1: b = 3; break;
			case 2: b = 6; break;
			case 3: b = 27; break;
			case 4: b = 30; break;
			case 5: b = 33; break;
			case 6: b = 54; break;
			case 7: b = 57; break;
			case 8: b = 60; break;
		}
		for(int i=0;i<9;i++)
		{
			 row = i/3;
			 col = i%3;
			int c;
			c = b+9*row+col;
			a[i]=sudoku[c];
		}
		return a;
	}
	
	private Vector<Integer> getRowBoxes(int box) {
		Vector<Integer> boxNums = new Vector<Integer>();
		int b = box/9;
		b=b*9;
		for(int i = 0;i<9;i++)
			boxNums.add(b++);
		
		return boxNums;
	}
	
	private Vector<Integer> getColBoxes(int box) {
		Vector<Integer> boxNums = new Vector<Integer>();
		int b = box%9;
		
		for(int i = 0;i<9;i++) {
			boxNums.add(b);
			b+=9;
		}
		return boxNums;
	}
	private Vector<Integer> getBoxBoxes(int box) {
		Vector<Integer> boxNums = new Vector<Integer>();
		int col;
		int row;
		col=box%9/3;//divide3(b);
		row=box/27;
		int b=row*3+col;
		int a[]=new int[9];
		switch(b)
		{
			case 0: break;
			case 1: b = 3; break;
			case 2: b = 5; break;
			case 3: b = 27; break;
			case 4: b = 30; break;
			case 5: b = 33; break;
			case 6: b = 54; break;
			case 7: b = 57; break;
			case 8: b = 60; break;
		}
		
		for(int i = 0;i<9;i++)
		{
			row = i/3;
			 col = i%3;
			int c;
			c = b+9*row+col;
			boxNums.add(c);
		}
		
		return boxNums;
	}
	/*
	 * Get Guesses all work by getting the corresponding number of boxes that are in the row/col/box
	 * and then using the numbers to add those guesses into the array
	 * it does not add the box number itself
	 */
	private Vector<Vector<Integer>> getRowGuesses(int box){
		//return all row guesses except itself
		Vector<Vector<Integer>> otherGuesses = new Vector<Vector<Integer>>();
		Vector<Integer> num = getRowBoxes(box);
		for(int x:num)
		{
			if(box!=x)
				otherGuesses.add(guesses[x]);
		}
		
		return otherGuesses;
	}
	private Vector<Vector<Integer>> getColGuesses(int box) {
		Vector<Vector<Integer>> otherGuesses = new Vector<Vector<Integer>>();
		Vector<Integer> num = getColBoxes(box);
		for(int x:num)
		{
			if(box!=x)
				otherGuesses.add(guesses[x]);
		}
		return otherGuesses;
		
	}
	private Vector<Vector<Integer>> getBoxGuesses(int box) {
		Vector<Vector<Integer>> otherGuesses = new Vector<Vector<Integer>>();
		Vector<Integer> num = getBoxBoxes(box);
		for(int x:num)
		{
			if(box!=x)
				otherGuesses.add(guesses[x]);
		}
		
		
		
		return otherGuesses;
		
	}
	
	static boolean readfile(String filename) throws IOException
	{
		FileInputStream fin;
		//File file = new File("./sudoku.in");
		int i;
		int j =0;
		//int sudoku[]= new int[81];
		
		String line;
		char []a = null;
		
		
		try
		{
			fin = new FileInputStream(filename);
			/*FileInputStream fstream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			br.read(a);*/
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			return false;
		}
		
		
		do
		{
			
			i = fin.read();
			//a = fin.readline();
			if(i!=-1&&i>=48) 
			{
				//System.out.print((char) i);
				sudoku[j++]=i-48;
			}
		}while(i!=-1);
		
		fin.close();
		return true;
	}
	
	void finish(){}
	void guess(){}
	public void print() {
		int i =0;
		System.out.println();
		for(int x:sudoku)
		{
			if(i++%9==0)
				System.out.println();
			System.out.print(x);
		}
		
	}
	public boolean solve() throws Exception {
		changed = false;
		//boolean notdone = true;
		//eliminate rows
		//eliminiate cols
		//eliminate boxes
		for(int i = 0;i<81;i++)
		{	
			//System.out.printf("Box %d\n",i);
			//if that box is already filled
			if(sudoku[i]!=0){
				//System.out.printf("Solved!: %d\n",sudoku[i]);
				continue;
			}
			//get row, column, box of that box
			int row[] = getRow(i);
			int col[]= getCol(i);
			int box[]= getBox(i);
			
			//eliminate from guesses every number not 0 in these 3
			//System.out.println("Rows");
			eliminate(guesses[i],row);
			//System.out.println("Cols");
			eliminate(guesses[i],col);
			//System.out.println("Boxes");
			eliminate(guesses[i],box);
			//debugging guesses
			//System.out.print("Guesses: ");
			int guessSize=0;
			for(int x:guesses[i]) {
				if(x!=0){
					//System.out.print(x+", ");
					guessSize++;
				}
			}
			//check if a guess is only containted in that box
			eliminate2(i);
			
			//System.in.read();
			//System.out.printf("number of guesses %d\n",guessSize);
			
			if(guesses[i].size()==1){
				sudoku[i]=guesses[i].firstElement();
				//System.out.printf("Box %d solved\n",i);
			}
			
		}
		//print();
		
	
		
		for(Vector<Integer> a:guesses)//for each guesses
		{
			if(a.size()!=1)
				return true;//not done
		}
		return false;//done
		
	}
	
	private void eliminate(Vector<Integer> guess, int[] row) throws Exception {
		for(int x:row)
		{
			
			if(guess.removeElement(x)) {
				//System.out.print("Removed: ");
				//System.out.print(x+", ");
				changed=true;
			}
			if(guess.size()==0)
			{
				print();
				throw new Exception();
			 }
			
		}
	}
	//eliminates by that box being only possibility
	//takes in box number
	private void eliminate2(int box)
	{
		
		boolean found=false;
		Vector<Vector<Integer> > otherGuesses;

		//compare to row guesses
		otherGuesses= getRowGuesses(box);
		if(!found)
		found = findUnique(box, guesses[box],otherGuesses);
		
		//compare to col guesses
		otherGuesses= getColGuesses(box);
		if(!found)
		found=findUnique(box, guesses[box],otherGuesses);
		
		//compare to box guesses
		otherGuesses= getBoxGuesses(box);
		if(!found)
		found=findUnique(box, guesses[box],otherGuesses);
		
		
	}
	
	private boolean findUnique(int box, Vector<Integer> guesses1, Vector<Vector<Integer> > otherGuesses)
	{
		//given a guess of a box
		//find unique element 
		
		//take element from guesses
		//check if otherGuesses contains it
		boolean unique = true;
		for(int x:guesses1) 
		{
			unique=true;
			for(Vector<Integer> b:otherGuesses)
			{	
				if(b.contains(x))
					{
						unique=false;
						break;
					}
				
			}
			if(unique)
			{
			
				//sets solution
				sudoku[box]=x;
				//clears guesses
				guesses[box].clear();
				//sets guesses as the solution
				guesses[box].add(x);
				//System.out.printf("\nUnique Found:%d\n",x);
				//System.out.print("");
				return true;
			}
		}
		return false;
	}
	
	void backtrack()
	{
		//create copy of current map
		//create start node
		/*
		Vector<Integer>[] guesses2=guesses;
		Node start= new Node();
		Node current = start;
		boolean solved=false;
		int level = 0;
		while(!solved) 
		{
			/*
			for(int i =0;i<81;i++)
			{
				if(guesses[i].size()!=1)
				{
					for(int n:guesses[i])
					{
						current.addchild(n);
					}
				}
			}
			
			
			//find first unknown
			int i=0;
			while(guesses[i].size()==1)
			{
				i++;
			}
			
			
		}
		*/
		
		//find all unknowns
		Vector<Integer> unknowns = new Vector<Integer>();
		for(int x:sudoku)
		{
			if(x==0)
				unknowns.add(x);
		}
		BT(0,unknowns);
		
	}
	//recursive backtrack algorithm
	int BT(int index, Vector<Integer> unknowns) {
		Vector<Integer> pos = new Vector<Integer>();//possibilities 
		for(int x: guesses[index])
		{
			pos.add(x);
		}
		
		return 0;
	}
	
	boolean test(int needle,int index) {
		//test column
		Vector<Integer> nums=null;
		for(int i = 0;i<3;i++){
			switch(i){
			case 0: 
				nums = getColBoxes(index);
				break;
			case 1:
				nums = getRowBoxes(index);
				break;
			case 2:
				nums = getBoxBoxes(index);
				break;
			
			}
			
			for(int x:nums) {
				if(x==needle)
					return false;
			}
		}
		//test row
		
		//test box
		return true;	
	}
	private class Node{
		public int guess;
		public Vector<Node> children;
		public Node parent;
		
		//constructor
		public Node(){}
		public Node(int n){
			
		}
		public void addchild(int n)
		{
			
		}
		
		
		
	}
				
	
}
