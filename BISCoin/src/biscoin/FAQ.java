package biscoin;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FAQ extends SignIn{
    
    public FAQ(){
        //constructor
    }
    
     @Override
    public void start(Stage window){
        
            Exchange exchangeObj1 = new Exchange();
            AboutUs aboutUsObj1 = new AboutUs();
            ContactUs contactUsObj1 = new ContactUs();
            Portfolio portfolioObj1 = new Portfolio();
            LandingPage BISCoinHomeObj1 = new LandingPage();
            MainMenu mainMenuObj1 = new MainMenu();
          
            
            
            Button btnHome = mainMenuObj1.getBtnHome();
            Button btnFAQGuides = mainMenuObj1.getBtnFAQGuides();
            Button btnBuySell = mainMenuObj1.getBtnBuySell();
            Button btnPortfolio = mainMenuObj1.getBtnPortfolio();
            Button btnAboutUs = mainMenuObj1.getBtnAboutUs();
            
            Separator menuSep = mainMenuObj1.getSep();
            MenuBar menuBar = mainMenuObj1.getMenuBar();
        GridPane layoutFAQ = new GridPane();
        layoutFAQ.setVgap(5);
        layoutFAQ.setHgap(5);
        
        
        // New Stuff
            //Declaring ELements
            
            // Containers
            VBox vbxOuterCont = new VBox();   
            BorderPane bpnLayout = new BorderPane();
            TreeView trvAnswerLinks = new TreeView();
            HBox hbxSearchCont = new HBox();
            // Form Elements
            TableView tblFaqResults = new TableView();
            TextField txtSearchBar = new TextField();
            Button btnSearchFaq = new Button("Search");
            Label lblTitle = new Label("Frequently Asked Questions");
            
            //Setting Properties
           vbxOuterCont.setSpacing(20);
           hbxSearchCont.setSpacing(20); 
            
           //Setting IDs 
            vbxOuterCont.setId("vbx_Outer");
            bpnLayout.setId("bpn_Layout");
            trvAnswerLinks.setId("trv_LinkContainer");
            hbxSearchCont.setId("hbx_Search");
            tblFaqResults.setId("tbl_FaqResults");
            txtSearchBar.setId("txt_Search");
            btnSearchFaq.setId("btn_Search");
            lblTitle.setId("lbl_Title");
            
        Scene FAQScene = new Scene(layoutFAQ, 1200, 800, Color.WHITE);
            FAQScene.getStylesheets().add("FAQ.css");
            FAQScene.getStylesheets().add("MainMenu.css");
            window.setScene(FAQScene);
        
         
        
        // Create Toolbar and add the items
        ToolBar FAQMainMenu = new ToolBar();
        FAQMainMenu.setId("FAQMainMenu");
        
        FAQMainMenu.getItems().addAll(
                btnHome,
                btnFAQGuides,
                btnBuySell,
                btnPortfolio,
                btnAboutUs,
                menuSep,
                menuBar
        );
        
        layoutFAQ.add(FAQMainMenu, 0, 0, 1200, 800);
        FAQMainMenu.setStyle("-fx-background-color: #000000;");
    
        
        
        // Putting Elements into a hierarchy
            hbxSearchCont.getChildren().addAll(txtSearchBar, btnSearchFaq);
            vbxOuterCont.getChildren().addAll(lblTitle, hbxSearchCont, tblFaqResults);
            bpnLayout.setTop(FAQMainMenu);
            bpnLayout.setCenter(vbxOuterCont);
            bpnLayout.setLeft(trvAnswerLinks);
            
            
            
                layoutFAQ.add(bpnLayout, 0, 0, 1200, 10);
        //
        
         //Buttons to link to other pages
          btnHome.setOnAction(e -> {
           BISCoinHomeObj1.start(window);
        });
        
        btnAboutUs.setOnAction(e -> {
            aboutUsObj1.start(window);
        });
        
        btnPortfolio.setOnAction(e -> {
             portfolioObj1.start(window);
        });
        
        btnBuySell.setOnAction(e -> {
             exchangeObj1.start(window);
        });
        
 
        
            window.setResizable(false);
            window.setTitle("FAQ/Guides");
            window.show();
    }
}
