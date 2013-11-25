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

public class TestDelete3g{

  // Used to construct the tree to be tested
 
  RBT<Integer, String> buildTree() {

    Integer FIVE = new Integer(5);
    String sFIVE = new String("five");
    RBTNode<Integer, String> T5 =
       new RBTNode<Integer, String>(FIVE, sFIVE, Colour.BLACK);

    Integer FIFTEEN = new Integer(15);
    String sFIFTEEN = new String("fifteen");
    RBTNode<Integer, String> T15 =
       new RBTNode<Integer, String>(FIFTEEN, sFIFTEEN, Colour.BLACK);

    Integer TEN = new Integer(10);
    String sTEN = new String("ten");
    RBTNode<Integer, String> T10 =
       new RBTNode<Integer, String>(TEN, sTEN, Colour.RED);

    T10.setLeft(T5);
    T5.setParent(T10);

    T10.setRight(T15);
    T15.setParent(T10);

    T10.setSize(3);
    T10.setBlackHeight(2);

    Integer TWENTYFIVE = new Integer(25);
    String sTWENTYFIVE = new String("twenty-five");
    RBTNode<Integer, String> T25 =
      new RBTNode<Integer, String>(TWENTYFIVE, sTWENTYFIVE, Colour.BLACK);

    Integer TWENTY = new Integer(20);
    String sTWENTY = new String("twenty");
    RBTNode<Integer, String> T20 =
      new RBTNode<Integer, String>(TWENTY, sTWENTY, Colour.BLACK);

    T20.setLeft(T10);
    T10.setParent(T20);

    T20.setRight(T25);
    T25.setParent(T20);

    T20.setSize(5);
    T20.setBlackHeight(2);

    RBT<Integer, String> T = new RBT<Integer, String>(T20);

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

  // Tests that when a RED node is deleted, the result
  // is still a red-black tree

  @Test
  public void ShapeAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    assertTrue(utils.RBTShape(T));

  }

  @Test
  public void KeyOrderAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    assertTrue(utils.RBTKeyOrder(T.root()));

  }

  @Test
  public void ColoursAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    assertTrue(utils.RBTColours(T));

  }

  @Test
  public void SizesAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    assertTrue(utils.RBTSizes(T.root()));

  }

  @Test
  public void BlackHeightsAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    assertTrue(utils.RBTBlackHeights(T.root()));

  }

  // Checks that the resulting red-black tree now represents the
  // expected set.

  @Test
  public void CorrectSizeAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    assertTrue(T.size() == 4);

  }

  @Test
  public void CheckContents1() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    Integer FIVE = new Integer(5);
    String sFIVE = new String("five");

    assertTrue(sFIVE.equals(T.get(FIVE)));

  }

  @Test
  public void CheckContents2() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    Integer TEN = new Integer(10);
    String sTEN = new String("ten");

    assertTrue(sTEN.equals(T.get(TEN)));

  }

  @Test
  public void CheckContents3() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    Integer TWENTY = new Integer(20);
    String sTWENTY = new String("twenty");

    assertTrue(sTWENTY.equals(T.get(TWENTY)));

  }

  @Test
  public void CheckContents4() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer FIFTEEN = new Integer(15);
    T.delete(FIFTEEN);

    Integer TWENTYFIVE = new Integer(25);
    String sTWENTYFIVE = new String("twenty-five");

    assertTrue(sTWENTYFIVE.equals(T.get(TWENTYFIVE)));

  }
}
