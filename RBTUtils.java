package cpsc331.assignment3;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ListIterator;
import cpsc331.assignment3.Colour;
import cpsc331.assignment3.FoundException;
import cpsc331.assignment3.NotFoundException;
import java.util.NoSuchElementException;
import cpsc331.assignment3.RBTNode;
import cpsc331.assignment3.RBT;

class RBTUtils<K extends Comparable<K>, V> {

  RBTUtils() {
  };

  // Checks whether a subtree with a given node as root has
  // the shape of a red-black tree - that is, NIL and non-NIL
  // nodes are correctly used

  boolean RBTSubtreeShape (RBTNode<K, V> x) {

    if (x.isNil()) {

      return ((x.left() == null) && (x.right() == null));

    } else {

      if ((x.left() == null) || (x.right() == null)) {

        return false;

      } else if ((x.left().parent() == x) && (x.right().parent() == x)) {

        return (RBTSubtreeShape(x.left()) && RBTSubtreeShape(x.right()));

      } else {

        return false;

      }

    }

  }

 // Checks whether a tree has the shape of a red-black tree ---
 // that is, the root passes the above test and has a null parent
 
  boolean RBTShape (RBT<K, V> T) {

    if (T.root().parent() == null ) {

      return RBTSubtreeShape(T.root());

    } else {

      return false;

    }

  }

 // Checks whether a subtree with a given node as root has null keys
 // at NIL nodes, non-null keys at non-NIL nodes, and with keys
 // organized in the usual "binary search tree order."
 //
 // Note: This should only be called if RBTShape(x) is true
 
  boolean RBTKeyOrder (RBTNode<K, V> x) {

    if (x.isNil()) {

      return (x.key() == null);

    } else if (x.key() != null ) {

      if (RBTKeyOrder(x.left()) && RBTKeyOrder(x.right())) {

        if (x.left().isNil()) {

          if (x.right().isNil()) {

            return true;

          } else {

            return (x.key().compareTo(x.right().key()) < 0);

          }

        } else {

          if (x.right().isNil()) {

            return (x.key().compareTo(x.left().key()) > 0);

          } else {

            return ((x.key().compareTo(x.left().key()) > 0)
                  && (x.key().compareTo(x.right().key()) < 0));

          }

        }

      } else {

        return false;

      }

    } else {

      return false;

    }

  }

  // Checks whether a subtree with a given node as root satisfies
  // the "colour" requirements for a subtree of a red-black tree
  //
  // Note: This should only be called if RBTShape(x) is true.

  boolean RBTSubtreeColours(RBTNode<K, V> x) {

    if (x.isNil()) {

      return (x.colour() == Colour.BLACK);

    } else if ((x.colour() == Colour.BLACK)
         || ((x.colour() == Colour.RED)
              && (x.left().colour() == Colour.BLACK)
              && (x.right().colour() == Colour.BLACK))) {

      return (RBTSubtreeColours(x.left())
                && RBTSubtreeColours(x.right()));

    } else {

      return false;

    }

  }

  // Checks whether a given tree satisfies the red-black tree
  // colour properties
  //
  // Note: This should only be called if RBTShape(x) is true
 
  boolean RBTColours(RBT<K, V> T) {

    if (T.root().colour() == Colour.BLACK) {
      return RBTSubtreeColours(T.root());
    } else {
      return false;
    }

  }

  // Checks whether the sizes of all nodes in the subtree with
  // a given node as root are correctly defined

  boolean RBTSizes(RBTNode<K, V> x) {

    if (x.isNil()) {

      return (x.size() == 0);

    } else if (x.size() == x.left().size() + x.right().size() + 1) {

      return (RBTSizes(x.left()) && RBTSizes(x.right()));

    } else {

      return false;

    }

  }

  // Checks whether the blackheights of all nodes in the subtree
  // with a given node as root are correctly defined (so that they
  // are also *well-defined*)
  //
  // Note: This should only be called in RBTShape(x) is true

  boolean RBTBlackHeights(RBTNode<K, V> x) {

    if (x.isNil()) {

      return (x.blackHeight() == 0);

    } else {

      if (((x.left().colour() == Colour.BLACK)
            && (x.blackHeight() == x.left().blackHeight() + 1))
          || ((x.left().colour() == Colour.RED)
            && (x.blackHeight() == x.left().blackHeight()))) {

        if (((x.right().colour() == Colour.BLACK)
              && (x.blackHeight() == x.right().blackHeight() + 1))
            || ((x.right().colour() == Colour.RED)
              && (x.blackHeight() == x.right().blackHeight()))) {

          return (RBTBlackHeights(x.left()) && RBTBlackHeights(x.right()));

        } else {

          return false;

        }

      } else {

        return false;

      }

    }

  }

}
