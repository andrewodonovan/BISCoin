package biscoin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;


public class MainMenu extends Application {
    
    SignIn BISCoinHomeObj1 = new SignIn();
    AboutUs aboutUsObj1 = new AboutUs();
    Exchange exchangeObj1 = new Exchange();
    ContactUs contactUsObj1 = new ContactUs();
    Portfolio portfolioObj1 = new Portfolio();
    FAQ faqObj1 = new FAQ();
    
    public MainMenu(){
        //constructor
    }
    
    
    public Button getBtnHome(){
        Button btnHome = new Button("Home");
        btnHome.setId("btnhome");
        
        return btnHome;
    }
    
    public Button getBtnAboutUs(){
        Button btnAboutUs = new Button("About Us");
        btnAboutUs.setId("aboutUs");
        
        return btnAboutUs;
    }
    
    public Button getBtnFAQGuides(){
        Button btnFAQGuides = new Button("FAQ/Guides");
        btnFAQGuides.setId("faqguides");
        
        return btnFAQGuides;
    }
    
    public Button getBtnBuySell(){
        Button btnBuySell = new Button("Exchange");
        btnBuySell.setId("buysell");
        
        return btnBuySell;
    }
    
    
     public Button getBtnPortfolio(){
        Button btnPortfolio = new Button("Portfolio");
        btnPortfolio.setId("portfolio");
        
        return btnPortfolio;
    }
    
    public Separator getSep(){
        Separator menuSep = new Separator();
        menuSep.setId("menusep");
        
        return menuSep;
    }
    
    public MenuBar getMenuBar(){
         MenuBar menuBar = new MenuBar();
        
        javafx.scene.control.Menu menu = new javafx.scene.control.Menu("Username");
        menu.getItems().add(new MenuItem("Fund My Account"));
        menu.getItems().add(new MenuItem("Withdraw Funds"));
        menu.getItems().add(new MenuItem("Delete Account"));
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Log Out"));
        
        menuBar.getMenus().add(menu);
        menuBar.setId("menuBar");
        
        return menuBar;
    }
    
   
    
    public ToolBar getMainMenu(){
        ToolBar mainMenu = new ToolBar();
        
        // Create Toolbar and add the items
        mainMenu.setId("mainMenu");
        
        Button btnHome = getBtnHome();
        Button btnFAQGuides = getBtnFAQGuides();
        Button btnBuySell = getBtnBuySell();
        Button btnPortfolio = getBtnPortfolio();
        Button btnAboutUs = getBtnAboutUs();
        Separator menuSep = getSep();
        MenuBar menuBar = getMenuBar();
        
        mainMenu.getItems().addAll(
               
                btnHome,
                btnFAQGuides,
                btnBuySell,
                btnPortfolio,
                btnAboutUs,
                menuSep,
                menuBar
        );
        return mainMenu;
    }
    
    @Override
    public void start(Stage primaryStage) {
        //blank
    }
    
}
