/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import bankapplication.Domain.Account;

/**
 *
 * @author ADMIN
 */
public class BankApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Account account = new Account("12jyh","5648jbr","Bouslema Oumaima",0);
        account.showMenu();
    }
    
}
