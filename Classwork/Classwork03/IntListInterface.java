/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  IntListInterface.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-09-17
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public interface IntListInterface {
      int getValueAtIndex( int index );
      boolean append( int valueToAdd );
      boolean insertValueAtIndex( int value, int index );
      int removeValueAtIndex( int index );
   }
