/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  FamilyTreeNode.java
* Purpose    :  Classwork09
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-10-29
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class FamilyTreeNode {

  private String name;
  private String relation;
  private FamilyTreeNode left;
  private FamilyTreeNode right;

  FamilyTreeNode ( String n, String r ) {
      name = n;
      relation = r;
      left = null;
      right = null;
  }

  public void add( String n, String r, String child ) {
     child = child.toUpperCase();
     if( child.equals( "L" ) ) {
        left = new FamilyTreeNode( n, r );
     } else if( child.equals( "R" ) ) {
        right = new FamilyTreeNode( n, r );
     } else {
        throw new IllegalArgumentException();
     }
  }

  public FamilyTreeNode getChild( String child ) {
     child = child.toUpperCase();
     if( child.equals("L") || child.equals("R") ) {
        return (child.equals("L") ? left : right);
     } else {
        throw new IllegalArgumentException();
     }
  }

  public String getName() {
      return name;
  }

  public String getRelation() {
      return relation;
  }
}
