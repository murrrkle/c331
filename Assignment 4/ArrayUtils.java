package cpsc331.assignment4;

import cpsc331.assignment4.Array;

/**
 * @author Arnold Padillo
 * @author Michael Hung
 * @author Bryan Huff
 *
 * This is an implementation of the QuickSort Algorithm used for sorting arrays in place, in n log n time.
 * 
 * @param <T> Generic Type
 */
public class ArrayUtils<T extends Comparable<T>> {
    
    /**
     * Implementation of Quicksort, a "divide and conquer" algorithm. Recursively calls itself to sort progressively parts of an <tt>Array</tt>.
     * 
     * @param A - An <tt>Array</tt>
     * @param left - An <tt>Integer</tt> index
     * @param right - An <tt>Integer</tt> index
     */
    private void quicksort(Array<T> A, int left, int right) 
    {
        if (right <= left) // right index should not be less than left index
            return;
        
        int i = partition(A, left, right); // Finds an index i to divide the Array into left and right parts - the 'pivot'
        quicksort(A, left, i - 1);
        quicksort(A, i + 1, right);
    }
    
    /**
     * @param A - An <tt>Array</tt>
     * @param left - An <tt>Integer</tt> index
     * @param right - An <tt>Integer</tt> index
     * @return i -  - An <tt>Integer</tt> index used as pivot for "Divide and Conquer"
     */
    private int partition(Array<T> A, int left, int right)
    {   
        int i = left - 1;
        int j = right;
        
        while (true)
        {
            while(A.get(++i).compareTo(A.get(right)) < 0)
            
            while(A.get(--j).compareTo(A.get(right)) > 0)
                if (j == left)
                    break;
            
            if (i >= j)
                break;
            
            exchange(A, i, j);
        }
        
        exchange(A, i, right);
        return i;
    }
    
    /**
     * Swaps the contents of two elements in A.
     * 
     * @param A - An <tt>Array</tt>
     * @param i - An <tt>Integer</tt> index
     * @param j - An <tt>Integer</tt> index
     */
    private void exchange(Array<T> A, int i, int j)
    {
        T temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j,  temp);
    }
    
    /**
     * Use the sorting algorithm.
     * 
     * @param A - An <tt>Array</tt>
     */
    public void sort(Array<T> A )
    {   
        System.out.print("Unsorted: [");
        for (int i = 0; i < A.length() - 1; i++)
            System.out.print(A.get(i).toString() + ", ");
        System.out.print(A.get(A.length()-1));
        System.out.println("]");
        
        quicksort(A, 0, A.length() - 1);
        
        System.out.print("Sorted:   [");
        for (int i = 0; i < A.length() - 1; i++)
            System.out.print(A.get(i).toString() + ", ");
        System.out.print(A.get(A.length()-1));
        System.out.println("]\n");
    }

}
