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

public class TestEmptyMap {

  // Test that size of an empty map is correctly reported

  @Test
  public void EmptyMapSize() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    assertTrue(M.size() == 0);
  }

  // Tests of "defined" method on null and non-null inputs

  @Test(expected=NullPointerException.class)
  public void EmptyDefinedNull() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    M.defined(null);
  }

  @Test
  public void EmptyDefined() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    Integer ZERO = new Integer(0);
    assertFalse(M.defined(ZERO));
  }

  // Tests of "get" method with null and non-null keys as input

  @Test(expected=NullPointerException.class)
  public void EmptyGetNull() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    M.get(null);
  }

  @Test(expected=UndefinedException.class)
  public void EmptyGet() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    Integer ZERO = new Integer(0);
    M.get(ZERO);
  }

  // Tests of "indexOf" method with null and non-null keys as inputs

  @Test(expected=NullPointerException.class)
  public void EmptyIndexOfNull() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    M.indexOf(null);
  }

  @Test
  public void EmptyIndexOf() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    Integer ZERO = new Integer(0);
    assertTrue(M.indexOf(ZERO) == -1);
  }

  // Tests of "get" with negative, zero and positive integer inputs

  @Test(expected=IndexOutOfBoundsException.class)
  public void EmptyGetNegativeIndex() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    M.get(-1);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void EmptyGetZeroIndex() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    M.get(0);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void EmptyGetPositiveIndex() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    M.get(1);
  }

  // Tests of "set" with non-null and null keys as inputs

  @Test(expected=NullPointerException.class)
  public void EmptySetNull() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    String s = new String("alpha");
    M.set(null, s);
  }

  @Test
  public void EmptySet() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    Integer ZERO = new Integer(0);
    String s = new String("alpha");
    M.set(ZERO, s);
    assertTrue(M.size() == 1);
  }

  // Tests of "remove" with non-null and null keys as inputs

  @Test(expected=NullPointerException.class)
  public void EmptyRemoveNull() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    M.remove(null);
  }

  @Test(expected=NotFoundException.class)
  public void EmptyRemove() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    Integer ZERO = new Integer(0);
    M.remove(ZERO);
  }

  // Tests of a ListIterator for an Empty Map

  @Test
  public void EmptyhasPrevious() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    assertFalse(iter.hasPrevious());
  }

  @Test
  public void EmptyhasNext() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    assertFalse(iter.hasNext());
  }

  @Test(expected=NoSuchElementException.class)
  public void EmptyPrevious() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    iter.previous();
  }

  @Test(expected=NoSuchElementException.class)
  public void EmptyNext() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    iter.next();
  }

  @Test
  public void EmptyPreviousIndex() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    assertTrue(iter.previousIndex() == -1);
  }

  @Test
  public void EmptyNextIndex() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    assertTrue(iter.nextIndex() == 0);
  }

  @Test(expected=UnsupportedOperationException.class)
  public void EmptyIteratorAdd() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    iter.add(null);
  }

  @Test(expected=UnsupportedOperationException.class)
  public void EmptyIteratorSet() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    iter.set(null);
  }

  @Test(expected=UnsupportedOperationException.class)
  public void EmptyIteratorRemove() {
    RBTMap<Integer, String> M = new RBTMap<Integer, String>();
    ListIterator<Integer> iter = M.iterator();
    iter.remove();
  }

}
