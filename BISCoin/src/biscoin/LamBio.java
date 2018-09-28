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

public class LamBio extends SignIn {
    
    public LamBio(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
      GridPane layoutLamBio = new GridPane();
      layoutLamBio.setHgap(5);
      layoutLamBio.setVgap(5);
      Scene lamBioScene = new Scene(layoutLamBio, 1200, 800);
      window.setTitle("Lâm Hoáng");
      
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
            
             ToolBar lamBioMainMenu = new ToolBar(
                    btnHome,
                    btnFAQGuides,
                    btnBuySell,
                    btnPortfolio,
                    btnAboutUs,
                    menuSep,
                    menuBar
            );
            layoutLamBio.add(lamBioMainMenu, 0, 0, 1200, 10);
            lamBioMainMenu.setStyle("-fx-background-color: #000000;");
            
            lamBioScene.getStylesheets().add("MainMenu.css");
            lamBioScene.getStylesheets().add("LamBio.css");
            
            Text txtLamHeading = new Text("Lâm Hoáng");
            txtLamHeading.setId("txtLamHeading");
            Text txtLamTitle = new Text("Lead Designer");
            txtLamTitle.setId("txtLamTitle");
            
            VBox vboxHeadingLam = new VBox(
                txtLamHeading,
                txtLamTitle
            );
            
            Image imgF4 = new Image("F4.gif", 200, 200, true, true);
            ImageView ivF4 = new ImageView(imgF4);
            VBox vboxImgViewFounder2 = new VBox(ivF4);
            vboxImgViewFounder2.setPadding(new Insets(-10, 12, 0, 650));
            HBox hboxHeadingLam = new HBox(
                    vboxHeadingLam,
                    vboxImgViewFounder2
            );
            
            Text txtLamBio = new Text("I am the Lead Designer for BISCoin, "
             +"I have a passion for both programming and design and love when I "
                    + "get the opportunity for both passions to meet. \n\nI am a fan "
                    + "of clean and minimalistic design, functional yet aesthetically pleasing, "
                    + "I believe that every element on every page must serve a purpose not only in "
                    + "the operation of the application but also in the overall design scheme.\n\n "
                    + "I have previously worked on websites like AVIDModelling and my own website "
                    + "where I have honed my front and backend development skills.\n\n"
                    + "When I'm not programming and designing I enjoy gaming and playing piano or listening to music.");
            txtLamBio.setWrappingWidth(700);
            txtLamBio.setTextAlignment(TextAlignment.JUSTIFY);
            VBox vboxTxtLamBio = new VBox(txtLamBio);
            vboxTxtLamBio.setPadding(new Insets(-100, 0, 0, 0)); 
           
            Text txtUsefulLinksLam = new Text("Useful Links");
            txtUsefulLinksLam.setId("txtUsefulLinksLam");
            Hyperlink lnkAvid = new Hyperlink("• AvidModelling");
            lnkAvid.setId("lnkAvid");
            Hyperlink lnkLam = new Hyperlink("• Lâm's Website");
            lnkLam.setId("lnkLam");
           VBox vboxLamLinks = new VBox(
                   txtUsefulLinksLam,
                   lnkAvid,
                   lnkLam
           );
           vboxLamLinks.setPadding(new Insets(10, 0, 0, 0)); 
            
            //Outer Container
            VBox outerContLam = new VBox(
                    hboxHeadingLam,
                    vboxTxtLamBio,
                    vboxLamLinks
            );
            layoutLamBio.add(outerContLam, 20, 15);
            
            
            
            
            
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
    
            window.setScene(lamBioScene);
            window.show();
    }
    
}
