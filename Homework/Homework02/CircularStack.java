/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  CircularStack.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-010-20
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class CircularStack {

   private Node top;
   private Node current;
   private Node bottom;
   private int  size;

   public CircularStack() {
      top = null;
      current = null;
      size = 0;
   }

   public void push( int dataToAdd ) {
      Node pushNode = new Node( dataToAdd); // make new Node
      if( top == null ) {  // if there is no top, new Node becomes top and current and bottom
        top = pushNode;
        current = pushNode;
        bottom = pushNode;
      } else {
        pushNode.next = top;  // place new Node before top and point next to top
        if( top.next == null ) {  // if there is only 1 existing Node, that points to new Node
          top.next = pushNode;
        }
        top = pushNode;  // make new Node the top Node
        current = pushNode;  // make new Node the current Node
      }
      size++;  // increase size
   }

   public int pop() {
     int poppedInt = current.data;  // store data to be popped
     top = top.next;  // make the Node after top the new top Node
     current = top;  // make new top Node the current Node
     bottom.next = top;  // point bottom Node to new top
     size--;  // decrease size
     return poppedInt;  // return popped Node data
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
     Node currentNode = current;  // save current Node
     current = top;  // move current to top of stack
     for( int i = 0; i < size; i++ ) {
       System.out.println( "[" + current.data + "] " ); // print from the top Node
       step();  // move to next Node
     }
     current = currentNode;  // return current to original place
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
     CircularStack myStack = new CircularStack();

     myStack.push( 59 );
     myStack.push( 57 );
     myStack.push( 53 );
     myStack.push( 51 );
     myStack.push( 47 );

     System.out.println( "\nPushing 5 items into Circular Stack: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );

     myStack.push( 43 );
     myStack.push( 41 );
     myStack.push( 37 );
     myStack.push( 31 );
     myStack.push( 29 );

     System.out.println( "\nPushing 5 items into Circular Stack: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );


     myStack.push( 23 );
     myStack.push( 19 );
     myStack.push( 17 );
     myStack.push( 13 );
     myStack.push( 11 );

     System.out.println( "\nPushing 5 items into Circular Stack: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );

     myStack.push(  7 );
     myStack.push(  5 );
     myStack.push(  3 );
     myStack.push(  2 );

     System.out.println( "\nPushing 4 items into Circular Stack: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );


     System.out.println( "\nPopping off 1 item from Circular Stack: " );
     System.out.println( "Popped " + myStack.pop() );
     System.out.println( "After the popping: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );

     System.out.println( "\nPopping off 5 items from Circular Stack: " );
     for( int i = 0; i < 5; i++ ) {
       System.out.println( "Popped " + myStack.pop() );
     }
     System.out.println( "After the popping: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );

     System.out.println( "\nPopping off 3 items from Circular Stack: " );
     for( int i = 0; i < 3; i++ ) {
       System.out.println( "Popped " + myStack.pop() );
     }
     System.out.println( "After the popping: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );

     System.out.println( "\nPopping off 5 items from Circular Stack: " );
     for( int i = 0; i < 5; i++ ) {
       System.out.println( "Popped " + myStack.pop() );
     }
     System.out.println( "After the popping: " );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " / Size of Stack is: " + myStack.getSize() );

     System.out.println( "\nMoving Current Node downstream: " );
     myStack.step();
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() );

     System.out.println( "\nMoving Current Node downstream: " );
     myStack.step();
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() );

     System.out.println( "\nMoving Current Node downstream: " );
     myStack.step();
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() );

     System.out.println( "\nMoving Current Node downstream: " );
     myStack.step();
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " (Bottom of Stack) " );

     System.out.println( "\nMoving Current Node downstream: " );
     myStack.step();
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() + " (Top of Stack) " );

     myStack.search( 53 );
     myStack.search( 88 );

     System.out.println( "Pushing item of value 88 into Circular Stack: " );
     myStack.push( 88 );
     myStack.display();
     System.out.println( "Current Node is: " + myStack.getCurrentData() );

     System.out.println("");
     myStack.search( 88 );
   }
}
