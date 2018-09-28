package biscoin;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPass extends SignIn {
    public ForgotPass(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
        GridPane layoutForgotPass = new GridPane();
        layoutForgotPass.setVgap(2);
        layoutForgotPass.setHgap(2);
        
        Scene forgotPassScene = new Scene(layoutForgotPass, 1200, 800, Color.WHITE);
        forgotPassScene.getStylesheets().add("MainMenu.css");
        forgotPassScene.getStylesheets().add("ForgotPass.css");
        window.setScene(forgotPassScene);
        
        SignIn signInObj1 = new SignIn();
        
        //Start of Form
                
        //Register An Acoount Now Label
        Text txtForgotPass = new Text("Forgot Your Password?");
        txtForgotPass.setId("txtForgotPass");
        
        VBox forgotPassHeader = new VBox(
                txtForgotPass
        );
        forgotPassHeader.setId("forgotPassHeader");
        forgotPassHeader.setPadding(new Insets(50, 0, 30, 395));
        
        //Name
       
        TextField txtName = new TextField();
        txtName.setPromptText("Legal Name");
        
        HBox hboxName = new HBox(
                txtName
        );
        hboxName.setPadding(new Insets(8, 0, 10, 400));
       
        TextField txtEmailAddr = new TextField();
        txtEmailAddr.setPromptText("Email Address");
        
        HBox hboxEmail = new HBox(
                txtEmailAddr
        );
        hboxEmail.setPadding(new Insets(8, 0, 10, 400));
        
        //Password
        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Password");
        
        HBox hboxPass = new HBox(
                txtPass
        );
        hboxPass.setPadding(new Insets(8, 0, 10, 400));
        
        //Confirm Password
      
        PasswordField txtPassConf = new PasswordField();
        txtPassConf.setPromptText("Password Confirmation");
        
        Label lblPassConfWarn = new Label("Passwords don't match");
        lblPassConfWarn.setPadding(new Insets(0, 20, 2, 0));
        
        HBox hboxPassConf = new HBox(
                txtPassConf,
                lblPassConfWarn
        );
        hboxPassConf.setPadding(new Insets(8, 0, 10, 400));
        lblPassConfWarn.setVisible(false);
        
        Button btnSetNewPass = new Button("Set New Password");
        btnSetNewPass.setPadding(new Insets(10, 37, 10, 37));
        HBox hboxBtnSetNewPass = new HBox(
           btnSetNewPass
        );
       
                
               
              
        btnSetNewPass.setOnAction(e -> {
               
            try {
                String strTxtName = txtName.getText();
                String strTxtEmailAddr = txtEmailAddr.getText();
                String strTxtPass = txtPass.getText();
                String strTxtPassConf = txtPassConf.getText();
                String strName;
                String strEmailAddr;
                String strPass;
                
                Connection conn = LandingPage.sqlConnection();
                String strSQLGetInfo = "SELECT user_fName, user_lName, user_Email, user_Password FROM tbluser WHERE user_Email = '" + strTxtEmailAddr + "';";
                
                String strSQLForgot = "UPDATE tbluser SET user_Password = '" + strTxtPass + "' WHERE EXISTS (SELECT * FROM (SELECT user_Password FROM tbluser WHERE user_Email = '" + strTxtEmailAddr + "') AS users WHERE user_Email = '" + strTxtEmailAddr + "')";
                
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(strSQLGetInfo);
                while(rs.next()){
                    strName = rs.getString("user_fName") + " " + rs.getString("user_lName");
                    strEmailAddr = rs.getString("user_Email");
                    strPass = rs.getString("user_Password");
                   
                    //if(txtName.getText() != null && txtEmailAddr.getText() != null && txtPass.getText() != null && txtPassConf.getText() != null  && strName.equals(strTxtName) && strEmailAddr.equals(strTxtEmailAddr) && strPass.equals(strTxtPass) && strTxtPass.equals(strTxtPassConf)){
                    
                        PreparedStatement pst = conn.prepareStatement(strSQLForgot);
                        pst.executeUpdate();
                        conn.close();
                        signInObj1.start(window);
                       /* System.out.println("True");
                    } else{
                        lblPassConfWarn.setVisible(true);
                        txtName.clear();
                        txtEmailAddr.clear();
                        txtPass.clear();
                        txtPassConf.clear();
                        txtName.requestFocus();
                    }*/
                } 
                } catch(SQLException ex){
                    System.out.println("Error: " + ex);
                }
                });
                
                //Pass all other hboes and vboxes here
                VBox outerContForgot = new VBox(
                        forgotPassHeader,
                        hboxName,
                        hboxEmail,
                        hboxPass,
                        hboxPassConf,
                        hboxBtnSetNewPass
                );
                
                outerContForgot.setId("outerContForgot");
                layoutForgotPass.add(outerContForgot, 30, 45, 500, 60);
                
                window.setTitle("Forgot Password");
                window.show();
            
    }
}
