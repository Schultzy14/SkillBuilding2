package Game;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class Login {
  
      public JLabel menutitle;
  
  public static void main(String[] args){
    
    run(args);
   //menuscreen.main(args);
  }
  
  public static void run(String[] args){
    
    
    
    
    String filename = "C:/Users/Administrator/Desktop/Game/Login.txt";
    Scanner scan = new Scanner(System.in);
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    
    
    try{
      scan = new Scanner(new File(filename));
           
      
       } catch (Exception e){
      System.out.println("The file '" + filename + "' was not found, idiot.");
       } finally {
    
       } 
 
   
     
    String[]userDB = new String[25];
    Scanner keyboard = new Scanner (System.in);
    String user = null;
    String pass = null;
    String name = null;
    String userID = null;
    String[] temp = new String[10];
    String pushLine = null;
    
    FileReader fileReader;
    InputStreamReader backup = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(backup);
    

    
     
    
    System.out.println("Enter username, or type 'new' to create an account:");
    user = keyboard.nextLine();
   
     if(search(filename, user)==true){
      System.out.println("Enter password:");
      pass = keyboard.nextLine();
      
     }
     
     if(user.equals("new")){
     //create user, add to database
      System.out.println("Enter desired username:");
      user = keyboard.nextLine();
      if(search(filename, user)==true){
        do{
          System.out.println(user + " is already taken. Please select a new username:");
      user = keyboard.nextLine();
        }while(search(filename, user)==true);
      }
      
      System.out.println(user + ", please select a password:");
      pass = keyboard.nextLine();
      
      System.out.println("Enter password:");
     pass = keyboard.nextLine();
     
     System.out.println("Enter your name:");
     name = keyboard.nextLine();
     

       userID = userIDgen(user);
       String temp2 = null;
       
       temp2 = user;
       temp2= temp2.concat("<=>");
       temp2 = temp2.concat(pass);
       temp2 = temp2.concat("<=>");
       temp2 = temp2.concat(name);
       temp2 = temp2.concat("<=>");
       temp2 = temp2.concat(userID);
       pushLine = temp2.concat("/n/");
       
       String s = pushLine;
    byte data[] = s.getBytes();
    Path p = Paths.get(filename);

    try (OutputStream out = new BufferedOutputStream(
      Files.newOutputStream(p, CREATE, APPEND))) {
      out.write(data, 0, data.length);
    } catch (IOException x) {
      System.err.println(x);
    }
       
             
    }
    
     //if(userSearch(user)==false){
      System.out.println("Account does not exist. Please enter desired password:"); 
      pass=keyboard.nextLine();
      String id = userIDgen(user);
      String s = null;
      s = user.concat("<=>");
      s = s.concat(pass);
      s = s.concat("<=>");
      s = s.concat(id);
      System.out.println("Please enter your name:");
      String name2 = keyboard.nextLine();
      s = s.concat("<=>");
      s = s.concat(name2);
      s = s.concat("/n/");
      
      
    byte data[] = s.getBytes();
    Path p = Paths.get(filename);

    try (OutputStream out = new BufferedOutputStream(
      Files.newOutputStream(p, CREATE, APPEND))) {
      out.write(data, 0, data.length);
    } catch (IOException x) {
      System.err.println(x);
    }
    // }
    
       

    
    
    
    
    
    try{
    
      fileReader = new FileReader(filename);
      bufferedReader = new BufferedReader(fileReader);
      
      bufferedReader.close();
       fileReader.close();
       } catch (Exception e){
          System.out.println("Unable to read the file."); 
       } finally {
      
       }
    
    String line = null;
    String[] x = new String[5];
    
    String uTemp = x[0];
    String pTemp = x[1];
    int check = 0;
    Boolean reachedEnd = false;
    
     try{
    
       
      while((line = bufferedReader.readLine()) != null){
        
        if(bufferedReader.readLine() == null){
         reachedEnd = true; 
        }
    
        x = delimiter(line);
        uTemp = x[0];
        pTemp = x[1];
      
       
       if(uTemp.equals(user) && pTemp.equals(pass)){
         login(user, pass, args);
         check++;
         
       }
       
       if(check==0 && reachedEnd==true){
        System.out.println("Username/password combination not found."); 
       }
       
       }

      
      
    } catch(Exception e) {
      
    } finally {
      
    }
    
    login(user, pass, args);

  }


    
private static void login(String user, String pass, String[] args){
  
  String currentUser = user;
  String currentPass = pass;
  String[] data = new String[3];
  data[0] = user;
  data[1] = pass;
  
  System.out.println("Login successful. Welcome, " + data[0] + ".");
  menuscreen.main(args);

}

public static String[] delimiter(String line){
 
  String[] userPass = line.split("<=>");
  
  if(userPass[0].equals(null) && userPass[1].equals(null)){
   System.out.println("Username/password combination not detected. No delimiting character."); 
  } else {
  }
  return userPass;
  
}

public static String[] splitter(String file){
 String[] split = new String[50];
 
 split = file.split("/n/");
 
 return split;
}

public static String copier(String path){
  
  FileReader fileReader;
  InputStreamReader backup = new InputStreamReader(System.in);
  BufferedReader bufferedReader = new BufferedReader(backup);
  String line = null;
  
  try{
    
      fileReader = new FileReader("C:/Users/Administrator/Desktop/Game/Login.txt");
      bufferedReader = new BufferedReader(fileReader);
      
      bufferedReader.close();
       fileReader.close();
      
       } catch (Exception e){
          System.out.println("Unable to read the file."); 
       } finally {
      
       }
       
       try{
  
  if(bufferedReader.readLine() != null){
           line = bufferedReader.readLine();
           path.concat(line);
           }
       } catch (Exception e){
         
         
       } finally {
         
       }
  
 return path; 
}

public static String userIDgen(String user){
  
  int userIDi;
  Random rand = new Random();
  String line = null;
  userIDi = rand.nextInt(9999) + 1;
  Boolean reachedEnd = false;
  String idTemp = null;
  String[] x = new String[5];
  String userID = Integer.toString(userIDi);
  int check = 0;
  
  String filename = "C:/Users/Administrator/Desktop/Game/Login.txt";
  FileReader fileReader;
  InputStreamReader backup = new InputStreamReader(System.in);
  BufferedReader bufferedReader = new BufferedReader(backup);
  
  try{
    
      fileReader = new FileReader(filename);
      bufferedReader = new BufferedReader(fileReader);
      
      bufferedReader.close();
       fileReader.close();
       } catch (Exception e){
          System.out.println("Unable to read the file."); 
       } finally {
      
       }
       
       
 
       if(search(filename, userID)==true){
         
         do{
           userIDi = rand.nextInt(99999999) + 1;
           userID = Integer.toString(userIDi);
           
         } while(search(filename, userID)==true);
         
       }
       
       System.out.println("New user ID created. " + user + ", your ID is: " + userID);
  
  
    return userID;
 
}

public static Boolean search(String filename, String query){
  
  
  Boolean found = false;
  String line = null;
  String[] x = new String[5];
  String temp = null;
  String[] diced = null;
  
  FileReader fileReader;
  InputStreamReader backup = new InputStreamReader(System.in);
  BufferedReader bufferedReader = new BufferedReader(backup);
  diced = splitter(filename);
  
  try{
    
      fileReader = new FileReader(filename);
      bufferedReader = new BufferedReader(fileReader);
      
      
      
       } catch (Exception e){
          System.out.println("Unable to read the file."); 
       } finally {
      
       }
       
       

  
  
  
  try{
    
       
      while((line = bufferedReader.readLine()) != null){
        
     
        
     for(int j=0; j<50; j++){
       
       
          for(int i=0; i<3; i++){
          x = delimiter(diced[j]);
          temp = x[i];
      
       
           if(temp.equals(query)){
             found = true;
           }
           
           if(bufferedReader.readLine() != null){
           line = bufferedReader.readLine();
           }
        }
   //  } 
      
   }
      }


      
    } catch(Exception e) {

      
    } finally {
      
    }
 
 return found;
}

public static Boolean pairing(String filename, String one, String two){

  Boolean paired = false;
  String line = null;
  String[] x = new String[5];
  String temp = null;
  String temp2 = null;
  String temp3 = null;
  String temp4 = null;
  
  
  
  FileReader fileReader;
  InputStreamReader backup = new InputStreamReader(System.in);
  BufferedReader bufferedReader = new BufferedReader(backup);
  
  try{
    
      fileReader = new FileReader(filename);
      bufferedReader = new BufferedReader(fileReader);
      
      try{
    
       
      while((line = bufferedReader.readLine()) != null){
        
     
          

          x = delimiter(line);
          temp = x[0];
          temp2 = x[1];
          temp3 = x[2];
          temp4 = x[3];
      
       
           if(one.equals(temp)||one.equals(temp2)||one.equals(temp3)||one.equals(temp4)){
             if(two.equals(temp)||two.equals(temp2)||two.equals(temp3)||two.equals(temp4)){
             paired = true;
           }
}
           
           if(bufferedReader.readLine() != null){
           line = bufferedReader.readLine();
           } 
      
   }
      
      
      
      bufferedReader.close();
       fileReader.close();
      
       } catch (Exception e){
          System.out.println("Unable to read the file."); 
       } finally {
      
       }
  } catch(Exception e){
  } finally {
  }
  
  return paired;
}


}
