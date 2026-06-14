/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginapp;

import java.util.Random;

public class Message {
    private static  String messageID;
    private static  int messageNumber;
    private  static String recipient;
    private  static String messageText;
    private  static String messageHash;

    public Message(int messageNumber, String recipient, String messageText){
        Message.messageNumber = messageNumber;
        Message.recipient = recipient;
        Message.messageText = messageText;
        Message.messageID = generateMessageID();
        Message.messageHash = createMessageHash();
    }
 // 1. Message ID is created - 10 digit random number
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000L + rand.nextLong(9000000L);
        return String.valueOf(id);
    }
public boolean checkMessageID() {
        return messageID.length() <= 10;
   }
 // 2. Recipient number validation
    public String checkRecipientCell(){
        // Must start with + and be 10-13 digits total including 
        if (recipient.startsWith("+") && recipient.length() <= 13 ){
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
      }

    // 3. Message hash creation: 00:0:HITONIGHT
    public static String createMessageHash() {
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words.length > 0? words[0] : "";
        String lastWord = words.length > 1? words[words.length - 1] : firstWord;

        Message.messageHash = messageID.substring(0, 2) + ":" + messageNumber + ":" +
                           firstWord.toUpperCase() + lastWord.toUpperCase();
        return Message.messageHash;
    }
// 4. MessageSent - send/store/disregard options
    public String sentMessage(int option) {
        switch (option) {
            case 1:
                return "Message successfully sent.";
            case 2:
                return "Message disregarded.";
            case 3:
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }
    
// Getters needed for testing and Main class
    public String getMessageID(){
        return messageID;
    } 
    
    public String getMessageHash(){
       return messageHash;
    }
    public String getRecipient(){
        return recipient;
    }
    public String getMessageText(){
       return messageText;
}  
}//<- this closes the Message class

