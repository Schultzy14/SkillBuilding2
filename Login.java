import java.util.*;
import java.io.File;



public class Login {
  public static void main(String[] args){
  
    String filename = "C:/Users/Administrator/Desktop/Game/Login.txt";
    Scanner scan = new Scanner(System.in);
    
    try{
      scan = new Scanner (new File(filename));
      
      
    } catch (Exception e){
      System.out.println("The file '" + filename + "' was not found, idiot.");
    }
    
    
    Scanner keyboard = new Scanner (System.in);
    String user = scan.nextLine();
    String pass = scan.nextLine(); // looks at selected file in scan

    String inpUser = keyboard.nextLine();
    String inpPass = keyboard.nextLine(); // gets input from user

    if (inpUser.equals(user) && inpPass.equals(pass)) {
        System.out.print("Welcome to Accountable");
    } else {
        System.out.print("Sorry, your username and/or password was incorrect!");
   
    }
}
}
