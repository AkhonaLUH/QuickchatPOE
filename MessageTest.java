/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginapp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest{

 @Test
    public void testRecipientSuccess() {
        Message msg = new Message(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }
@Test
    public void testRecipientFailure() {
        Message msg = new Message(0, "27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                     msg.checkRecipientCell());
    }
 @Test
    public void testMessageHash() {
        Message msg = new Message(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        Message.createMessageHash();
        String hash = msg.getMessageHash();
        assertTrue(hash.endsWith("HITONIGHT"));
    }
@Test
    public void testSendMessageOption() {
        Message msg = new Message(0, "+27718693002", "Test message");
        assertEquals("Message successfully sent.", msg.sentMessage(1));
    
}
  @Test
     public void testCheckRecipientCell_Valid() {
Message msg = new Message(1, "+27831234567", "Test message");
assertEquals( "Cell phone number successfully captured.",
        msg.checkRecipientCell());
}
@Test
    public void testCheckRecipientCell_Invalid() {
Message msg = new Message(1, "0831234567", "Test message");
assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
        msg.checkRecipientCell() );
}
@Test
     public void testCheckMessageLength_Valid() {
String message = "Hello";
assertTrue(message.length() <= 250);

}
@Test
     public void testCheckMessageLength_Invalid() {
String message ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
boolean result = message.length() <= 250;
assertFalse(result);
}
@Test
    public void testCreateMessageHash() {
   Message msg = new Message(1, "+27718693002","Hi Mike can you join us for dinner tonight");
String hash = Message.createMessageHash();
assertNotNull(hash);
}
@Test
    public void testSentMessage() {
        Message msg;
     msg = new Message(1,"+27718693002","Test message");
String result = msg.sentMessage(1);
assertEquals("Message successfully sent.",
            result);
    }
}
