/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  PriorityQHeap.java
* Purpose    :	Class for creating a Priority Queue based on Heap and removing in descending order.
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-012-13
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

class PriorityQHeap {
// array in sorted order, from max at 0 to min at size-1
  private int maxSize;
  private Heap theHeap;
  private int nItems;
  //-------------------------------------------------------------
  public PriorityQHeap (int s) { // constructor
    maxSize = s;
    theHeap = new Heap(maxSize);
    nItems = 0;
  }
  //-------------------------------------------------------------
  public void insert(int item) { // insert item

    theHeap.insertHeap(item); // insert at 0
    nItems++;

  } // end insert()

  // [NEW CODE]
  // removes largest items first
  public void remove() {
    int maxNode = 0;
    int maxNodeIndex = 0;

    // find largest item
    if( nItems > 2 ) {
      for ( int i = nItems-1; i > 0; i--) {
        for( int j = nItems - 2; j > 0; j--) {
          if( theHeap.heapArray[i].iData > theHeap.heapArray[j].iData && theHeap.heapArray[i].iData > maxNode) {
            maxNode = theHeap.heapArray[i].iData;
            maxNodeIndex = i;
          } else if ( theHeap.heapArray[i].iData < theHeap.heapArray[j].iData && theHeap.heapArray[j].iData > maxNode ) {
            maxNode = theHeap.heapArray[j].iData;
            maxNodeIndex = j;
          }
        }
      }
    } else if (nItems == 2 ) {
      if( theHeap.heapArray[0].iData > theHeap.heapArray[1].iData) {
        maxNode = theHeap.heapArray[0].iData;
        maxNodeIndex = 0;
      } else {
        maxNode = theHeap.heapArray[1].iData;
        maxNodeIndex = 1;
      }
    } else {
      maxNode = theHeap.heapArray[0].iData;
      maxNodeIndex = 0;
    }
    nItems--;
    theHeap.removeHeap(maxNodeIndex);
    System.out.println("Removed Node: "+  maxNode);
  }

  public boolean isEmpty() // true if queue is empty
  { return (nItems==0); }


  public void display() {
    theHeap.displayHeap();
  }


  class Node {
      private int iData; // data item (key)
      // -------------------------------------------------------------
      public Node(int key) // constructor
      {
          iData = key;
      }
      // -------------------------------------------------------------
      public int getKey() {
          return iData;
      }
      // -------------------------------------------------------------
      public void setKey(int id) {
          iData = id;
      }
  // -------------------------------------------------------------
  } // end class Node

  class Heap {
      private Node[] heapArray;
      private int maxSize; // size of array
      private int currentSize; // number of nodes in array

      // -------------------------------------------------------------
      public Heap(int mx) // constructor
      {
          maxSize = mx;
          currentSize = 0;
          heapArray = new Node[maxSize]; // create array
      }

      // -------------------------------------------------------------
      public boolean isEmpty() {
          return currentSize == 0;
      }

      // -------------------------------------------------------------
      public boolean insertHeap(int key) {
          if (currentSize == maxSize)
              return false;
          Node newNode = new Node(key);
          heapArray[currentSize] = newNode;
          trickleUp(currentSize++);
          return true;
      } // end insertHeap()

      // -------------------------------------------------------------
      public void trickleUp(int index) {
          int parent = (index - 1) / 2;
          Node bottom = heapArray[index];
          while (index > 0 &&
                  heapArray[parent].getKey() > bottom.getKey()) {
              heapArray[index] = heapArray[parent]; // move it down
              index = parent;
              parent = (parent - 1) / 2;
          } // end while
          heapArray[index] = bottom;
      } // end trickleUp()

      // -------------------------------------------------------------
      public Node removeHeap( int removeIndex) // delete item with max key
      { // (assumes non-empty list)
          Node root = heapArray[removeIndex];
          heapArray[removeIndex] = heapArray[--currentSize];
          trickleDown(removeIndex);
          return root;
      } // end removeHeap()

      // -------------------------------------------------------------
      public void trickleDown(int index) {
          int largerChild;
          Node top = heapArray[index]; // save root
          while (index < currentSize / 2) // while node has at
          { // least one child,
              int leftChild = 2 * index + 1;
              int rightChild = leftChild + 1;
              // find smaller child
              if (rightChild < currentSize && // (rightChild exists?)
                      heapArray[leftChild].getKey() >
                              heapArray[rightChild].getKey())
                  largerChild = rightChild;
              else
                  largerChild = leftChild;
                  // top >= smallerChild?
              if (top.getKey() <= heapArray[largerChild].getKey())
                  break;
                  // shift child up
              heapArray[index] = heapArray[largerChild];
              index = largerChild; // go down
          } // end while
          heapArray[index] = top; // root to index
      } // end trickleDown()

      // -------------------------------------------------------------
      public boolean change(int index, int newValue) {
          if (index < 0 || index >= currentSize)
              return false;
          int oldValue = heapArray[index].getKey(); // remember old
          heapArray[index].setKey(newValue); // change to new
          if (oldValue < newValue) // if raised,
              trickleUp(index); // trickle it up
          else // if lowered,
              trickleDown(index); // trickle it down
          return true;
      } // end change()

      // -------------------------------------------------------------
      public void displayHeap() {
          System.out.print("heapArray: "); // array format
          for (int m = 0; m < currentSize; m++)
              if (heapArray[m] != null)
                  System.out.print(heapArray[m].getKey() + " ");
              else
                  System.out.print("-- ");
          System.out.println();
  // heap format
          int nBlanks = 32;
          int itemsPerRow = 1;
          int column = 0;
          int j = 0; // current item
          String dots = "...............................";
          System.out.println(dots + dots); // dotted top line
          while (currentSize > 0) // for each heap item
          {
              if (column == 0) // first item in row?
                  for (int k = 0; k < nBlanks; k++) // preceding blanks
                      System.out.print(' ');
  // display item
              System.out.print(heapArray[j].getKey());
              if (++j == currentSize) // done?
                  break;
              if (++column == itemsPerRow) // end of row?
              {
                  nBlanks /= 2; // half the blanks
                  itemsPerRow *= 2; // twice the items
                  column = 0; // start over on
                  System.out.println(); // new row
              } else // next item on row
                  for (int k = 0; k < nBlanks * 2 - 2; k++)
                      System.out.print(' '); // interim blanks
          } // end for
          System.out.println("\n" + dots + dots); // dotted bottom line
      } // end displayHeap()
    }

  //-------------------------------------------------------------
  /*public boolean isFull() // true if queue is full
  { return (nItems == maxSize); }
  //-------------------------------------------------------------
  } // end class PriorityQ*/
  ////////////////////////////////////////////////////////////////

    public static void main(String[] args) { //throws IOException
      PriorityQHeap thePQ = new PriorityQHeap(11);
      thePQ.insert(30);
      thePQ.insert(50);
      thePQ.insert(10);
      thePQ.insert(40);
      thePQ.insert(20);
      thePQ.insert(45);
      thePQ.insert(43);
      thePQ.insert(1);
      thePQ.insert(3);
      thePQ.insert(5);
      thePQ.insert(7);

      thePQ.theHeap.displayHeap();

      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();
      thePQ.remove();

    } // end main()
//---------------------------------------
} // end class PriorityQApp
