/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginapp;
import java.util.Scanner;
import java.util.ArrayList;

public class LoginApp {
    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<Message> disregardedMessages = new ArrayList<>();
    
static ArrayList<String> messageHashes = new ArrayList<>();
static ArrayList<String> messageIDs = new ArrayList<>();
    

    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {
            Login user = new Login ();
            Scanner sc = new Scanner(System.in);
           
            
            
            System.out.print("Enter first name:");
            String firstName = input.nextLine();
            
            System.out.print("Enter last name:");
            String lastName = input.nextLine();
            
            System.out.print("Enter username:");
            String username = input.nextLine();
            
            System.out.print("Enter password:");
            String password = input.nextLine();
            
            System.out.print("Enter SA phone number (+27...):");
            String phone = input.nextLine();
            
            String result = user.registerUser(username, password, phone, firstName, lastName);
            System.out.println(result);
            
            System.out.print("Enter username to login:");
            String loginUser = input.nextLine();
            
            System.out.print("Enter password to login:");
            String loginPass = input.nextLine();
            
            boolean success = user.loginUser(loginUser, loginPass);
            String message = user.returnLoginStatus(success);
            
            System.out.println(message);
        
            int messageCount = 0;
            
            System.out.println("Welcome to QuickChat.");
            System.out.print("How many messages do you want to send? ");
            int numMessages;
                numMessages = sc.nextInt();
            sc.nextLine();
            
            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Send Message");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");
                System.out.print("4. Stored Messages");
                System.out.print("Enter choice:");
                
                int choice = sc.nextInt();
                sc.nextLine();
                
                if (choice == 1 && messageCount < numMessages) {
                    messageCount++;
                    
                    System.out.print("Enter recipient number with international code: ");
                    String recipient = sc.nextLine();
                    
                    System.out.print("Enter message (max 250 chars): ");
                    String messageText = sc.nextLine();
                    
                    // Check message length
                    if (messageText.length() > 250) {
                        System.out.println("Message exceeds 250 characters by " + (messageText.length() - 250) +
                                "; please reduce the size.");
                        messageCount--;
                        continue;
                    }
                    
                    Message msg = new Message(messageCount, recipient, messageText);
                    String cellCheck = msg.checkRecipientCell();
                    System.out.println(cellCheck);
                    
                    // Validate recipient
                    System.out.println(msg.checkRecipientCell());
                    
                    // Show send options
                    System.out.println("Choose an option:");
                    System.out.println("1. Send Message");
                    System.out.println("2. Disregard Message");
                    System.out.println("3. Store Message");
                    int option = sc.nextInt();
                    sc.nextLine();
                    
                    String results = msg.sentMessage(option);
                    System.out.println(results);
                    
             messageHashes.add(msg.getMessageHash());
messageIDs.add(msg.getMessageID());       
                    
                    switch (option) {
                        case 1:
                            sentMessages.add(msg);
                            System.out.println("\nMessage Details:");
                            System.out.println("Message ID: " + msg.getMessageID());
                            System.out.println("Message Hash: " + msg.getMessageHash());
                            System.out.println("Recipient: " + msg.getRecipient());
                            System.out.println("Message: " + msg.getMessageText());
                            break;
                        case 2:
                            disregardedMessages.add(msg);
                            break;
                        case 3:
                            storedMessages.add(msg);
                            break;
                        default:
                            break;
   } 
                    
  }else if (choice == 2){
 for (Message m : sentMessages) {
  System.out.println(m.getMessageText());
    }
}
else if (choice == 3) {
System.out.println("Goodbye!");
    break;
}
else if (choice == 4) {

System.out.println("\nStored Messages Menu");
System.out.println("Sent Messages: " + sentMessages.size());
System.out.println("Stored Messages: " + storedMessages.size());
System.out.println("Disregarded Messages: " + disregardedMessages.size());

}
                }
            }
        }
    }

            
        
    
     

     

     
     

    

