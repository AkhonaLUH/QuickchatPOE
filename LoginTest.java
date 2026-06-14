/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    @Test
    public void testRegisterUser_Success()
    {
        Login user = new Login();
        
        String result = user.registerUser("John_Smith","Pass123","+27831234567","John","Smith");
   assertEquals("User successfully registered.",result);
}
@Test
 public void testRegisterUser_InvalidUsername(){
     Login user = new Login();
     
     String result = user.registerUser("John Smith","Pass123","+27831234567","John","Smith");
     
     assertEquals("Username is not correctly formatted.", result);
    }
 @Test
    public void testLoginUser_Success() {
        Login user = new Login();
        // FIRST REGISTER THE USER 
        user.registerUser("John_Smith","Pass123","+27831234567","John","Smith");
    boolean success = user.loginUser("John_Smith","Pass123");
    
    assertTrue(success);
}
    @Test
    public void testLoginUser_Fail() {
        Login user = new Login();
        
        //Register first
        user.registerUser("John Smith","Pass123","+27831234567","John","Smith");
    boolean success = user.loginUser("John_Smith","WrongPass");
    
    assertFalse(success);
}
    @Test
    public void testReturnLoginStatus_Success() {
        Login user = new Login();
        String message = user.returnLoginStatus(true);
        
        assertEquals("Welcome back!",message);
    }
    
    @Test
    public void testReturnLoginStatus_Fail() {
        Login user = new Login();
        String message = user.returnLoginStatus(false);
        
        assertEquals("Username or password incorrect.", message);
    }
    
}

   