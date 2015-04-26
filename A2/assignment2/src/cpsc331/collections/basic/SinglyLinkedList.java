package cpsc331.collections.basic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Provides an implementation of a simple singly linked list
 * <br />
 *
 * <p>
 *  <strong>SinglyLinkedList Invariant:</strong>
 * </p>
 * <p>
 * 
 * </p>
 * <ol style="list-style-type: lower-alpha;">
 * <li> The data structure represented is a singly linked list
 *      whose nodes store values with type&nbsp;E. </li>
 * <li> head is a reference to the node at the front of this Linked List or
 *      is null if the list is empty </li>
 * <li> tail is a reference to the node at the rear of this Linked List  or
 *      is null if the list is empty </li>
 * </ol>
 *
 **/

public class SinglyLinkedList<E> {

  // Provides a node in this linked list

  private class ListNode {

    // Class Invariant:
    // a) The value of this ListNode has type E
    // b) next is a reference to another ListNode (possibly null)

    // Data Fields
 
    private E value;
    private ListNode next;

    // Constructor
    //
    // Precondition:
    // a) e is an input with type E
    //
    // Postcondition:
    // a) The value of this new ListNode is e
    // b) next (for this new ListNode) is null

    ListNode(E e) {

      this.value = e;
      this.next = null;

    }

    // Provides the value being stored.
    //
    // Precondition:
    // a) The class invariant is satisfied.
    //
    // Postcondition:
    // a) The class invariant is satisfied.
    // b) This ListNode has not been changed.
    // c) The value for this ListNode has been returned as output.

    E value() {

      return this.value;

    }

    // Provides the next ListNode for this ListNode.
    //
    // Precondition:
    // a) The class invariant is satisfied.
    //
    // Postcondition:
    // a) The class invariant is satisfied.
    // b) This ListNode has not been changed.
    // c) The next ListNode for this ListNode has been returned as output.

    ListNode next() {

      return this.next;

    }

    // Changes the next ListNode for this one to the one that is
    // provided as input.
    //
    // Precondition:
    // a) The class invariant is satisfied.
    // b) next is an input with type ListNode.
    //
    // Postcondition:
    // a) The class invariant is satisfied.
    // b) On termination, the next ListNode for this ListNode is the
    //    one that has been supplied as input.
    // c) The value for this ListNode has not been changed.

    void setNext(ListNode next) {

      this.next = next;

    }

  }

  // Provides an Iterator for this Singly Linked List

  class SinglyLinkedListIterator implements Iterator<E> {

    // Class Invariant:
    // a) next is a reference to a ListNode in this Singly Linked
    //    List, or is null
    // b) If next is not null and this Singly Linked List has not
    //    been modified since this Iterator was created then every
    //    ListNode in this SinglyLinkedList between the head and
    //    next (not including next) has been visited - and no other
    //    ListNodes have been visited.
    // c) If next is null and this Singly Linked List has not been
    //    modified since this Iterator was created then every ListNode
    //    in this SinglyLinkedList has been visited.

    // Data Fields
    private ListNode next;

    // Constructor

    public SinglyLinkedListIterator() {

      this.next = head;

    }

    public boolean hasNext() {

      return !(this.next == null);

    }

    public E next() {

      // Return the value stored at this.next, advancing this.next
      // as well

      if (this.next == null) {

        throw new NoSuchElementException();

      } else {

        E value = this.next.value();
        this.next = this.next.next();
        return value;

      }

    }

    public void remove() {

      // This optional operation is not supported.

      throw new UnsupportedOperationException("remove is not supported");

    }

  }

  // Data Fields

  // ListNode at the front of this SinglyLinkedList
  private ListNode head;

  // ListNode at the rear of this SinglyLinkedList
  private ListNode tail;

  /**
  *
  * Constructs an empty singly linked list.
  * <br />
  *
  * <p>
  *  <strong>Precondition:</strong> None
  * </p>
  * <p>
  *  <strong>Postcondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * <li> This singly linked list is empty. </li>
  * </ol>
  *
  */

  public SinglyLinkedList() {

    this.head = null;
    this.tail = null;

  }

  /**
  *
  * Reports whether this singly linked list is empty.
  * <br />
  *
  * <p>
  *  <strong>Precondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * </ol>
  *
  * <p>
  *  <strong>Postcondition:</strong>
  * </p>
  * <ol>
  * <li> The class invariant is satisfied. </li>
  * <li> This singly linked list has not been changed. </li>
  * <li> If this singly linked list is empty then the value
  *      <code>true</code> is returned as output; the value
  *      <code>false</code> is returned as output otherwise.
  * </li>
  * </ol>
  *
  * @return true if this singly linked list is empty, and false otherwise
  *
  */

  public boolean isEmpty() {

    return (this.head == null);

  }

  /**
  *
  * Returns the element stored at the head of this SinglyLinkedList
  * <br />
  *
  * <p>
  *  <strong>Precondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * </ol>
  *
  * <p>
  *  <strong>Postcondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * <li> This singly linked list has not been changed. </li>
  * <li> If this singly linked list is empty then a NoSuchElementException
  *      is thrown. The element stored at the head of this singly linked
  *      list is returned, as output, otherwise.
  * </li>
  * </ol>
  *
  * @return the element stored at the head of this singly linked list
  * @throws NoSuchElementException if this singly linked list is empty
  *
  */

  public E head() {

    if (this.head == null) {

      throw new NoSuchElementException();

    } else {

      return this.head.value();

    }

  }

  /**
  *
  * Returns the element stored at the tail of this SinglyLinkedList
  * <br />
  *
  * <p>
  *  <strong>Precondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * </ol>
  *
  * <p>
  *  <strong>Postcondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * <li> This singly linked list has not been changed. </li>
  * <li> If this singly linked list is empty then a NoSuchElementException
  *      is thrown. The element stored at the tail of this singly linked
  *      list is returned, as output, otherwise.
  * </li>
  * </ol>
  *
  * @return the element stored at the tail of this singly linked list
  * @throws NoSuchElementException if this singly linked list is empty
  *
  */

  public E tail() {

    if (this.tail == null) {

      throw new NoSuchElementException();

    } else {

      return this.tail.value();

    }

  }

  /**
  *
  * Inserts the given element before the head of this singly linked list.
  * <br />
  *
  * <p>
  *  <strong>Precondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * </ol>
  *
  * <p>
  *  <strong>Postcondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * <li> A new ListNode storing the given element is inserted before
  *      the current head of this singly linked list, which is otherwise
  *      unchanged. </li>
  * </li>
  * </ol>
  *
  * @param e element to be inserted before the current head of this singly
  *          linked list
  *
  */

  public void addHead(E e) {

    ListNode newNode = new ListNode(e);

    if (this.head == null) {

      this.head = newNode;
      this.tail = newNode;

    } else {

      newNode.setNext(this.head);
      this.head = newNode;

    }

  }

  /**
  *
  *  Inserts the given element after the tail of this singly linked list.
  *  <br />
  *
  *  <p>
  *   <strong>Precondition:</strong>
  *  </p>
  *  <ol style="list-style-type: lower-alpha">
  *  <li> The class invariant is satisfied.
  *  </ol>
  *
  *  <p>
  *   <strong>Postcondition:</strong>
  *  </p>
  *  <ol style="list-style-type: lower-alpha">
  *  <li> The class invariant is satisfied. </li>
  *  <li> A new ListNode storing the given element is inserted after the
  *       current tail of this singly linked list, which is otherwise unchanged.
  *  </li>
  *
  *  @param e element to be inserted after the current tail of this singly
  *           linked list
  *
  */

  public void addTail(E e) {

    ListNode newNode = new ListNode(e);

    if (this.tail == null) {

      this.head = newNode;
      this.tail = newNode;

    } else {

      this.tail.setNext(newNode);
      this.tail = newNode;

    }

  }

  /**
  *
  * Removes the head from this singly linked list, returning the element
  * stored at the (former) head as output.
  * <br />
  *
  * <p>
  *  <strong>Precondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * </ol>
  *
  * <p>
  *  <strong>Postcondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * <li> If this singly linked list was nonempty at the beginning of this
  *      operation then the ListNode at the head of this singly linked
  *      list has been removed and the value stored at the former head
  *      has been returned as output &mdash; with this singly linked
  *      list being otherwise unchanged. A NoSuchElementException has
  *      been thrown (and this singly linked list has not beem changed)
  *      otherwise.
  * </li>
  * </ol>
  *
  * @return the element that has been removed from the head of this
  *         singly linked list
  * @throws NoSuchElementException of this singly linked list was already
  *         empty
  *
  */

  public E removeHead() {

    if (this.head == null) {

      throw new NoSuchElementException("This singly linked list is already empty.");

    } else {

      E e = this.head.value();
      this.head = this.head.next();

      if (this.head == null) {
        this.tail = null;
      };

      return e;

    }

  }

  /**
  *
  * Provides an iterator of this singly linked list.
  * <br />
  *
  * <p>
  *  <strong>Precondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> The class invariant is satisfied. </li>
  * </ol>
  *
  * <p>
  *  <strong>Postcondition:</strong>
  * </p>
  * <ol style="list-style-type: lower-alpha">
  * <li> This class invariant is satisfied. </li>
  * <li> This singly linked list has not been changed. </li>
  * <li> An iterator for this singly linked list has been returned
  *      as output. </li>
  * </ol>
  *
  * @return an iterator for this singly linked list
  *
  */

  public Iterator<E> iterator() {

    SinglyLinkedListIterator iter = new SinglyLinkedListIterator();
    return iter;

  }

} 
