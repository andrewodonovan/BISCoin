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

public class SamLKBio extends SignIn {
    
    public SamLKBio(){
        //constructor
    }
    
    public void start(Stage window){
      GridPane layoutSamLKBio = new GridPane();
      layoutSamLKBio.setHgap(5);
      layoutSamLKBio.setVgap(5);
      Scene samLKBioScene = new Scene(layoutSamLKBio, 1200, 800);
      window.setTitle("Sam Kiernan Director/CEO, Co-Designer ");
      
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
            
             ToolBar samLKBioMainMenu = new ToolBar(
                    btnHome,
                    btnFAQGuides,
                    btnBuySell,
                    btnPortfolio,
                    btnAboutUs,
                    menuSep,
                    menuBar
            );
            layoutSamLKBio.add(samLKBioMainMenu, 0, 0, 1200, 10);
            samLKBioMainMenu.setStyle("-fx-background-color: #000000;");
            
            samLKBioScene.getStylesheets().add("MainMenu.css");
            samLKBioScene.getStylesheets().add("SamLKBio.css");
            
            Text txtSamLKHeading = new Text("Sam Kiernan");
            txtSamLKHeading.setId("txtSamLKHeading");
            Text txtSamLKTitle = new Text("Director/CEO, Co-Designer ");
            txtSamLKTitle.setId("txtSamLKTitle");
            
            VBox vboxHeadingSamLK = new VBox(
                txtSamLKHeading,
                txtSamLKTitle
            );
            
            Image imgF1 = new Image("F1.gif", 200, 200, true, true);
            ImageView ivF1 = new ImageView(imgF1);
            VBox vboxImgViewFounder1 = new VBox(ivF1);
            vboxImgViewFounder1.setPadding(new Insets(-10, 12, 0, 560));
            HBox hboxHeadingSamLK = new HBox(
                    vboxHeadingSamLK,
                    vboxImgViewFounder1
            );
            
            Text txtSamLKBio = new Text("Starting out I knew I had to gather a reliable, skilled and intellectual team to design, build and complete BIScoin. \n" +
"\n" +
"Each team member plays a crucial part in BIScoin and it’s a pleasure to lead such individuals. I enjoying leading and organising projects such as this because it is yet challenging but fulfilling to create the end product. \n" +
"\n" +
"Not only do I have a passion for leadership and Entrepreneurship but I also have a passion for design. Consisting of minimalistic principles and contemporary design.\n" +
"Practising in hobbies such as fashion and graphic design.");
            txtSamLKBio.setWrappingWidth(700);
            txtSamLKBio.setTextAlignment(TextAlignment.JUSTIFY);
            VBox vboxTxtSamLKBio = new VBox(txtSamLKBio);
            vboxTxtSamLKBio.setPadding(new Insets(-100, 0, 0, 0)); 
           
            Text txtUsefulLinksSamLK = new Text("Useful Links");
            txtUsefulLinksSamLK.setId("txtUsefulLinksSamLK");
            Hyperlink lnkAvid = new Hyperlink("• AvidModelling");
            lnkAvid.setId("lnkAvid");
            Hyperlink lnkSamLK = new Hyperlink("• SamLK's Website");
            lnkSamLK.setId("lnkSamLK");
           VBox vboxSamLKLinks = new VBox(
                   txtUsefulLinksSamLK,
                   lnkAvid,
                   lnkSamLK
           );
           vboxSamLKLinks.setPadding(new Insets(10, 0, 0, 0)); 
            
            //Outer Container
            VBox outerContSamLK = new VBox(
                    hboxHeadingSamLK,
                    vboxTxtSamLKBio,
                    vboxSamLKLinks
            );
            layoutSamLKBio.add(outerContSamLK, 20, 15);
            
            
            
            
            
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
            
            window.setScene(samLKBioScene);
            window.show();
    }
    
}
