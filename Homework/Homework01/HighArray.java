/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  HighArray.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-09-17
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class HighArray {
  private long[] a;
  private int nElems;

  public HighArray(int max) {
    a = new long[max];
    nElems = 0;
  }

  public boolean find(long searchKey) {
    int j;
    for( j = 0; j < nElems; j++)
      if( a[j] == searchKey)
        break;
    if( j == nElems)
      return false;
    else
      return true;
  }

  public void insert( long value ) {
    a[nElems] = value;
    nElems++;
  }

  public boolean delete(long value) {
    int j;
    for( j = 0; j < nElems; j++)
      if( value == a[j])
        break;
    if( j == nElems)
      return false;
    else {
      for( int k = j; k < nElems; k++)
        a[k] = a[k+1];
      nElems--;
      return true;
    }
  }

  public void display() {
    System.out.println("");
    for( int j = 0; j < nElems; j++ )
      System.out.println( a[j] + " ");
    System.out.println( "" );
  }

  public long getMax() {
    if( a.length == 0) {
      return -1;
    } else {
    long maxVal = a[0];
    for( int i = 1; i < a.length; i++) {
      if( a[i] > maxVal ) {
        maxVal = a[i];
      }
    }
    return maxVal;
    }
  }

  public boolean noDups() {
    for( int i = 0; i < nElems; i++) {
      for( int j = i + 1; j < nElems; j++) {
        if( a[j] == a[i] ) {
            System.out.println("Duplicate of " + a[j] + " deleted");
            delete(a[j]);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
  }
}
