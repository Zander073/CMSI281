/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  CircularList.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-010-17
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class CircularList {

   private Node head;
   private Node current;
   private int  size;

   public CircularList() {
      head = null;
      current = null;
      size = 0;
   }

   public void insert( int dataToAdd ) {
      Node insertNode = new Node( dataToAdd); // make new Node
      if( head == null ) {  // if there is no head, new Node becomes head and current
        head = insertNode;
        current = head;
      } else {
        if( current.next == null ) {  // if there is no next Node, new Node points to head
          insertNode.next = head;
        } else {
          insertNode.next = current.next; // else point new Node to existing next Node
        }
        current.next = insertNode; // point current node to new Node
        current = insertNode;  // make new Node the new current node
        }
      size++;  // increase size
   }

   public int remove() {
     int removedInt = current.data;  // store data to be removed

     if( current == head ) { // if removing the head, make next Node new head
       head = current.next;
     }
      Node nextNode = current.next;  // temporarily hold next Node
      for( int i = 0; i < size - 1; i++ ) {  // loop around list to arrive at previous Node
       step();
     }
     current.next = nextNode; // point previous Node to next Node
     current = nextNode;  // make next Node the new current Node once old current Node removed
     size--;  // decrease size

     return removedInt;  // return removed Node data
   }

   public int getSize() {
     return size;
   }

   public void step() {
     if( current == null ) {
        return;
     } else {
        current = current.next; // move current to the next Node
     }
   }

   public int getCurrentData() {
      return current.data;
   }

   public void display() {
     for( int i = 0; i < size; i++ ) {
       System.out.print( "[" + current.data + "] " ); // print current Node
       step();  // move to next Node
     }
     System.out.println("");
   }

   public boolean search( int valueToSearch ) {
     System.out.print( "\nSearching for Value " + valueToSearch + " -------- " );
     for( int i = 0; i < size; i++ ) {
       if( current.data == valueToSearch ) { // print message if matching value found
         System.out.println( "Value " + valueToSearch + " has been found!\n" );
         return true;
       } else {
         step();  // move downstream if matching value not found
       }
     }
     System.out.println( "Value " + valueToSearch + " has NOT been found.\n" );  // print message if matching value not found
     return false;
   }

   private class Node {

      int data;
      Node next;

      Node( int d ) {
         data = d;
         next = null;
      }
   }

   public static void main( String[] arg ) {
     CircularList myList = new CircularList();
     myList.insert( 23 );
     myList.insert( 19 );
     myList.insert( 17 );
     myList.insert( 13 );
     myList.insert( 11 );

     System.out.println("");
     System.out.println( "Inserting 5 values into Circular List: " );
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     myList.insert(  7 );
     myList.insert(  5 );
     myList.insert(  3 );
     myList.insert(  2 );

     System.out.println("");
     System.out.println( "Inserting 4 more values into Circular List: " );
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     System.out.println("");
     System.out.println( "Moving Current Node downstream: " );
     myList.step();
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     System.out.println("");
     System.out.println( "Moving Current Node downstream: " );
     myList.step();
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     System.out.println("");
     System.out.println( "Moving Current Node downstream: " );
     myList.step();
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     System.out.println("");
     System.out.println( "Removing Current Node of Value " + myList.current.data + ":" );
     myList.remove();
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     System.out.println("");
     System.out.println( "Moving Current Node downstream: " );
     myList.step();
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     System.out.println("");
     System.out.println( "Removing Current Node of Value " + myList.getCurrentData() + ":" );
     myList.remove();
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     myList.search( 19 );
     myList.search( 88 );

     System.out.println( "Inserting Value of 88 into Circular List: " );
     myList.insert( 88 );
     myList.display();
     System.out.println( "Current Node is: " + myList.getCurrentData() );

     System.out.println("");
     myList.search( 88 );
   }
}
