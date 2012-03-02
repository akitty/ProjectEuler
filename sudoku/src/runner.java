import java.io.IOException;


public class runner {
	public static void main(String[]args) throws Exception
	{
		String filename="2.in";
		SudokuSolver sudoku = new SudokuSolver(filename);
		int i =0;
	
		while(sudoku.solve()){
			i++;
			System.out.println(i);
			if(i>20) 
				break;
		}
		//try backtracking 
		
		System.out.printf("\nnumber of iterations:%d\n", i);
		sudoku.print();
	}
}
