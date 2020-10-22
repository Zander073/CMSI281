/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  Queue.java
* Purpose    :  Homework02
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-10-10
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

class Queue {
  private int maxSize;
  private long[] queArray;
  private int front;
  private int rear;
  private int nItems;

  public Queue( int s ) {
    maxSize = s;
    queArray = new long[maxSize];
    front = 0;
    rear = -1;
    nItems = 0;
  }

  public void insert( long j ) {               // put item at rear of queue
    if( isFull()) {                            // print message if queue is full
      System.out.println( "The Queue is full. Please remove some items\n" );
    } else {
      if( rear == maxSize - 1 ) {
        rear = -1;                               // deal with wraparound
      }
      queArray[++rear] = j;                      // increment rear
      nItems++;                                  // increase items
      }
  }

  public long remove() {                     // take item from front of queue
    long temp = queArray[front++];             // get value and increment front
    if( front == maxSize )                       // deal with wraparound
     front = 0;
    nItems--;                                  // decrease items
    return temp;
  }

  public long peekFront() {                  // peek at front of queue
   return queArray[front];
  }


  public boolean isEmpty() {                 // true if queue is empty
   return ( nItems == 0 );
  }

  public boolean isFull()  {                 // true if queue is full
   return ( nItems == maxSize );
  }

  public int size() {                         // number of items in queue
   return nItems;
  }

  public void display() {
    System.out.println( "Front: " + front + " Rear: " + rear + "\n" );

   if( rear > front || rear == front ) {      // check if rear is behind front
      for( int i = front; i <= rear; i++ ) {
        System.out.print( "| " + queArray[i] );      // print items
        System.out.print( " |" );
      }
      for( int i = 0; i < maxSize - nItems ; i++ ) {
        System.out.print( "| - |" );      // print empty boxes
      }
    }

    else if( rear < front ) {      // check if rear is before front
      if( nItems > 0 ) {
        for( int i = front; i < maxSize; i++ ) {
          System.out.print( "| " + queArray[i] );      // print items from the front to the end of the array
          System.out.print( " |" );
        }
        for( int i = 0; i < rear + 1; i++ ) {
          System.out.print( "| " + queArray[i] );      //print from beginning of array to the rear
          System.out.print( " |" );
        }
      }
      for( int i = 0; i < maxSize - nItems; i++ ) {
          System.out.print( "| - |" );     // print empty boxes
        }
    }
    System.out.println("\n");
  }

  public void emptyQueue() {
    System.out.println( "Removing " + nItems + " items: " );
    queArray = null;
    nItems = 0;
  }

  public static void main(String[] args) {
    Queue q = new Queue( 10 );
    System.out.println( "\nEmpty Queue initialized with 10 slots: " );
    q.display();

    q.insert( 2 );
    q.insert( 3 );
    q.insert( 5 );

    System.out.println( "Inserting 3 items: " );
    q.display();

    q.insert( 7 );
    q.insert( 11 );
    q.insert( 13 );
    q.insert( 17 );
    q.insert( 19 );

    System.out.println( "Inserting 5 items: " );
    q.display();

    q.remove();
    q.remove();

    System.out.println( "Removing 2 items: " );
    q.display();

    q.insert( 23 );
    q.insert( 29 );

    System.out.println( "Inserting 2 items: " );
    q.display();

    q.insert( 31 );
    q.insert( 37 );

    System.out.println( "Inserting 2 items: " );
    q.display();

    q.remove();
    q.remove();
    q.remove();

    System.out.println( "Removing 3 items: " );
    q.display();

    q.insert( 41 );
    q.insert( 43 );
    q.insert( 47 );

    System.out.println( "Inserting 3 items: " );
    q.display();

    System.out.println( "Attempting to insert 1 item: " );
    q.insert( 53 );

    q.emptyQueue();
    q.display();
  }
}
