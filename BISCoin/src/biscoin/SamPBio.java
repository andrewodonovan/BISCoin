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

public class SamPBio extends SignIn {
    
    public SamPBio(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
      GridPane layoutSamPBio = new GridPane();
      layoutSamPBio.setHgap(5);
      layoutSamPBio.setVgap(5);
      Scene samPBioScene = new Scene(layoutSamPBio, 1200, 800);
      window.setTitle("Samuel Punch");
      
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
            
             ToolBar samPBioMainMenu = new ToolBar(
                    btnHome,
                    btnFAQGuides,
                    btnBuySell,
                    btnPortfolio,
                    btnAboutUs,
                    menuSep,
                    menuBar
            );
            layoutSamPBio.add(samPBioMainMenu, 0, 0, 1200, 10);
            samPBioMainMenu.setStyle("-fx-background-color: #000000;");
            
            samPBioScene.getStylesheets().add("MainMenu.css");
            samPBioScene.getStylesheets().add("SamPBio.css");
            
            Text txtSamPHeading = new Text("Samuel Punch");
            txtSamPHeading.setId("txtSamPHeading");
            Text txtSamPTitle = new Text("Lead Designer");
            txtSamPTitle.setId("txtSamPTitle");
            
            VBox vboxHeadingSamP = new VBox(
                txtSamPHeading,
                txtSamPTitle
            );
            
            Image imgF5 = new Image("F5.gif", 200, 200, true, true);
            ImageView ivF5 = new ImageView(imgF5);
            VBox vboxImgViewFounder5 = new VBox(ivF5);
            vboxImgViewFounder5.setPadding(new Insets(-10, 12, 0, 580));
            HBox hboxHeadingSamP = new HBox(
                    vboxHeadingSamP,
                    vboxImgViewFounder5
            );
            
            Text txtSamPBio = new Text("I am the Lead Designer for BISCoin, "
             +"I have a passion for both programming and design and love when I "
                    + "get the opportunity for both passions to meet. \n\nI am a fan "
                    + "of clean and minimalistic design, functional yet aesthetically pleasing, "
                    + "I believe that every element on every page must serve a purpose not only in "
                    + "the operation of the application but also in the overall design scheme.\n\n "
                    + "I have previously worked on websites like AVIDModelling and my own website "
                    + "where I have honed my front and backend development skills.\n\n"
                    + "When I'm not programming and designing I enjoy gaming and playing piano or listening to music.");
            txtSamPBio.setWrappingWidth(700);
            txtSamPBio.setTextAlignment(TextAlignment.JUSTIFY);
            VBox vboxTxtSamPBio = new VBox(txtSamPBio);
            vboxTxtSamPBio.setPadding(new Insets(-100, 0, 0, 0)); 
           
            Text txtUsefulLinksSamP = new Text("Useful Links");
            txtUsefulLinksSamP.setId("txtUsefulLinksSamP");
            Hyperlink lnkAvid = new Hyperlink("• AvidModelling");
            lnkAvid.setId("lnkAvid");
            Hyperlink lnkSamP = new Hyperlink("• SamP's Website");
            lnkSamP.setId("lnkSamP");
           VBox vboxSamPLinks = new VBox(
                   txtUsefulLinksSamP,
                   lnkAvid,
                   lnkSamP
           );
           vboxSamPLinks.setPadding(new Insets(10, 0, 0, 0)); 
            
            //Outer Container
            VBox outerContSamP = new VBox(
                    hboxHeadingSamP,
                    vboxTxtSamPBio,
                    vboxSamPLinks
            );
            layoutSamPBio.add(outerContSamP, 20, 15);
            
            
            
            
            
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
            
            
            window.setScene(samPBioScene);
            window.show();
    }
    
}
