package cpsc331.assignment3;

import org.junit.*;
import static org.junit.Assert.*;
import cpsc331.assignment3.SortedMap;
import cpsc331.assignment3.RBTMap;
import java.util.ListIterator;
import cpsc331.assignment3.Colour;
import cpsc331.assignment3.FoundException;
import cpsc331.assignment3.NotFoundException;
import cpsc331.assignment3.UndefinedException;
import java.util.NoSuchElementException;

public class TestIncreasingMapInsert {

  // Used to construct the tree to be tested
 
  RBTMap<Integer, Integer> buildMap() {

    final int SIZE = 100;
    RBTMap<Integer, Integer> M = new RBTMap<Integer, Integer>();

    int i = 0;
    while (i < SIZE) {

      Integer next = new Integer(i);
      M.set(next, next);
      i = i+1;

    };

    return M;

  } 

  @Test
  public void ExpectedSize() {

    SortedMap<Integer, Integer> M = buildMap();
    assertTrue(M.size() == 100);

  }

  @Test
  public void ForwardIteration() {

    final int SIZE = 100;

    SortedMap<Integer, Integer> M = buildMap();
    ListIterator<Integer> iter = M.iterator();

    int i = 0;

    while (iter.hasNext()) {

      assertTrue(iter.nextIndex() == i);

      Integer nextVal = new Integer(i);
      Integer nextInMap = iter.next();

      assertTrue(nextVal.equals(nextInMap));

      i = i + 1;

    };

    assertTrue(i == SIZE);
    assertTrue(iter.nextIndex() == SIZE);

  }

  @Test
  public void BackwardIteration() {

    final int SIZE = 100;
    int i = SIZE;

    SortedMap<Integer, Integer>  M = buildMap();
    ListIterator<Integer> iter = M.iterator();

    while (iter.hasNext()) {
      iter.next();
    };

    while (iter.hasPrevious()) {

      i = i-1;
      assertTrue(iter.previousIndex() == i);

      Integer previousVal = new Integer(i);
      Integer previousInMap = iter.previous();

      assertTrue(previousVal.equals(previousInMap));

    };

    assertTrue(i == 0);
    assertTrue(iter.previousIndex() == -1);

  }

}
