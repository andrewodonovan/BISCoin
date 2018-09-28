/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biscoin;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author donnm
 */
public class Transaction {
    Boolean is_eurTransaction;
    String crypto_symbol;
    Double crypto_eur_price;
    Double crypto_btc_price;
    Double total_price;
    int user_id;
    //@need to add a balance for the various cryptos
    public void transaction_calc(int user_id,String crypto_symbol, Double eur_price,Double crypto_btc_price, Double crypto_amount_requested,  String payment_currency, Double eur_balance, String trans_date, String trans_buy_sell ){
        // Logic to check what currency is being used as payment
        if(payment_currency == "EUR"){
            
            is_eurTransaction = true;
        }else{
            is_eurTransaction = false;
        }
        
        if(is_eurTransaction = true){
            int status = 0; 
            //Calculating total cost of the transaction
            total_price = crypto_amount_requested * eur_price;
            
            
                //Logic to check the Balance of the user
                if(eur_balance < total_price){
                    System.out.println("insufficient funds");
                }else{
                    // Logic to update the balance
                    eur_balance = eur_balance - total_price;
                    
                    
                   // make sql statment to pass into tbltransaction the values o new crypto owned and balance
                     SignIn BISCoinHomeObj1 = new SignIn();
                    java.sql.Connection conn = BISCoinHomeObj1.sqlConnection();
                    PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = (PreparedStatement) conn
                            .prepareStatement("insert into tbltransactions(trans_user_id, trans_crypto_id, trans_date, trans_buy_sell , trans_price_paid , trans_amount_bought_sold,trans_paid_in, trans_total_value) values (?, ?, ?, ?,? ,? ,? ,?)");
                                preparedStatement.setInt(1, user_id);
                        preparedStatement.setString(2, crypto_symbol);
                        preparedStatement.setString(3, trans_date);
                        preparedStatement.setString(4, trans_buy_sell);
                        preparedStatement.setDouble(5, eur_price);
                        preparedStatement.setDouble(6, crypto_amount_requested);
                        preparedStatement.setString(7, payment_currency);
                        preparedStatement.setDouble(8, total_price);
                      //  preparedStatement.setDouble(1, balance);
                        status = preparedStatement.executeUpdate();
                        System.out.println("We Making Money Bitch!!!");
                        System.out.println("Current Euro Balance: " + eur_balance) ;
                } catch (SQLException ex) {
                    Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                      
                        
                }
        }
    }
}
