package biscoin;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AndrewBio extends SignIn {
    
    public AndrewBio(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
      GridPane layoutAndrewBio = new GridPane();
      layoutAndrewBio.setHgap(5);
      layoutAndrewBio.setVgap(5);
      Scene andrewBioScene = new Scene(layoutAndrewBio, 1200, 800);
      window.setTitle("Andrew O' Donovan Lead Designer");
      
            Exchange exchangeObj1 = new Exchange();
            LandingPage BISCoinHomeObj1 = new LandingPage();
            AboutUs aboutUsObj1 = new AboutUs();
            ContactUs contactUsObj1 = new ContactUs();
            Portfolio portfolioObj1 = new Portfolio();
            FAQ faqObj1 = new FAQ();
            MainMenu mainMenuObj1 = new MainMenu();
           
            Button btnHome = mainMenuObj1.getBtnHome();
            Button btnFAQGuides = mainMenuObj1.getBtnFAQGuides();
            Button btnBuySell = mainMenuObj1.getBtnBuySell();
            Button btnPortfolio = mainMenuObj1.getBtnPortfolio();
            Button btnAboutUs = mainMenuObj1.getBtnAboutUs();
          
            Separator menuSep = mainMenuObj1.getSep();
            MenuBar menuBar = mainMenuObj1.getMenuBar();
            
             ToolBar andrewBioMainMenu = new ToolBar(
                    btnHome,
                    btnFAQGuides,
                    btnBuySell,
                    btnPortfolio,
                    btnAboutUs,
         
                    menuSep,
                    menuBar
            );
            layoutAndrewBio.add(andrewBioMainMenu, 0, 0, 1200, 10);
            andrewBioMainMenu.setStyle("-fx-background-color: #000000;");
            andrewBioScene.getStylesheets().add("MainMenu.css");
            andrewBioScene.getStylesheets().add("AndrewBio.css");
            
            Text txtAndrewHeading = new Text("Andrew O' Donovan");
            txtAndrewHeading.setId("txtAndrewHeading");
            Text txtAndrewTitle = new Text("Lead Designer");
            txtAndrewTitle.setId("txtAndrewTitle");
            
            VBox vboxHeadingAndrew = new VBox(
                txtAndrewHeading,
                txtAndrewTitle
            );
            
            Image imgF2 = new Image("F2.gif", 200, 200, true, true);
            ImageView ivF2 = new ImageView(imgF2);
            VBox vboxImgViewFounder2 = new VBox(ivF2);
            vboxImgViewFounder2.setPadding(new Insets(-10, 12, 0, 510));
            HBox hboxHeadingAndrew = new HBox(
                    vboxHeadingAndrew,
                    vboxImgViewFounder2
            );
            
            Text txtAndrewBio = new Text("I am the Lead Designer for BISCoin, "
             +"I have a passion for both programming and design and love when I "
                    + "get the opportunity for both passions to meet. \n\nI am a fan "
                    + "of clean and minimalistic design, functional yet aesthetically pleasing, "
                    + "I believe that every element on every page must serve a purpose not only in "
                    + "the operation of the application but also in the overall design scheme.\n\n "
                    + "I have previously worked on websites like");
            
            txtAndrewBio.setWrappingWidth(700);
            txtAndrewBio.setTextAlignment(TextAlignment.JUSTIFY);
            HBox hboxTxtAndrewBio = new HBox(txtAndrewBio);
            hboxTxtAndrewBio.setPadding(new Insets(-100, 0, 0, 0)); 
           
            
            
            //Outer Container
            VBox outerContAndrew = new VBox(
                    hboxHeadingAndrew,
                    hboxTxtAndrewBio
            );
            layoutAndrewBio.add(outerContAndrew, 20, 15);
            
            
            
            
            
             btnAboutUs.setOnAction(e -> {
                aboutUsObj1.start(window);
            });
            
            btnHome.setOnAction(e -> {
                BISCoinHomeObj1.start(window);
            });
            
            btnFAQGuides.setOnAction(e -> {
                faqObj1.start(window);
            });
            
            btnBuySell.setOnAction(e -> {
                exchangeObj1.start(window);
            });
            
            btnPortfolio.setOnAction(e -> {
                portfolioObj1.start(window);
            });
            

            
            
            
            
            
            window.setScene(andrewBioScene);
            window.show();
    }
    
}
