/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  IntList.java
* Purpose    :  Classwork03
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-09-17
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
public class IntList implements IntListInterface {
      private int[] theList;
      private int   size;

      private static final int STARTING_SIZE = 10;    // defines starting size; don't worry, we'll deal

      private class ListException extends Exception {
         public ListException( String m ) {
            super( m );
            //System.exit(0);
         }
      }

      public IntList() {                        // doesn't HAVE to be declared public, but doesn't hurt
         theList = new int[STARTING_SIZE];
         size = 0;
      }

      public int getValueAtIndex( int index ) {

         try {
            if( size == 0 ) {
               throw new ListException( "The list is empty!" );
            } else if( index > size ) {
               throw new ListException( "The index value is too large" );
            } else if( index < 0 ) {
               throw new ListException( "The index value is too small") ;
            } else if( checkIndex( index ) == false ) {
                throw new ListException( "The index value is out of bounds") ;
               }

         }
         catch( ListException le ) {}
         return theList[index];
      }

      public boolean append( int valueToAdd ) {
          //System.out.println( "from append size: " + size );
          //System.out.println( "from append listlength: " + theList.length);
           if( size < theList.length ) {
              theList[size] = valueToAdd;
              size++;
              return true;
           } else {
             try{
               throw new ListException ( "There is no room! " ); // what should we do here, if there's no room?

           } catch( ListException le ) {}

             int[] theList2 = new int[theList.length + STARTING_SIZE];
             for( int i = 0; i < theList.length; i++ ) {
               theList2[i] = theList[i];
             }
             theList = theList2;
             append( valueToAdd );

           }
           return false;
        }

      private void holeFiller( int index ) {
         for( int i = index; i < size - 1; i++ ) {
            theList[i] = theList[i+1];
         }
         size--;
      }

      public int removeValueAtIndex( int index ) {
         int value = theList[index];
         try {
            if( size == 0 ) {
               throw new ListException( "The list is empty!" );
            } else if( index > size ) {
               throw new ListException( "The index value is too large" );
            } else if( index < 0 ) {
               throw new ListException( "The index value is too small");
            }
         }
         catch( ListException le ) {}
         holeFiller( index );
         theList[size] = 0;
         return value;
      }

      // we've gotta have this to actually get things to compile
      public boolean insertValueAtIndex( int value, int index ) {
        // check that there is space in the array to insert new value
          if( size < theList.length ) {
            // move everything to the right of the index over one
            for( int i = size; i > index; i-- ) {
              theList[i] = theList[i - 1] ;
            }
            theList[index] = value; // insert new value at desired index
            size++;
          }
           else {

             int[] theList2 = new int[theList.length + STARTING_SIZE];
             for( int i = 0; i < theList.length; i++ ) {
               theList2[i] = theList[i];
             }
             theList = theList2;
             insertValueAtIndex( value, index );

          }
          return true;
      }

      // method to add value at the beginning of the list
      public boolean prepend( int valueToAdd ) {
        // move all the values over one to the right
        if( size < theList.length ) {
          for( int i = size; i > 0 ; i-- ) {
            theList[i] = theList[i - 1] ;
          }
          theList[0] = valueToAdd ; // add value to the front of list
          size++;
        } else {
        System.out.println("Not enough room in list");
       }
        return true;
      }

      // method to check if index is valid
      public boolean checkIndex ( int index ) {
        try {
          if( index < 0 || index >= theList.length) {
            throw new ListException( "Index out of bounds" );
          }
        } catch (ListException le ) {
        System.out.println("Please input a valid index value " );
        }
        return false;
      }

      public static void main( String[] args ) {
         IntList list = new IntList();
         list.append( 2 );
         list.append( 3 );
         list.append( 5 );
         list.append( 7 );
         System.out.println( list.getValueAtIndex( 3 ) );   // should return the value 7
         list.append( 11 );
         list.append( 13 );
         list.append( 17 );
         list.append( 19 );
         list.append( 43 );
         list.append( 12 );
         list.append( 54 );
         list.prepend( 1 );
         //list.append( 83 );
         //list.append( 93 );
         System.out.println( list.getValueAtIndex( 7 ) );      // should return the value 19
         System.out.println( list.removeValueAtIndex( 3 ) );   // should return the value 7
         System.out.println( list.getValueAtIndex( 3 ) );      // should return the value 11
         System.out.println( list.getValueAtIndex( 9 ) );     // just to see what happens


         /*
         list.insertValueAtIndex( 99, 2 );
         list.insertValueAtIndex( 100, 2);
         list.insertValueAtIndex( 1, 2 );
         list.insertValueAtIndex( 2, 2);
         list.insertValueAtIndex( 3, 2 );
         list.insertValueAtIndex( 4, 2);
         list.insertValueAtIndex( 5, 2 );
         list.insertValueAtIndex( 6, 2);
         list.insertValueAtIndex( 7, 2 );
         */


         //System.out.println("size: " + list.size);
         //System.out.println("theList.length: " + list.theList.length);
         //System.out.println(Arrays.toString(list.theList));

      }
   }
