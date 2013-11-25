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

public class TestInsert5 {

  // Used to construct the tree to be tested
  
  RBT<Integer, String> buildTree() {

    Integer TWENTYFIVE = new Integer(25);
    String sTWENTYFIVE = new String("twenty-five");
    RBTNode<Integer, String> T25 =
       new RBTNode<Integer, String>(TWENTYFIVE, sTWENTYFIVE, Colour.RED);

    Integer THIRTYFIVE = new Integer(35);
    String sTHIRTYFIVE = new String("thirty-five");
    RBTNode<Integer, String> T35 =
       new RBTNode<Integer, String>(THIRTYFIVE, sTHIRTYFIVE, Colour.RED);

    Integer THIRTY = new Integer(30);
    String sTHIRTY = new String("thirty");
    RBTNode<Integer, String> T30 =
       new RBTNode<Integer, String>(THIRTY, sTHIRTY, Colour.BLACK);

    T30.setLeft(T25);
    T25.setParent(T30);

    T30.setRight(T35);
    T35.setParent(T30);

    T30.setSize(3);

    Integer FIFTEEN = new Integer(15);
    String sFIFTEEN = new String("fifteen");
    RBTNode<Integer, String> T15 =
      new RBTNode<Integer, String>(FIFTEEN, sFIFTEEN, Colour.BLACK);

    Integer TWENTY = new Integer(20);
    String sTWENTY = new String("twenty");
    RBTNode<Integer, String> T20 =
      new RBTNode<Integer, String>(TWENTY, sTWENTY, Colour.RED);

    T20.setLeft(T15);
    T15.setParent(T20);

    T20.setRight(T30);
    T30.setParent(T20);

    T20.setSize(5);
    T20.setBlackHeight(2);
    
    Integer FIVE = new Integer(5);
    String sFIVE = new String("five");
    RBTNode<Integer, String> T5 =
      new RBTNode<Integer, String>(FIVE, sFIVE, Colour.BLACK);

    Integer TEN = new Integer(10);
    String sTEN = new String("ten");
    RBTNode<Integer, String> T10 =
      new RBTNode<Integer, String>(TEN, sTEN, Colour.BLACK);

    T10.setLeft(T5);
    T5.setParent(T10);

    T10.setRight(T20);
    T20.setParent(T10);

    T10.setSize(7);
    T10.setBlackHeight(2);

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

  // Insertion of a node with key 38 triggers insert case 1(b),
  // which is then followd by insert case 5.
  // .
  // The next tests ensure that a red-black tree has resulted from
  // this operation.

  @Test
  public void ShapeAfterInsertion() {
    
    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

    assertTrue(utils.RBTShape(T));

  }

  @Test
  public void KeyOrderAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

    assertTrue(utils.RBTKeyOrder(T.root()));

  }

  @Test
  public void ColoursAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

    assertTrue(utils.RBTColours(T));

  }

  @Test
  public void SizesAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

    assertTrue(utils.RBTSizes(T.root()));

  }

  @Test
  public void BlackHeightsAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

    assertTrue(utils.RBTBlackHeights(T.root()));

  }

  // A few more tests to ensure that of the tree are now
  // as expected

  @Test
  public void SizeAfterInsertion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

    assertTrue(T.size() == 8);

  }

  @Test
  public void CheckContents1() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

     Integer FIVE = new Integer(5);
     String sFIVE = new String("five");

    assertTrue(sFIVE.equals(T.get(FIVE)));

  }

  @Test
  public void CheckContents2() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

     Integer TEN = new Integer(10);
     String sTEN = new String("ten");

    assertTrue(sTEN.equals(T.get(TEN)));

  }

  @Test
  public void CheckContents3() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

     Integer FIFTEEN = new Integer(15);
     String sFIFTEEN = new String("fifteen");

    assertTrue(sFIFTEEN.equals(T.get(FIFTEEN)));

  }

  @Test
  public void CheckContents4() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

     Integer TWENTY = new Integer(20);
     String sTWENTY = new String("twenty");

    assertTrue(sTWENTY.equals(T.get(TWENTY)));

  }
  @Test
  public void CheckContents5() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

     Integer TWENTFIVE = new Integer(25);
     String sTWENTFIVE = new String("twenty-five");

    assertTrue(sTWENTFIVE.equals(T.get(TWENTFIVE)));

  }
  @Test
  public void CheckContents6() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

     Integer THIRTY = new Integer(30);
     String sTHIRTY = new String("thirty");

    assertTrue(sTHIRTY.equals(T.get(THIRTY)));

  }
  @Test
  public void CheckContents7() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

     Integer THIRTYFIVE = new Integer(35);
     String sTHIRTYFIVE = new String("thirty-five");

    assertTrue(sTHIRTYFIVE.equals(T.get(THIRTYFIVE)));

  }

  @Test
  public void CheckContents8() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYEIGHT = new Integer(38);
    String sTHIRTYEIGHT = new String("thirty-eight");
    T.insert(THIRTYEIGHT, sTHIRTYEIGHT);

    assertTrue(sTHIRTYEIGHT.equals(T.get(THIRTYEIGHT)));

  }
}
