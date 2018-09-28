package biscoin;

import java.text.DecimalFormat;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Portfolio extends SignIn{
    
    public Portfolio(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
        
        LandingPage BISCoinHomeObj1 = new LandingPage();
        Exchange exchangeObj1 = new Exchange();
        AboutUs aboutUsObj1 = new AboutUs();
        ContactUs contactUsObj1 = new ContactUs();
        FAQ faqObj1 = new FAQ();
        MainMenu mainMenuObj1 = new MainMenu();
        
        
        Button btnHome = mainMenuObj1.getBtnHome();
        Button btnFAQGuides = mainMenuObj1.getBtnFAQGuides();
        Button btnBuySell = mainMenuObj1.getBtnBuySell();
        Button btnPortfolio = mainMenuObj1.getBtnPortfolio();
        Button btnAboutUs = mainMenuObj1.getBtnAboutUs();
        Separator menuSep = mainMenuObj1.getSep();
        MenuBar menuBar = mainMenuObj1.getMenuBar();
        
        GridPane layoutPortfolio = new GridPane();
        layoutPortfolio.setVgap(5);
        layoutPortfolio.setHgap(5);
        
        Scene portfolioScene = new Scene(layoutPortfolio, 1200, 800, Color.WHITE);
        portfolioScene.getStylesheets().add("MainMenu.css");    
        portfolioScene.getStylesheets().add("Portfolio.css");
            window.setScene(portfolioScene);
        
            ToolBar portfolioMainMenu = new ToolBar(
                btnHome,
                btnFAQGuides,
                btnBuySell,
                btnPortfolio,
                btnAboutUs,
                menuSep,
                menuBar
        );
        layoutPortfolio.add(portfolioMainMenu, 0, 0, 1200, 10);
        portfolioMainMenu.setStyle("-fx-background-color: #000000;");
        
        //Form
        double dblTotalPortfolioVal = 0.00;
        DecimalFormat df = new DecimalFormat("0.00");
        String strFormattedCurrency = df.format(dblTotalPortfolioVal);
        
        Text txtPortfolioVal = new Text("Portfolio Value:   €" + strFormattedCurrency);
        txtPortfolioVal.setId("txtPortfolioVal");
        
        
        
        TableView tbvPortfolioVal = new TableView();
        tbvPortfolioVal.setId("tbvPortfolio");
        tbvPortfolioVal.setMaxWidth(575);
        tbvPortfolioVal.setMinWidth(575);
        tbvPortfolioVal.setPrefHeight(100);
        
        VBox vboxPortfolioVal = new VBox(
             txtPortfolioVal,
             tbvPortfolioVal
        );
        vboxPortfolioVal.setPadding(new Insets(20,20,0,0));
        
        Text txtPortfolioAct = new Text("Your Portfolio Activity");
        txtPortfolioAct.setId("txtPortfolioVal");
       
        TableView tbvPortfolioAct = new TableView();
        tbvPortfolioAct.setId("tbvPortfolioAct");
        tbvPortfolioAct.setMaxWidth(575);
        tbvPortfolioAct.setMinWidth(575);
        tbvPortfolioAct.setPrefHeight(100);
        
         VBox vboxPortfolioAct = new VBox(
                 txtPortfolioAct,
                 tbvPortfolioAct
         );
         vboxPortfolioAct.setPadding(new Insets(20,0,0,0));
        
        HBox outerContPortfolio = new HBox(
                vboxPortfolioVal,
                vboxPortfolioAct
        );
        
        
        // VERY IMPORTANT CODE
      /*     ObservableList<ObservableList> data;
        Connection c;
          data = FXCollections.observableArrayList();
          try{
            c = BISCoinHomeObj1.sqlConnection();
            //SQL FOR SELECTING ALL OF Crypto In tblCrypto
            String SQL = "SELECT trans_id As 'Transaction Number', trans_crypto_ID As 'Crypto ID', trans_date As 'Transaction Date', trans_buy_sell As 'BUY/SELL Request', trans_price_paid As 'Cost', trans_amount_bought_sold As 'Amount Gained', trans_paid_in As 'EUR/BTC Transaction', trans_total_value As 'Transaction Value' FROM tbltransactions WHERE trans_user_id = 6";
            //ResultSet
              ResultSet rs = c.createStatement().executeQuery(SQL);
                    
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnLabel(i+1));
                 col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tbvPortfolioAct.getColumns().addAll(col);
                tbvPortfolioAct.getSortOrder().add(col);
                tbvPortfolioAct.setEditable(false);
                tbvPortfolioAct.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            }
            */
            /********************************
             * Data added to ObservableList *
             ********************************/
            /*while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tbvPortfolioAct.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
        
       // Code to popuate your total portfolio
        // VERY IMPORTANT CODE
           ObservableList<ObservableList> cryptodata;
        Connection ca;
          cryptodata = FXCollections.observableArrayList();
          try{
            ca = BISCoinHomeObj1.sqlConnection();
            //SQL FOR SELECTING ALL OF Crypto In tblCrypto
            String SQL = "SELECT trans_crypto_id As 'Crypto ID', SUM(trans_price_paid) As 'Cost', SUM(trans_amount_bought_sold) As 'Amount Gained', SUM(trans_total_value) As 'Crypto Value' FROM tbltransactions WHERE trans_user_id = 6 GROUP BY trans_crypto_id DESC";
            //ResultSet
              ResultSet rsa = ca.createStatement().executeQuery(SQL);
                    
            for(int i=0 ; i<rsa.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rsa.getMetaData().getColumnLabel(i+1));
                 col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tbvPortfolioVal.getColumns().addAll(col);
                tbvPortfolioVal.getSortOrder().add(col);
                tbvPortfolioVal.setEditable(false);
                tbvPortfolioVal.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            /*while(rsa.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rsa.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rsa.getString(i));
                }
                System.out.println("Row [1] added "+row );
                cryptodata.add(row);

            }

            //FINALLY ADDED TO TableView
            tbvPortfolioVal.setItems(cryptodata);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
        */
        
        outerContPortfolio.setId("outerContPortfolio");
        layoutPortfolio.add(outerContPortfolio, 3, 15, 200, 60);
        
         //Buttons to link to other pages
        btnHome.setOnAction(e -> {
           BISCoinHomeObj1.start(window);
        });
        
        btnAboutUs.setOnAction(e -> {
            aboutUsObj1.start(window);
        });
        
        btnFAQGuides.setOnAction(e -> {
             faqObj1.start(window);
        });
        
        btnBuySell.setOnAction(e -> {
             exchangeObj1.start(window);
        });

        
            window.setResizable(false);
            window.setTitle("Portfolio");
            window.show();
    }
}