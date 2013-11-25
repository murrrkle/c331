package cpsc331.assignment3;

import java.util.ListIterator;

/**
 *
 * Provides a simplified version of a finite ordered Map interface.
 * <br />
 *
 * <p>
 *  <strong>SortedMap Invariant:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> A finite map from keys of type&nbsp;K to
 *      values of type&nbsp;V is represented. </li>
 * <li> There is a total order on the set K of possible keys. </li>
 * <li> None of the keys included in this map are null. </li>
 * </ol>
 *
 * <p>
 *  Additional Notes:
 * </p>
 * 
 * <p>
 *  A constructor that creates an empty map should be provided.
 * </p>
 *
 */

public interface SortedMap<K extends Comparable<? super K>, V> {

 /**
 *
 * Reports the number of keys for which values are defined.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * </ol><br />
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> The number of keys for which values are defined is returned
 *      as output. </li>
 * <li> The represented Sorted Map has not been changed. </li>
 * </ol>
 *
 * @return the number of keys for which values are defined.
 *
 */

 int size();

 /**
 *
 * Reports whether this map includes a key-value pair with a given key.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> An element key of type K has been supplied as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied </li>
 * <li> The map being represented has not been changed </li>
 * <li> If the input key is null then an NullPointerException is thrown </li>
 * <li> If the input key is not null then the value true is returned as output
 *       if there is a key-value pair in this map with the given key, and false
 *       is returned otherwise.
 * </li>
 * </ol>
 *
 * @param key The key being asked about 
 * @return true if this map contains a key-value pair with the given key,
 *         and false otherwise
 * @throws NullPointerException if the input key is null
 *
 */

 boolean defined(K key);
 
  /**
 *
 * Gets the value corresponding to a given key in this map.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> A key of type K is supplied as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> This map has not been changed. </li>
 * <li> If the input key is null then a NullPointerException is thrown. </li>
 * <li> If the input key is not null and there is a key-value pair in this map
 *      for the given key then the value in this pair is returned as output.
 *      An UndefinedException is thrown otherwise. </li>
 *  </li>
 *  </ol>
 *
 * @param key A key being asked about
 * @return the value corresponding to this key in this map
 * @throws NullPointerException if the input key is null
 * @throws UndefinedException if the input key is not null and
 *         there is no key-value pair for this key in this map
 *
 */

 V get(K key);

 /**
 *
 * Reports the number of other keys, for which key-values pairs are
 * included, that are less than the given key.
 * <br />
 *
 * <p>
 * <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> An key of type K has been given as input. </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> If the input key is null then a NullPointerException is thrown. </li>
 * <li> If the input key is not null and there is a key-value pair with the given
 *      key in this map, then the number of other keys, for which key-value pairs exist,
 *      that are less than this key is returned as output. The value &minus;1
 *      is returned, otherwise.
 * </li>
 * <ii> The map being represented has not been changed &mdash; so that the
 *      SortedMap invariant is still satisfied.
 * </li>
 * </ol>
 *
 * @param key the key of type K whose index is to be reported
 * @return the number of keys for which key-value pairs are defined that
 *         are less than this key, if a key-value pair for it exists;
 *         &minus;1, otherwise.
 * @throws NullPointerException if the input key is null.
 *
 */

 int indexOf(K key);

 /**
 *
 * Returns the key, for which a value is defined, with a given index.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> An integer index is given as input. </li>
 * </ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> If the input index is nonnegative and less than the number
 *      of keys for which values are defined, then the key returned
 *      is the element of this set of keys that is less than exactly
 *       &ldquo;index&rdquo; other keys in the set. An
 *        IndexOutOfBoundsException is thrown, otherwise.
 * </li>
 * <li> The map being represented has not been changed &mdash; so that the
 *      SortedMap invariant is still satisfied. </li>
 * </ol>
 *
 * @param index an integer index (or position) into this ordered map
 * @return the key, in the set of keys for which values are defined,
 *         such that there are exactly &ldquo;index&rdquo; other keys in this
 *         set that are less than this
 * @throws IndexOutOfBoundsException if the input index is negative, or greater
 *         than or equal to the size of the set of keys for which values
 *         are defined
 *
 */

 K get(int index);

 /**
 *
 * Sets the value for a given key in this map.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> A key with type K and value with type V are given as input. </li>
 * <?ol>
 *
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> If the input key is null then a NullPointerException is thrown.
 * </li>
 * <li> If the input key is not null and there is no key-value pair for
 *      the given key then a key-value pair with the given key and value
 *      is added to this map.  Otherwise, the value in the key-value pair
 *      for the input key is changed to the input value. The map is
 *      otherwise unchanged. </li>
 * </ol>
 *
 * @param key The key for which a value is to be set.
 * @param value The corresponding value.
 * @throws NullPointerException if the input key is null.
 *
 */

 void set(K key, V value);

  /**
 *
 * Removes the key-value pair for a given key.
 * <br />
 *
 * <p>
 *  <strong>Precondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> A key of type K is given as input. </li>
 * </ol>
 * <p>
 *  <strong>Postcondition:</strong>
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li> The SortedMap invariant is satisfied. </li>
 * <li> If the input key is null then a NullPointerException is thrown. </li>
 * <li> If the input key is not null and a key-value pair for this key
 *      is included in the map then this pair is removed from the map,
 *      which is otherwise unchanged. Otherwise an UndefinedException
 *      is thrown and the map is not changed at all. </li>
 * </ol>
 *
 * @param key The key whose key-value pair is to be removed from this map.
 * @throws NullPointerException if the input key is null.
 * @throws NotFoundException if the input key is not null and the map did not
 *         include a key-value pair for this key.
 *
 */

 void remove(K key);


 /**
 *
 *  Returns an iterator over the keys for which key-value pairs are included.
 *  The keys are returned in increasing order.
 *  <br />
 *
 *  <p>
 *   <strong>Preconditon:</strong>
 *  </p>
 *  <ol style="list-style-type: lower-alpha">
 *  <li> The SortedMap invariant is satisfied. </li>
 *  </ol>
 *  <p>
 *   <strong>Postcondition:</strong>
 *  </p>
 *  <ol style="list-style-type: lower-alpha">
 *  <li> The SortedMap invariant is satisfied. </li>
 *  <li> An Iterator over the keys for which key-value pairs exist 
 *       is returned as output. </li>
 *  <li> The map being represented has not been changed. </li>
 *  </ol>
 *
 *  @return an iterator over the keys for which key-value pairs e
 *
 */

  ListIterator<K> iterator();

}
