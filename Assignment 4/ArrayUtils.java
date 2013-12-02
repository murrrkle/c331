package cpsc331.assignment4;

import cpsc331.assignment4.Array;

public class ArrayUtils<T extends Comparable<T>> {
    
    private void quicksort(Array<T> A, int left, int right) 
    {
        if (right <= left) 
            return;
        
        int i = partition(A, left, right);
        quicksort(A, left, i-1);
        quicksort(A, i+1, right);
    }
    
    private int partition(Array<T> A, int left, int right)
    {   
        int i = left - 1;
        int j = right;
        
        while (true)
        {
            while(i < j)
            {
                while(j > i)
                {
                    if (j == left)
                    {
                        break;
                    }
                j--;
                }
                
            if (i >= j)
                {break;}
                
            i++;
                
            }
        
        exchange(A, i, j);
        return i;
        }
    }
    
    private void exchange(Array<T> A, int i, int j)
    {
        T swap = A.get(i);
        A.set(i, A.get(j));
        A.set(j,  swap);
    }
    
    public void sort(Array<T> A )
    {    
        quicksort(A, 0, A.length() - 1);
    };

}
