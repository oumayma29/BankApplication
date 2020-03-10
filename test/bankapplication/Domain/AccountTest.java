/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication.Domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADMIN
 */
public class AccountTest {
    Account instance ;
    public AccountTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Account();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }


    /**
     * Test of deposit method, of class Account.
     */
    //test 0 pour la methode deposit
    
    @Test
    public void testDeposit() {
        assertEquals("Invalid Transaction", instance.deposit(-1000));
    }
    // Test 1 pour la méthode deposit 
    //positive amount 
 @Test 
    public void testDeposit1() {
        assertEquals("Transaction ok", instance.deposit(1000));
    }
 
    //test 0 pour la methode withdraw
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        assertEquals("Transaction ok", instance.withdraw(500));
    }
    //test 1 pour la methode withdraw1 --  balance = -1000
    @Test
    public void testWithdraw1() {
        System.out.println("withdraw");
        assertEquals("You don't have enough funds in this account for this transaction. Please try again with a smaller amount", instance.withdraw(1000));
    }

    
}
