package cpsc331.assignment3;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ListIterator;
import cpsc331.assignment3.Colour;
import cpsc331.assignment3.FoundException;
import cpsc331.assignment3.NotFoundException;
import java.util.NoSuchElementException;
import cpsc331.assignment3.RBTNode;
import cpsc331.assignment3.RBT;
import cpsc331.assignment3.RBTUtils;

public class TestEmptyTree {

  // Check that the shape of an empty tree is correct

  @Test
  public void EmptyShape() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
   assertTrue(utils.RBTShape(T));
  }

  // Check that keys have the expected order (a standard part
  // of the test suite)
  
  @Test
  public void EmptyKeyOrder() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    assertTrue(utils.RBTKeyOrder(T.root()));
  }

  // Check that the empty tree satisfies the expected "colour"
  // properties

  @Test
  public void EmptyColours() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    assertTrue(utils.RBTColours(T));
  }

  // Check that sizes of nodes are correctly defined in an empty
  // tree

  @Test
  public void EmptySizes() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    assertTrue(utils.RBTSizes(T.root()));
  }

  // Check that blackHeights of nodes are correctly defined (and,
  // thus, *well-defined*) in an empty tree

  @Test
  public void EmptyBlackHeights() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    assertTrue(utils.RBTBlackHeights(T.root()));
  }

  // Explicit Test of Size of Empty Tree

  @Test
  public void EmptyTreeSize() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    assertTrue(T.size() == 0);
  }

  // Test of "includes" for Empty Tree with null and non-null Inputs

  @Test(expected = NullPointerException.class)
  public void EmptyIncludesNull() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    T.includes(null);
  }

  @Test
  public void EmptyIncludes() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    Integer ONE = new Integer(1);
    assertFalse(T.includes(ONE));
  }

  // Test of "indexOf" for Empty Tree with null and non-null INputs

  @Test(expected = NullPointerException.class)
  public void EmptyIndexOfNull() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    T.indexOf(null);
  }

  @Test
  public void EmptyIndexOf() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    Integer ONE = new Integer(1);
    assertTrue(T.indexOf(ONE) == -1);
  }

  // Test of "get" for Empty Tree with null and non-null Keys as Input

  @Test(expected=NullPointerException.class)
  public void EmptyGetNull() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    T.get(null);
  }

  @Test(expected=NotFoundException.class)
  public void EmptyGet() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    Integer ONE = new Integer(1);
    T.get(ONE);
  }

  // Test of "get" for Empty Tree with negative, zero, and
  // positive inputs

  @Test(expected=IndexOutOfBoundsException.class)
  public void EmptyGetNegative() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    T.get(-1);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void EmptyGetZero() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    T.get(0);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void EmptyGetPositive() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    T.get(1);
  }

  // Tests of change on Empty Tree with null and non-null Inputs

  @Test(expected=NullPointerException.class)
  public void ChangeEmptyNull() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    String s = new String("abcde");
    T.change(null, s);
  }

  @Test(expected=NotFoundException.class)
  public void ChangeEmpty() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    Integer ONE = new Integer(1);
    String s = new String("abcde");
    T.change(ONE, s);
  }

  @Test(expected=NotFoundException.class)
  public void ChangeEmptyNullString() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    Integer ONE = new Integer(1);
    T.change(ONE, null);
  }

  // Tests of delete from Empty Tree with null and non-null inputs

  @Test(expected=NullPointerException.class)
  public void DeleteEmptyNull() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    T.delete(null);
  }

  @Test(expected=NotFoundException.class)
  public void DeleteEmpty() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    Integer ONE = new Integer(1);
    T.delete(ONE);
  }

  // Tests of ListIterator for an Empty Tree
  
  @Test
  public void EmptyhasPrevious() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    assertFalse(iter.hasPrevious());
  }

  @Test
  public void EmptyhasNext() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    assertFalse(iter.hasNext());
  }

  @Test(expected=NoSuchElementException.class)
  public void EmptyPrevious() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    iter.previous();
  }

  @Test(expected=NoSuchElementException.class)
  public void EmptyNext() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    iter.next();
  }

  @Test
  public void EmptyPreviousIndex() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    assertTrue(iter.previousIndex() == -1);
  }

  @Test
  public void EmptyNextIndex() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    assertTrue(iter.nextIndex() == 0);
  }

  @Test(expected=UnsupportedOperationException.class)
  public void EmptyIteratorAdd() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    iter.add(null);
  }

  @Test(expected=UnsupportedOperationException.class)
  public void EmptyIteratorSet() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    iter.set(null);
  }

  @Test(expected=UnsupportedOperationException.class)
  public void EmptyIteratorRemove() {
    RBT<Integer, String> T = new RBT<Integer, String>();
    ListIterator<RBTNode<Integer, String>> iter = T.iterator();
    iter.remove();
  }

}
