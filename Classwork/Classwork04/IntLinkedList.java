/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  IntLinkedList.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-09-24
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class IntLinkedList {

   private Node head;
   private int  size;

  // the constructor
   public IntLinkedList() {
      head = null;
      size = 0;
   }

   public int getSize() {
      return size;
   }

   public void prepend( int dataToAdd ) {
      Node currentHead = head;
      head = new Node( dataToAdd );
      head.next = currentHead;
      size++;
   }

   public void insertAt( int index, int value ) {
      // Set variable for Node before insertion
      Node preNode = getIteratorAt(index-1).currentNode;
      Node newNode = new Node( value );  // Create Node to insert
      newNode.next = preNode.next; // Point new Node to next Node
      preNode.next = newNode; // Point preNode to Node
      size++;
   }

   public void removeAt( int index ) {
     getIteratorAt(index-1).currentNode.next = getIteratorAt(index+1).currentNode;
     size--;

   }

   private class Node {

      int data;            // remember this is an IntLinkedList
      Node next;           // here's the self-referential part

      // constructor
      Node( int d ) {
         data = d;
         next = null;
      }
   }

   public Iterator getIteratorAt( int index ) {
      if( (index > size) || (index < 0) ) {
         throw new IllegalArgumentException();
      }
      Iterator it = new Iterator();
      while( index > 0 ) {
         it.next();
         index--;
      }
      return it;
   }

   public class Iterator {
      private Node currentNode;

      Iterator() {
         currentNode = head;
      }

      public void next() {
         if( currentNode == null ) {
            return;
         } else {
            currentNode = currentNode.next;
         }
      }

      public boolean hasNext() {
         return ((currentNode != null) && (currentNode.next != null));
      }

      public int getCurrentInt() {
         return currentNode.data;
      }

   }
}
