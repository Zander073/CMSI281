/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  BinaryTreeTraversal.java
* Purpose    :	Driver for traversing a binary tree structure. An in-order traversal in particular.
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-012-13
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BinaryTreeTraversal {

      public static void main( String[] args ) {
         BinaryTreeNode root = new BinaryTreeNode( 0 );
         root.add( 1, "L" );
         root.add( 2, "R" );
         BinaryTreeNode one = root.getChild( "L" );
         BinaryTreeNode two = root.getChild( "R" );
         one.add( 3, "L" );
         one.add( 4, "R" );
         two.add( 5, "L" );
         two.add( 6, "R" );
         BinaryTreeNode six = two.getChild( "R" );
         six.add( 7, "L" );
         six.add( 8, "R" );

         System.out.print("Pre-order traverse result: ");
         root.preOrderPrinter(root);
         System.out.println("\n" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

         System.out.print("In-order traverse result: ");
         root.inOrderPrinter(root);

      }

  }
