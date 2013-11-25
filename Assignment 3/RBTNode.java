package cpsc331.assignment3;

import cpsc331.assignment3.Colour;
import cpsc331.assignment3.IllegalOperationException;
import cpsc331.assignment3.FoundException;
import cpsc331.assignment3.NotFoundException;

/*
 *
 * Provides a node in a red-black tree.
 *
 */

class RBTNode<K extends Comparable<K>, V> {

  // Data Fields

  private boolean isNil;          // True if and only if this is a NIL node
  private K key;                  // The key stored at this node
  private V value;                // The value stored at this node
  private RBTNode<K, V> left;     // The left child of this node
  private RBTNode<K, V> right;    // The right child of this node
  private RBTNode<K, V> parent;   // The parent of this node
  private int setSize;            // The size of the set represented by the
                                  // subtree with this node as root
  private Colour colour;          // The colour of this node
  private int blackHeight;        // The blackheight of this node


  // Constructor of a Nil Node

  RBTNode() {

    this.isNil = true;
    this.key = null;
    this.value = null;
    this.left = null;
    this.right = null;
    this.parent = null;
    this.setSize = 0;
    this.colour = Colour.BLACK;
    this.blackHeight = 0;

  }
  
  // Constructor of an Internal Node
 
  RBTNode(K key, V value, Colour colour) {

    this.isNil = false;

    if (key == null) {
      throw new NullPointerException("A key cannot be null");
    } else {
      this.key = key;
    };

    this.value = value;
    this.left = new RBTNode<K, V>();
    this.left.setParent(this);
    this.right = new RBTNode<K, V>();
    this.right.setParent(this);
    this.parent = null;
    this.setSize = 1;
    if ((colour == Colour.RED) || (colour == Colour.BLACK)) {
      this.colour = colour;
    } else {
      throw new IllegalOperationException("Colour of new node must be RED or BLACK");
    };
    this.blackHeight = 1;

  }

  // Inspector method to report whether this is a NIL node

  boolean isNil() {

    return this.isNil;

  }

  // Inspector method to report the key at this node

  K key() {

    return this.key;

  }

  // Inspector method to report the value at this node

  V value() {

    return this.value;

  }

  // Inspector method to report the left child of this node

  RBTNode<K, V> left() {

    return this.left;

  }

  // Inspector method to report the right child of this node

  RBTNode<K, V> right() {

    return this.right;

  }

  // Inspector method to report the parent of this node

  RBTNode<K, V> parent() {

    return this.parent;

  }

  // Inspector method to report the size of the set represented by
  // the subtree with this node as root
  
  int size() {

    return this.setSize;

  }

  // Inspector method to report the colour of this node

  Colour colour() {

    return this.colour;

  }

  // Inspector method to report the blackHeight of this node
  
  int blackHeight() {

    return this.blackHeight;

  }

  // Mutator method the change the key at this node

  void setKey(K key) {

    if (this.isNil) {
      throw new IllegalOperationException("Cannot set a value for a NIL node.");
    } else if (key == null) {
      throw new NullPointerException("Key for an internal node cannot be null.");
    } else {
      this.key = key;
    }

  }

  // Mutator method to change the value at this node

  void setValue(V value) {

    if (!this.isNil) {
      this.value = value;
    } else {
      throw new IllegalOperationException("Cannot set a value for a NIL node.");
    };

  }

  // Mutator method to update the left child of this node

  void setLeft(RBTNode<K, V> left) {

    if (!this.isNil) {
      this.left = left;
    } else {
      throw new IllegalOperationException("Cannot change the left child of a NIL node");
    };

  }

  // Mutator method to update the right child of this node

  void setRight(RBTNode<K, V> right) {

    if (!this.isNil) {
      this.right = right;
    } else {
      throw new IllegalOperationException("Cannot change the right child of a NIL node");
    };

  }

  // Mutator method to update the parent of this node

  void setParent(RBTNode<K, V> parent) {

    this.parent = parent;

  }

  // Mutator method to update the size of the set represented by the
  // subtree with this node as root
  
  void setSize(int size) {

    if (!this.isNil) {
      this.setSize = size;
    } else {
      throw new IllegalOperationException("Cannot change the size of the set represented by a NIL node");
    };

  }

  // Mutator method to change the colour of this node

  void setColour(Colour colour) {

    if (!this.isNil) {
      this.colour = colour;
    } else if ((colour == Colour.BLACK) || (colour == Colour.DOUBLEBLACK)) {
      this.colour = colour;
    } else {
      throw new IllegalOperationException("A NIL node must be BLACK or DOUBLEBLACK");
    };

  }

  // Mutator method to update the blackHeight of this node

  void setBlackHeight(int blackHeight) {

    if (!this.isNil) {
      this.blackHeight = blackHeight;
    } else {
      throw new IllegalOperationException("Cannot change the blackHeight of a NIL node");
    };

  }

  // NOTE: Method below this line are incomplete and must be filled in!

  // Searches for a node with the given key in the subtree with
  // this node as root.
  //
  // A NullPointerException is thrown if the input key is null.
  //
  // If the input key is not null and there is no node in the
  // subtree with this node as root storing this key, then the NIL
  //  node that would be replaced by a new node with this key, at
  //  the beginning of an insertion operation, should be returned
  //  instead.
  //
  //  If the input key is null then a NullPointerException
  //  should be thrown, with a message explaining that null cannot
  //  be used as a key in a Red-Black Tree.
  
  RBTNode<K, V> search(K key) {
      
      RBTNode<K, V> temp;
      
      if (key == null)
          throw new NullPointerException("null cannot be used as a key in a Red-Black Tree");
      
      else {
          if (key == this.key())
              return this;
          
          else if (this.isNil())
              return this;
          
          else if (key.compareTo(this.key()) < 0)
              temp = this.left().search(key());
    
          else
              temp = this.right().search(key()); 
      }
      return temp;
  }

  // Returns the number of keys included in this the subtree
  // with this node as root storing keys that are
  // less than the given key, provided that the input key is
  // also stored in this subtree; -1 is returned otherwise, if the
  // key is not null..
  //
  // A NullPointerException is thrown if the input key is null.
  
  int indexOf(K key) {

    if (key == null)
        throw new NullPointerException("Input key is null.");
    
    else {
        RBTNode<K, V> temp = this.search(key());
        if (key == temp.key())
            return temp.left().size();
        else
            return -1;
    }
  }

  // Returns the key that is is used in this map and this is greater
  // than the given number of other keys that are stored in
  // the subtree with this node as root.
  //
  // An IndexOutOfBoundsException is thrown if the input index is negative
  // or greater than or equal to the number of key-value pairs stored in the
  // subtree with this node as root.

  K get(int index) {

    if ((index < 0) || (index >= this.size())) {
      throw new IndexOutOfBoundsException("Index is out of range.");
    } else if (index < this.left().size()) {
      return this.left().get(index);
    } else if (index > this.left().size()) {
      return this.right().get(index - this.left().size() - 1);
    } else {
      return this.key();
    }
  }
 
  // Returns the root of the subtree obtained by performing a left rotation
  // at this node
  //
  // An IllegalOperationException should be thrown, with a useful error
  // message, if a left rotation at this node is not allowed.

  private RBTNode<K, V> leftRotate() {
      
      // Condition: Root must have a non-Nil right child 
      
      if (this.isNil() || this.right.isNil())
          throw new IllegalOperationException("Left Rotation at this node is not allowed.");
      else {
          RBTNode<K, V> temp;
          this.right().setParent(this.parent());
          temp = this.right().left();
          this.right().setLeft(this);
          
          if (this == this.parent().left())
              this.parent().setLeft(this.right());
          
          else if (this == this.parent().right())
              this.parent().setRight(this.right());
              
          this.setParent(this.right());
          this.setRight(temp);
          this.right().setParent(this);
          
          return this.parent();
      }
  }

  // Returns the root of the subtree obtained by performing a right rotation
  // at this node
  //
  // An IllegalOperationException should be thrown, with a useful error
  // message, if a right rotation at this node is not allowed.

  private RBTNode<K, V> rightRotate() {

      // Condition: Root must have a non-Nil left child 
      
      if (this.isNil() || this.left.isNil())
          throw new IllegalOperationException("Right Rotation at this node is not allowed.");
      
      else {
          RBTNode<K, V> temp;
          this.left().setParent(this.parent());
          temp = this.left().right();
          this.left().setRight(this);
          
          if (this == this.parent().left())
              this.parent().setLeft(this.left());
          
          else if (this == this.parent().right())
              this.parent().setRight(this.left());
              
          this.setParent(this.left());
          this.setLeft(temp);
          this.left().setParent(this);
          
          return this.parent();
      }
  }

  // Performs the beginning of an insertion operation for
  // a binary search tree - inserting a new RED node into the
  // the tree with the required value and correcting the sizes
  // of all other nodes that the roots of subtrees whose set
  // sizes have changed. Returns a reference to the new node
  // that has been inserted - throwing a FoundException and
  // leaving the tree unchanged if the key was in the tree
  // already
  //
  // It can be ASSUMED that the input key is not null.

  private RBTNode<K, V> regular_insert(K key, V value) throws FoundException {
      
      if (this.parent == null)
          return this;
      
      else if (this.parent().colour() == Colour.BLACK) {
          if (this.parent().key().compareTo(this.key()) > 0)
              this.parent().setLeft(this);
          
          else if (this.parent().key().compareTo(this.key()) < 0)
              this.parent().setRight(this);
          
      } else if ((this.parent().right() == this) && (this.parent().parent() != null)) {
          if (this.parent().parent().left() == this.parent()) {
              if (this.parent().parent().right().colour() == Colour.RED)
                  this.insert_case_1b(this.parent().parent());
                      
              else
                  this.insert_case_3(this.parent().parent());
                  
          } else {
              if (this.parent().parent().left().colour() == Colour.RED)
                  this.insert_case_4a(this.parent().parent());
              
              else
                  this.insert_case_5(this.parent().parent());
          }
          
      } else if ((this.parent().left() == this) && (this.parent().parent() != null)) {        
          if (this.parent().parent().left() == this.parent()) {      
              if (this.parent().parent().right().colour() == Colour.RED) {        
                  this.insert_case_1a(this.parent().parent());
                      
              } else
                  this.insert_case_2(this.parent().parent());
                      
          } else {
              if (this.parent().parent().left().colour() == Colour.RED)
                  this.insert_case_4b(this.parent().parent());
                      
              else
                  this.insert_case_6(this.parent().parent());
          }
      }
      return this;
  }

  // The next eight methods each implement needed for one of the
  // cases that might arise when a red node has a red parent
  // during an insertion.
  //
  // - The input is a reference to the GRANDPARENT of the red
  //   node that has a reference to a red parent.
  //
  // - The value returned should be the root of the subtree
  //   that replaces the subtree with the GRANDPARENT as root
  //   after the adjustment.
  //
  // In the description of cases that follows, z is the red
  // node that has a red parent.

  // Implements the adjustment for an insertion in case 1(a):
  // - z is a left child
  // - the parent of z is a left child
  // - the sibling of the parent of z is red

  private RBTNode<K, V> insert_case_1a(RBTNode<K, V> grandparent) {
      
      grandparent.left().setColour(Colour.BLACK); 
      grandparent.right().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);
      
      grandparent.setBlackHeight(grandparent.blackHeight() + 1);
      
      return grandparent;
    }

  // Implements the adjustment for an insertion in case 1(b):
  // - z is a right child
  // - the parent of z is a left child
  // - the sibling of the parent of z is red

  private RBTNode<K, V> insert_case_1b(RBTNode<K, V> grandparent) {
      
      grandparent.left().setColour(Colour.BLACK);
      grandparent.right().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);
      
      grandparent.setBlackHeight(grandparent.blackHeight() + 1);
      
      return grandparent;
    }

  // Implements the adjustment for an insertion in case 2:
  // - z is a left child
  // - the parent of z is a left child
  // - the sibling of the parent of z is black

  private RBTNode<K, V> insert_case_2(RBTNode<K, V> grandparent) {
      
      grandparent.rightRotate().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);

      grandparent.parent().setBlackHeight(grandparent.parent().blackHeight() + 1);
      grandparent.setSize(grandparent.left().size() + grandparent.right().size());
      grandparent.parent().setSize(grandparent.parent().left().size() + grandparent.parent().right().size());
      
      return grandparent.parent();
    }

  // Implements the adjustment for an insertion in case 3:
  // - z is a right child
  // - the parent of z is a left child
  // - the sibling of the parent of z is black

  private RBTNode<K, V> insert_case_3(RBTNode<K, V> grandparent) {
      
      grandparent.left().leftRotate();
      grandparent.rightRotate().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);
      
      grandparent.parent().setBlackHeight(grandparent.parent().blackHeight() + 1);
      grandparent.parent().left().setSize(grandparent.parent().left().left().size() + grandparent.parent().left().right().size());
      grandparent.setSize(grandparent.left().size() + grandparent.right().size());
      grandparent.parent().setSize(grandparent.parent().left().size() + grandparent.parent().right().size());
      
      return grandparent.parent();
    }

  // Implements the adjustment for an insertion in case 4(a):
  // - z is a right child
  // - the parent of z is a right child
  // - the sibling of the parent of z is red

  private RBTNode<K, V> insert_case_4a(RBTNode<K, V> grandparent) {
      
      grandparent.right().setColour(Colour.BLACK);
      grandparent.left().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);

      grandparent.setBlackHeight(grandparent.blackHeight() + 1);
      
      return grandparent;

  }
  // Implements the adjustment for an insertion in case 4(b):
  // - z is a left child
  // - the parent of z is a right child
  // - the sibling of the parent of z is red

  private RBTNode<K, V> insert_case_4b(RBTNode<K, V> grandparent) {
      
      grandparent.right().setColour(Colour.BLACK);
      grandparent.left().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);
      
      grandparent.setBlackHeight(grandparent.blackHeight() + 1);
      
      return grandparent;
  }
  // Implements the adjustment for an insertion in case 5:
  // - z is a right child
  // - the parent of z is a right child
  // - the sibling of the parent of z is black

  private RBTNode<K, V> insert_case_5(RBTNode<K, V> grandparent) {
      
      grandparent.leftRotate().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);
      
      grandparent.parent().setBlackHeight(grandparent.parent().blackHeight() + 1);
      grandparent.setSize(grandparent.left().size() + grandparent.right().size());
      grandparent.parent().setSize(grandparent.parent().left().size() + grandparent.parent().right().size());

      return grandparent.parent();
    }

  // Implements the adjustment for an insertion in case 6:
  // - z is a left child
  // - the parent of z is a right child
  // - the sibling of the parent of z is black

  private RBTNode<K, V> insert_case_6(RBTNode<K, V> grandparent) {

      grandparent.right().rightRotate();
      grandparent.leftRotate().setColour(Colour.BLACK);
      grandparent.setColour(Colour.RED);
      
      grandparent.parent().setBlackHeight(grandparent.parent().blackHeight() + 1);
      grandparent.parent().right().setSize(grandparent.parent().right().right().size() + grandparent.parent().right().left().size());
      grandparent.setSize(grandparent.right().size() + grandparent.left().size());
      grandparent.parent().setSize(grandparent.parent().right().size() + grandparent.parent().left().size());
      
      return grandparent.parent();
  }

  // Method for an insertion of a node with a given key and value.
  // This should throw a FoundException, leaving the tree, if the
  // given key is stored at a node in this tree already. It should
  // throw a NullPointerException, with a helpful error message,
  // if the input key is null.

  void insert(K key, V value) throws FoundException {
      
    if (key == null)
          throw new NullPointerException("Key cannot be null.");
    
    else {
          RBTNode<K, V> temp = this.search(key);
          RBTNode<K, V> newNode = new RBTNode<K, V>(key, value, Colour.RED);
          
          if (key == temp.key())
              throw new FoundException("Key already exists.");
          
          else if (temp.isNil()) {
              newNode.setParent(temp.parent());
              
              if (newNode.key().compareTo(temp.parent().key()) < 0)
                  temp.parent().setLeft(newNode);
              
              else
                  temp.parent().setRight(newNode);
              
              newNode.regular_insert(key, value);
          }
      }
  }

  // Implements the beginning of a deletion of a node - adjusting
  // the sizes of all nodes whose subtrees now represent sets
  // whose sizes have changed, and returning the node (called x
  // in later comments) that was promoted when a node was removed
  // from this tree. A NotFoundException should be thrown, and
  // the tree should be unchanged, if the input key was not stored
  // at any node in this tree before this method was called.
  //
  // It can be ASSUMED here that the input key is not null.

  private RBTNode<K, V> regular_delete(K key) throws NotFoundException {

    // Details of this method must be replaced!
    return null;

  }

  // The next ten methods each implement one of the adjustments
  // that might be required when the tree includes a double-black
  // node that is not at the root.
  //
  //  - The input is a reference to the PARENT of the double-black node.
  //
  //  - In the descriptions that follow, x is the double-black
  //    root that is not at the root.

  // Implements the adjustment needed in case 3(a):
  // - x is a left child
  // - sibling of x is black
  // - right child of the sibling of x is red
  // A reference to x (whose colour has changed) should be returned
  // as output.

  private RBTNode<K, V> delete_case_3a(RBTNode<K, V> x) {
    
      x.leftRotate();
      x.left().setColour(Colour.BLACK);
      x.setColour(Colour.BLACK);
      x.parent().right().setColour(Colour.BLACK);
 
      x.setBlackHeight(x.blackHeight() - 1);
      x.left().setBlackHeight(x.left().blackHeight() - 1);
      
      if (x.right().colour() == Colour.BLACK)
          x.parent().setBlackHeight(x.parent().blackHeight() + 1);
      // Increases by 1 if Right child of x has a BLACK node.
      
      else if(x.right().colour() == Colour.RED)
          x.parent().setBlackHeight(x.parent().blackHeight() + 2);
       // Increases by 2 if Right child of x has a RED node.
      
      return x;
  }

  // Implements the adjustment needed in case 3(b):
  // - x is a left child
  // - parent of x is red
  // - sibling of x is black
  // - both children of the siblings of x are black
  // A reference to the red-black node that results from this
  // change should be returned as output.

  private RBTNode<K, V> delete_case_3b(RBTNode<K, V> x) {
      
      x.setColour(Colour.REDBLACK);
      x.left().setColour(Colour.BLACK);
      x.right().setColour(Colour.RED);
      
      x.setBlackHeight(x.blackHeight() - 1);
      x.left().setBlackHeight(x.left().blackHeight() - 1);
      
      return x;
  }

  // Implements the adjustment needed in case 3(c):
  // - x is a left child
  // - sibling of x is black
  // - left child of sibling of x is red
  // - right child of sibling of x is red
  // A reference to the double-black node that results from
  // this change should be returned as output.

  private RBTNode<K, V> delete_case_3c(RBTNode<K, V> x) {

      x.parent().right().rightRotate();
      x.parent().right().setColour(Colour.BLACK);
      x.parent().right().right().setColour(Colour.RED);
      
      x.parent().right().setBlackHeight(x.parent().right().blackHeight + 1);
      
      return x;
  }

  // Implements the adjustment needed in case 3(d):
  // - x is a left child
  // - parent of x is black
  // - sibling of x is red
  // - both children of the sibling of x are black
  // A reference to the double-black node that results from
  // this change should be returned as output.

  private RBTNode<K, V> delete_case_3d(RBTNode<K, V> x) {

      x.parent().leftRotate();
      x.parent().setColour(Colour.RED);
      x.parent().parent().setColour(Colour.BLACK);
      
      x.parent().parent().setBlackHeight(x.parent().parent().blackHeight + 1);
      
      return x;
  }

  // Implements the adjustment needed in case 3(e):
  // - x is a left child
  // - parent of x is black
  // - sibling of x is black
  // - both children of the sibling of x are black
  // A reference to the double-black node that results from
  // this change should be returned as output.

  private RBTNode<K, V> delete_case_3e(RBTNode<K, V> x) {
      RBTNode<K, V> y = x.parent();
      y.left().setColour(Colour.BLACK);
      y.setColour(Colour.DOUBLEBLACK);
      y.right().setColour(Colour.RED);
      
      // No change in black heights
      
      return x.parent();
  }

  // Implements the adjustment needed in case 3(f):
  // - x is a right child
  // - sibling of x is black
  // - left child of the sibling of x is red
  // A reference to x (whose colour has changed) should be returned
  // as output.

  private RBTNode<K, V> delete_case_3f(RBTNode<K, V> x) {

      // Mirror of Subcase 3(a)
      x.rightRotate();
      x.right().setColour(Colour.BLACK);
      x.setColour(Colour.BLACK);
      x.parent().left().setColour(Colour.BLACK);
      
      x.setBlackHeight(x.blackHeight - 1);
      x.right().setBlackHeight(x.right().blackHeight - 1);
       
       
     if (x.left().colour() == Colour.BLACK){
      x.parent().setBlackHeight(x.parent().blackHeight + 1);
      } // Increases by 1 if Right child of x has a BLACK node.
       
     else if(x.left().colour() == Colour.RED){
      x.parent().setBlackHeight(x.parent().blackHeight + 2);
      } // Increases by 2 if Right child of x has a RED node.
      
      return x;
  }

  // Implements the adjustment needed in case 3(g):
  // - x is a right child
  // - parent of x is red
  // - sibling of x is black
  // - both children of the sibling of x are black
  // A reference to the red-black node that results from
  // this change should be returned as output.

  private RBTNode<K, V> delete_case_3g(RBTNode<K, V> x) {

      x.setColour(Colour.REDBLACK);
      x.right().setColour(Colour.BLACK);
      x.left().setColour(Colour.RED);
      x.setParent(x);
      
      x.setBlackHeight(x.blackHeight - 1);
      x.right().setBlackHeight(x.left().blackHeight - 1);
        
      return x;

  }

  // Implements the adjustment needed in case 3(h):
  // - x is a right child
  // - sibling of x is black
  // - left child of the sibling of x is black
  // - right child of the sibling of x is red
  // A reference to the double-black node that results from
  // this change should be returned as output.

  private RBTNode<K, V> delete_case_3h(RBTNode<K, V> x) {

      x.parent().left().leftRotate();
      x.parent().left().setColour(Colour.BLACK);
      x.parent().left().left().setColour(Colour.RED);
      
      x.parent().left().setBlackHeight(x.parent().left().blackHeight + 1);
      
      return x;
  }

  // Implements the adjustment needed in case 3(i):
  // - x is a right child
  // - parent of x is black
  // - sibling of x is red
  // - both children of the sibling of x are black
  // A reference to the double-black node that results from
  // this change should be returned as output.

  private RBTNode<K, V> delete_case_3i(RBTNode<K, V> x) {

      x.parent().rightRotate();
      x.parent().setColour(Colour.RED);
      x.parent().parent().setColour(Colour.BLACK);
      
      x.parent().parent().setBlackHeight(x.parent().parent().blackHeight + 1);
      
      return x;
  }

  // Implements the adjustment needed in case 3(j):
  // - x is a right child
  // - parent of x is black
  // - sibling of x is black
  // - both children of the sibling of x are black
  // A reference to the double-black node that results from
  // this change should be returned as output.

  private RBTNode<K, V> delete_case_3j(RBTNode<K, V> x) {

      x.right().setColour(Colour.BLACK);
      x.setColour(Colour.DOUBLEBLACK);
      x.left().setColour(Colour.RED);
      x.setParent(x);
      
      // No change in black heights
      
      return x;
  }

  // Method for the deletion of a node with a given key.
  // This should throw a NotFoundException, leaving the
  // tree unchanged, if there was no node storing the
  // given tree before the operation was performed.
  // A NullPointerException with helpful error message
  // should be thrown if the input key is null.

  void delete(K key) throws NotFoundException {

      if (key == null)
          throw new NullPointerException("Key cannot be null.");
    
    else {
          RBTNode<K, V> temp = this.search(key);
          RBTNode<K, V> NILNode = new RBTNode<K, V>();
          
          if (temp.isNil())
              throw new NotFoundException("Key not found.");
          
          else if (key == temp.key()) {
              if (key.compareTo(temp.parent().key()) < 0)
                  temp.parent().setLeft(NILNode);
              
              else
                  temp.parent().setRight(NILNode);
              temp.parent().regular_delete(key);
          }
      }
  }

  // Returns the node storing the smallest key in the
  // subtree with this node as root. An IllegalOperationException
  // should be thrown if this node NIL (so that its subtree
  // does not store any keys at all).
  //
  // Note: This method will be useful when supplying a ListIterator
  // for a red-black tree.

  RBTNode<K, V> min() {

      if (this.left() == null)
          return this;
      else
          return this.left().min();
  }

  // Returns the node storing the largest key in the
  // subtree with this node as root. An IllegalOperationException
  // should be thrown if this node is NIL (so that its subtree
  // does not store any keys at all).
  //
  // Note: This method will be useful when supplying a ListIterator
  // for a red-black tree.
 
  RBTNode<K, V> max() {

      if (this.right() == null)
          return this;
      else
          return this.right().max();
  }

  // Returns the node storing the smallest key in the red-black
  // tree including this node, that is not a node in the subtree
  // with this node as root. Returns null if there is no such
  // key (or node).
  //
  // Note: This method will be useful when supplying a ListIterator
  // for a red-black tree.

  RBTNode<K, V> nextAbove() {

      if (this.parent() == null)
          return null;
      
      else if (this.key().compareTo(this.parent().key()) < 0)
          return this.parent();
      
      else
          return this.parent().nextAbove();
  }

  // Returns the node storing the largest key in the red-black
  // tree including this node, that is not a node in the subtree
  // with this node as root. Returns null if there is no such
  // key (or node).
  //
  // Note: This method will be useful when supplying a ListIterator
  // for a red-black tree.
  
  RBTNode<K, V> previousAbove() {

      if (this.parent() == null)
          return null;
      
      else if (this.key().compareTo(this.parent().key()) > 0)
          return this.parent();
      
      else
          return this.parent().previousAbove();
  }
  
}
