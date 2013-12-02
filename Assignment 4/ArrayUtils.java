package cpsc331.assignment4;

import cpsc331.assignment4.Array;

public class ArrayUtils<T extends Comparable<T>> {
    
    private void quicksort(Array<T> A)
    {
        
    }
    
    private int partition(Array<T> A, int left, int right)
    {
        int i;
        int j;
        
        int i = left - 1;
        int j = right;
        
        while (true)
        {
            while(i < j)
            {
                while(j > i)
                {
                    if (j == left)
                        {break;}
                j--;
                }
                
            if (i >= j)
                {break;}
                
            i++;
                
            }
        
        exchange(i,j);
        return i;
        }
    
    }
    
    private void exchange(Array<T> A, int i, int j)
    {
        
    }
    
    public void sort(Array<T> A )
    {    
        
    };

}
