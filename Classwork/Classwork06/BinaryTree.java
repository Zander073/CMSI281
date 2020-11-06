/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  BinaryTree.java
* Purpose    :  Classwork09
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-10-29
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BinaryTree {

  public static void printUsage () {
    System.out.println( "\nPlease input: java BinaryTree <data> <data> <data>...\nwhere <data> is a valid number. Please input a total of 19 numbers.\n" );
    System.exit(0);
  }

  public static void preOrderPrinter( BinaryTreeNode node ) {
    if( node == null ) {
       return;
    }
    System.out.print( "[" + node.getValue() + "]" );
    preOrderPrinter( node.getChild( "L" ) );
    preOrderPrinter( node.getChild( "R" ) );
 }

 public static void postOrderPrinter( BinaryTreeNode node ) {
    if( node == null ) {
       return;
    }
    postOrderPrinter( node.getChild( "L" ) );
    postOrderPrinter( node.getChild( "R" ) );
    System.out.print( "[" + node.getValue() + "]");
 }

 public static void inOrderPrinter( BinaryTreeNode node ) {
    if( node == null ) {
       return;
    }
    inOrderPrinter( node.getChild( "L" ) );
    System.out.print( "[" + node.getValue() + "]" );
    inOrderPrinter( node.getChild( "R" ) );
 }

  public static void main( String[] args ) {

    int[] dataValues = new int[19];

    try {
      for( int i = 0; i < args.length; i++ ) {
       dataValues[i] = Integer.parseInt(args[i]);
      }
      if( args.length < 19 ) {
        throw new IllegalArgumentException( "Not enough values" );
      }
    } catch ( NumberFormatException nfe ) {
      printUsage();
    } catch( ArrayIndexOutOfBoundsException aioobe ) {
      printUsage();
    } catch( IllegalArgumentException iae ) {
      printUsage();
    }

     BinaryTreeNode root = new BinaryTreeNode( dataValues[0] );

     root.add( dataValues[1], "L" );
     root.add( dataValues[2], "R" );
     BinaryTreeNode one = root.getChild( "L" );
     BinaryTreeNode two = root.getChild( "R" );
     one.add( dataValues[3], "L" );
     one.add( dataValues[4], "R" );
     two.add( dataValues[5], "L" );
     two.add( dataValues[6],"R" );
     BinaryTreeNode three = one.getChild( "L" );
     BinaryTreeNode four = one.getChild( "R" );
     BinaryTreeNode five = two.getChild( "L" );
     BinaryTreeNode six = two.getChild( "R" );
     three.add( dataValues[7], "L" );
     three.add( dataValues[8], "R");
     four.add( dataValues[9], "L" );
     four.add( dataValues[10], "R");
     five.add( dataValues[11], "L" );
     five.add( dataValues[12], "R");
     six.add( dataValues[13], "L" );
     six.add( dataValues[14], "R");
     BinaryTreeNode seven = three.getChild( "R" );
     BinaryTreeNode thirteen = six.getChild( "R" );
     seven.add( dataValues[15], "L");
     seven.add( dataValues[16], "R");
     thirteen.add( dataValues[17], "L");
     thirteen.add( dataValues[18], "R");


     System.out.println( "\n\nPre-Order Print: " );
     preOrderPrinter( root );
     System.out.println( "\n\nIn-Order Print: " );
     inOrderPrinter( root );
     System.out.println( "\n\nPost-Order Print: " );
     postOrderPrinter( root );
     System.out.println("\n");

  }
}
