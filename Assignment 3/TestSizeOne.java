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

public class TestSizeOne {


  // Used to construct the tree to be tested

  RBT<String, Integer> buildTree() {

    String s = new String("alpha");
    Integer m = new Integer(0);
    RBT<String, Integer> T = new RBT<String, Integer>();
    T.insert(s, m);
    return T;

  }

  // Check that the shape of a tree with size one is correct
  
  @Test
  public void SizeOneShape() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    assertTrue(utils.RBTShape(T));
  }

  // Check that the keys have expected order (a standard part
  // of the test suite)

  @Test
  public void SizeOneKeyOrder() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    assertTrue(utils.RBTKeyOrder(T.root()));
  }

  // Check that this tree satisfies the expected "colour" properties

  @Test
  public void SizeOneColours() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    assertTrue(utils.RBTColours(T));
  }

  // Check that the sizes of nodes in this tree are correctly defined

  @Test
  public void SizeOneSizes() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    assertTrue(utils.RBTSizes(T.root()));
  }

  // Check that the blackHeights of nodes in this tree are well defined

  @Test
  public void SizeOneBlackHeights() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    assertTrue(utils.RBTBlackHeights(T.root()));
  }

  // Explicit Test of Size of Empty Tree

  @Test
  public void SizeOneSize() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    assertTrue(T.size() == 1);
  }

  // Tests of "includes: Successful searches as well as unsuccessful
  // ones in which the search key is less than the value at the root
  // and greater than it

  @Test
  public void SizeOneSuccessfulSearch() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("alpha");
    assertTrue(T.includes(key));
  }

  @Test
  public void SizeOneKeyTooSmall() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("aaa");
    assertFalse(T.includes(key));
  }

  @Test
  public void SizeOneKeyTooBig() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("beta");
    assertFalse(T.includes(key));
  }

  // Tests of "indexOf" for this Tree - for Keys in, and not in, Tree

  @Test
  public void SizeOneSuccessfulIndexOf() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("alpha");
    assertTrue(T.indexOf(key) == 0);
  }

  @Test
  public void SizeOneUnsuccessfulIndexOf() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("gamma");
    assertTrue(T.indexOf(key) == -1);
  }

  // Tests of "get" for This Tree - for Keys in, and not in, Tree

  @Test
  public void SizeOneSuccessfulGet() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("alpha");
    Integer ZERO = new Integer(0);
    assertTrue(ZERO.equals(T.get(key)));
  }

  @Test(expected=NotFoundException.class) 
  public void SizeOneUnsuccessfulGet() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("gamma");
    T.get(key);
  }

  // Tests of "get" with indices in and out of range

  @Test
  public void SizeOneSuccessfulGetIndex() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("alpha");
    assertTrue(key.equals(T.get(0)));
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void SizeOneUnsuccessfulGetIndex() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    T.get(3);
  }

  // Tests of "insert" with an input key that is, and is not, in this
  // tree

  @Test(expected=FoundException.class)
  public void SizeOneUnsuccessfulInsert() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("alpha");
    Integer ONE = new Integer(1);
    T.insert(key, ONE);
  }

  @Test
  public void SizeOneSuccessfulInsert() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("beta");
    Integer ONE = new Integer(1);
    T.insert(key, ONE);
    assertTrue(T.size() == 2);
  }

  // Tests of "change" with an input key that is, and is not,
  // in this tree

  @Test(expected=NotFoundException.class)
  public void SizeOneUnsuccessfulChange() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("beta");
    Integer ONE = new Integer(1);
    T.change(key, ONE);
  }

  @Test
  public void SizeOneSuccessfulChange() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("alpha");
    Integer TWO = new Integer(2);
    T.change(key, TWO);
    assertTrue(TWO.equals(T.get(key)));
  }

  // Tests of "delete" with input keys that are, and are not, in
  // this tree

  @Test
  public void SizeOneSuccessfulDelete() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("alpha");
    T.delete(key);
    assertTrue(T.size() == 0);
  }

  @Test(expected=NotFoundException.class)
  public void SizeOneUnsuccessfulDelete() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    String key = new String("beta");
    T.delete(key);
  }

  // Tests of ListIterator for a Tree with Size One

  @Test
  public void SizeOneHasPrevious() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    assertFalse(iter.hasPrevious());
  }

  @Test
  public void SizeOneHasNext() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    assertTrue(iter.hasNext());
  }

  @Test(expected=NoSuchElementException.class) 
  public void SizeOnePrevious() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.previous();
  }

  @Test
  public void SizeOneNext() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    String s = new String("alpha");
    assertTrue(s.equals(iter.next().key()));
  }

  @Test
  public void SizeOneNext2() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    assertTrue(iter.hasPrevious());
  }

  @Test
  public void SizeOneNext3() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    assertFalse(iter.hasNext());
  }

  @Test
  public void SizeOneNext4() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    String s = new String("alpha");
    assertTrue(s.equals(iter.previous().key()));
  }

  @Test
  public void SizeOneNextPrevious() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    iter.previous();
    assertFalse(iter.hasPrevious());
  }

  @Test
  public void SizeOneNextPrevious2() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    iter.previous();
    assertTrue(iter.hasNext());
  }

  @Test
  public void SizeOneNextPrevious3() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    iter.previous();
    String s = new String("alpha");
    assertTrue(s.equals(iter.next().key()));
  }

  @Test
  public void SizeOnePreviousIndex() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    assertTrue(iter.previousIndex() == -1);
  }

  @Test
  public void SizeOnePreviousIndex2() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    assertTrue(iter.previousIndex() == 0);
  } 
  @Test
  public void SizeOnePreviousIndex3() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    iter.previous();
    assertTrue(iter.previousIndex() == -1);
  } 

  @Test
  public void SizeOneNextIndex() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    assertTrue(iter.nextIndex() == 0);
  }

  @Test
  public void SizeOneNextIndex2() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    assertTrue(iter.nextIndex() == 1);
  }
  @Test
  public void SizeOneNextIndex3() {
    RBT<String, Integer> T = buildTree();
    RBTUtils<String, Integer> utils = new RBTUtils<String, Integer>();
    ListIterator<RBTNode<String, Integer>> iter = T.iterator();
    iter.next();
    iter.previous();
    assertTrue(iter.nextIndex() == 0);
  }

}

