package cpsc331.assignment1;
import java.math.BigInteger;

/**
 * <b><u>CPSC 331 ASSIGNMENT #1: ON THE CORRECTNESS OF SIMPLE ALGORITHMS AND PROGRAMS</b></u>
 * 
 * <p><tt>Routes2</tt> solves the Routes(n, m) counting problem as required by Assignment 1 
 * Problem 5 by implementing an algorithm based on the <i>Pascal Triangle</i> to determine the 
 * number of paths that can be taken on a two-dimensional grid by traversing using only the 
 * directions of <i>north</i> and <i>east</i>.
 * 
 * @author Bryan Huff (UCID 10096604)
 * @author Michael Hung (UCID 10099049)
 * @author Arnold Padillo (UCID 10097013)
 */

public class Routes2
{
    /**Performs three tests on the expected arguments:
     * <p>1. Are there exactly two (2) arguments?
     * <p>2. Are the arguments both integers? If so, parse and store them.
     * <p>3. Are the integers non-negative? If so, execute the recursive method, <tt>count</tt>.
     * <p>Should any of these tests fail, the program is to terminate immediately.
     * 
     * @param args A <tt>String</tt> <tt>Array</tt> of the arguments provided on the command-line. In 
     * <tt>Routes1</tt>, there should be exactly two non-negative, <tt>Integer</tt>-type arguments 
     * provided.
     * 
     * @throws IllegalArgumentException Thrown in the case that something other than a non-negative 
     * <tt>Integer</tt> has been provided on the command-line. Crashing subverted with a <tt>try-
     * catch</tt> block.
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
    
    /**This method uses two <tt>Integer</tt>-type arguments to create a two-dimensional <tt>Array</tt>, 
     * with dimensions <b>columns</b> x <b>rows</b>, to calculate the total number of possible paths from 
     * (0, 0) to (columns, rows). These paths can only be traversed using directions in the <i>north</i> 
     * and <i>east</i>.<p>The algorithm relies on the mathematical phenomenon as described by the <i>Pascal 
     * Triangle</i>. 
     * 
     * @param columns An <tt>Integer</tt> that represents the number of columns in the <tt>Array</tt>.
     * @param rows An <tt>Integer</tt> that represents the number of rows in the <tt>Array</tt>.<p>
     * 
     * @return The sum of two <tt>BigIntegers</tt>: the total number of possible paths to a defined point.<p>
     * 
     * @throws IllegalArgumentException If a negative <tt>Integer</tt> is used at any point during the execution 
     * of the <tt>count</tt> method, throw an exception and terminate the program.
     */
    public static BigInteger count(int columns, int rows)
    {   
        if (columns < 0 || rows < 0) 
            // Assertion: inputs columns or rows are an integer less than 0
            throw new IllegalArgumentException("This method does not accept negative integers as arguments.");
        
        // Assertion: inputs columns or rows are an integer greater than or equal to 0
        else if (columns == 0 || rows == 0)
            return new BigInteger("1");
            /* Assertion:
             *  1. inputs columns or rows are an integer exactly equal to 0
             *  2. A BigInteger with value 1 has been returned
             */
        // Assertion: columns and rows are both positive integers
        else
        {
            BigInteger[][] grid = new BigInteger[columns + 1][rows + 1];
            
            int i = 0;
            int j = 1;
            int p = 1;
            int q = 1;

            /* Loop Invariant:
             *  1. columns is a non-negative integer input
             *  2. rows is a non-negative integer input
             *  3. The value of i is between 0 and (columns+1), inclusive
             *  4. grid is an array, with length (columns+1), of BigInteger arrays with length (rows+1)
             *
             *  Bound Function: columns - i
             */  
            
            /* Assertion - Before Loop Execution:
             *  1. The loop invariant is satisfied
             *  2. i is equal to 0
             *  3. grid[x][y] == null, for every x and y such that 0 <= x < (columns+1), 0 <= y < (rows+1)
             */
            
            while (i < columns + 1)      
            /* Assertion - Before Each Iteration:
             *  1. The loop invariant is satisfied
             *  2. The value of i is between 0 and (columns+1), inclusive
             *  3. grid[x][0] == BigInteger("1") for every x such that 0 <= x < i
             *  4. grid[x][0] == null for every x such that i <= x < (columns+1)
             */
            {
                grid[i][0] = new BigInteger("1");
                i++;
                
                /* Assertion - After Each Iteration:
                 *  1. The loop invariant is satisfied
                 *  2. The value of i is between 1 and (columns+1), inclusive
                 *  3. grid[x][0] == BigInteger("1") for every x such that 0 <= x < i
                 *  4. grid[x][0] == null for every x such that i <= x < (columns+1)
                 */
            }
            
            /* Assertion - After Loop Execution:
             *  1. The loop invariant is satisfied
             *  2. The value of i is equal to (columns+1)
             *  3. grid[x][0] == BigInteger("1") for every x such that 0 <= x < (columns+1)
             *  4. grid[x][y] == null for every x and y such that 1 <= x < (columns+1), 0 <= y < (rows+1)
             */
            
            /* Loop Invariant:
             *  1. columns is a non-negative integer input
             *  2. rows is a non-negative integer input
             *  3. The value of j is between 1 and (rows+1), inclusive
             *  4. grid is an array, with length (columns+1), of BigInteger arrays with length (rows+1)
             *  5. grid[x][0] == BigInteger("1") for every x such that 0 <= x < (columns+1)
             *
             *  Bound Function: rows - j
             */       
             
            /* Assertion - Before Loop Execution:
             *  1. The loop invariant is satisfied
             *  2. The value of j is equal to 1
             *  3. grid[x][y] == null, for every x and y such that 0 <= x < (columns+1), 1 <= y < (rows+1)
             */
            
            while (j < rows + 1)
            /* Assertion - Before Each Iteration:
             *  1. The loop invariant is satisfied
             *  2. The value of j is between 1 and (rows+1), inclusive
             *  3. grid[0][y] == BigInteger("1") for every y such that 0 <= x < j
             *  4. grid[0][y] == null for every y such that j <= y < (rows+1)
             */
            {
                grid[0][j] = new BigInteger("1");
                j++;
                
                /* Assertion - After Each Iteration:
                 *  1. The loop invariant is satisfied
                 *  2. The value of j is between 2 and (rows+1), inclusive
                 *  3. grid[0][y] == BigInteger("1") for every y such that 0 <= x < j
                 *  4. grid[0][y] == null for every y such that j <= y < (rows+1)
                 */
            }
            
            /* Assertion - After Loop Execution:
             *  1. The loop invariant is satisfied
             *  2. The value of j is equal to (rows+1)
             *  3. grid[0][y] == BigInteger("1") for every y such that 0 <= y < (rows+1)
             *  4. grid[x][y] == null for every x and y such that 1 <= x < (columns+1), 1 <= y < (rows+1)

            /* Outer Loop Invariant:
             *  1. columns is a non-negative integer input
             *  2. rows is a non-negative integer input
             *  3. The value of p is between 1 and (columns+1), inclusive
             *  4. The value of q is between 1 and (rows+1), inclusive
             *  5. grid is an array, with length (columns+1), of BigInteger arrays with length (rows+1)
             *  6. grid[x][0] == BigInteger("1") for every x such that 0 <= x < (columns+1)
             *  7. grid[0][y] == BigInteger("1") for every y such that 0 <= y < (rows+1)
             *
             *  Bound Function: columns - p
             */

            /* Assertion - Before Outer Loop Execution:
             *  1. The outer loop invariant is satisfied
             *  2. The value of p is equal to 1
             *  3. The value of q is equal to 1
             *  4. grid[x][y] == null, for every x and y such that 1 <= x < (columns+1), 1 <= y < (rows+1)
             */
            
            while (p < columns + 1)
            /* Assertion - Before Each Outer Loop Iteration:
             *  1. The outer loop invariant is satisfied
             *  2. The value of p is between 1 and (columns+1), inclusive
             *  3. The value of q is between 1 and (rows+1), inclusive
             *  4. grid[x][y] != null for every x and y such that 0 <= x < p, 0 <= y < q
             *  5. grid[x][y] == null for every x and y such that p <= x < (columns+1), q <= y < (rows+1)
             */
            {
                q = 1;
                
                /* Inner Loop Invariant:
                 *  1. columns is a non-negative integer input
                 *  2. rows is a non-negative integer input
                 *  3. The value of p is between 1 and (columns+1), inclusive
                 *  4. The value of q is between 1 and (rows+1), inclusive
                 *  5. grid is an array, with length (columns+1), of BigInteger arrays with length (rows+1)
                 *  6. The value of p in the Inner Loop is kept constant
                 *
                 *  Bound Function: rows - q
                 */

                /* Assertion - Before Inner Loop Execution:
                 *  1. The outer and inner loop invariants are satisfied
                 *  2. The value of q is equal to 1
                 *  3. grid[x][y] != null for every x and y such that 0 <= x < p, 0 <= y < q
                 *  4. grid[x][y] == null, for every x and y such that p <= x < (columns+1), 1 <= y < (rows+1)
                 */
                
                while (q < rows + 1)
                /* Assertion - Before Each Inner Loop Iteration:
                 *  1. The outer and inner loop invariants are satisfied
                 *  2. The value of q is between 1 and (rows+1), inclusive
                 *  3. grid[x][y] != null for every x and y such that 0 <= x < p, 0 <= y < q
                 *  4. grid[x][y] == null for every x and y such that p <= x < (columns+1), q <= y < (rows+1)
                 */
                {
                    grid[p][q] = grid[p - 1][q].add(grid[p][q - 1]);
                    q++;
                    
                    /* Assertion - After Each Inner Loop Iteration:
                     *  1. The outer and inner loop invariants are satisfied
                     *  2. The value of q is equal to (rows+1)
                     *  3. grid[x][y] != null for every x and y such that 0 <= x < p, 0 <= y < q
                     *  4. grid[x][y] == null for every x and y such that p <= x < (columns+1), q <= y < (rows+1)
                     */
                }
                
                /* Assertion - After Inner Loop Execution:
                 *  1. The outer and inner loop invariants are satisfied
                 *  2. The value of q is equal to (columns+1)
                 *  3. grid[x][y] != null for every x and y such that 0 <= x < (columns+1), 0 <= y < (rows+1)
                 *  4. grid[x][y] == null for every x and y such that p <= x < (columns+1), q <= y < (rows+1)
                 */
                
                p++;
                
                /* Assertion - After Each Outer Loop Iteration:
                 *  1. The outer loop invariant is satisfied
                 *  2. The value of p is between 2 and (columns+1), inclusive
                 *  3. The value of q is equal to (rows+1)
                 *  4. grid[x][y] != null for every x and y such that 0 <= x < p, 0 <= y < q
                 *  5. grid[x][y] == null for every x and y such that p <= x < (columns+1), q <= y < (rows+1)
                 */
            }
            
            /* Assertion - After Outer Loop Execution:
             *  1. The outer loop invariant is satisfied
             *  2. The value of p is equal to (rows+1)
             *  3. The value of q is equal to (columns+1)
             *  4. grid[x][y] != null for every x and y such that 0 <= x < (columns+1), 0 <= y < (rows+1)
            
            /* Assertion:
             *  1. The value of grid[columns][rows] is not null
             *  2. grid[columns][rows] contains an object of class BigInteger that has some returnable value
             */
            
            /* Assertion:
             *  1. columns and rows are non-negative integer inputs
             *  2. The value of grid[columns][rows] is not null
             *  3. grid[columns][rows] contains an object of class BigInteger that has some 
             *     returnable value
             */
            
            return grid[columns][rows];            

            /* Assertion: 
             *  1. columns and rows are non-negative integer inputs
             *  2. A BigInteger containing the correct value solving Routes(n, m) has been         
             *     returned
             */

        }
    }    
}
