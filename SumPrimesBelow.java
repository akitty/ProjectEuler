public class SumPrimesBelow {
    public static void main(String[] args) {
        if ((args.length > 0) && (Integer.parseInt(args[0]) > 2))
        {
            int primeMax = Integer.parseInt(args[0]);
            long time = System.currentTimeMillis();
            long sum = 5; // assume 2 and 3
            int iJump = 4;
            for (int i = 5; i<primeMax; i+=iJump) {
                for (int j = 5; true; j+=6) {
                    if (j*j > i) { // found a prime
                        sum += i;
                        break;
                    }
                    if ((i % j == 0) || (i % (j+2) == 0))
                        break; // found a composite
                }
                if (iJump == 2)
					iJump = 4;
				else iJump = 2;
            }
            System.out.println(String.format("elapsed time: %,d (milliseconds)", 
                System.currentTimeMillis() - time));
            System.out.println(String.format("prime sum = %,d", sum));
        }
        else System.out.println("example usage: java SumPrimesBelow 1000000");
    }
}