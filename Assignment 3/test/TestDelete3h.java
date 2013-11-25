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

public class TestDelete3h{

  // Used to construct the tree to be tested
 
  RBT<Integer, String> buildTree() {

    Integer FORTYFIVE = new Integer(45);
    String sFORTYFIVE = new String("forty-five");
    RBTNode<Integer, String> T45 =
       new RBTNode<Integer, String>(FORTYFIVE, sFORTYFIVE, Colour.BLACK);

    Integer THIRTYFIVE = new Integer(35);
    String sTHIRTYFIVE = new String("thirty-five");
    RBTNode<Integer, String> T35 =
       new RBTNode<Integer, String>(THIRTYFIVE, sTHIRTYFIVE, Colour.BLACK);

    Integer FORTY = new Integer(40);
    String sFORTY = new String("forty");
    RBTNode<Integer, String> T40 =
       new RBTNode<Integer, String>(FORTY, sFORTY, Colour.BLACK);

    T40.setLeft(T35);
    T35.setParent(T40);

    T40.setRight(T45);
    T45.setParent(T40);

    T40.setSize(3);
    T40.setBlackHeight(2);

    Integer FIFTEEN = new Integer(15);
    String sFIFTEEN = new String("fifteen");
    RBTNode<Integer, String> T15 =
      new RBTNode<Integer, String>(FIFTEEN, sFIFTEEN, Colour.BLACK);

    Integer TWENTYFIVE = new Integer(25);
    String sTWENTYFIVE = new String("twenty-five");
    RBTNode<Integer, String> T25 =
      new RBTNode<Integer, String>(TWENTYFIVE, sTWENTYFIVE, Colour.BLACK);

    Integer TWENTY = new Integer(20);
    String sTWENTY = new String("twenty");
    RBTNode<Integer, String> T20 = 
      new RBTNode<Integer, String>(TWENTY, sTWENTY, Colour.RED);

    T20.setLeft(T15);
    T15.setParent(T20);

    T20.setRight(T25);
    T25.setParent(T20);

    T20.setSize(3);
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

    T10.setSize(5);
    T10.setBlackHeight(2);

    Integer THIRTY = new Integer(30);
    String sTHIRTY = new String("thirty");
    RBTNode<Integer, String> T30 =
      new RBTNode<Integer, String>(THIRTY, sTHIRTY, Colour.BLACK);

    T30.setLeft(T10);
    T10.setParent(T30);

    T30.setRight(T40);
    T40.setParent(T30);

    T30.setSize(9);
    T30.setBlackHeight(3);

    RBT<Integer, String> T = new RBT<Integer, String>(T30);

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

  // Second case used is the required one

  @Test
  public void ShapeAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    assertTrue(utils.RBTShape(T));

  }

  @Test
  public void KeyOrderAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    assertTrue(utils.RBTKeyOrder(T.root()));

  }

  @Test
  public void ColoursAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    assertTrue(utils.RBTColours(T));

  }

  @Test
  public void SizesAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    assertTrue(utils.RBTSizes(T.root()));

  }

  @Test
  public void BlackHeightsAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    assertTrue(utils.RBTBlackHeights(T.root()));

  }

  // Checks that the resulting red-black tree now represents the
  // expected set.

  @Test
  public void CorrectSizeAfterDeletion() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    assertTrue(T.size() == 8);

  }

  @Test
  public void CheckContents1() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer FIVE = new Integer(5);
    String sFIVE = new String("five");

    assertTrue(sFIVE.equals(T.get(FIVE)));

  }


  @Test
  public void CheckContents2() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer TEN = new Integer(10);
    String sTEN = new String("ten");

    assertTrue(sTEN.equals(T.get(TEN)));

  }

  @Test
  public void CheckContents3() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer FIFTEEN = new Integer(15);
    String sFIFTEEN = new String("fifteen");

    assertTrue(sFIFTEEN.equals(T.get(FIFTEEN)));

  }

  @Test
  public void CheckContents4() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer TWENTY = new Integer(20);
    String sTWENTY = new String("twenty");

    assertTrue(sTWENTY.equals(T.get(TWENTY)));

  }

  @Test
  public void CheckContents5() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer TWENTYFIVE = new Integer(25);
    String sTWENTYFIVE = new String("twenty-five");

    assertTrue(sTWENTYFIVE.equals(T.get(TWENTYFIVE)));

  }

  @Test
  public void CheckContents6() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer THIRTY = new Integer(30);
    String sTHIRTY = new String("thirty");

    assertTrue(sTHIRTY.equals(T.get(THIRTY)));

  }

  @Test
  public void CheckContents7() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer FORTY = new Integer(40);
    String sFORTY = new String("forty");

    assertTrue(sFORTY.equals(T.get(FORTY)));

  }

  @Test
  public void CheckContents8() {

    RBT<Integer, String> T = buildTree();
    RBTUtils<Integer, String> utils = new RBTUtils<Integer, String>();
    Integer THIRTYFIVE = new Integer(35);
    T.delete(THIRTYFIVE);

    Integer FORTYFIVE = new Integer(45);
    String sFORTYFIVE = new String("forty-five");

    assertTrue(sFORTYFIVE.equals(T.get(FORTYFIVE)));

  }
}
