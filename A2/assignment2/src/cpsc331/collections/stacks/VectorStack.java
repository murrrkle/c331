package cpsc331.collections.stacks;

import cpsc331.collections.adts.Stack;
import cpsc331.collections.exceptions.EmptyStackException;

/**
*
* Provides a Vector-based implementation of a Stack.
* </br />
*
* <p>
*  <strong>Class Invariant:</strong>
* </p>
* <ol style="list-style-type: lower-alpha">
* <li> A collection of objects of type E is maintained.
*      The object that is visible at the top of the collection
*      (that is, the stack) is the object that has been most
*      recently pushed onto it, and not yet removed.
* </li>
* <li> An object of type java.util.Stack<E> is used to store
*      the elements in this stack, in the natural order for this.
* </li>
* </ol>
*
*/

public class VectorStack<E> implements Stack<E>{

  // Data Field: Stack to be used internally

  private java.util.Stack<E> S;

  /**
 *
 * Creates an empty stack.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong> None.
 * </p>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied. </li>
 * <li> An empty stack has been created. </li>
 * </ol>
 *
 */

  public VectorStack() {

    this.S = new java.util.Stack<E>();

  }

  /**
 *
 * Pushes a given element onto the top of the stack.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied. </li>
 * <li> A value x of type E has been given as input. </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The class invariant is satisfied. </li>
 * <li> The input object x has been pushed onto the top
 *      of the stack (which is otherwise unchanged)
 * </li>
 * </ol>
 *
 * @param x an object to be pushed onto the stack
 *
 */

  public void push (E x) {

    this.S.push(x);

  }

  /**
 *
 * Returns the element at the top of the stack without modifying
 * the stack.
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
 * <li> This stack has not been changed. </li>
 * <li> If the stack is not empty then the element at the top of
 *      the stack is returned as output. An EmptyStackException
 *      is thrown otherwise. </li>
 * </ol>
 *
 * @return the object at the top of the stack
 * @throws EmptyStackException if the stack is empty
 *
 */

  public E peek() {

    if (this.S.empty()) {
      throw new EmptyStackException();
    } else {
      return this.S.peek();
    }

  }

  /**
 *
 * Removes an object from the top of the stack and returnes
 * it as output.
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
 * <li> If the stack was nonempty when this operation began
 *      the element at the top of the stack is removed (with
 *      the stack otherwise unchanged) and this element is
 *      returned as output. An EmptyStackException is thrown otherwise.
 * </li>
 * </ol>
 *
 * @return the object at the top of the stak
 * @throws EmptyStackException if the stack is empty
 *
 */

  public E pop() {

    if (this.S.empty()) {
      throw new EmptyStackException();
    } else {
      return this.S.pop();
    }

  }

  /**
 *
 * Reports whether the stack is empty.
 * </br />
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
 * <li> This stack has not been changed. </li>
 * <li> The value true is returned if this stack is empty, and
 *      the value false is returned otherwise. </li>
 * </ol>
 *
 * @return true if the stack is empty, and false otherwise
 *
 */

  public boolean isEmpty() {

    return this.S.empty();

  }

}
