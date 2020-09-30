/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  IntLinkedListTester.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-09-24
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class IntLinkedListTester {

   public static void main( String[] args ) {
      IntLinkedList myList = new IntLinkedList();
      myList.prepend( 23 );
      myList.prepend( 19 );
      myList.prepend( 17 );
      myList.prepend( 13 );
      myList.prepend( 11 );
      myList.prepend(  7 );
      myList.prepend(  5 );
      myList.prepend(  3 );
      myList.prepend(  2 );

      IntLinkedList.Iterator myIt = myList.getIteratorAt( 0 );


      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 2
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 3
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 5
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
      myIt = myList.getIteratorAt( 3 );
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 11
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 13
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 17
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 19
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 23
      System.out.println( "" );

      // Insert value 100 at index 2
      myList.insertAt(2, 100);

      // Reset iterator to start of list
      myIt = myList.getIteratorAt( 0 );

      // Prints out list with new value of 100 inserted at index 2
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 2
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 3
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 100
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 5
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 11
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 13
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 17
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 19
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 23
      System.out.println( "" );

      // Remove value at index 2 (100)
      myList.removeAt(2);

      // Reset iterator to start of list
      myIt = myList.getIteratorAt( 0 );
      
      // Prints out list with value of 100 removed
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 2
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 3
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 5
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 7
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 11
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 13
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 17
      myIt. next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 19
      myIt.next();
      System.out.println( "Current Node is: " + myIt.getCurrentInt() );    // 23

   }
}
