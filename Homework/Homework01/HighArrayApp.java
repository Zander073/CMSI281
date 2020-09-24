/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  HighArrayApp.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-09-17
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

//package homework01;
public class HighArrayApp {
  public static void main( String[] args) {
  int maxSize = 100;
  HighArray arr;
  arr = new HighArray(maxSize);
  arr.insert(19);
  arr.insert(77);
  arr.insert(99);
  arr.insert(44);
  arr.insert(55);
  arr.insert(22);
  arr.insert(88);
  arr.insert(11);
  arr.insert(00);
  arr.insert(66);
  arr.insert(33);

  arr.display();

  System.out.println("Max value: " + arr.getMax());

  int searchKey = 35;
  if( arr.find(searchKey) )
    System.out.println( "Found " + searchKey );
  else
    System.out.println( "Can't find " + searchKey );

  arr.insert(22);
  arr.delete(00);
  arr.delete(55);
  arr.delete(99);
  arr.display();

  System.out.println("Max value: " + arr.getMax());

  arr.delete(88);
  arr.display();

  System.out.println("Max value: " + arr.getMax());

  arr.insert(19);
  arr.insert(144);
  arr.insert(143);
  arr.insert(22);
  arr.display();

  System.out.println("Max value: " + arr.getMax());

  arr.delete(144);
  arr.display();

  System.out.println("Max value: " + arr.getMax());

  arr.noDups();

  arr.display();
  }
}
