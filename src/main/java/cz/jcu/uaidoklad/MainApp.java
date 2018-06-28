package cz.jcu.uaidoklad;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import cz.jcu.uaidoklad.Model.Faktura;
import javafx.scene.image.Image;



public class MainApp extends Application {

    
    /**
     * 
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/HlavniOkno.fxml"));
                 
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/hlavniokno.css");
       
        stage.getIcons().add(new Image("/main/java/cz.jcu.uaidoklad/java.jfif"));
        stage.setTitle("UAIdoklad");
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
