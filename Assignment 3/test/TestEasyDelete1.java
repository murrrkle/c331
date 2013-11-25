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

public class TestEasyDelete1 {

  // Used to construct the tree to be tested
 
  RBT<Integer, String> buildTree() {

    Integer FIVE = new Integer(5);
    String sFIVE = new String("five");
    RBTNode<Integer, String> T5 =
       new RBTNode<Integer, String>(FIVE, sFIVE, Colour.BLACK);

    RBT<Integer, String> T = new RBT<Integer, String>(T5);

   return T;

  }

  // First a sanity check: Ensure that the initial tree really
  // is a red-black tree.

  @Test
  public void SanityCheck() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();

    assertTrue(utils.RBTShape(T));
    assertTrue(utils.RBTKeyOrder(T.root()));
    assertTrue(utils.RBTColours(T));
    assertTrue(utils.RBTSizes(T.root()));
    assertTrue(utils.RBTBlackHeights(T.root()));

  }

  // Tests that when the only non-NIL node is deleted, the result
  // is still a red-black tree

  @Test
  public void ShapeAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIVE = new Integer(5);
    T.delete(FIVE);

    assertTrue(utils.RBTShape(T));

  }

  @Test
  public void KeyOrderAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIVE = new Integer(5);
    T.delete(FIVE);

    assertTrue(utils.RBTKeyOrder(T.root()));

  }

  @Test
  public void ColoursAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIVE = new Integer(5);
    T.delete(FIVE);

    assertTrue(utils.RBTColours(T));

  }

  @Test
  public void SizesAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIVE = new Integer(5);
    T.delete(FIVE);

    assertTrue(utils.RBTSizes(T.root()));

  }

  @Test
  public void BlackHeightsAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIVE = new Integer(5);
    T.delete(FIVE);

    assertTrue(utils.RBTBlackHeights(T.root()));

  }

  // A check that the resulting red-black tree now represents the
  // empty set.

  @Test
  public void EmptyAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIVE = new Integer(5);
    T.delete(FIVE);

    assertTrue(T.size() == 0);

  }

}
