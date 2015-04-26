package cpsc331.collections.exceptions;

/**
 * Provides an exception to report that a stack is already empty.
 *
 */

@SuppressWarnings("serial")
public class EmptyStackException extends RuntimeException {

  /**
 *
 * Constructs an EmptyStackException with no message
 *
 */

  public EmptyStackException() {
    super();
  }

  /**
 *
 * Constructs an EmptyStackException with a given message
 *
 */

  public EmptyStackException(String message){
    super(message);
  }

}