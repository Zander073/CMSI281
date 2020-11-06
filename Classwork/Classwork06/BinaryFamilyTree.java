/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  BinaryFamilyTree.java
* Purpose    :  Classwork09
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-10-29
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BinaryFamilyTree {

  public static void preOrderPrinter( FamilyTreeNode node ) {
    if( node == null ) {
       return;
     }
    String printName = node.getName();
    for( int i = 0; i < 12 - node.getName().length(); i++ ) {
      printName = printName + " ";
    }
    System.out.println( "  " + printName + node.getRelation() );
    preOrderPrinter( node.getChild( "L" ) );
    preOrderPrinter( node.getChild( "R" ) );
  }

 public static void postOrderPrinter( FamilyTreeNode node ) {
    if( node == null ) {
       return;
    }
    String printName = node.getName();
    for( int i = 0; i < 12 - node.getName().length(); i++ ) {
      printName = printName + " ";
    }
    postOrderPrinter( node.getChild( "L" ) );
    postOrderPrinter( node.getChild( "R" ) );
    System.out.println( "  " + printName + node.getRelation() );
 }

 public static void inOrderPrinter( FamilyTreeNode node ) {
    if( node == null ) {
       return;
    }
    String printName = node.getName();
    for( int i = 0; i < 12 - node.getName().length(); i++ ) {
      printName = printName + " ";
    }
    inOrderPrinter( node.getChild( "L" ) );
    System.out.println( "  " + printName + node.getRelation() );
    inOrderPrinter( node.getChild( "R" ) );
 }

  public static void main( String[] args ) {
     
     FamilyTreeNode root = new FamilyTreeNode( "Nekko", "Root" );
     root.add( "Chiyo", "Paternal Grandma", "L" );
     root.add( "Matsuko", "Maternal Grandma", "R" );
     FamilyTreeNode grandma = root.getChild( "L" );
     FamilyTreeNode obaachan = root.getChild( "R" );
     grandma.add( "Paul", "American Uncle", "L" );
     grandma.add( "David", "American Uncle", "R" );
     obaachan.add( "Makiko", "Mom", "L" );
     obaachan.add( "Satoru", "Japanese Uncle","R" );
     FamilyTreeNode paul = grandma.getChild( "L" );
     FamilyTreeNode david = grandma.getChild( "R" );
     FamilyTreeNode makiko = obaachan.getChild( "L" );
     FamilyTreeNode satoru = obaachan.getChild( "R" );
     paul.add( "Trent", "Cousin", "L" );
     paul.add( "Kyle", "Cousin", "R");
     david.add( "JJ", "Cousin", "L" );
     david.add( "Brent", "Cousin", "R");
     makiko.add( "Teresa", "Self", "L" );
     makiko.add( "Christina", "Sister", "R");
     satoru.add( "Meriya", "Cousin", "L" );
     satoru.add( "Seiya", "Cousin", "R");
     FamilyTreeNode kyle = paul.getChild( "R" );
     FamilyTreeNode seiya = satoru.getChild( "R" );
     kyle.add( "Kyle Jr.", "First Cousin Once Removed", "L" );
     kyle.add( "Amada Jr.", "First Cousin Once Removed", "R" );
     seiya.add( "Ryusei", "First Cousin Once Removed", "L" );
     seiya.add( "Aira", "First Cousin Once Removed", "R" );


     // Visual family tree representation
     System.out.println( "\n\n                  ________________" + root.getName() + "________________" );
     System.out.println( "                 /                                     \\"  );
     System.out.println( "            ___" + grandma.getName() + "___                            ___" + obaachan.getName() + "___" );
     System.out.println( "           /           \\                          /             \\"  );
     System.out.println( "      _" + paul.getName() + "_           _" + david.getName() + "_             _" + makiko.getName() + "_             _" + satoru.getName() + "_" );
     System.out.println( "     /      \\         /       \\           /        \\           /        \\"  );
     System.out.println( "  " + paul.getChild( "L" ).getName() + "    " + kyle.getName() + "     " + david.getChild( "L" ).getName() + "       " + david.getChild( "R" ).getName() + "     " + makiko.getChild( "L" ).getName() + "   " + makiko.getChild( "R" ).getName() + "   " + seiya.getName() + "     " + satoru.getChild( "L" ).getName() );
     System.out.println( "          /    \\                                           /     \\"  );
     System.out.println( "  " + kyle.getChild( "L" ).getName() + "      " + kyle.getChild( "R" ).getName() + "                            " + seiya.getChild( "L" ).getName() + "       " + seiya.getChild( "R" ).getName() );


     // Printing name and relation of each node in different orders
     System.out.println( "\n\n  Pre-Order Print: " );
     System.out.println( "\n  Name        Relation\n  -----------------------------------------" );
     preOrderPrinter( root );
     System.out.println( "\n\n  In-Order Print: " );
     System.out.println( "\n  Name        Relation\n  -----------------------------------------" );
     inOrderPrinter( root );
     System.out.println( "\n\n  Post-Order Print: " );
     System.out.println( "\n  Name        Relation\n  -----------------------------------------" );
     postOrderPrinter( root );
     System.out.println( "\n" );

  }
}
