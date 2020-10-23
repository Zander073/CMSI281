/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  JosephusProblem.java
* Purpose    :
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-010-17
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


import java.util.ArrayList;

public class JosephusProblem {

  //List of remaining positions
  static ArrayList<Integer> list = new ArrayList<Integer>();

  //Switch for constructing list
  static boolean listConstructed = false;

  static int size;
  static int stepSize;
  static int startingIndex;

  public JosephusProblem(int size, int stepSize, int startingIndex){
    this.size = size;
    this.stepSize = stepSize;
    this.startingIndex = startingIndex;
  }

  //Recursive method of solving for which position to be in so you do not die/become a slave
  public static int computeJP(int current, int n) {
    if(listConstructed == false) {
      constructList(size);
      listConstructed = true;
    }
    int currentIndex = current;
    if(list.size() != 1) {
      int positionToKill = travelList(currentIndex, n);
      adjustList(positionToKill);
      currentIndex = positionToKill;
      computeJP(currentIndex, n);
    }
    return list.get(0);
  }

  //Computes the next person to elimate
  public static int travelList(int currentIndex, int n) {
    n = n - 1;
    int indexToKill = 0;
    int length = list.size();
    if(length == 1) {
      return indexToKill;
    }
    if(length == 2) {
      indexToKill = computeFinalTwo(currentIndex, n);
    } else {
      if(currentIndex + n >= length - 1) {
        int index = currentIndex;
        for(int j = 0; j < n; j++) {
          if(index >= length - 1) {
            index = 0;
          } else {
            index++;
          }
        }
        indexToKill = index;
      } else {
        indexToKill = currentIndex + n;
      }
    }
    return indexToKill;
  }

  //Computes who dies of the final two
  public static int computeFinalTwo(int currentIndex, int n) {
    if(n % 2 == 0) {
      if(currentIndex == 0) {
        return 0;
      } else {
        return 1;
      }
    } else {
      if(currentIndex == 0) {
        return 0;
      } else {
        return 1;
      }
    }
  }

  public static void adjustList(int index){
    int indexToRemove = index;
    list.remove(indexToRemove);
    printList();
  }

  public static void constructList(int length){
    for(int i = 0; i < length; i++) {
      list.add(i + 1);
    }
  }

  public static void printList() {
    System.out.print("Remaining positions: ");
    for(int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }

  //Main method
  public static void main(String[] args) {
    JosephusProblem x = new JosephusProblem(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    int positionToBe = x.computeJP(startingIndex, stepSize);
    System.out.println("For a circle of size " + size + ", starting at index " + startingIndex
    + ", and step size of " + stepSize + ", you are going to want to be in the " + positionToBe + " position in the circle.");
  }
}
