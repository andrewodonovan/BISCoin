package biscoin;

import java.sql.*;

public class User {
    public static String user_fName;
    public static String user_lName;
    public static String user_DOB;
    public static String user_Gender;
    public static String user_Add1;
    public static String user_Add2;
    public static String user_City;
    public static String user_County;
    public static String user_Postcode;
    public static String user_Email;
    public static String user_Pass;
    
    //Objects
    SignIn signInObj1 = new SignIn();
    
    public User(){
        //Constructor
    }
    
    //ALL USER INFO RETRIEVED FROM DATABASE HERE
    public static void retrieveUserInfo(){
        String sqlUserInfo = "SELECT * FROM tbluser WHERE user_Email = '" + user_Email + "'";
        try{
            Connection c = SignIn.sqlConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sqlUserInfo);
            
            while(rs.next()){
                user_fName = rs.getString("user_fName");
                setUser_fName("user_fName");
                user_lName = rs.getString("user_lName");
                setUser_lName("user_lName");
                user_DOB = rs.getString("user_DOB");
                setUser_DOB("user_DOB");
                user_Gender = rs.getString("user_Gender");
                setUser_Gender("user_Gender");
                user_Add1 = rs.getString("user_Add1");
                setUser_Add1("user_Add1");
                user_Add2 = rs.getString("user_Add2");
                setUser_Add2("user_Add2");
                user_City = rs.getString("user_City");
                setUser_City("user_City");
                user_County = rs.getString("user_County");
                setUser_County("user_County");
                user_Postcode = rs.getString("user_Postcode");
                setUser_Postcode("user_Postcode");
                user_Email = rs.getString("user_Email");
                setUser_Email("user_Email");
                user_Pass = rs.getString("user_Pass");
                setUser_Password("user_Pass");
            }
        } catch(SQLException ex) {
            System.err.println((ex));
        }
        
    }
   //SETTER FOR USERS FIRST NAME
   public static void setUser_fName(String fname){
       user_fName = fname;
   }
   
   //GETTER FOR USERS FIRST NAME
   public static String getUser_fName(){
       return user_fName;
   }
   
   //SETTER FOR USERS LAST NAME
   public static void setUser_lName(String lname){
       user_lName = lname;
   }
   
   //GETTER FOR USERS LAST NAME
   public static String getUser_lName(){
       return user_lName;
   }
   
   //SETTER FOR USERS DATE OF BIRTH
   public static void setUser_DOB(String dob){
       user_DOB = dob;
   }
   
   //GETTER FOR USERS DOB
   public static String getUser_DOB(){
       return user_DOB;
   }
   
   //SETTER FOR USERS GENDER
   public static void setUser_Gender(String gender){
       user_Gender = gender;
   }
   
   //GETTER FOR USERS GENDER
   public static String getUser_Gender(){
       return user_Gender;
   }
   
   //SETTER FOR USERS ADDRRESS LINE 1
   public static void setUser_Add1(String add1){
       user_Add1 = add1;
   }
   
   //GETTER FOR USERS ADDRESS LINE 1
   public static String getUser_Add1(){
       return user_Add1;
   }
   
   //SETTER FOR USERS ADDRRESS LINE 2
   public static void setUser_Add2(String add2){
       user_Add2 = add2;
   }
   
   //GETTER FOR USERS ADDRRESS LINE 2
   public static String getUser_Add2(){
       return user_Add2;
   }
   
    //SETTER FOR USERS CITY
   public static void setUser_City(String city){
       user_City = city;
   }
   
   //GETTER FOR USERS CITY
   public static String getUser_City(){
       return user_City;
   }
   
   //SETTER FOR USERS COUNTY
   public static void setUser_County(String county){
       user_County = county;
   }
   
   //GETTER FOR USERS COUNTY
   public static String getUser_County(){
       return user_County;
   }
   
   //SETTER FOR USERS POSTCODE
   public static void setUser_Postcode(String postcode){
       user_Postcode = postcode;
   }
   
   //GETTER FOR USERS POSTCODE
   public static String getUser_Postcode(){
       return user_Postcode;
   }
   
   //SETTER FOR USERS EMAIL
   public static void setUser_Email(String email){
       user_Email = email;
   }
   
   //GETTER FOR USERS EMAIL
   public static String getUser_Email(){
       return user_Email;
   }
   
   //SETTER FOR USERS PASSWORD
   public static void setUser_Password(String pass){
       user_Pass = pass;
   }
   
   //GETTER FOR USERS PASSWORD
   public static String getUser_Password(){
       return user_Pass;
   }
   
}
