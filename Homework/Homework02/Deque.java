/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  Deque.java
* Purpose    :  Homework02
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-10-12
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

class Deque {
  private int maxSize;
  private long[] deqArray;
  private int front;
  private int rear;
  private int nItems;

  public Deque( int s ) {
    maxSize = s;
    deqArray = new long[maxSize];
    front = 0;
    rear = -1;
    nItems = 0;
  }

  //--------------------------------------------------------------

  public void insertLeft( long j ) {               // put item at rear of deque
    if( isFull() ) {
      System.out.println( "\nThe Deque is full. Please remove some items. \n" );
    } else {
      if( rear == maxSize - 1 ) {
        rear = -1;                               // deal with wraparound
       }
      deqArray[++rear] = j;                      // increment rear and insert
      nItems++;                                  // one more item
      }
  }

  public void insertRight( long j ) {               // put item at front of deque
    if( isFull() ) {
      System.out.println( "\nThe Deque is full. Please remove some items. \n" );
    } else {
      if( front == 0 ) {
        front = maxSize - 1;           // deal with wraparound
        deqArray[front] = j;
      } else {
        deqArray[front-1] = j;          // insert new item before front
        front--;
      }
      nItems++;                                  // increase items
    }
  }

  //--------------------------------------------------------------

  public long removeLeft() {                  // take item from front of deque
    long temp = deqArray[front++];             // get value and increment front
    if( front == maxSize ) {
      front = 0;                               // deal with wraparound
    }
    nItems--;                                  // increase items
    return temp;
  }

  //--------------------------------------------------------------

  public long removeRight() {
    long temp = deqArray[rear--];             // take item from rear of deque
    if( rear == 0 ) {
      rear = maxSize - 1;                     // deal with wraparound
    }
    nItems--;                                 // decrease items
    return temp;
  }

  //--------------------------------------------------------------

  public long peekFront() {                  // peek at front of deque
   return deqArray[front];
  }

  //--------------------------------------------------------------


  public boolean isEmpty() {                 // true if deque is empty
   return ( nItems == 0 );
  }

  //--------------------------------------------------------------

  public boolean isFull()  {                 // true if deque is full
   return ( nItems == maxSize );
  }

  //--------------------------------------------------------------

  public int size() {                         // number of items in deque
   return nItems;
  }
  public void display() {
    System.out.println( "Front: " + front + " Rear: " + rear + "\n" );

   if( rear > front || rear == front) {      // check if rear is behind front
      for( int i = front; i <= rear; i++ ) {
        System.out.print( "| " + deqArray[i] );      // print items from front to rear (no wrap around)
        System.out.print( " |" );
      }
      for( int i = 0; i < maxSize - nItems; i++ ) {
        System.out.print( "| - |" );      // print empty boxes
      }
    }

    else if( rear < front ) {      // check if rear is before front
      if( nItems > 0 ) {
        for( int i = front; i < maxSize; i++ ) {
          System.out.print( "| " + deqArray[i] );      // print items from front to end of array
          System.out.print( " |" );

        }
        for( int i = 0; i < rear + 1; i++ ) {
          System.out.print( "| " + deqArray[i] );      //print beginning of array to rear
          System.out.print( " |" );
        }
      }
      for( int i = 0; i < maxSize - nItems; i++ ) {
          System.out.print("| - |");     // print empty boxes
        }
    }
    System.out.println("\n");
  }

  public void emptyDeque() {
    System.out.println( "Removing " + nItems + " items: " );
    deqArray = null;
    nItems = 0;
  }

  //--------------------------------------------------------------

  public static void main( String[] args ) {
    Deque d = new Deque( 10 );
    System.out.println( "\nEmpty Deque initialized with 10 slots: " );
    d.display();

    d.insertLeft( 2 );

    System.out.println( "1 item added from the left" );
    d.display();

    d.insertLeft( 3 );
    d.insertLeft( 5 );
    d.insertLeft( 7 );

    System.out.println( "3 items added from the left: " );
    d.display();

    d.insertRight( 11 );
    d.insertRight( 13 );
    d.insertRight( 17 );
    d.insertRight( 19 );


    System.out.println( "4 items added from the right: " );
    d.display();

    d.removeRight();
    d.removeRight();

    System.out.println( "2 items removed from the right: " );
    d.display();

    d.insertLeft( 23 );
    d.insertLeft( 29 );

    System.out.println( "2 items added from the left: " );
    d.display();

    d.removeLeft();
    d.removeLeft();

    System.out.println( "2 items removed from the left: " );
    d.display();

    d.insertLeft( 31 );
    d.insertLeft( 37 );

    System.out.println( "2 items added from the left: " );
    d.display();

    d.insertRight( 41 );
    d.insertRight( 43 );

    System.out.println( "2 items added from the right: " );
    d.display();

    System.out.println( "Attempting to add an item from the left: " );
    d.insertLeft( 116 );

    System.out.println( "Attempting to add an item from the right: " );
    d.insertRight( 200 );

    d.emptyDeque();
    d.display();
  }

}
