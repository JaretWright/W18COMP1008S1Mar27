package w18comp1008s1mar27;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author JWright
 */
public class GUIExampleLaunch extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //If you misspell the .fxml file name, you will get an exception 
        //with "Location not set"
        Parent root = FXMLLoader.load(getClass().getResource("GUIExampleView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Experiments with GUI objects");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
