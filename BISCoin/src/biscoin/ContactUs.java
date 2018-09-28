package biscoin;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContactUs extends SignIn{
    
    public ContactUs(){
        //ContactUs
    }
    
    @Override
    public void start(Stage window){
        
        SignIn BISCoinHomeObj1 = new SignIn();
        Exchange exchangeObj1 = new Exchange();
        AboutUs aboutUsObj1 = new AboutUs();
        Portfolio portfolioObj1 = new Portfolio();
        JSonParserTest Testobj = new JSonParserTest();
        FAQ faqObj1 = new FAQ();
        LoadingScreen Loadingobj1 = new LoadingScreen();
       
        GridPane layoutContactUs = new GridPane();
        layoutContactUs.setVgap(5);
        layoutContactUs.setHgap(5);
        Button btnPurchase = new Button("buy");
        layoutContactUs.getChildren().addAll(btnPurchase);
        Scene contactUsScene = new Scene(layoutContactUs, 1200, 800, Color.WHITE);
            contactUsScene.getStylesheets().add("ContactUs.css");
            window.setScene(contactUsScene);
        
        Button btnHomeCu = new Button("Home");
        btnHomeCu.setId("btnhomeCu");
        
         btnPurchase.setOnAction(e -> {
            try {
                Testobj.getData();
//test1.purchaseCrypto(1000.00);
            } catch (Exception ex) {
                Logger.getLogger(ContactUs.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button btnAboutUsCu = new Button("About Us");
        btnAboutUsCu.setId("aboutUsCu");
        
        Button btnFAQGuidesCu = new Button("FAQ/Guides");
        btnFAQGuidesCu.setId("faqguidesCu");
        
        Button btnBuySellCu = new Button("BUY/SELL");
        btnBuySellCu.setId("buysellCu");
        
        
        Button btnPortfolioCu = new Button("Portfolio");
        btnPortfolioCu.setId("portfolioCu");
        
        Button btnContactUsCu = new Button("Contact Us");
        btnContactUsCu.setId("contactUsCu");
        
        Separator menuSep2Cu = new Separator();
        menuSep2Cu.setId("menusep2Cu");
        
        MenuBar menuBarCu = new MenuBar();
        
        Menu menuCu = new Menu("Username");
        menuCu.getItems().add(new MenuItem("Fund My Account"));
        menuCu.getItems().add(new MenuItem("Withdraw Funds"));
        menuCu.getItems().add(new SeparatorMenuItem());
        menuCu.getItems().add(new MenuItem("Log Out"));
        
        menuBarCu.getMenus().add(menuCu);
        menuBarCu.setId("menuBarCu");
        
      
        
        // Create Toolbar and add the items
        ToolBar mainMenuCu = new ToolBar();
        mainMenuCu.setId("mainMenuCu");
        
        mainMenuCu.getItems().addAll(
                btnHomeCu,
                btnFAQGuidesCu,
                btnBuySellCu,
                btnPortfolioCu,
                btnContactUsCu,
                btnAboutUsCu,
                menuSep2Cu,
                menuBarCu
        );
        
        
        
        layoutContactUs.add(mainMenuCu, 0, 0, 1200, 10);
        
         //Buttons to link to other pages
        btnHomeCu.setOnAction(e -> {
           BISCoinHomeObj1.start(window);
        });
        
        btnAboutUsCu.setOnAction(e -> {
            Loadingobj1.start(window);
        });
        
        btnFAQGuidesCu.setOnAction(e -> {
              RSSFeedParser parser = new RSSFeedParser(
                "http://www.coindesk.com/");
        Feed feed = parser.readFeed();
        System.out.println(feed);
        for (FeedMessage message : feed.getMessages()) {
            System.out.println(message);

        }

    
           ////
        });
        
        btnBuySellCu.setOnAction(e -> {
             Transaction trns1 = new Transaction();
             trns1.transaction_calc(6,"DOGE", 0.006543, 0.0000002, 1000.00, "EUR", 10000.00, "Today", "BUY");
        });
        
        btnPortfolioCu.setOnAction(e -> {
             portfolioObj1.start(window);
        });
        
        
            window.setResizable(false);
            window.setTitle("Contact Us");
            window.show();
        
    }
}
