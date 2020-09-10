/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  SayHello.java
* Purpose    :  Program that greets the user by name.
* @author    :  Teresa Ueunten & Zander Zemliak
* Date       :  2020-09-08
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.Scanner;

public class SayHello {

  public static void main ( String[] args) {

    // Program greets the world and prompts user for name input
    System.out.println( "\n\n" +
                        "*******************\n" +
                        "*                 *\n" +
                        "*  Hello, World!  *\n" +
                        "*                 *\n" +
                        "*******************");
    //System.out.println( "\n\nHello, World!" );
    System.out.print( "\n\nPlease input your name then press Enter Key: " );

    // Setting up Scanner to read user input
    Scanner myInput = new Scanner( System.in );
    String inputName = myInput.nextLine();

    // Trims whitespaces and reduces String to length 0 if all whitespaces
    if( inputName.trim().isEmpty()) {
      inputName = "";
    }

    // Detect if input is 0 length
    if( inputName.length() == 0) {
      inputName = "Nameless";
    }

    // Strings to make the box around the output
    String starExtender = "****";
    String sideExtender = "   *";

    // For loop to extend the box based on input length
    for( int i = 0; i < inputName.length(); i++) {
      starExtender = "*" + starExtender;
      sideExtender = " " + sideExtender;
    }

    // Greets the user by name/input
    System.out.println ( "\n\n" +
                         "**********" + starExtender + "\n" +
                         "*         " + sideExtender + "\n" +
                         "*  Hello, " + inputName + "!  *\n" +
                         "*         " + sideExtender + "\n" +
                         "**********" + starExtender +
                         "\n\n" );
  }
}
