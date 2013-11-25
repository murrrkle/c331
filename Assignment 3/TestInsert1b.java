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

public class TestInsert1b {

  // Used to construct the tree to be tested
  
  RBT<Integer, String> buildTree() {

    Integer FIVE = new Integer(5);
    String sFIVE = new String("five");
    RBTNode<Integer, String> T5 =
       new RBTNode<Integer, String>(FIVE, sFIVE, Colour.RED);

    Integer FIFTEEN = new Integer(15);
    String sFIFTEEN = new String("fifteen");
    RBTNode<Integer, String> T15 =
       new RBTNode<Integer, String>(FIFTEEN, sFIFTEEN, Colour.RED);

    Integer TEN = new Integer(10);
    String sTEN = new String("ten");
    RBTNode<Integer, String> T10 =
       new RBTNode<Integer, String>(TEN, sTEN, Colour.BLACK);

    T10.setLeft(T5);
    T5.setParent(T10);

    T10.setRight(T15);
    T15.setParent(T10);

    T10.setSize(3);

    RBT<Integer, String> T = new RBT<Integer, String>(T10);

    return T;

  }

  // First a sanity check: Ensure that that the initial tree
  // really is a red-black tree

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

  // Insertion of a node with key 8 triggers insert case 1(b).
  // The next tests ensure that a red-black tree has resulted from
  // this operation.

  @Test
  public void ShapeAfterInsertion() {
    
    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    assertTrue(utils.RBTShape(T));

  }

  @Test
  public void KeyOrderAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    assertTrue(utils.RBTKeyOrder(T.root()));

  }

  @Test
  public void ColoursAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    assertTrue(utils.RBTColours(T));

  }

  @Test
  public void SizesAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    assertTrue(utils.RBTSizes(T.root()));

  }

  @Test
  public void BlackHeightsAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    assertTrue(utils.RBTBlackHeights(T.root()));

  }

  // A few more tests to ensure that of the tree are now
  // as expected

  @Test
  public void SizeAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    assertTrue(T.size() == 4);

  }

  @Test
  public void CheckContents1() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    Integer FIVE = new Integer(5);
    String sFIVE = new String("five");

    assertTrue(sFIVE.equals(T.get(FIVE)));

  }

  @Test
  public void CheckContents2() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

    assertTrue(sEIGHT.equals(T.get(EIGHT)));

  }

  @Test
  public void CheckContents3() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

     Integer TEN = new Integer(10);
     String sTEN = new String("ten");

    assertTrue(sTEN.equals(T.get(TEN)));

  }

  @Test
  public void CheckContents4() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer EIGHT = new Integer(8);
    String sEIGHT = new String("eight");
    T.insert(EIGHT, sEIGHT);

     Integer FIFTEEN = new Integer(15);
     String sFIFTEEN = new String("fifteen");

    assertTrue(sFIFTEEN.equals(T.get(FIFTEEN)));

  }

}
