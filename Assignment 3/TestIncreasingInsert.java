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

public class TestIncreasingInsert {

  // Used to construct the tree to be tested
 
  RBT<Integer, Integer> buildTree() {

    final int SIZE = 100;
    RBT<Integer, Integer> T = new RBT<Integer, Integer>();

    int i = 0;
    while (i < SIZE) {

      Integer next = new Integer(i);
      T.insert(next, next);
      i = i+1;

    };

    return T;

  } 

  @Test
  public void ShapeAfterCreation() {

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    assertTrue(utils.RBTShape(T));

  }

  @Test
  public void KeyOrderAfterCreation() {

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    assertTrue(utils.RBTKeyOrder(T.root()));

  }

  @Test
  public void ColoursAfterCreation() {

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    assertTrue(utils.RBTColours(T));

  }

  @Test
  public void SizesAfterCreation() {

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    assertTrue(utils.RBTSizes(T.root()));

  }

  @Test
  public void BlackHeightsAfterCreation() {

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    assertTrue(utils.RBTBlackHeights(T.root()));

  }

  // Tests that the tree is storing the expected set. These also introduce
  // tests for the ListIterator

  @Test
  public void ExpectedSize() {

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    assertTrue(T.size() == 100);

  }

  @Test
  public void ForwardIteration() {

    final int SIZE = 100;

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    ListIterator<RBTNode<Integer, Integer>> iter = T.iterator();

    int i = 0;

    while (iter.hasNext()) {

      assertTrue(iter.nextIndex() == i);

      Integer nextVal = new Integer(i);
      RBTNode<Integer, Integer> nextNode = iter.next();

      assertTrue(nextVal.equals(nextNode.key()));
      assertTrue(nextVal.equals(nextNode.value()));

      i = i + 1;

    };

    assertTrue(i == SIZE);
    assertTrue(iter.nextIndex() == SIZE);

  }

  @Test
  public void BackwardIteration() {

    final int SIZE = 100;
    int i = SIZE;

    RBT<Integer, Integer> T = buildTree();
    RBTUtils<Integer, Integer> utils = new RBTUtils<Integer, Integer>();
    ListIterator<RBTNode<Integer, Integer>> iter = T.iterator();

    while (iter.hasNext()) {
      iter.next();
    };

    while (iter.hasPrevious()) {

      i = i-1;
      assertTrue(iter.previousIndex() == i);

      Integer previousVal = new Integer(i);
      RBTNode<Integer, Integer> previousNode = iter.previous();

      assertTrue(previousVal.equals(previousNode.key()));
      assertTrue(previousVal.equals(previousNode.value()));

    };

    assertTrue(i == 0);
    assertTrue(iter.previousIndex() == -1);

  }

}
