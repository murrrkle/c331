package cpsc331.assignment3;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ListIterator;
import cpsc331.assignment3.SortedMap;
import cpsc331.assignment3.Colour;
import cpsc331.assignment3.FoundException;
import cpsc331.assignment3.NotFoundException;
import java.util.NoSuchElementException;
import cpsc331.assignment3.UndefinedException;
import cpsc331.assignment3.RBTNode;
import cpsc331.assignment3.RBT;
import cpsc331.assignment3.RBTUtils;

public class TestSizeOneMap {

  // Used to construct the map to be tested

  RBTMap<String, Integer> buildMap() {

    String s = new String("alpha");
    Integer m = new Integer(0);
    RBTMap<String, Integer> M = new RBTMap<String, Integer>();
    M.set(s, m);
    return M;

  }

  // Test that the size of this map is correctly reported
  
  @Test
  public void SizeOneMapSize() {
    RBTMap<String, Integer> M = buildMap();
    assertTrue(M.size() == 1);
  }

  // Tests of "defined" method with non-null keys that are
  // in, and not in, the map

  @Test
  public void SizeOneDefinedTrue() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("alpha");
    assertTrue(M.defined(s));
  }

  @Test
  public void SizeOneDefinedFalse() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("beta");
    assertFalse(M.defined(s));
  }

  // Tests of "get" with keys that are in, and not in, the map

  @Test
  public void SizeOneGetSuccessful() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("alpha");
    Integer ZERO = new Integer(0);
    assertTrue(ZERO.equals(M.get(s)));
  }

  @Test(expected=UndefinedException.class)
  public void SizeOneGetUnsuccessful() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("beta");
    M.get(s);
  }

  // Tests of "indexOf" method with input keys that are in, and
  // not in, the map

  @Test
  public void SizeOneIndexOfSuccessful() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("alpha");
    assertTrue(M.indexOf(s) == 0);
  }

  @Test
  public void SizeOneIndexOfUnsuccessful() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("beta");
    assertTrue(M.indexOf(s) == -1);
  }

  // Tests of "get" with a negative integer input, zero, and
  // a positive input

  @Test(expected=IndexOutOfBoundsException.class)
  public void SizeOneGetNegativeIndex() {
    RBTMap<String, Integer> M = buildMap();
    M.get(-1);
  }

  @Test
  public void SizeOneGetZeroIndex() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("alpha");
    assertTrue(s.equals(M.get(0)));
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void SizeOneGetPositiveIndex() {
    RBTMap<String, Integer> M = buildMap();
    M.get(1);
  }

  // Tests of "set" with key that are, and are not, already included

  @Test
  public void SizeOneSetIncluded() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("alpha");
    Integer TEN = new Integer(10);
    M.set(s, TEN);
    assertTrue(M.size() == 1);
  }

  @Test
  public void SizeOneSetIncluded2() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("alpha");
    Integer TEN = new Integer(10);
    M.set(s, TEN);
    assertTrue(TEN.equals(M.get(s)));
  }

  @Test
  public void SizeOneSetNotIncluded() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("beta");
    Integer TEN = new Integer(10);
    M.set(s, TEN);
    assertTrue(M.size() == 2);
  }

  @Test
  public void SizeOneSetNotIncluded2() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("beta");
    String t = new String("alpha");
    Integer TEN = new Integer(10);
    Integer ZERO = new Integer(0);   
    M.set(s,TEN);
    assertTrue(ZERO.equals(M.get(t)));
  }

  @Test
  public void SizeOneSetNotIncluded3() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("beta");
    Integer TEN = new Integer(10);
    M.set(s,TEN);
    assertTrue(TEN.equals(M.get(s)));
  }

  // Tests of "remove" with keys that are in, and not in, the map

  @Test
  public void SizeOneRemoveSuccessful() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("alpha");
    M.remove(s);
    assertTrue(M.size() == 0);
  }

  @Test(expected=NotFoundException.class)
  public void SizeOneRemoveUnsuccessful() {
    RBTMap<String, Integer> M = buildMap();
    String s = new String("beta");
    M.remove(s);
  }

  // Tests of ListIterator for a Map with Size One

  @Test
  public void SizeOneHasPrevious() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    assertFalse(iter.hasPrevious());
  }

  @Test
  public void SizeOneHasNext() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    assertTrue(iter.hasNext());
  }

  @Test(expected=NoSuchElementException.class)
  public void SizeOnePrevious() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.previous();
  }

  @Test
  public void SizeOneNext() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    String s = new String("alpha");
    assertTrue(s.equals(iter.next()));
  }

  @Test
  public void SizeOneNext2() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    assertTrue(iter.hasPrevious());
  }

  @Test
  public void SizeOneNext3() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    assertFalse(iter.hasNext());
  }

  @Test
  public void SizeOneNext4() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    String s = new String("alpha");
    assertTrue(s.equals(iter.previous()));
  }

  @Test
  public void SizeOneNextPrevious() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    iter.previous();
    assertFalse(iter.hasPrevious());
  }

  @Test
  public void SizeOneNextPrevious2() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    iter.previous();
    assertTrue(iter.hasNext());
  }

  @Test
  public void SizeOneNextPrevious3() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    iter.previous();
    String s = new String("alpha");
    assertTrue(s.equals(iter.next()));
  }

  @Test
  public void SizeOnePreviousIndex() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    assertTrue(iter.previousIndex() == -1);
  }

  @Test
  public void SizeOnePreviousIndex2() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    assertTrue(iter.previousIndex() == 0);
  }
  @Test
  public void SizeOnePreviousIndex3() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    iter.previous();
    assertTrue(iter.previousIndex() == -1);
  }

  @Test
  public void SizeOneNextIndex() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    assertTrue(iter.nextIndex() == 0);
  }

  @Test
  public void SizeOneNextIndex2() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    assertTrue(iter.nextIndex() == 1);
  }
  @Test
  public void SizeOneNextIndex3() {
    RBTMap<String, Integer> M = buildMap();
    ListIterator<String> iter = M.iterator();
    iter.next();
    iter.previous();
    assertTrue(iter.nextIndex() == 0);
  }

}
