
package biscoin;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author donnm
 */
public class LoadingScreen extends SignIn implements Runnable{
        

        
        public LoadingScreen(){
            
        }
     
        public void start(Stage window){
          window.setTitle("Loading...");
          
          GridPane layout = new GridPane();
          layout.setStyle("-fx-background: #0D47A1; -fx-font-size: 20pt;");
          layout.setVgap(5);
          layout.setHgap(5);
          
          Image image = new Image("Loading2.gif");
      
            //Setting the image view 1 
          ImageView iv = new ImageView(image); 
          iv.setFitHeight(100); 
          iv.setFitWidth(100);         
          layout.add(iv, 100, 40);
          Label lblLoading = new Label("Loading 0%");
          layout.add(lblLoading, 90, 60);
         
        Scene scene = new Scene(layout, 1200, 800);
        
        window.setScene(scene);
        window.show();
        

    }

}
