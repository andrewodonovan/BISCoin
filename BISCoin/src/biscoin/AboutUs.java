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
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AboutUs extends SignIn{
    public AboutUs(){
        //constructor
    }
    
    @Override
    public void start(Stage window){
      GridPane layoutAboutUs = new GridPane();
      layoutAboutUs.setHgap(5);
      layoutAboutUs.setVgap(5);
      Scene aboutUsScene = new Scene(layoutAboutUs, 1200, 800);
      window.setTitle("About Us");
      
            Exchange exchangeObj1 = new Exchange();
            LandingPage BISCoinHomeObj1 = new LandingPage();
            ContactUs contactUsObj1 = new ContactUs();
            Portfolio portfolioObj1 = new Portfolio();
            FAQ faqObj1 = new FAQ();
            MainMenu mainMenuObj1 = new MainMenu();
            AndrewBio andrewBioObj1 = new AndrewBio();
            SamLKBio samLKBioObj1 = new SamLKBio();
            SamPBio samPBioObj1 = new SamPBio();
            DonnachaBio donnachaBioObj1 = new DonnachaBio();
            LamBio lamBioObj1 = new LamBio();
            
            Button btnHome = mainMenuObj1.getBtnHome();
            Button btnFAQGuides = mainMenuObj1.getBtnFAQGuides();
            Button btnBuySell = mainMenuObj1.getBtnBuySell();
            Button btnPortfolio = mainMenuObj1.getBtnPortfolio();
            Button btnAboutUs = mainMenuObj1.getBtnAboutUs();
            Separator menuSep = mainMenuObj1.getSep();
            MenuBar menuBar = mainMenuObj1.getMenuBar();
            
            aboutUsScene.getStylesheets().add("MainMenu.css");
            aboutUsScene.getStylesheets().add("AboutUs.css");
            window.setScene(aboutUsScene);
            
            ToolBar aboutUsMainMenu = new ToolBar(
                    btnHome,
                    btnFAQGuides,
                    btnBuySell,
                    btnPortfolio,
                    btnAboutUs,
                   
                    menuSep,
                    menuBar
            );
            layoutAboutUs.add(aboutUsMainMenu, 0, 0, 1200, 11);
            aboutUsMainMenu.setStyle("-fx-background-color: #000000;");
      Text txtPassionHeading = new Text("Passion");
      txtPassionHeading.setId("txtPassionHeading");
      
      Text txtPassion = new Text("Even before forming BISCoin our co-founders Sam,"
              + " Andrew, Donnacha, Lâm and Sam had a passion for an experience in"
              + " things like trading crypto currencies and stocks, skills in creating"
              + " smooth UX interfaces, business accumen to front and back end development"
              + " We knew that this combination of skills could be used for the benefit"
              + " of others in some shape or form. So we started collaborating.");
      txtPassion.setWrappingWidth(700);
      txtPassion.setTextAlignment(TextAlignment.JUSTIFY);
      txtPassion.setId("txtPassion");
      
      VBox vboxPassion = new VBox(
              txtPassionHeading,
              txtPassion
      );
      vboxPassion.setId("vboxPassion");
      vboxPassion.setPadding(new Insets(0, 0, 10, 30));
      
      Image img1 = new Image("Image 1.png", 145, 145, false, false);
      ImageView iv1 = new ImageView(img1);
      VBox vboxImgView1 = new VBox(iv1);
      vboxImgView1.setPadding(new Insets(0, 0, 0, 30));
      
      HBox hboxPassion = new HBox(
              vboxPassion,
              vboxImgView1
      );
      hboxPassion.setPadding(new Insets(5, 0, 0, 0));
      
      Text txtProblemHeading = new Text("Problem");
      txtProblemHeading.setId("txtProblemHeading");
      Text txtProblem = new Text("We recognised a problem in recent times. That ther was no platform"
              + " for students to buy and sell cryptocurrency, that was user friendly, very intuitive and informative to"
              + " appeal to the new, inexperienced user. So we decided to solve that problem by utilising our skills"
              + " and expertise in these areas.");
      txtProblem.setId("txtProblem");
      txtProblem.setWrappingWidth(700);
      txtProblem.setTextAlignment(TextAlignment.JUSTIFY);
      
      VBox vboxProblem = new VBox(
              txtProblemHeading,
              txtProblem
      );
       vboxProblem.setPadding(new Insets(0, 0, 10, 30));
       
      Image img2 = new Image("Image 2.png", 290, 145, false, false);
      ImageView iv2 = new ImageView(img2);
      VBox vboxImgView2 = new VBox(iv2);
      vboxImgView2.setPadding(new Insets(0, 0, 0, 33));
      
      
      HBox hboxProblem = new HBox(
              vboxProblem,
              vboxImgView2
      );
      
      
      Text txtProductHeading = new Text("Product");
      txtProductHeading.setId("txtProductHeading");
      Text txtProduct = new Text("To solve that problem we had to create a platform that met the needs of the user."
              + " Well, that is just exactly what we did. By drawing on our collective expertise and addressing the problem at hand"
              + " we created a product that even the most inexperienced user could use to by and sell currencies,"
              + " have access to information about cryptocurrencies, whilst offering low fees to make trading crytpocurrency"
              + " affordable to interested students.");
      txtProduct.setWrappingWidth(700);
      txtProduct.setTextAlignment(TextAlignment.JUSTIFY);
      txtProduct.setId("txtProduct");
      
      VBox vboxProduct = new VBox(
              txtProductHeading,
              txtProduct
      );
      vboxProduct.setPadding(new Insets(0, 0, 0, 30));
      
      
      Image img3 = new Image("Image 3.png", 145, 145, false, false);
      ImageView iv3 = new ImageView(img3);
      VBox vboxImgView3 = new VBox(iv3);
      vboxImgView3.setPadding(new Insets(0, 0, 0, 30));
      
      HBox hboxProduct = new HBox(
              vboxProduct,
              vboxImgView3
      );
      hboxProduct.setPadding(new Insets(0, 0, 10, 0));
      //Contact Section of the Page
      //FOUNDERS IMAGES
      
      Text txtFounders = new Text("Our Team");
      txtFounders.setId("txtFounders");
      txtFounders.setFill(Color.WHITE);
        
      txtFounders.setTextAlignment(TextAlignment.CENTER);
      HBox hboxTxtFounders = new HBox(txtFounders);
      hboxTxtFounders.setPadding(new Insets(5, 200, 5, 498));
      
      //Images of BISCoin Founders
      
      Image imgF1 = new Image("F1.gif", 115, 115, true, true);
      ImageView ivF1 = new ImageView(imgF1);
      ivF1.setId("ivF1");
      Text txtSamLK = new Text("Samuel Kiernan");
      txtSamLK.setStyle("-fx-font-size: 11pt;");
      txtSamLK.setTextAlignment(TextAlignment.CENTER);
      txtSamLK.setFill(Color.WHITE);
      VBox vboxImgViewFounder1 = new VBox(
              ivF1,
              txtSamLK
      );
      vboxImgViewFounder1.setPadding(new Insets(0, 12, 0, 12));
      
      Image imgF2 = new Image("F2.gif", 115, 115, true, true);
      Text txtAndrew = new Text("Andrew O' Donovan");
      txtAndrew.setStyle("-fx-font-size: 11pt;");
      txtAndrew.setTextAlignment(TextAlignment.CENTER);
      txtAndrew.setFill(Color.WHITE);
      ImageView ivF2 = new ImageView(imgF2);
      ivF2.setId("ivF2");
      VBox vboxImgViewFounder2 = new VBox(
              ivF2,
              txtAndrew
      );
      vboxImgViewFounder2.setPadding(new Insets(0, 12, 0, 12));
      
      Image imgF3 = new Image("F3.gif", 115, 115, true, true);
      Text txtDonie = new Text("Donnacha Murphy");
      txtDonie.setStyle("-fx-font-size: 11pt;");
      txtDonie.setTextAlignment(TextAlignment.CENTER);
      txtDonie.setFill(Color.WHITE);
      ImageView ivF3 = new ImageView(imgF3);
      ivF3.setId("ivF3");
      VBox vboxImgViewFounder3 = new VBox(
              ivF3,
              txtDonie
      );
      vboxImgViewFounder3.setPadding(new Insets(0, 12, 0, 12));
      
      Image imgF4 = new Image("F4.gif", 115, 115, true, true);
      Text txtLam = new Text("Lâm Hoàng");
      txtLam.setStyle("-fx-font-size: 11pt;");
      txtLam.setTextAlignment(TextAlignment.CENTER);
      txtLam.setFill(Color.WHITE);
      HBox hboxLam = new HBox(txtLam);
      hboxLam.setPadding(new Insets(0, 0, 0 , 22));
      ImageView ivF4 = new ImageView(imgF4);
      ivF4.setId("ivF4");
      VBox vboxImgViewFounder4 = new VBox(
              ivF4,
              hboxLam
      );
      vboxImgViewFounder4.setPadding(new Insets(0, 12, 0, 12));
      
      Image imgF5 = new Image("F5.gif", 115, 115, true, true);
      ImageView ivF5 = new ImageView(imgF5);
      ivF5.setId("ivF5");
      Text txtSamP = new Text("Samuel Punch");
      txtSamP.setStyle("-fx-font-size: 11pt;");
      HBox hboxSamP = new HBox(txtSamP);
      hboxSamP.setPadding(new Insets(0, 0, 0 , 15));
      txtSamP.setTextAlignment(TextAlignment.CENTER);
      txtSamP.setFill(Color.WHITE);
      VBox vboxImgViewFounder5 = new VBox(
              ivF5,
              hboxSamP
      );
      vboxImgViewFounder5.setPadding(new Insets(0, 12, 0, 12));
      
      
      HBox hboxFounders = new HBox(
              vboxImgViewFounder1,
              vboxImgViewFounder2,
              vboxImgViewFounder3,
              vboxImgViewFounder4,
              vboxImgViewFounder5
      );
      hboxFounders.setPadding(new Insets(10, 0, 10, 190));
      
      Text txtClick = new Text("Click the pictures above to find out more about us");
      txtClick.setFill(Color.WHITE);
      txtClick.setId("txtClick");
      HBox hboxTxtClick = new HBox(txtClick);
      hboxTxtClick.setPadding(new Insets(5, 0, 0, 375));
     
      // CONTACT INFO
      
      Text txtPhone = new Text("Phone: 08X XXX XXXX");
      txtPhone.setFill(Color.WHITE);
      HBox hboxTxtPhone = new HBox(txtPhone);
      hboxTxtPhone.setPadding(new Insets(9, 0, 0, 0));
      hboxTxtPhone.setId("hboxTxtPhone");
      
      Hyperlink lnkWebsite = new Hyperlink("BISCoin.com");
      lnkWebsite.setTextFill(Color.WHITE);
      lnkWebsite.setBorder(Border.EMPTY);
      HBox hboxLnkWebsite = new HBox(lnkWebsite);
      hboxLnkWebsite.setPadding(new Insets(5, 0, 0, 275));
      hboxLnkWebsite.setId("hboxLnkWebsite");
      
      Image imgTwitter = new Image("Twitter.png", 40, 40, true, true);
      ImageView ivTwitter = new ImageView(imgTwitter);
      VBox vboxImgViewTwitter = new VBox(ivTwitter);
      vboxImgViewTwitter.setPadding(new Insets(-5, 0, 0, 10));
      
      Image imgFb = new Image("FB.png", 40, 40, true, true);
      ImageView ivFb = new ImageView(imgFb);
      VBox vboxImgViewFb = new VBox(ivFb);
      vboxImgViewFb.setPadding(new Insets(-5, 0, 0, 10));
      
      Image imgLinkedin = new Image("LinkedIn.png", 40, 40, true, true);
      ImageView ivLinkedin = new ImageView(imgLinkedin);
      VBox vboxImgViewLinkedin = new VBox(ivLinkedin);
      vboxImgViewLinkedin.setPadding(new Insets(-5, 0, 0, 10));
      
      HBox hboxSocialMedia = new HBox(
              vboxImgViewTwitter,
              vboxImgViewFb,
              vboxImgViewLinkedin
      );
      hboxSocialMedia.setPadding(new Insets(0, 0, 0, 325));
      
      HBox hboxContactContent = new HBox(
           hboxTxtPhone,
           hboxLnkWebsite,
           hboxSocialMedia
      );
      hboxContactContent.setId("hboxContactContent");
      hboxContactContent.setPadding(new Insets(15, 15, 15, 40));
      
      VBox vboxContact = new VBox(
              hboxTxtFounders,
              hboxFounders,
              hboxTxtClick,
              hboxContactContent
      );
      
      vboxContact.setId("hboxContact");
      vboxContact.setPadding(new Insets(10, 10, 10, 0));
      
      VBox aboutUsOuterCont = new VBox(
              hboxPassion,
              hboxProblem,
              hboxProduct,
              vboxContact
      );
      layoutAboutUs.add(aboutUsOuterCont, 0, 12, 1200, 800);
      
      //Buttons to link to other pages
            btnAboutUs.setOnAction(e -> {
                window.setScene(aboutUsScene);
                window.setTitle("About Us");
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
            
            
            ivF1.setOnMouseClicked(e -> {
                samLKBioObj1.start(window);
            });
            
            ivF2.setOnMouseClicked(e -> {
                andrewBioObj1.start(window);
            });
            
            ivF3.setOnMouseClicked(e -> {
                donnachaBioObj1.start(window);
            });
            
            ivF4.setOnMouseClicked(e -> {
                lamBioObj1.start(window);
            });
            
            ivF5.setOnMouseClicked(e -> {
                samPBioObj1.start(window);
            });
            
      
      window.setResizable(false);
      window.setScene(aboutUsScene);
      window.show();
    }
}