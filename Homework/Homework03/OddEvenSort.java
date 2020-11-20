/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  OddEvenSort.java
* Purpose    :	Sorts a list of numbers using the odd-even sort algorithm.
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-011-16
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class OddEvenSort {

   public static void oddEvenSort(int[] array) {
     boolean sorted = false;
     int pass = 0;
     while (!sorted) {
         sorted = true;
         for (int i = 1; i < array.length - 1; i += 2) {
              if (array[ i ] > array[ i + 1 ]) {
                   swapValues( array , i , i + 1 );
                   sorted = false;
               }
         }
         pass++;
         printList(array, pass);
         for (int i = 0; i < array.length - 1; i += 2) {
               if (array[ i ] > array[ i + 1 ]) {
                   swapValues( array , i , i + 1 );
                   sorted = false;
               }
         }
         pass++;
         printList(array, pass);
     }
   }

   public static void swapValues(int[] array, int i, int j) {
     int temp;
     temp = array[ i ];
     array[ i ] = array[ j ];
     array[ j ] = temp;
   }

   public static void printList(int[] list, int pass){
     System.out.print("Pass " + pass + ": ");
     for(int i = 0; i < list.length; i++){
       System.out.print(list[i] + " ");
     }
     System.out.println();
   }

   public static void main(String args[]) {
     int[] listToBeSorted = {10, 3, 73, 2, 21, 19, 40, 5, 16, 17};
     oddEvenSort(listToBeSorted);
   }
}
