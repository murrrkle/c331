package cpsc331.assignment1;
import java.math.BigInteger;

/**
 * <b><u>CPSC 331 ASSIGNMENT #1: ON THE CORRECTNESS OF SIMPLE ALGORITHMS AND PROGRAMS</b></u>
 * 
 * <p><tt>Routes1</tt> implements a simple recursive algorithm to determine the 
 * number of paths that can be taken on a two-dimensional grid by traversing using 
 * only the directions of <i>north</i> and <i>east</i>.
 * 
 * @author Bryan Huff
 * @author Michael Hung
 * @author Arnold Padillo
 */

public class Routes1
{
    /**
     * @param args A <tt>String</tt> <tt>Array</tt> of the provided arguments. In <tt>Routes1</tt>, there should be exactly two non-negative, <tt>Integer</tt>-type arguments provided.
     * @throws IllegalArgumentException Thrown in the case that something other than a non-negative <tt>Integer</tt> has been provided as an argument. Crashing subverted with a <tt>try-catch</tt> block.
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

            catch(IllegalArgumentException e)
            {
                System.out.println("Hey! One or more of the arguments you provided were not a non-negative integer!\nPlease provide two non-negative integers.");
                System.exit(0);
            }
        }
        
        if (columns < 0 || rows < 0)
        {
            System.out.println("Hey! One or more of the arguments you provided were not a non-negative integer!\nPlease provide two non-negative integers.");
            System.exit(0);
        }
        
        System.out.println(count(columns, rows));
    }
    
    /**This method uses two <tt>Integer</tt>-type arguments to recursively compute the total number of paths possible, using traversals only in the <i>north</i> or <i>east</i> directions, in the grid with area <b>columns</b> x <b>rows</b> units squared.
     * @param columns An <tt>Integer</tt> that represents the number of columns in the grid.
     * @param rows An <tt>Integer</tt> that represents the number of rows in the grid.
     * @return The sum of two <tt>BigIntegers</tt>.
     */
    public static BigInteger count(int columns, int rows)
    {   
        if (columns == 0 || rows == 0)
        {
            return new BigInteger("1");
        }
        
        else
        {
            BigInteger eastValue = count(columns,  rows - 1);
            BigInteger northValue = count(columns - 1, rows);
            
            return eastValue.add(northValue);
        }
    }
}
