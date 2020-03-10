/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication.Domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Account {
    private String idAccount;
    private String idClient; 
    private String clientName;
    private int balance;
    private List<String> transactions = new ArrayList<String>();
    
    public Account(){}
    public Account(String idAccount, String idClient, String clientName, int balance) {
        this.idAccount = idAccount;
        this.idClient = idClient;
        this.clientName = clientName;
        this.balance = balance;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getClientName() {
        return clientName;
    }

    public int getBalance() {
        return balance;
    }


    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

   
    
   public String deposit( int amount)
    {
       if(amount > 0)
       {
           this.balance= this.balance +amount;
           DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   Date date = new Date();
           
           this.transactions.add( "Deposit | " + amount+ " Euros | "+ dateFormat.format(date)+" | New Balance | "+ this.balance +" Euros");
           System.out.println("Valid Transaction ");
           return "Transaction ok";
       }
       System.out.println("Invalid Transaction");
       return "Invalid Transaction";
    }
     public String withdraw (int amount){
          if(amount > 0 && (this.balance-amount)>-1000)
          {
           this.balance = this.balance -amount;
           DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   Date date = new Date();
           this.transactions.add( "Withdraw | " + amount+ " Euros | "+ dateFormat.format(date)+ " | new Balance | "+ this.balance +" Euros");
              System.out.println("Valid Transaction"); 
           return "Transaction ok";
          }else 
        System.out.println(  "You don't have enough funds in this account for this transaction. Please try again with a smaller amount");
        return "You don't have enough funds in this account for this transaction. Please try again with a smaller amount";

     }
     
     public void showHistory()
     {
       for(Iterator it=this.transactions.iterator(); it.hasNext();)
            System.out.println(it.next());
     }
     
   public void showMenu(){
        char option='\0';
     Scanner scanner = new Scanner(System.in);
     System.out.println("welcome Sir / Madam  " + this.clientName);
     System.out.println("1 - To check your Balance Account");
     System.out.println("2 - To deposit money");
     System.out.println("3 - To withdraw money");
     System.out.println("4 - History (operation,date,amount)");
     System.out.println("5 - Exit");
        do
        {
            System.out.println("enter an option");
            option = scanner.next().charAt(0);
                 System.out.println("\n");
                 switch(option){
                     case '1' : 
                          System.out.println("-------------------------------------------------------------------");
                          System.out.println("-------------------------Account Balance---------------------------");
                          System.out.println("-------------------------------------------------------------------");
                              System.out.println("Balance : "+ this.balance+" Euros");
                              break;
                     case '2' : 
                          System.out.println("-------------------------------------------------------------------");
                          System.out.println("-----------------------------Deposit-------------------------------");
                          System.out.println("-------------------------------------------------------------------");
                          System.out.println("Enter an amount : ");
                         int amountEntred = scanner.nextInt();
                         this.deposit(amountEntred);
                         break;
                     case '3' : 
                          System.out.println("-------------------------------------------------------------------");
                          System.out.println("-----------------------------withdraw----------------------------");
                          System.out.println("-------------------------------------------------------------------");
                          System.out.println("Enter an amount : ");
                         int amountEntred1 = scanner.nextInt();
                         this.withdraw(amountEntred1);
                         break;
                                 
                     case '4' : 
                          System.out.println("-------------------------------------------------------------------");
                          System.out.println("---------------------Account History Report------------------------");
                          System.out.println("-------------------------------------------------------------------");
                         this.showHistory();
                         break;
                     case '5' : 
                          System.out.println("------------------------------Have a nice day------------------------------------------ ");
                         break;
                                  
                     default:
                         System.out.println("Error");
                              break;
                 }
        }while (option != '5');
    }
    
}
 