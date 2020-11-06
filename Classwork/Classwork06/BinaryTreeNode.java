/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  BinaryTreeNode.java
* Purpose    :  Classwork09
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-11-01
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BinaryTreeNode {

  private int data;
  private BinaryTreeNode left;
  private BinaryTreeNode right;

  BinaryTreeNode ( int d ) {
      data = d;
      left = null;
      right = null;
  }

  public void add( int s, String child ) {
     child = child.toUpperCase();
     if( child.equals( "L" ) ) {
        left = new BinaryTreeNode( s );
     } else if( child.equals( "R" ) ) {
        right = new BinaryTreeNode( s );
     } else {
        throw new IllegalArgumentException();
     }
  }

  public BinaryTreeNode getChild( String child ) {
     child = child.toUpperCase();
     if( child.equals("L") || child.equals("R") ) {
        return (child.equals("L") ? left : right);
     } else {
        throw new IllegalArgumentException();
     }
  }

  public int getValue() {
      return data;
  }
}
