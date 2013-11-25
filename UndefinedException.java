package cpsc331.assignment3;

/**
 * Provides an exception to report that a the value for a given key in a
 * map is undefined &mdash; that is, there is no key-value pair in the
 * map for this key..
 *
 */

public class UndefinedException extends RuntimeException {

  /**
 *
 * Constructs an UndefinedException with no message
 *
 */

  public UndefinedException() {
    super();
  }

  /**
 *
 * Constructs an UndefinedException with a given message
 *
 */

  public UndefinedException(String message){
    super(message);
  }

}
