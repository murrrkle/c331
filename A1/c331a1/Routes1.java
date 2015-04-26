package cpsc331.assignment1;
import java.math.BigInteger;

/**
 * <b><u>CPSC 331 ASSIGNMENT #1: ON THE CORRECTNESS OF SIMPLE ALGORITHMS AND PROGRAMS</b></u>
 * 
 * <p><tt>Routes1</tt> solves the Routes(n, m) counting problem as required in Assignment 1 Problem 3 by
 * implementing a simple recursive algorithm to determine the number of paths that can be taken 
 * on a two-dimensional grid by traversing using only the directions of <i>north</i> and <i>east</i>.
 * 
 * @author Bryan Huff (UCID 10096604)
 * @author Michael Hung (UCID 10099049)
 * @author Arnold Padillo (UCID 10097013)
 */

public class Routes1
{
    /**Performs three tests on the expected arguments:
     * <p>1. Are there exactly two (2) arguments?
     * <p>2. Are the arguments both integers? If so, parse and store them.
     * <p>3. Are the integers non-negative? If so, execute the recursive method, <tt>count</tt>.
     * <p>Should any of these tests fail, the program is to terminate immediately.
     * 
     * @param args A <tt>String</tt> <tt>Array</tt> of the arguments provided on the command-line. 
     * In <tt>Routes1</tt>, there should be exactly two non-negative, <tt>Integer</tt>-type arguments provided.
     * 
     * @throws IllegalArgumentException Thrown in the case that something other than a non-negative 
     * <tt>Integer</tt> has been provided on the command-line. Crashing subverted with a <tt>try-catch</tt> block.
     */
    public static void main(String[] args)
    {
        int columns = 0;
        int rows = 0;
        
        if (args.length != 2)
        {
            System.out.println("Please provide exactly two non-negative integers as arguments.");
            System.exit(0);
        }
        
        else
        {
            try
            {
                columns = Integer.parseInt(args[0]);
                rows = Integer.parseInt(args[1]);            
            }

            catch (IllegalArgumentException e)
            {
                System.out.println("Please provide exactly two non-negative integers as arguments.");
                System.exit(0);
            }
        }
        
        if (columns < 0 || rows < 0)
        {
            System.out.println("Please provide exactly two non-negative integers as arguments.");
            System.exit(0);
        }
            
        System.out.println(count(columns, rows));
    }
    
    /**This method uses two <tt>Integer</tt>-type arguments to recursively compute the total number of paths 
     * possible, using traversals only in the <i>north</i> or <i>east</i> directions, in the grid with area 
     * <b>columns</b> x <b>rows</b> units squared.
     * @param columns An <tt>Integer</tt> that represents the number of columns in the grid.
     * @param rows An <tt>Integer</tt> that represents the number of rows in the grid.
     * 
     * @return The sum of two <tt>BigIntegers</tt>.
     * 
     * @throws IllegalArgumentException If a negative <tt>Integer</tt> is used at any point during the execution 
     * of the <tt>count</tt> method, throw an exception and terminate the program.
     */
    public static BigInteger count(int columns, int rows)
    {   
        if (columns < 0 || rows < 0) 
            throw new IllegalArgumentException("This method does not accept negative integers as arguments.");
        
        else if (columns == 0 || rows == 0)
            return new BigInteger("1");
        
        else
        {
            BigInteger eastValue = count(columns,  rows - 1);
            BigInteger northValue = count(columns - 1, rows);
            
            return eastValue.add(northValue);
        }
    }
}
