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
        if(left < right)
        {
            int pivot = partition(A,left, right);
            quicksort(A, left, pivot);
            quicksort(A, pivot + 1, right);
        }
    }
    
    /**
     * @param A - An <tt>Array</tt>
     * @param left - An <tt>Integer</tt> index
     * @param right - An <tt>Integer</tt> index
     * @return j -  - An <tt>Integer</tt> index used as pivot for "Divide and Conquer"
     */
    private int partition(Array<T> A, int left, int right)
    {
        T first = A.get(left);
        int i = left - 1 ;
        int j = right + 1 ;

        while (true) 
        {
            i++;
            while ((i < right) && (A.get(i).compareTo(first) < 0))
                i++;
            
            j--;
            
            while ((j > left) && (A.get(j).compareTo(first) > 0))
                j--;

            if (i < j)
                swap(A, i, j);
            
            else
                return j;
        }
    }    
    
    /**
     * Swaps the contents of two elements in A.
     * 
     * @param A - An <tt>Array</tt>
     * @param i - An <tt>Integer</tt> index
     * @param j - An <tt>Integer</tt> index
     */
    private void swap(Array<T> A, int i, int j)
    {
        T temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j,  temp);
    }
    
    /**
     * Prints the array in the following format:
     * "[a1, a2, ..., an]"
     * where n is the length of the array.
     * 
     * @param A - An <tt>Array</tt>
     */
    private void printArray(Array<T> A)
    {
        System.out.print("[");
        for (int i = 0; i < A.length() - 1; i++)
            System.out.print(A.get(i).toString() + ", ");
        System.out.print(A.get(A.length()-1));
        System.out.println("]");
    }
    
    /**
     * Use the sorting algorithm. Displays unsorted and the respective sorted array and the time taken to sort in nanoseconds.
     * 
     * @param A - An <tt>Array</tt>
     */
    public void sort(Array<T> A)
    {   
        System.out.println("Number of Elements in Array: " + A.length() + "\nUnsorted:");
        
        printArray(A);
        
        long startTime = System.nanoTime();
        
        quicksort(A, 0, A.length() - 1);
        
        long endTime = System.nanoTime();
        
        System.out.print("Sorted:");
        printArray(A);
        
        System.out.println("Took " + (endTime - startTime) + " ns\n"); 
    }

}
