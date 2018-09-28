package biscoin;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

public class DonnachaBio extends SignIn {
    
    public DonnachaBio(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
      GridPane layoutDonnachaBio = new GridPane();
      layoutDonnachaBio.setHgap(5);
      layoutDonnachaBio.setVgap(5);
      Scene donnachaBioScene = new Scene(layoutDonnachaBio, 1200, 800);
      window.setTitle("Donnacha Murphy Lead Programmer");
      
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
            
             ToolBar donnachaBioMainMenu = new ToolBar(
                    btnHome,
                    btnFAQGuides,
                    btnBuySell,
                    btnPortfolio,
                    btnAboutUs,
                  
                    menuSep,
                    menuBar
            );
            layoutDonnachaBio.add(donnachaBioMainMenu, 0, 0, 1200, 10);
            donnachaBioMainMenu.setStyle("-fx-background-color: #000000;");
            donnachaBioScene.getStylesheets().add("MainMenu.css");
            donnachaBioScene.getStylesheets().add("DonnachaBio.css");
            
            Text txtDonnachaHeading = new Text("Donnacha Murphy");
            txtDonnachaHeading.setId("txtDonnachaHeading");
            Text txtDonnachaTitle = new Text("Lead Designer");
            txtDonnachaTitle.setId("txtDonnachaTitle");
            
            VBox vboxHeadingDonnacha = new VBox(
                txtDonnachaHeading,
                txtDonnachaTitle
            );
            
            Image imgF3 = new Image("F3.gif", 200, 200, true, true);
            ImageView ivF3 = new ImageView(imgF3);
            VBox vboxImgViewFounder3 = new VBox(ivF3);
            vboxImgViewFounder3.setPadding(new Insets(-10, 12, 0, 520));
            HBox hboxHeadingDonnacha = new HBox(
                    vboxHeadingDonnacha,
                    vboxImgViewFounder3
            );
            
            Text txtDonnachaBio = new Text("I am the Lead Designer for BISCoin, "
             +"I have a passion for both programming and design and love when I "
                    + "get the opportunity for both passions to meet. \n\nI am a fan "
                    + "of clean and minimalistic design, functional yet aesthetically pleasing, "
                    + "I believe that every element on every page must serve a purpose not only in "
                    + "the operation of the application but also in the overall design scheme.\n\n "
                    + "I have previously worked on websites like AVIDModelling and my own website "
                    + "where I have honed my front and backend development skills.\n\n"
                    + "When I'm not programming and designing I enjoy gaming and playing piano or listening to music.");
            txtDonnachaBio.setWrappingWidth(700);
            txtDonnachaBio.setTextAlignment(TextAlignment.JUSTIFY);
            VBox vboxTxtDonnachaBio = new VBox(txtDonnachaBio);
            vboxTxtDonnachaBio.setPadding(new Insets(-100, 0, 0, 0)); 
           
            Text txtUsefulLinksDonnacha = new Text("Useful Links");
            txtUsefulLinksDonnacha.setId("txtUsefulLinksDonnacha");
            Hyperlink lnkAvid = new Hyperlink("• AvidModelling");
            lnkAvid.setId("lnkAvid");
            Hyperlink lnkDonnacha = new Hyperlink("• Donnacha's Website");
            lnkDonnacha.setId("lnkDonnacha");
           VBox vboxDonnachaLinks = new VBox(
                   txtUsefulLinksDonnacha,
                   lnkAvid,
                   lnkDonnacha
           );
           vboxDonnachaLinks.setPadding(new Insets(10, 0, 0, 0)); 
            
            //Outer Container
            VBox outerContDonnacha = new VBox(
                    hboxHeadingDonnacha,
                    vboxTxtDonnachaBio,
                    vboxDonnachaLinks
            );
            layoutDonnachaBio.add(outerContDonnacha, 20, 15);
            
            
            
            
            
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
            
          

            window.setScene(donnachaBioScene);
            window.show();
    }
}
