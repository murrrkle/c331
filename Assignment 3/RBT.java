package cpsc331.assignment3;

import cpsc331.assignment3.Colour;
import cpsc331.assignment3.FoundException;
import cpsc331.assignment3.NotFoundException;
import cpsc331.assignment3.RBTNode;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/*
 *
 * Provides a Red-Black Tree that can be used to implement either
 * a SortedSet or a SortedMap
 *
 */

class RBT<K extends Comparable<K>, V> {

  // Data Fields
  
  private RBTNode<K, V> root;    // The root of this red-black tree

  // Inner class providing a ListIterator

  class RBTIterator implements ListIterator<RBTNode<K, V>> {

    // Data Fields
    private RBTNode<K, V> previous;
    private RBTNode<K, V> next;

    // Creates a new iterator, with previous set to null and next
    // set to the node containing the smallest key in the tree,
    // if the set being represented is nonempty - or to null,
    // if the set is empty.

    public RBTIterator() {

      this.previous = null;
      if (root.isNil()) {
        this.next = null;
      } else {
        this.next = root.min();
      }

    }

    // Reports whether there is a next element to be visited.

    public boolean hasNext() {

      return !(this.next == null);

    }

    // Reports whether there is a previous element to be visited.

    public boolean hasPrevious() {

      return !(this.previous == null);

    }

    // Returns the next element, updating this.previous and
    // this.next appropriately. Throws a NoSuchElementException
    // if there is no next element.

    public RBTNode<K, V> next() {

        if (!this.hasNext()) {
            return null;
        }
            
        else
            throw new NoSuchElementException();
    }

    // Returns the index of the next element to be visited,
    // returning the size of the set that is represented if
    // we are already at the end.

    public int nextIndex() {

      if (this.next == null) {

        return root.size();

      } else {

        K key = this.next.key();
        return root.indexOf(key);

      }

    }
    
  
    // Returns the previous element, updating this.previous
    // and this.next appropriately. Throws a NoSuchElementException
    // if there is no previous element.

    public RBTNode<K, V> previous() {

      // Details must be supplied!
      return null;

    }

    // Returns the index of the previous element to be visited,
    // returning -1 if we are already at the beginning.

    public int previousIndex() {

      if (this.previous == null) {

        return -1;

      } else {

        K key = this.previous.key();
        return root.indexOf(key);

      }

    }

    // Unsupported operations included in the ListIterator
    // interface.


    public void add(RBTNode<K, V> node) {

      throw new UnsupportedOperationException("add is not supported.");

    }

    public void set(RBTNode<K, V> node) {

      throw new UnsupportedOperationException("set is not supported.");

    }

    public void remove() {

      throw new UnsupportedOperationException("remove is not supported.");

    }

  }

  // Constructor of a Red-Black Tree storing an empty set or map

  RBT() {

    RBTNode<K, V> root = new RBTNode<K, V>();
    this.root = root;

  }

  // Constructor of a Red-Back Tree with a given node as root:
  // For use in testing of Red-Black Trees

  RBT(RBTNode<K, V> root) {

    this.root = root;

  }

  // Returns the root of this tree - useful for testing
 
  RBTNode<K, V> root() {
    return this.root;
  }

  // Inspector method to report the size of the set or map represented
  // by this Red-Black tree

  int size() {

    return this.root.size();

  }

  // Reports whether this set or map includes a node storing the
  // given key if the input key is not null. A NullPointerException
  // is thrown otherwise.

  boolean includes(K key) {

    RBTNode<K, V> node = this.root.search(key);
    return !node.isNil();

  }

  // Returns the number of keys included in this map that are
  // less than the given key, provided that the input key is
  // also stored in this map; -1 is returned otherwise, if the
  // input key is not null.
  //
  // A NullPointerException is thrown if the input key is null.
 
  int indexOf(K key) throws NullPointerException {

    return this.root.indexOf(key);

  }

  // Returns the value corresponding to a given key is in this map.
  // A NullPointerException is thrown if the input key is null; a
  // NotFoundException is thrown, instead, if the input key is null
  // but there is not key-value pair with the input key stored in
  // this map.

  V get(K key) throws NullPointerException {

    RBTNode<K, V> node = this.root.search(key);
    if (node.isNil()) {
      throw new NotFoundException("Key not found.");
    } else {
      return node.value();
    }

  }

  // Returns the key stored in this map that is less than the given
  // number of other keys used in this map.
  //
  // An IndexOutOfBoundsException is thrown if the given index is negative,
  // or greater than or equal to the size of this map.

  K get(int index) {

    if ((index < 0) || (index >= this.size())) {
      throw new IndexOutOfBoundsException("Index is out of range.");
    } else {
      return this.root.get(index);
    }

  }

  // Inserts a node with the given key and value into this
  // red black tree, if the key is not null and not already
  // included.
  //
  // A NullPointerException is thrown if the key is null;
  // a FoundException is thrown if the key is stored in the
  // tree already.

  void insert(K key, V  value) throws NullPointerException, 
                                      FoundException {
    this.root.insert(key, value);

  }

  // Updates the value for the given key with the given value,
  // if the input key is not null and already stored in this
  // tree. A NullPointerExcption is thrown if the input key
  // is null. A NotFoundException is thrown (and the tree
  // is not changed) if the key is not null but is also not
  // stored in the tree already.

  void change(K key, V value) throws NullPointerException {

    RBTNode<K, V> node = this.root.search(key);
    if (node.isNil()) {
      throw new NotFoundException("This key was not found.");
    } else {
      node.setValue(value);
    }

  }

  // Removes the node with the given key, if this key is
  // not null and stored in the tree. A NullPointerException
  // is thrown if the input key is null, and a NotFoundException
  // is thrown if this input key is null but not stored in
  // the tree.

  void delete(K key) throws NullPointerException, NotFoundException {

    this.root.delete(key);

  }

  // Returns a ListIterator for the set of nodes in this tree.
  // Nodes are visited by increasing order of keys.

  ListIterator<RBTNode<K, V>> iterator() {

    return new RBTIterator();

  }

}
