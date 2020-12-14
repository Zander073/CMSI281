/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  BinaryTreeNode.java
* Purpose    :	Class for creating binary tree structure. Also contains method for in-order traversal
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-012-13
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

   public int getData() {
       return data;
   }

   public void preOrderPrinter( BinaryTreeNode node ) {
       if( node == null ) {
          return;
       }
       System.out.print( "[" + node.data + "]" );
       preOrderPrinter( node.getChild( "L" ) );
       preOrderPrinter( node.getChild( "R" ) );
    }

   public void postOrderPrinter( BinaryTreeNode node) {
     if( node == null ) {
       return;
     }
     postOrderPrinter( node.getChild( "L" ));
     postOrderPrinter( node.getChild( "R" ));
     System.out.print( "[" + node.data + "]" );
   }

   public void inOrderPrinter( BinaryTreeNode node) {
     if( node == null ) {
       return;
     }
     inOrderPrinter( node.getChild( "L" ));
     System.out.print( "[" + node.data + "]" );
     inOrderPrinter( node.getChild( "R" ));
   }
}
