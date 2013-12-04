package cpsc331.assignment4;

import java.util.Random;

import cpsc331.assignment4.ArrayUtils;

public class ArrayUtilsTest
{
    public static void main(String args[])
    {
        for (int counter = 1; counter < 100; counter++)
        {
            Array<Integer> A = new Array<Integer>(counter); 
            Random rand = new Random();
            
            Integer a;
            
            for (int i = 0; i < counter; i++)
            {
                a = rand.nextInt(100);
                A.set(i, a);
            }
            
            ArrayUtils<Integer> B = new ArrayUtils<Integer>();
            
            long startTime = System.nanoTime();
            
            B.sort(A);
            
            long endTime = System.nanoTime();
            System.out.println("Took " + (endTime - startTime) + " ns"); 
        }
    }
}
