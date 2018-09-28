package biscoin;

import java.sql.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SignIn extends Application implements Runnable{
    
   
    
    @Override
    public void run() {
       try{
           js.getData();
       } catch(Exception e){
           System.out.println("Error: " + e);
       }
    }
    
    JSonParserTest js = new JSonParserTest();
    User userObj1 = new User();
    
    @Override
    public void start(Stage window){
            window.getIcons().add(new Image("BISCOIN_icon.png"));
            
            //OBJECTS
            RegisterUser regObj1 = new RegisterUser();
            ForgotPass forgotObj1 = new ForgotPass();
            LandingPage BISCoinHomeObj1 = new LandingPage();
            User findUser = new User();
            
            //DECLARE LAYOUT
            GridPane layoutSignIn = new GridPane();
            layoutSignIn.setVgap(5);
            layoutSignIn.setHgap(5);
            
            //DECLARE SIGN IN SCENE
            Scene signInScene = new Scene(layoutSignIn, 1200, 800, Color.WHITE);
            signInScene.getStylesheets().add("MainMenu.css");
            signInScene.getStylesheets().add("SignIn.css");
            window.setScene(signInScene);
            
            //IMPLEMENT OUR LOGO
            Image logoImage = new Image("BISCOIN_logo.png", 550, 550, true, true);
            ImageView logo = new ImageView();
            logo.setImage(logoImage);
            HBox hboxLogo = new HBox(logo);
            hboxLogo.setPadding(new Insets(0, 0, 0, 290));
            
            Label lblBISCoin = new Label("BISCoin");
            HBox hboxLabel = new HBox(lblBISCoin);
            hboxLabel.setPadding(new Insets(-100, 0, 0, 540));
            
            //Add Panels for Items
            // ------------------------------------
            
            // VBOX FOR OUR LOGO
            VBox panel1 = new VBox(
                    hboxLogo,
                    hboxLabel
            );
            panel1.setId("panel1");
            
            //ADD LOGO TO LAYOUT
            layoutSignIn.add(panel1, 0, 10, 241, 70);
            
            // ------------------------------------
            
            //PANEL FOR LOGIN SECTION
            Label loginHeader = new Label("Sign Into BISCoin");
            loginHeader.setId("loginhead");
           
            VBox panel2_header = new VBox(
                    loginHeader
            );
            
            panel2_header.setPadding(new Insets(10, 0, 5, 20));
            
            
            
            TextField txtEmail = new TextField();
            txtEmail.setMinWidth(300);
            txtEmail.setMaxWidth(300);
            txtEmail.setPromptText("Email Address");
            txtEmail.setId("txtEmail");
            
            PasswordField txtPassword = new PasswordField();
            txtPassword.setMinWidth(300);
            txtPassword.setMaxWidth(300);
            txtPassword.setPromptText("Password");
            txtPassword.setId("txtPassword");
            
            
            HBox panel2_email = new HBox(
                    txtEmail
            );
            
            
            HBox panel2_password = new HBox(
                    txtPassword
            );
            
            panel2_email.setPadding(new Insets(2, 0, 4, 20));
            panel2_password.setPadding(new Insets(4, 0, 10, 20));
            
            Hyperlink lnkForgot = new Hyperlink("Forgot Password?");
            lnkForgot.setId("lnkForgot");
            
            
            HBox panel2_Forgot = new HBox(
                    lnkForgot
            );
            panel2_Forgot.setPadding(new Insets(0, 90, 0, 0));
            
            Button btnSignIn = new Button("Sign In");
            btnSignIn.setId("btnSignIn");
            HBox panel2_SignIn = new HBox(
                    btnSignIn
            );
            
            HBox panel2_SignInForgot = new HBox(
                    panel2_Forgot,
                    panel2_SignIn
            );
            
            panel2_SignInForgot.setPadding(new Insets(5, 0, 0, 15));
            
            VBox panel2 = new VBox(
                    panel2_header,
                    panel2_email,
                    panel2_password,
                    panel2_SignInForgot
            );
            
            panel2.setId("panel2");
            
            layoutSignIn.add(panel2, 34, 95, 80, 50);
            
            // ------------------------------------
            
            Text panel3_lblHeader = new Text("With this account you can");
            panel3_lblHeader.setId("panel3_lblHeader");
            
            VBox panel3_Header = new VBox(
                    panel3_lblHeader
            );
            
            panel3_Header.setPadding(new Insets(10, 0, 1, 0));
            
            Text List_Learn = new Text("•  Learn about how cryptocurrecies work");
            List_Learn.setStyle("-fx-font-weight: lighter");
            Text List_Track = new Text("•  Track a number of cryptocurrencies");
            List_Track.setStyle("-fx-font-weight: lighter");
            Text List_Exchange = new Text("•  Buy and Sell Cryptocurrencies on our Exchange");
            List_Exchange.setStyle("-fx-font-weight: lighter");
            Text List_Portfolio = new Text("•  View and Manage your portfolio");
            List_Portfolio.setStyle("-fx-font-weight: lighter");
            
            VBox panel3_List = new VBox(
                    List_Learn,
                    List_Track,
                    List_Exchange,
                    List_Portfolio
            );
            panel3_List.setId("panel3_List");
            
            panel3_List.setPadding(new Insets(5, 0, 5, 5));
            
            Hyperlink lnkRegistration = new Hyperlink("Not a Member? Register Now");
            lnkRegistration.setId("lnkRegistration");
            
            VBox panel3_Registration = new VBox(
                    lnkRegistration
            );
            panel3_Registration.setPadding(new Insets(5, 0, 1, 0));
            
            
            VBox panel3 = new VBox(
                    panel3_Header,
                    panel3_List,
                    panel3_Registration
            );
            panel3.setPadding(new Insets(0, 10, 0, 20));
            panel3.setId("panel3");
            
            layoutSignIn.add(panel3, 113, 95, 80, 50);
            
            // ------------------------------------
            
            
            
            
            window.setTitle("Sign In");
  
            
            //Buttons to link to other pages
            
            lnkRegistration.setOnAction(e -> {
                regObj1.start(window);
            });
            
            lnkForgot.setOnAction(e -> {
                forgotObj1.start(window);
            });
            
            logo.setOnMouseClicked(e -> {
                window.setScene(signInScene);
                window.setTitle("Homepage");
            });
            
            
            
            btnSignIn.setOnAction(e -> {
                
                String strTxtUsername = txtEmail.getText();
                String strTxtPassword = txtPassword.getText();
                User.setUser_Email(strTxtUsername);
                String strUser = User.getUser_Email();
                String strPass = User.getUser_Password();
                
                //Sign in Code - It checks that the username and password match database records
                if(!"".equals(strTxtUsername) && !"".equals(strTxtPassword) && !"".equals(strUser) && !"".equals(strPass) && strTxtUsername.equals(strUser) && strTxtPassword.equals(strPass)){
                    BISCoinHomeObj1.start(window);
                    System.out.println("true");
                } else {
                    System.out.println("false");
                    txtEmail.clear();
                    txtPassword.clear();
                    txtEmail.requestFocus();
                }
            });
            
            
            window.setResizable(false);
            window.setScene(signInScene);
            window.show();

        }
        
    
    //DATA ACCESS LAYER (CONNECTION TO HOSTED DATABASE)
    public static Connection sqlConnection(){
        final String USERNAME = "biscoin";
        final String PASSWORD = "BISLads2!";
        final String CONN_STRING = "jdbc:mysql://den1.mysql1.gear.host/biscoin";
        
        Connection conn = null;
        
        try{
            //ESTABLISH SQL CONNECTION
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Database connection established");
        }
        catch(SQLException ex){
            //PRINT OUT ERROR/EXCEPTION TO THE CONSOLE
            System.err.println(ex);
        }
        return conn;
    }
    
    
    public static void main(String[] args) {    
        //START OTHER THREAD TO LOAD UP SQL OPERATIONS
        Thread t1 = new Thread(new SignIn());
        t1.start();
        //START MAIN PROGRAM THREAD
        launch(args);
    }    
}

