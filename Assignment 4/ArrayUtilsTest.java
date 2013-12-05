package cpsc331.assignment4;

import java.util.Random;

import cpsc331.assignment4.ArrayUtils;

public class ArrayUtilsTest
{
    
    public static void main(String args[])
    {
        ArrayUtils<Integer> B = new ArrayUtils<Integer>();
        
        for (int counter = 1; counter < 51; counter++)
        {
            Array<Integer> A = new Array<Integer>(counter); 
            Random rand = new Random();
            
            Integer a;
            
            for (int i = 0; i < counter; i++)
            {
                a = rand.nextInt(200);
                A.set(i, a);
            }
           
            B.sort(A); 
        }
        /*
        Array<Integer> testing1 = new Array<Integer>(10);
        Array<Integer> testing2 = new Array<Integer>(10);
        Random rand = new Random();
        int a;
        
        for(int i = 0; i < 10; i++)
        {
            a = rand.nextInt(100);
            testing1.set(i, a);
        }
        
        for(int i = 0; i < 10; i++)
            testing2.set(i, 1);
        
        B.sort(testing1);
        B.sort(testing2);
        */
        
        
    }
}
