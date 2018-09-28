/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biscoin;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author donnm
 */
public class JSonParserTest {
    
    public JSonParserTest(){
        //construction
    }
    
     private Connection connect = null;
  PreparedStatement preparedStatement = null;
public void getData() throws ParseException, Exception{
         try {
              URL url = new URL("https://api.coinmarketcap.com/v1/ticker/?convert=EUR&limit=100"); 
              HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
              conn.setRequestMethod("GET"); 
              String inline = new String();
              conn.connect(); 
             
              int responsecode = conn.getResponseCode(); 
              
              if(responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " +responsecode);
                else{
                       Scanner sc = new Scanner(url.openStream());
                        while(sc.hasNext())
                        {
                            inline+=sc.nextLine();
                        }
                        JSONParser parser = new JSONParser();
                        JSONArray arrJson = (JSONArray) parser.parse(inline);
                        
                        
                    //    JSONArray jArray = new JSONArray(inline);

                      //  JSONArray jsonArray = json.getJSONArray("locations");
                        System.out.println("\nJSON data in string format");
                        System.out.println(inline);
                        sc.close();
                        
                        this.save(arrJson);
                    }

         
         } catch (IOException ex) {
             Logger.getLogger(JSonParserTest.class.getName()).log(Level.SEVERE, null, ex);
         }
  

}
public int save(JSONArray inStringa) throws Exception {
   int status = 0;  
    try {
     //   String[] arrJsonString = inString;
        
      // Load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      //JSONParser parser=new JSONParser();

      // DB connection setup 
      SignIn BISCoinHomeObj1 = new SignIn();
       java.sql.Connection conn = BISCoinHomeObj1.sqlConnection();
    //  connect = (Connection) DriverManager.getConnection("jdbc:mysql://den1.mysql1.gear.host/biscoin" +"user=biscoin&password=BISLads2!");

      // PreparedStatements 
      String strTrunc  = "truncate tblcrypto";
      java.sql.PreparedStatement pst = conn.prepareStatement(strTrunc);
      pst.executeUpdate();
      //Object obj = parser.parse(new FileReader("c.\\itemize.json"));
     // code
     int i = 1;
     //JSONArray a = (JSONArray) inString();
      for (Object o : inStringa)
  {
       preparedStatement = (PreparedStatement) conn
          .prepareStatement("insert into tblcrypto(crypto_Id, crypto_Name, crypto_Price, crypto_perc1 , crypto_perc24 ,crypto_perc7,crypto_marketcap, crypto_btc, crypto_symbol) values (?, ?, ?, ?,? ,? ,?,?, ? )");
       
    JSONObject crypto = (JSONObject) o;

    String id = (String) crypto.get("id");
    i++;
    preparedStatement.setString(1, id);

    String name = (String) crypto.get("name");
    preparedStatement.setString(2, name);

    String price_eur = (String) crypto.get("price_eur");
    preparedStatement.setString(3, price_eur);
    
    String percent_change_1h = (String) crypto.get("percent_change_1h");
    preparedStatement.setString(4, percent_change_1h);
    
    String percent_change_24h = (String) crypto.get("percent_change_24h");
    preparedStatement.setString(5, percent_change_24h);
    
    String percent_change_7d = (String) crypto.get("percent_change_7d");
    preparedStatement.setString(6, percent_change_7d);
    
    String market_cap_euro = (String) crypto.get("market_cap_eur");
    preparedStatement.setString(7, market_cap_euro);
    
    String price_btc = (String) crypto.get("price_btc");
    preparedStatement.setString(8, percent_change_1h);
    
    String crypto_symbol = (String) crypto.get("symbol");
    preparedStatement.setString(9, crypto_symbol);

    status = preparedStatement.executeUpdate();
    //JSONArray cars = (JSONArray) crypto.get("cars");
  }
      
      // code
      /*
      JSONObject jsonObject = (JSONObject) obj;

      String pr = (String) jsonObject.get("Pr");
      // Parameters start with 1
      preparedStatement.setString(1, pr);

      String n = (String)  jsonObject.get("n");
      preparedStatement.setString(2, n);

      String yst = (String) jsonObject.get("yst");
      preparedStatement.setString(3, yst);

      String wh = (String)  jsonObject.get("wh");
      preparedStatement.setString(4, wh);

      status = preparedStatement.executeUpdate();
      ` */
    } catch (Exception e) {
      throw e;
    } finally {
      try {
          if (connect != null) {
             connect.close();
           }

         } catch (Exception e) {

         }
    }
    return status;
  }
    
}