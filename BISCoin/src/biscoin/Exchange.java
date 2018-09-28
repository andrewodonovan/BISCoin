    package biscoin;

import java.sql.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Exchange extends SignIn {
           
    
    String crypto_symbol;
    Double crypto_eur_price;
    Double crypto_btc_price;
    Double crypto_amount_requested;
    //Double crypto_price_required;
    Boolean is_eurTransaction;
    String payment_currency;
    
    Double eur_balance;
    String trans_date;
    String trans_buy_sell;
    Double total_price;
      
        public Exchange(){
            //constructor
            crypto_symbol = "BTC";
            crypto_eur_price = 10000.00;
            crypto_btc_price = 1.00;
        }
    
        @Override
        public void start(Stage window){
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
        
            
            GridPane layoutExchange = new GridPane();
            layoutExchange.setVgap(5);
            layoutExchange.setHgap(5);
            
            Scene exchangeScene = new Scene(layoutExchange, 1200, 800, Color.WHITE);
            exchangeScene.getStylesheets().add("MainMenu.css");
            exchangeScene.getStylesheets().add("Exchange.css");
            window.setScene(exchangeScene);
            
            ToolBar exchangeMainMenu = new ToolBar(
                btnHome,
                btnFAQGuides,
                btnBuySell,
                btnPortfolio,
                btnAboutUs,
                menuSep,
                menuBar
        );
        layoutExchange.add(exchangeMainMenu, 0, 0, 1200, 10);
        exchangeMainMenu.setStyle("-fx-background-color: #000000;");
        
        //Start of form
        

        TextField txtSearch = new TextField();
        txtSearch.setPromptText("Search...");
        txtSearch.setMaxSize(300, 30);
        txtSearch.setMinSize(300, 30);

        VBox vboxTxtSearch = new VBox(txtSearch);
        
        Button btnSearch = new Button("Search");
        btnSearch.setId("btnSearch");
        btnSearch.setMaxSize(100, 30);
        btnSearch.setMinSize(100, 30);
        
        
        
        VBox vboxBtnSearch = new VBox(btnSearch);
        vboxBtnSearch.setPadding(new Insets(0, 0, 0, 15));
        
        HBox hboxSearch = new HBox(
                vboxTxtSearch,
                vboxBtnSearch
        );
        hboxSearch.setPadding(new Insets(10, 0, 15, 375));
        
        
        TableView tbvExchange = new TableView();
        
        ObservableList<ObservableList> data;
        
        // Declarations and oriional assignment of comboboxes
        ComboBox cmbConvBox2 = new ComboBox();
        cmbConvBox2.getItems().addAll(
            "EUR",
            "BTC"
        );
        
         ComboBox cmbConvBox1 = new ComboBox();
        cmbConvBox1.getItems().add(
            0,
            crypto_symbol
        );
        
        
        // VERY IMPORTANT CODE
        
        Connection c;
          data = FXCollections.observableArrayList();
          try{
            c = BISCoinHomeObj1.sqlConnection();
            //SQL FOR SELECTING ALL OF Crypto In tblCrypto
            String SQL = "SELECT crypto_name As Name, crypto_price As 'Price (€)', crypto_perc1 As '% Change (1 Hour)', crypto_perc24 As '% Change (1 Day)', crypto_perc7 As '% Change (Week)', crypto_btc As 'BTC Vol', crypto_marketcap As 'Market Cap' FROM tblcrypto GROUP BY crypto_price DESC";
            //ResultSet
              ResultSet rs = c.createStatement().executeQuery(SQL);
                    
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnLabel(i+1));
                 col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tbvExchange.getColumns().addAll(col);
                tbvExchange.getSortOrder().add(col);
                tbvExchange.setEditable(false);
                tbvExchange.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
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
            tbvExchange.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
         tbvExchange.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
             if (newVal != null){
                 TablePosition pos = (TablePosition) tbvExchange.getSelectionModel().getSelectedCells().get(0);
                 int row = pos.getRow();
                 
                 //Item item = tbvExchange.getItems().get(row);
                 
                 TableColumn col = pos.getTableColumn();
                 
                 String tbvExString = tbvExchange.getItems().get(row).toString();
                 final String[] crypto_data = tbvExString.split((","));
                 // Passing the selected row to global variables
                 crypto_symbol =   crypto_data[0];     //tbvExString.substring(1, tbvExString.indexOf(","));
                 crypto_eur_price =  Double.parseDouble(crypto_data[1]);          //Double.parseDouble(tbvExString.substring(2, tbvExString.indexOf(",")));
                 crypto_btc_price =  Double.parseDouble(crypto_data[2]);           //Double.parseDouble(tbvExString.substring(6, tbvExString.indexOf(",")));
                 //Hard Coded Need to be changed
                 eur_balance = 10000.00;
                 crypto_amount_requested= 10000.00;
                 payment_currency = "EUR";
                 trans_date = "Today";
                 trans_buy_sell = "BUY";
                 
                 
                 // Update the combo boxes
                 cmbConvBox2.getItems().addAll(
                    crypto_symbol,
                    "BTC"
                         
        );
                 
                 // = tbvExString.substring(1, tbvExString.indexOf(","));
                 System.out.println(tbvExString);
             }
         });
       tbvExchange.setId("tbvExchange");
        tbvExchange.setMaxWidth(1200);
        tbvExchange.setMaxHeight(450);
        tbvExchange.setMinWidth(1200);
        tbvExchange.setMinHeight(450);
        
        VBox vboxTbvExchange = new VBox(
             tbvExchange
        );
        vboxTbvExchange.setPadding(new Insets(0, 0, 0 , 0));
        
        
        //3 Bottom Panels
        
        //Conversion Panel
        VBox Header_ConversionPanel = new VBox(
            new Text("Conversion")
        );
        Header_ConversionPanel.setId("Header_ConversionPanel");
        Header_ConversionPanel.setPadding(new Insets(8, 8, 8, 8));
        
              
   //     ComboBox cmbConvBox1 = new ComboBox();
        cmbConvBox1.getItems().add(
            0,
            crypto_symbol
        );
        cmbConvBox1.getSelectionModel().selectFirst();
        cmbConvBox1.setMinWidth(100);
        cmbConvBox1.setMaxWidth(100);
        
        HBox hboxCmbConvBox1 = new HBox(
             cmbConvBox1
        );
        hboxCmbConvBox1.setPadding(new Insets(10, 7, 5, 5));
        
        TextField txtConvBox1 = new TextField();
        txtConvBox1.setMinWidth(155);
        txtConvBox1.setMaxWidth(155);
        txtConvBox1.setPromptText("0.0000000000");
        
        HBox hboxTxtConvBox1 = new HBox(
             txtConvBox1
        );
        hboxTxtConvBox1.setPadding(new Insets(10, 5, 5, 5));
        
        TextField txtConvBox1Eur = new TextField();
        txtConvBox1Eur.setMinWidth(155);
        txtConvBox1Eur.setMaxWidth(155);
        txtConvBox1Eur.setPromptText("0.00");
        
        HBox hboxTxtConvBox1Eur = new HBox(
             txtConvBox1Eur
        );
        hboxTxtConvBox1Eur.setPadding(new Insets(10, 5, 5, -160));
        hboxTxtConvBox1Eur.setVisible(false);
        
        HBox hboxConvBox1 = new HBox(
           hboxCmbConvBox1,
           hboxTxtConvBox1,
           hboxTxtConvBox1Eur
        );
        hboxConvBox1.setId("hboxConvBox1");
        
                    hboxTxtConvBox1.setVisible(true);
                    hboxTxtConvBox1Eur.setVisible(false);
                    
                    txtConvBox1.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtConvBox1.setText(oldValue);
                        }
                    }
                    });
                    
        cmbConvBox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldVal, String changedVal) {
                txtConvBox1.clear();
                txtConvBox1Eur.clear();
                if(changedVal.equals("EUR")){
                    hboxTxtConvBox1.setVisible(false);
                    hboxTxtConvBox1Eur.setVisible(true);
                    
                    txtConvBox1Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtConvBox1Eur.setText(oldValue);
                        }
                    }
                    });
                }
                else{
                    hboxTxtConvBox1.setVisible(true);
                    hboxTxtConvBox1Eur.setVisible(false);
                    
                    txtConvBox1.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtConvBox1.setText(oldValue);
                        }
                    }
                    });
                }
            }
        });
        
        
        
        
        cmbConvBox2.getSelectionModel().selectFirst();
        cmbConvBox2.setMinWidth(100);
        cmbConvBox2.setMaxWidth(100);
        
        HBox hboxCmbConvBox2 = new HBox(
             cmbConvBox2
        );
        hboxCmbConvBox2.setPadding(new Insets(5, 7, 5, 5));
        
         cmbConvBox2.getSelectionModel().selectFirst();

        
        TextField txtConvBox2Eur = new TextField();                  
        
        txtConvBox2Eur.setMinWidth(155);
        txtConvBox2Eur.setMaxWidth(155);
        txtConvBox2Eur.setPromptText("0.00");
        
        HBox hboxTxtConvBox2Eur = new HBox(
             txtConvBox2Eur
        );
        hboxTxtConvBox2Eur.setPadding(new Insets(5, 5, 5, 5));
        
        TextField txtConvBox2 = new TextField();
        txtConvBox2.setMinWidth(155);
        txtConvBox2.setMaxWidth(155);
        txtConvBox2.setPromptText("0.0000000000");
        
        HBox hboxTxtConvBox2 = new HBox(
             txtConvBox2
        );
        hboxTxtConvBox2.setPadding(new Insets(5, 5, 5, -160));
        
        HBox hboxConvBox2 = new HBox(
             hboxCmbConvBox2,
             hboxTxtConvBox2Eur,
             hboxTxtConvBox2
        );
        hboxConvBox2.setId("hboxConvBox2");
      
        
                    hboxTxtConvBox2Eur.setVisible(true);
                    hboxTxtConvBox2.setVisible(false);
                    
                    txtConvBox2Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtConvBox2Eur.setText(oldValue);
                        }
                    }
                    });
        
        
        cmbConvBox2.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldVal, String changedVal) {
                txtConvBox2.clear();
                txtConvBox2Eur.clear();
                if(changedVal.equals("EUR")){
                    hboxTxtConvBox2Eur.setVisible(true);
                    hboxTxtConvBox2.setVisible(false);
                    
                    txtConvBox2Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtConvBox2Eur.setText(oldValue);
                        }
                    }
                    });
                }
                else{
                    hboxTxtConvBox2.setVisible(true);
                    hboxTxtConvBox2Eur.setVisible(false);
                    
                    txtConvBox2.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtConvBox2.setText(oldValue);
                        }
                    }
                    });
                }
            }
        });

        
        VBox conversion_panel = new VBox(
              Header_ConversionPanel,
              hboxConvBox1,
              hboxConvBox2
        );
        conversion_panel.setId("vboxConversionPanel");
        layoutExchange.add(conversion_panel, 15, 75);
        
        
        //Buy Panel
        
        
        
        VBox Header_BuyPanel = new VBox(
            new Text("Buy")
        );
        Header_BuyPanel.setId("Header_BuyPanel");
        Header_BuyPanel.setPadding(new Insets(8, 8, 8, 8));
        
        ComboBox cmbBuyBox1 = new ComboBox();
        cmbBuyBox1.getItems().addAll(
            "BTC",
            "EUR"
        );
        cmbBuyBox1.getSelectionModel().selectFirst();
        cmbBuyBox1.setMinWidth(100);
        cmbBuyBox1.setMaxWidth(100);
        
        HBox hboxCmbBuyBox1 = new HBox(
             cmbBuyBox1
        );
        hboxCmbBuyBox1.setPadding(new Insets(10, 7, 5, 5));
        
        TextField txtBuyBox1 = new TextField();
        txtBuyBox1.setMinWidth(155);
        txtBuyBox1.setMaxWidth(155);
        txtBuyBox1.setPromptText("0.0000000000");
        
        HBox hboxTxtBuyBox1 = new HBox(
             txtBuyBox1
        );
        hboxTxtBuyBox1.setPadding(new Insets(10, 5, 5, 5));
        
        TextField txtBuyBox1Eur = new TextField();
        txtBuyBox1Eur.setMinWidth(155);
        txtBuyBox1Eur.setMaxWidth(155);
        txtBuyBox1Eur.setPromptText("0.00");
        
        HBox hboxTxtBuyBox1Eur = new HBox(
             txtBuyBox1Eur
        );
        hboxTxtBuyBox1Eur.setPadding(new Insets(10, 5, 5, -160));
        hboxTxtBuyBox1Eur.setVisible(false);
        
        HBox hboxBuyBox1 = new HBox(
           hboxCmbBuyBox1,
           hboxTxtBuyBox1,
           hboxTxtBuyBox1Eur
        );
        hboxBuyBox1.setId("hboxBuyBox1");
        
                    hboxTxtBuyBox1.setVisible(true);
                    hboxTxtBuyBox1Eur.setVisible(false);
                    
                    txtBuyBox1.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtBuyBox1.setText(oldValue);
                        }
                    }
                    });
                    
        cmbBuyBox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldVal, String changedVal) {
                txtBuyBox1.clear();
                txtBuyBox1Eur.clear();
                if(changedVal.equals("EUR")){
                    hboxTxtBuyBox1.setVisible(false);
                    hboxTxtBuyBox1Eur.setVisible(true);
                    
                    txtBuyBox1Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtBuyBox1Eur.setText(oldValue);
                        }
                    }
                    });
                }
                else{
                    hboxTxtBuyBox1.setVisible(true);
                    hboxTxtBuyBox1Eur.setVisible(false);
                    
                    txtBuyBox1.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtBuyBox1.setText(oldValue);
                        }
                    }
                    });
                }
            }
        });
        
        
        
        ComboBox cmbBuyBox2 = new ComboBox();
        cmbBuyBox2.getItems().addAll(
            "EUR",
            "BTC"
        );
        cmbBuyBox2.getSelectionModel().selectFirst();
        cmbBuyBox2.setMinWidth(100);
        cmbBuyBox2.setMaxWidth(100);
        
        HBox hboxCmbBuyBox2 = new HBox(
             cmbBuyBox2
        );
        hboxCmbBuyBox2.setPadding(new Insets(5, 7, 5, 5));
        
         cmbBuyBox2.getSelectionModel().selectFirst();

        
        TextField txtBuyBox2Eur = new TextField();                  
        
        txtBuyBox2Eur.setMinWidth(155);
        txtBuyBox2Eur.setMaxWidth(155);
        txtBuyBox2Eur.setPromptText("0.00");
        
        HBox hboxTxtBuyBox2Eur = new HBox(
             txtBuyBox2Eur
        );
        hboxTxtBuyBox2Eur.setPadding(new Insets(5, 5, 5, 5));
        
        TextField txtBuyBox2 = new TextField();
        txtBuyBox2.setMinWidth(155);
        txtBuyBox2.setMaxWidth(155);
        txtBuyBox2.setPromptText("0.0000000000");
        
        HBox hboxTxtBuyBox2 = new HBox(
             txtBuyBox2
        );
        hboxTxtBuyBox2.setPadding(new Insets(5, 5, 5, -160));
        
        HBox hboxBuyBox2 = new HBox(
             hboxCmbBuyBox2,
             hboxTxtBuyBox2Eur,
             hboxTxtBuyBox2
        );
        hboxBuyBox2.setId("hboxBuyBox2");
      
        
                    hboxTxtBuyBox2Eur.setVisible(true);
                    hboxTxtBuyBox2.setVisible(false);
                    
                    txtBuyBox2Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtBuyBox2Eur.setText(oldValue);
                        }
                    }
                    });
        
        
        cmbBuyBox2.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldVal, String changedVal) {
                txtBuyBox2.clear();
                txtBuyBox2Eur.clear();
                if(changedVal.equals("EUR")){
                    hboxTxtBuyBox2Eur.setVisible(true);
                    hboxTxtBuyBox2.setVisible(false);
                    
                    txtBuyBox2Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtBuyBox2Eur.setText(oldValue);
                        }
                    }
                    });
                }
                else{
                    hboxTxtBuyBox2.setVisible(true);
                    hboxTxtBuyBox2Eur.setVisible(false);
                    
                    txtBuyBox2.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtBuyBox2.setText(oldValue);
                        }
                    }
                    });
                }
            }
        });

        Button btnBuy = new Button("Buy");
        HBox hboxBtnBuy = new HBox(btnBuy);
        VBox buy_panel = new VBox(
            Header_BuyPanel,
            hboxBuyBox1,
            hboxBuyBox2,
            hboxBtnBuy
        );
        
        buy_panel.setId("vboxBuyPanel");
        layoutExchange.add(buy_panel, 35, 75);

        
        //Sell Panel
        VBox Header_SellPanel = new VBox(
            new Text("Sell")
        );
        Header_SellPanel.setId("Header_SellPanel");
        Header_SellPanel.setPadding(new Insets(8, 8, 8, 8));
        
        
        ComboBox cmbSellBox1 = new ComboBox();
        cmbSellBox1.getItems().addAll(
            "BTC",
            "EUR"
        );
        cmbSellBox1.getSelectionModel().selectFirst();
        cmbSellBox1.setMinWidth(100);
        cmbSellBox1.setMaxWidth(100);
        
        HBox hboxCmbSellBox1 = new HBox(
             cmbSellBox1
        );
        hboxCmbSellBox1.setPadding(new Insets(10, 7, 5, 5));
        
        TextField txtSellBox1 = new TextField();
        txtSellBox1.setMinWidth(155);
        txtSellBox1.setMaxWidth(155);
        txtSellBox1.setPromptText("0.0000000000");
        
        HBox hboxTxtSellBox1 = new HBox(
             txtSellBox1
        );
        hboxTxtSellBox1.setPadding(new Insets(10, 5, 5, 5));
        
        TextField txtSellBox1Eur = new TextField();
        txtSellBox1Eur.setMinWidth(155);
        txtSellBox1Eur.setMaxWidth(155);
        txtSellBox1Eur.setPromptText("0.00");
        
        HBox hboxTxtSellBox1Eur = new HBox(
             txtSellBox1Eur
        );
        hboxTxtSellBox1Eur.setPadding(new Insets(10, 5, 5, -160));
        hboxTxtSellBox1Eur.setVisible(false);
        
        HBox hboxSellBox1 = new HBox(
           hboxCmbSellBox1,
           hboxTxtSellBox1,
           hboxTxtSellBox1Eur
        );
        hboxSellBox1.setId("hboxSellBox1");
        
                    hboxTxtSellBox1.setVisible(true);
                    hboxTxtSellBox1Eur.setVisible(false);
                    
                    txtSellBox1.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtSellBox1.setText(oldValue);
                        }
                    }
                    });
                    
        cmbSellBox1.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldVal, String changedVal) {
                txtSellBox1.clear();
                txtSellBox1Eur.clear();
                if(changedVal.equals("EUR")){
                    hboxTxtSellBox1.setVisible(false);
                    hboxTxtSellBox1Eur.setVisible(true);
                    
                    txtSellBox1Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtSellBox1Eur.setText(oldValue);
                        }
                    }
                    });
                }
                else{
                    hboxTxtSellBox1.setVisible(true);
                    hboxTxtSellBox1Eur.setVisible(false);
                    
                    txtSellBox1.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtSellBox1.setText(oldValue);
                        }
                    }
                    });
                }
            }
        });
        
        
        
        ComboBox cmbSellBox2 = new ComboBox();
        cmbSellBox2.getItems().addAll(
            "EUR",
            "BTC"
        );
        cmbSellBox2.getSelectionModel().selectFirst();
        cmbSellBox2.setMinWidth(100);
        cmbSellBox2.setMaxWidth(100);
        
        HBox hboxCmbSellBox2 = new HBox(cmbSellBox2);
        hboxCmbSellBox2.setPadding(new Insets(5, 7, 5, 5));
        
         cmbSellBox2.getSelectionModel().selectFirst();

        
        TextField txtSellBox2Eur = new TextField();                  
        
        txtSellBox2Eur.setMinWidth(155);
        txtSellBox2Eur.setMaxWidth(155);
        txtSellBox2Eur.setPromptText("0.00");
        
        HBox hboxTxtSellBox2Eur = new HBox(txtSellBox2Eur);
        hboxTxtSellBox2Eur.setPadding(new Insets(5, 5, 5, 5));
        
        TextField txtSellBox2 = new TextField();
        txtSellBox2.setMinWidth(155);
        txtSellBox2.setMaxWidth(155);
        txtSellBox2.setPromptText("0.0000000000");
        
        HBox hboxTxtSellBox2 = new HBox(
             txtSellBox2
        );
        hboxTxtSellBox2.setPadding(new Insets(5, 5, 5, -160));
        
        HBox hboxSellBox2 = new HBox(
             hboxCmbSellBox2,
             hboxTxtSellBox2Eur,
             hboxTxtSellBox2
        );
        hboxSellBox2.setId("hboxSellBox2");
      
        
                    hboxTxtSellBox2Eur.setVisible(true);
                    hboxTxtSellBox2.setVisible(false);
                    
                    txtSellBox2Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtSellBox2Eur.setText(oldValue);
                        }
                    }
                    });
        
        
        cmbSellBox2.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldVal, String changedVal) {
                txtSellBox2.clear();
                txtSellBox2Eur.clear();
                if(changedVal.equals("EUR")){
                    hboxTxtSellBox2Eur.setVisible(true);
                    hboxTxtSellBox2.setVisible(false);
                    
                    txtSellBox2Eur.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,2})?")) {
                                txtSellBox2Eur.setText(oldValue);
                        }
                    }
                    });
                }
                else{
                    hboxTxtSellBox2.setVisible(true);
                    hboxTxtSellBox2Eur.setVisible(false);
                    
                    txtSellBox2.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        if (!newValue.matches("\\d{0,10}([\\.]\\d{0,10})?")) {
                                txtSellBox2.setText(oldValue);
                        }
                    }
                    });
                }
            }
        });


        Button btnSell = new Button("Sell");
        HBox hboxBtnSell = new HBox(btnSell);
  
        VBox sell_panel = new VBox(
              Header_SellPanel,
              hboxSellBox1,
              hboxSellBox2,
              hboxBtnSell
        );
        sell_panel.setId("vboxSellPanel");
       
        sell_panel.maxHeight(250);
        sell_panel.maxWidth(500);
        sell_panel.minHeight(250);
        sell_panel.minWidth(500);
        
        buy_panel.maxHeight(250);
        buy_panel.maxWidth(500);
        buy_panel.minHeight(250);
        buy_panel.minWidth(500);
        
        conversion_panel.maxHeight(250);
        conversion_panel.maxWidth(500);
        conversion_panel.minHeight(250);
        conversion_panel.minWidth(500);
        
        layoutExchange.add(sell_panel, 55, 75);

        VBox outerContEx = new VBox(
                hboxSearch,
                tbvExchange
        );
        layoutExchange.add(outerContEx, 0, 10, 200, 60);
        
        
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
        
        btnPortfolio.setOnAction(e -> {
             portfolioObj1.start(window);
        });
        
       /* btnContactUs.setOnAction(e -> {
             //contactUsObj1.start(window);
              Transaction trns1 = new Transaction();
             trns1.transaction_calc(6,crypto_symbol, crypto_eur_price, crypto_btc_price, crypto_amount_requested,payment_currency, eur_balance, trans_date, trans_buy_sell);
        });*/
       
            window.setResizable(false);
            window.setTitle("Exchange");
            window.show();
        }
}