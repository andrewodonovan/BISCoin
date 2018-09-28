package biscoin;

import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterUser extends SignIn{
    
    public RegisterUser(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
        GridPane layoutReg = new GridPane();
        layoutReg.setVgap(2);
        layoutReg.setHgap(2);
        
        Scene regScene = new Scene(layoutReg, 1180, 800, Color.WHITE);
        regScene.getStylesheets().add("MainMenu.css");
        regScene.getStylesheets().add("RegisterUser.css");
        window.setScene(regScene);
        
        SignIn signInObj1 = new SignIn();
        
        //Start of Form
       
        //Register An Acoount Now Label
        Text txtRegAccount = new Text("Register an Account Now");
        txtRegAccount.setId("txtRegAccount");
        
        VBox regAccountHeader = new VBox(
                txtRegAccount
        );
        regAccountHeader.setId("regAccountHeader");
        regAccountHeader.setPadding(new Insets(20, 0, 20, 310));
        
         //Title
        ComboBox cmbTitle = new ComboBox();
            cmbTitle.getItems().addAll(
                "Mr. ",
                "Mrs. ",
                "Ms. ",
                "Prof. ",
                "Dr. ",
                "Col. "
            );
            
            cmbTitle.getSelectionModel().selectFirst();

        //Name
        Label lblName = new Label("Legal Name:");
        lblName.setId("lblName");
        lblName.setPadding(new Insets(0, 78, 2, 80));
        
        Label lblFirst = new Label("First Name");
        lblFirst.setPadding(new Insets(0, 70, 2, 60));
        Label lblLast = new Label("Last Name");
        lblLast.setPadding(new Insets(0, 0, 2, 65));
        
        HBox hboxLabelName = new HBox(
                lblFirst,
                lblLast
        );
        hboxLabelName.setPadding(new Insets(2, 0, 0, 410));
        hboxLabelName.setId("hboxLabelName");
        
        TextField txtFirstName = new TextField();
        txtFirstName.setPromptText("First Name");
        txtFirstName.setId("txtFirstName");
        TextField txtLastName = new TextField();
        txtLastName.setPromptText("Last Name");
        txtLastName.setId("txtFirstName");
        
        //Container for Name Fields
        HBox hboxName = new HBox(
                lblName,
                cmbTitle,
                txtFirstName,
                txtLastName
        );
        hboxName.setPadding(new Insets(5, 0, 10, 140));
        
        
        
        //Date of Birth
        
        Label lblMonth = new Label("Month");
        lblMonth.setPadding(new Insets(2, 0, 0, 0));
        
        Label lblDay = new Label("Day");
        lblDay.setPadding(new Insets(2, 0, 0, 45));
        
        Label lblYear = new Label("Year");
        lblYear.setPadding(new Insets(2, 0, 0, 50));
        
        HBox hboxLabelDOB = new HBox(
                lblMonth,
                lblDay,
                lblYear
        );
        hboxLabelDOB.setPadding(new Insets(2, 0, 0, 384));
        hboxLabelDOB.setId("hboxLabelName");
        
        
        Label lblDOB = new Label("Date of Birth:");
        lblName.setId("lblDOB");
        lblDOB.setPadding(new Insets(0, 77, 2, 0));
        
        ComboBox DOBDD = new ComboBox();
          
            
            ComboBox DOBMMM = new ComboBox();
            DOBMMM.getItems().addAll(
                "01",
                "02",
                "03",
                "04",
                "05",
                "06",
                "07",
                "08",     
                "09",
                "10",
                "11",
                "12"
            );
            
            DOBMMM.getSelectionModel().selectFirst();

            String comboBoxVal = (String) DOBMMM.getSelectionModel().getSelectedItem();
            
            if(comboBoxVal.equals("01") || comboBoxVal.equals("03") || comboBoxVal.equals("05") || comboBoxVal.equals("07") || comboBoxVal.equals("08") || comboBoxVal.equals("10") || comboBoxVal.equals("12")){
                DOBDD.getItems().addAll(
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23",
                    "24",
                    "25",
                    "26",
                    "27",
                    "28",
                    "29",
                    "30",
                    "31"
                );
            }
            else if(comboBoxVal.equals("04") || comboBoxVal.equals("06") || comboBoxVal.equals("09") || comboBoxVal.equals("11")){
                 DOBDD.getItems().addAll(
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23",
                    "24",
                    "25",
                    "26",
                    "27",
                    "28",
                    "29",
                    "30"
                );
            }
            else{
                 DOBDD.getItems().addAll(
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23",
                    "24",
                    "25",
                    "26",
                    "27",
                    "28"
                );
            }
            
            DOBMMM.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldMonth, String changedMonth) {
                //Clear combobox
                DOBDD.getItems().clear();
                        
                if(changedMonth.equals("01") || changedMonth.equals("03") || changedMonth.equals("05") || changedMonth.equals("07") || changedMonth.equals("08") || changedMonth.equals("10") || changedMonth.equals("12")){
                  DOBDD.getItems().addAll(
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23",
                    "24",
                    "25",
                    "26",
                    "27",
                    "28",
                    "29",
                    "30",
                    "31"
                );
            }
            else if(changedMonth.equals("04") || changedMonth.equals("06") || changedMonth.equals("09") || changedMonth.equals("11")){
                   DOBDD.getItems().addAll(
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23",
                    "24",
                    "25",
                    "26",
                    "27",
                    "28",
                    "29",
                    "30"
                );
            }
            else{
                  DOBDD.getItems().addAll(
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23",
                    "24",
                    "25",
                    "26",
                    "27",
                    "28"
                );
            }
            DOBDD.getSelectionModel().selectFirst();
            }    
            });

    
            DOBDD.getSelectionModel().selectFirst();
            
            ComboBox DOBYYYY = new ComboBox();
            for(int i=2000; i>1899; i=i-1){
              DOBYYYY.getItems().add(i);
            }
            
            DOBYYYY.getSelectionModel().selectFirst();
            
        HBox hboxDOB = new HBox(
           lblDOB,
           DOBMMM,
           DOBDD,
           DOBYYYY
        );
        hboxDOB.setId("hboxDOB");
        hboxDOB.setPadding(new Insets(5, 0, 7, 220));
        
        Label lblGender = new Label("Gender:");
        lblGender.setPadding(new Insets(0, 106, 2, 0));
        ComboBox cmbGender= new ComboBox();
            cmbGender.getItems().addAll(
                "Male",
                "Female",
                "Prefer Not To Say",
                "Other"
            );
            cmbGender.getSelectionModel().selectFirst();
            
        HBox hboxGender = new HBox(
             lblGender,
             cmbGender
        );
        hboxGender.setPadding(new Insets(5, 0, 7, 220));
        
        //Address Line 1
        Label lblAdd1 = new Label("Address Line 1:");
        lblAdd1.setPadding(new Insets(0, 58, 2, 0));
        TextField txtAdd1 = new TextField();
         txtAdd1.setPromptText("Address Line 1");
        HBox hboxAdd1 = new HBox(
                lblAdd1,
                txtAdd1
        );
        hboxAdd1.setPadding(new Insets(5, 0, 7, 220));
        
        //Address Line 2
        Label lblAdd2 = new Label("Address Line 2:");
        lblAdd2.setPadding(new Insets(0, 55, 2, 0));
        TextField txtAdd2 = new TextField();
         txtAdd2.setPromptText("Address Line 2");
        HBox hboxAdd2 = new HBox(
                lblAdd2,
                txtAdd2
        );
        hboxAdd2.setPadding(new Insets(5, 0, 7, 220));
        
        //City
        Label lblCity = new Label("City/Town:");
        lblCity.setPadding(new Insets(0, 89, 2, 0));
        TextField txtCity = new TextField();
        txtCity.setPromptText("City");
        HBox hboxCity = new HBox(
                lblCity,
                txtCity
        );
        hboxCity.setPadding(new Insets(5, 0, 7, 220));
        
        //County
        Label lblCounty = new Label("County:");
        lblCounty.setPadding(new Insets(0, 107, 2, 0));
        ComboBox cmbCounty = new ComboBox();
            cmbCounty.getItems().addAll(
               "Carlow",
               "Cavan",
               "Clare",
               "Cork",
               "Donegal",
               "Dublin",
               "Galway",
               "Kerry",
               "Kildare",
               "Kilkenny",
               "Laois",
               "Leitrim",
               "Limerick",
               "Longford",
               "Louth",
               "Mayo",
               "Meath",
               "Monaghan",
               "Offaly",
               "Roscommon",
               "Sligo",
               "Tipperary",
               "Waterford",
               "Westmeath",
               "Wexford",
               "Wicklow"
            );
            cmbCounty.getSelectionModel().selectFirst();
            
        HBox hboxCounty = new HBox(
                lblCounty,
                cmbCounty
        );
        hboxCounty.setPadding(new Insets(5, 0, 7, 220));
        
        //Postcode
        Label lblPostcode = new Label("Postcode:");
        lblPostcode.setPadding(new Insets(0, 91, 2, 0));
        
        TextField txtPostcode = new TextField();
         txtPostcode.setPromptText("L## LL##");
        HBox hboxPostcode = new HBox(
                lblPostcode,
                txtPostcode
        );
        hboxPostcode.setPadding(new Insets(5, 0, 7, 220));
        
        
        //Country(Ireland)
        Label lblCountry = new Label("Country:");
        lblCountry.setPadding(new Insets(0, 104, 2, 0));
        
        Label lblIre = new Label("Rep. of Ireland");
        
        HBox hboxCountry = new HBox(
                lblCountry,
                lblIre
        );
        hboxCountry.setPadding(new Insets(5, 0, 7, 220));
        
        
        
        //Pass all HBoxs to this Address VBox
        
        VBox vboxAddress = new VBox(
                hboxAdd1,
                hboxAdd2,
                hboxCity,
                hboxCounty,
                hboxPostcode,
                hboxCountry
        );
        vboxAddress.setPadding(new Insets(7, 0, 7, 0));
        vboxAddress.setId("vboxAddress");
        
        Label lblEmail = new Label("Email Address:");
        lblEmail.setPadding(new Insets(0, 63, 2, 0));
        
        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Email Address");
        HBox hboxEmail = new HBox(
                lblEmail,
                txtEmail
        );
        hboxEmail.setPadding(new Insets(5, 0, 7, 220));
        
        
        Label lblPassword = new Label("Password:");
        lblPassword.setPadding(new Insets(0, 89, 2, 0));
        
        PasswordField pssPassword = new PasswordField();
         pssPassword.setPromptText("Password");
        
        HBox hboxPassword = new HBox(
                lblPassword,
                pssPassword
        );
        hboxPassword.setPadding(new Insets(5, 0, 7, 220));
        
        Label lblPasswordConf = new Label("Confirm Password:");
        lblPasswordConf.setPadding(new Insets(0, 33, 2, 0));
        PasswordField pssPasswordConf = new PasswordField();
        pssPasswordConf.setPromptText("Confirm Password");
        
        HBox hboxPasswordConf = new HBox(
                lblPasswordConf,
                pssPasswordConf
        );
        hboxPasswordConf.setPadding(new Insets(5, 0, 7, 220));
        
        VBox vboxEmailPass = new VBox(
                hboxEmail,
                hboxPassword,
                hboxPasswordConf
        );
        vboxEmailPass.setPadding(new Insets(7, 0, 7, 0));
        
        
        Button btnReg = new Button("Register");
        btnReg.setPadding(new Insets(10, 33, 10, 33));
        HBox hboxBtnReg = new HBox(
           btnReg
        );
        hboxBtnReg.setPadding(new Insets(0, 10, 0, 0));
        
        Button btnBack = new Button("Back");
        btnBack.setPadding(new Insets(10, 33, 10, 33));
        HBox hboxBtnBack = new HBox(
          btnBack
        );
        
        HBox hboxButtons = new HBox(
                hboxBtnReg,
                hboxBtnBack
        );
        hboxButtons.setPadding(new Insets(0, 0, 0, 200));
  
        //VERY IMPORTANT CODE
        //This is where the SQL code is
        btnReg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    
                    String strFirstName = txtFirstName.getText();
                    String strLastName = txtLastName.getText();
                    String strDOBDD = DOBDD.getValue().toString();
                    String strDOBMMM = DOBMMM.getValue().toString();
                    String strDOBYYYY = DOBYYYY.getValue().toString();
                    String FullDOB = strDOBDD + "/" + strDOBMMM + "/" + strDOBYYYY;
                    
                    Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(FullDOB);
                    
                    java.sql.Date sqlDOB = new java.sql.Date(date1.getTime());
                    
                    String strGender = (String) cmbGender.getValue();
                    String strAdd1 = txtAdd1.getText();
                    String strAdd2 = txtAdd2.getText();
                    String strCity = txtCity.getText();
                    String strCounty = (String) cmbCounty.getValue();
                    String strPostcode = txtPostcode.getText();
                    String strCountry = "Ireland";
                    String strEmail = txtEmail.getText();
                    String strPassword = pssPassword.getText();
                    
                    Connection conn = signInObj1.sqlConnection();
                    
                    String sqlReg = "INSERT INTO tblUser(user_fName, user_lName, user_DOB, user_Gender, user_Add1, user_Add2, user_City, user_County, user_Postcode, user_Country, user_Email, user_Password)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    PreparedStatement pst = conn.prepareStatement(sqlReg);
                    
                    pst.setString(1, strFirstName);
                    pst.setString(2, strLastName);
                    pst.setDate(3, sqlDOB);
                    pst.setString(4, strGender);
                    pst.setString(5, strAdd1);
                    pst.setString(6, strAdd2);
                    pst.setString(7, strCity);
                    pst.setString(8, strCounty);
                    pst.setString(9, strPostcode);
                    pst.setString(10, strCountry);
                    pst.setString(11, strEmail);
                    pst.setString(12, strPassword);
                    
                    pst.executeUpdate();
                    
                    signInObj1.start(window);
                    
                } catch (SQLException | ParseException ex) {
                    Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnBack.setOnAction(e -> {
            txtFirstName.clear();
            txtLastName.clear();
            txtAdd1.clear();
            txtAdd2.clear();
            txtCity.clear();
            txtPostcode.clear();
            txtEmail.clear();
            pssPassword.clear();
            pssPasswordConf.clear();
            signInObj1.start(window);
            
            
        });
        
        //Outer Container
        VBox outerContainer  = new VBox(
                regAccountHeader,
                hboxLabelName,
                hboxName,
                hboxLabelDOB,
                hboxDOB,
                hboxGender,
                vboxAddress,
                vboxEmailPass,
                hboxButtons
        );
        
        outerContainer.setId("outerContReg");
        layoutReg.add(outerContainer, 45, 5, 500, 60);
        
            window.setTitle("Register User");
            window.show();
    }
}