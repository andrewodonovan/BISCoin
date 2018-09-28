
package biscoin;

import static biscoin.SignIn.sqlConnection;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
//ROME IMPORTS
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Scanner;
import java.util.TimeZone;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LandingPage extends SignIn {
    public static String strCrypto;
    ArrayList <String> result = new ArrayList<String>(); 
    public static void setCrypto(String crypto){
        strCrypto = crypto;
    }
    
    public static String getCrypto(){
        return strCrypto;
    }
    ArrayList<String> cryptoDate = new ArrayList<>();
          ArrayList<Double> high = new ArrayList<>(); 
          String cryptoName = "ADA";
          String timeFrame = new String("7");
          String purchaseCurrency = new String("EUR");
          String timeAggerate = new String("1");
          String strnDescription = new String();
          String strLoggedIn;
    public LandingPage(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
        String strDescription = new String();
        try {
    GridPane layoutLanding = new GridPane();
    layoutLanding.setVgap(5);
    layoutLanding.setHgap(5);
    
    Scene landingScene = new Scene(layoutLanding, 1200, 800, Color.WHITE);
    landingScene.getStylesheets().add("LandingPage.css");
    landingScene.getStylesheets().add("MainMenu.css");
    
    window.setTitle("Landing Page");
    
    Exchange exchangeObj1 = new Exchange();
    AboutUs aboutUsObj1 = new AboutUs();
    Portfolio portfolioObj1 = new Portfolio();
    FAQ faqObj1 = new FAQ();
    MainMenu mainMenuObj1 = new MainMenu();
    SignIn signInObj1 = new SignIn();
    
    Button btnHome = mainMenuObj1.getBtnHome();
    Button btnFAQGuides = mainMenuObj1.getBtnFAQGuides();
    Button btnBuySell = mainMenuObj1.getBtnBuySell();
    Button btnPortfolio = mainMenuObj1.getBtnPortfolio();
    Button btnAboutUs = mainMenuObj1.getBtnAboutUs();
    Separator menuSep = mainMenuObj1.getSep();
    
    //Creating user menu
    MenuBar menuBar = new MenuBar(); 
    javafx.scene.control.Menu menu = new javafx.scene.control.Menu(strLoggedIn);
        MenuItem mniFundAccount = new MenuItem("Fund My Account");
        MenuItem mniWithdraw = new MenuItem("Withdraw Funds");
        MenuItem mniDelete = new MenuItem("Delete Account");
        MenuItem mniLogOut = new MenuItem("Log Out");
        menu.getItems().addAll(
                mniFundAccount,
                mniWithdraw,
                mniDelete,
                new SeparatorMenuItem(),
                mniLogOut
        );
        
        mniFundAccount.setOnAction(e -> {
            //Fund my Account Code Here
        });
        
        mniWithdraw.setOnAction(e -> {
            //Withdraw Code Here
        });
        
        mniDelete.setOnAction(e -> {
            //Delete Code Here
        });
        
        mniLogOut.setOnAction(e -> {
            
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm Log Out");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("Are you sure you want to log out, "+ strLoggedIn +"?");

        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                signInObj1.start(window);
            }
        });
        
        
        
        
        menuBar.getMenus().add(menu);
        menuBar.setId("menuBar");
    
    ToolBar landingMainMenu = new ToolBar(
                btnHome,
                btnFAQGuides,
                btnBuySell,
                btnPortfolio,
                btnAboutUs,
                menuSep,
                menuBar
        );
        layoutLanding.add(landingMainMenu, 0, 0, 1200, 11);
        landingMainMenu.setStyle("-fx-background-color: #000000;");            
            
            HBox hbxChart = new HBox();
            
            //Takes up top half
            hbxChart.setMinSize(1200, 400);
            hbxChart.setMaxSize(1200, 400);
            hbxChart.setStyle("-fx-border-color: #000000; -fx-border-width: 0.5;");
            
            VBox vboxTicker = new VBox(
                    new Text("Featured Cryptocurrencies")
                    
            );
            vboxTicker.setMinSize(480, 390);//40%
            vboxTicker.setMaxSize(480, 390);//40%
            vboxTicker.setStyle("-fx-border-color: #000000; -fx-border-width: 0.5;");
                /*
             /
             /  Start of Chart Declaration
             /
             */
        
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Dates");
        yAxis.setLabel("Price (Euro)");
        //creating the chart
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
          lineChart.setCreateSymbols(false);      
        lineChart.setTitle("Price of " + cryptoName + " in the last " + timeFrame + " Days");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        
        series.setName("Price of " + cryptoName + " in " + purchaseCurrency);
     
              try {
                  this.getData();
                
              } catch (Exception ex) {
                  Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
              }
        //populating the series with data
          String[] cryptoDatea = new String[cryptoDate.size()];
        double[] higha = new double[high.size()];
        int k = 0;
        int m = 0;
        while(m <= cryptoDatea.length - 1){
            System.out.println("Length: " + cryptoDatea.length);
                            cryptoDatea[m] = cryptoDate.get(m);
                             higha[m] = high.get(m);
                             
                             m++;
                        }
        while(k<=cryptoDatea.length - 1){
            System.out.println("Length: " + cryptoDatea.length);
            System.out.println("k: " + k);
            System.out.println("Date: " + cryptoDatea[k] + "  ; High: " + higha[k] + "j val: " + k);
        series.getData().add(new XYChart.Data(cryptoDatea[k], higha[k]));
        k++;
        }
         lineChart.getData().add(series);
         lineChart.setMinWidth(1050);
         lineChart.setMaxWidth(1050);
        
        
         // Creating Menu Section
         String strSQLCrypto = "SELECT crypto_symbol FROM tblcrypto;"; 
         ComboBox cmbCrypto = new ComboBox();
         try{
         Connection conn = sqlConnection();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(strSQLCrypto);
                    
                    int columnCount = rs.getMetaData().getColumnCount();
                        while(rs.next()){
                            String[] row = new String[columnCount];
                                for (int i=0; i <columnCount ; i++){
                                    row[i] = rs.getString(i + 1);
                                    result.add(row[i]);
                                    cmbCrypto.getItems().add(row[i]);
                                    
                                }
                        }
                        cmbCrypto.getSelectionModel().selectFirst();
                        
          
                        
         } catch(SQLException ex){
             System.err.println(ex);
         }
         
         ComboBox cmbPurchaseCurrency = new ComboBox();
         ComboBox cmbTimeFrame = new ComboBox();
         Label lblCrypto = new Label("Name");
         Label lblPurchaseCurrency = new Label("Currency");
         Label lblTimeFrame = new Label("Time Period");
         VBox vbxMenuCont = new VBox();
         vbxMenuCont.setSpacing(10);
         vbxMenuCont.setMinWidth(130);
         vbxMenuCont.setMaxWidth(130);
         
         VBox vbxMenu1 = new VBox();
         vbxMenu1.getChildren().addAll(lblCrypto, cmbCrypto);
     //    vbxMenu1.setMinWidth(200);
     //    vbxMenu1.setMaxWidth(200);
         
         VBox vbxMenu2 = new VBox();
         vbxMenu2.getChildren().addAll(lblPurchaseCurrency, cmbPurchaseCurrency);
    //     vbxMenu2.setMinWidth(200);
    //     vbxMenu2.setMaxWidth(200);
         
         VBox vbxMenu3 = new VBox();
         vbxMenu3.getChildren().addAll(lblTimeFrame, cmbTimeFrame);
    //     vbxMenu3.setMinWidth(200);
    //     vbxMenu3.setMaxWidth(200);
         //ComboBox cmbCrypto = new ComboBox();
         //hbxMenuCont.setHgap();
         vbxMenuCont.getChildren().addAll(vbxMenu1, vbxMenu2 , vbxMenu3);
         
        hbxChart.getChildren().addAll(lineChart,vbxMenuCont);
        
                    Text txtNoChart = new Text("Unfortunately no chart exists for that combination");
                    HBox hboxTxtNoChart = new HBox(txtNoChart);
                    cmbPurchaseCurrency.requestFocus();
                    hboxTxtNoChart.setPadding(new Insets(90, 325, 90, 325));
        try{
        cmbCrypto.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String oldCrypto, String newCrypto) {
                setCrypto(newCrypto);
                cryptoName = getCrypto();
                timeFrame =  "7";//cmbTimeFrame.getValue().toString();
                purchaseCurrency = "EUR";//cmbPurchaseCurrency.getValue().toString();
                System.out.println("Memes Are Dead and DONIE will not Succeed");
                LineChart line = null;
                try{
                     line = LandingPage.this.setChartValue();
                } catch(Exception ex){
                    System.err.println("Error is: " + ex);
                    
                } finally{
                cryptoDate.clear();
                high.clear();
                hbxChart.getChildren().clear();
                if(line != null){
                hbxChart.getChildren().addAll(line, vbxMenuCont);
                } else {
                    hbxChart.getChildren().addAll(hboxTxtNoChart, vbxMenuCont);
                }
                line.setMinWidth(1050);
                line.setMaxWidth(1050);
                hbxChart.setMinWidth(1050);
                hbxChart.setMaxWidth(1050);
                cmbPurchaseCurrency.requestFocus();
                }
                
            }
          });
        } catch (Exception ex){
            System.out.println("This went wrong: " + ex);
        }
        
        //Scene scene  = new Scene(lineChart,800,600);
        landingScene.getStylesheets().add("charts.css");
             
       
        /*
        /
        /   End of Chart Section
        /
        */
        
            /*
            /
            / Start Of RSS Feed
            /
            */
            ScrollPane layoutScroll= new ScrollPane();
            String feed = "http://bitcoin.worldnewsoffice.com/rss/category/2";
            int i = 0;
            URL feedUrl = new URL(feed);
            List<String[]> lstRss = new ArrayList<String[]>();
            String[] rssArray = new String[3];
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed sf = input.build(new XmlReader(feedUrl));
            // RSSList rss = new RSSList();
            List entries = sf.getEntries();
            Iterator it = entries.iterator();
            
            // Declare Flow Plane
            FlowPane flow = new FlowPane(); //Orientation.VERTICAL
            flow.setColumnHalignment(HPos.LEFT);
            flow.setVgap(5);
            flow.setHgap(0);
            // flow.setPrefWrapLength(300);
            // End of flow pane
            final WebView browser = new WebView();
            final WebEngine webEngine = browser.getEngine();
            while (it.hasNext()) {
                i++;
                SyndEntry entry = (SyndEntry)it.next();
                SyndContent description = entry.getDescription();
                
                strDescription = description.getValue();
                if(strDescription.length() > 30){
    strDescription = strDescription.substring(0,30) + "...";
    // String strnDescription = new String(description.getValue());
                    strnDescription = (description.getValue());
                
                // Filtering Unicode
                strnDescription = strnDescription.replace("&#38;#39", "");
                strnDescription = strnDescription.replace("&#38;nbsp;&#38;raquo;", "");
                strnDescription = strnDescription.replace("&#38;quot;", "");
                }
                Hyperlink hypLink = new Hyperlink(entry.getTitle());   //(entry.getLink());
               
                Label lblDescription = new Label(strnDescription);
                
                //Setting Min and Max Widths
                lblDescription.setMaxWidth(650);
                hypLink.setMaxWidth(650);
                lblDescription.setMinWidth(650);
                hypLink.setMinWidth(650);
                
                //Wrap Texts
                lblDescription.setWrapText(true);
                 lblDescription.setFont(Font.font("Verdana", FontWeight.BOLD, 9));
                hypLink.setWrapText(true);
                hypLink.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                //HyperLink Stuff
                String urla = entry.getLink();
                hypLink.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        // webEngine.load(urla);
                        Desktop d = Desktop.getDesktop();
                        try {
                            d.browse(new URI(urla));
                        } catch (URISyntaxException ex) {
                            //       Logger.getLogger(RSSTest.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            //       Logger.getLogger(RSSTest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                
                
                //flow.getChildren().add(lblTitle);
                flow.getChildren().add(hypLink);
                flow.getChildren().add(lblDescription);
                //     flow.getChildren().add(lblSpacer);
                
            }
            flow.setMaxWidth(700);
            flow.setMinWidth(700);
            
            
            /////////////////////////////
            layoutScroll.setContent(flow);
            layoutScroll.setMaxWidth(700);
            layoutScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            layoutScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            //  layoutScroll.setVmax(1100);
            
            /*
            /
            /
            /End Of RSS Feed
            /
            */
            
            /*
            /
            /
            / Start Of Crypto Ticker
            /
            */
            ObservableList<ObservableList> data;
           TableView tbvTicker = new TableView();
                 // VERY IMPORTANT CODE
        
        Connection c;
           LandingPage BISCoinHomeObj1 = new LandingPage();
          data = FXCollections.observableArrayList();
          try{
            c = BISCoinHomeObj1.sqlConnection();
            //SQL FOR SELECTING ALL OF Crypto In tblCrypto
            String SQL = "SELECT crypto_symbol As 'Crypto', crypto_price As 'Price (€)', crypto_perc24 As '% Change)' FROM tblcrypto GROUP BY crypto_perc24 DESC LIMIT 10";
            //ResultSet
              ResultSet rs = c.createStatement().executeQuery(SQL);
                    
            for(int l=0 ; l<rs.getMetaData().getColumnCount(); l++){
                //We are using non property style for making dynamic table
                final int j = l;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnLabel(l+1));
                 col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tbvTicker.getColumns().addAll(col);
                tbvTicker.getSortOrder().add(col);
                tbvTicker.setEditable(false);
                tbvTicker.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int l=1 ; l<=rs.getMetaData().getColumnCount(); l++){
                    //Iterate Column
                    row.add(rs.getString(l));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tbvTicker.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
            vboxTicker.getChildren().addAll(tbvTicker);
            /*/
            /
            /
            /End Of CryptoTicker
            /
            */
            
            
            
            VBox vboxRSS = new VBox(
                layoutScroll        
            );
            
           
            vboxRSS.setMinSize(720, 390);//60%
            vboxRSS.setMaxSize(720, 390);//60%
            vboxRSS.setStyle("-fx-border-color: #000000; -fx-border-width: 0.5;");
            
            HBox hboxBottomSplit = new HBox(
                    vboxTicker,
                    vboxRSS
            );
            
            
            VBox outerContLanding = new VBox(
                    hbxChart,
                    hboxBottomSplit
                    
            );
            
            btnBuySell.setOnAction(e -> {
                exchangeObj1.start(window);
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
            
            
            window.setResizable(false);
            layoutLanding.add(outerContLanding, 0, 11, 1200, 790);
            window.setScene(landingScene);
            window.show();
        } catch (MalformedURLException ex) {
            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FeedException ex) {
            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
         public void getData() throws ParseException, Exception{
         try {
              URL url = new URL("https://min-api.cryptocompare.com/data/histoday?fsym=" + cryptoName + "&tsym=" + purchaseCurrency +"&limit="+ timeFrame +"&aggregate=" + timeAggerate +"&e=CCCAGG"); 
              HttpURLConnection conn = (HttpURLConnection)url.openConnection(); 
              conn.setRequestMethod("GET"); 
              
           //   URL urla = new URL("https://min-api.cryptocompare.com/data/histoday?fsym=" + cryptoName + "&tsym=" + purchaseCurrency +"&limit="+ timeFrame +"&aggregate=" + timeAggerate +"&e=CCCAGG"); 
           //   HttpURLConnection conna = (HttpURLConnection)urla.openConnection(); 
           //   conna.setRequestMethod("GET"); 
              
              String inline = new String();
              conn.connect(); 
           
               int j = 0;
             
              int responsecode = conn.getResponseCode(); 
              
              if(responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " +responsecode);
                else{
                       Scanner sc = new Scanner(url.openStream());
                        while(sc.hasNext())
                        {
                            inline+=sc.nextLine();
                        }
                        JSONParser parser = new JSONParser();
                        JSONObject objJson = (JSONObject) parser.parse(inline);
                        JSONArray slideContent = (JSONArray) objJson.get("Data");
                        Iterator i = slideContent.iterator();

                        while (i.hasNext()) {
                            JSONObject dataPoint = (JSONObject) i.next();
                            long timestamp = (long) dataPoint.get("time");
                            cryptoDate.add(this.convTime(timestamp));
                            high.add((double) dataPoint.get("high"));                            
                            j++;
                        }
                        
                     
                        sc.close();
                    
                    }

         
         } catch (IOException ex) {
             Logger.getLogger(JSonParserTest.class.getName()).log(Level.SEVERE, null, ex);
         }
  

}
     public String convTime(long TimeStamp)
   {
   //Unix seconds
 //  long unix_seconds = 1372339860;
   //convert seconds to milliseconds
   Date date = new Date(TimeStamp*1000L); 
   // format of the date
   SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd");
   jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
   String javaDate = jdf.format(date);
 //  System.out.println("\n"+javaDate+"\n");
   
   return javaDate;
   }
     
     
     public LineChart setChartValue(){
            final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Dates");
        yAxis.setLabel("Price (Euro)");
        //creating the chart
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
          lineChart.setCreateSymbols(false);      
        lineChart.setTitle("Price of " + cryptoName + " in the last " + timeFrame + " Days");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        
        series.setName("Price of " + cryptoName + " in " + purchaseCurrency);
     //   series.setID("lol");
      //  series.nodeProperty().get().setStyle("-fx-stroke-width: 1px;");
          //   series.getNode().setStyle("-fx-stroke: #00FF00; ");
              try {
                  this.getData();
                
              } catch (Exception ex) {
                  Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
              }
        //populating the series with data
          String[] cryptoDatea = new String[cryptoDate.size()];
        double[] higha = new double[high.size()];
        int k = 0;
        int m = 0;
        while(m <= cryptoDatea.length - 1){
            System.out.println("Length: " + cryptoDatea.length);
                            cryptoDatea[m] = cryptoDate.get(m);
                             higha[m] = high.get(m);
                             
                             m++;
                        }
        while(k<=cryptoDatea.length - 1){
            System.out.println("Length: " + cryptoDatea.length);
            System.out.println("k: " + k);
            System.out.println("Date: " + cryptoDatea[k] + "  ; High: " + higha[k] + "j val: " + k);
        series.getData().add(new XYChart.Data(cryptoDatea[k], higha[k]));
        k++;
        }
         lineChart.getData().add(series);
         return lineChart;
     };
}
