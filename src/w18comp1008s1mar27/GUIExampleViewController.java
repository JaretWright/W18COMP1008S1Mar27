package w18comp1008s1mar27;

import java.net.URL;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class GUIExampleViewController implements Initializable
{
    //used to style the background of the AnchorPane
    @FXML    private AnchorPane anchorPane;
    
    //used for the check box objects
    @FXML    private CheckBox sleptInCheckBox;
    @FXML    private CheckBox workingCheckBox;
    @FXML    private CheckBox videoGamesCheckBox;
    @FXML    private CheckBox drinkCheckBox;
    @FXML    private CheckBox fearCheckBox;
    @FXML    private CheckBox musclePainCheckBox;
    @FXML    private TextArea excuseTextArea;
    
    //Used for the Slider object
    @FXML    private Slider slider;
    @FXML    private Label sliderLabel;

    //For the comboBox
    @FXML    private ComboBox<String> lunchComboBox;
    @FXML    private Label lunchLabel;
    
    //For the radio buttons
    @FXML    private RadioButton tallRadioButton;
    @FXML    private RadioButton grandeRadioButton;
    @FXML    private RadioButton ventiRadioButton;
    @FXML    private Label sizeLabel;
             private ToggleGroup sizeToggleGroup;
             
    /**
     * This method will update the color of the background when the button is
     * pushed
     */
    public void changeColorButtonPushed()
    {
        anchorPane.getStyleClass().clear();
        
        SecureRandom rng = new SecureRandom();
        int randomNum = rng.nextInt(3);
        if (randomNum == 0)
            anchorPane.getStyleClass().add("customBackground1");
        else if (randomNum == 1)
            anchorPane.getStyleClass().add("customBackground2");
        else
        {
            anchorPane.getStyleClass().add("mainFxmlClass");
        }
            
    }
    
    
    /**
     * This will update the lunchLabel when the comboBox is changed
     */
    public void comboBoxWasUpdated()
    {
        lunchLabel.setText(String.format("Lunch today will be %s",
                                         lunchComboBox.getValue()));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //this configures the slider
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(10);  //sets the "default" value
        updateSliderLabel();
        
        //configure the combobox
        lunchComboBox.getItems().add("pizza");
        List lunchItems = Arrays.asList("sandwhich","spaghetti","noodles","taco");
        lunchComboBox.getItems().addAll(lunchItems);
        this.lunchLabel.setText("");
        
        //configure the radio buttons and toggle group
        sizeToggleGroup = new ToggleGroup();
        tallRadioButton.setToggleGroup(sizeToggleGroup);
        grandeRadioButton.setToggleGroup(sizeToggleGroup);
        ventiRadioButton.setToggleGroup(sizeToggleGroup);
        sizeLabel.setText("");
    }    
    
    /**
     * This will update the label every time the radio button is changed
     * 
     */
    public void radioButtonChanged()
    {
        if (sizeToggleGroup.getSelectedToggle().equals(this.tallRadioButton))
            sizeLabel.setText("Tall selected");
        if (sizeToggleGroup.getSelectedToggle().equals(this.grandeRadioButton))
            sizeLabel.setText("Grande selected");
        if (sizeToggleGroup.getSelectedToggle().equals(this.ventiRadioButton))
            sizeLabel.setText("Venti selected");
    }
    
    /**
     * This will read the value from the slider and update
     * the label formatted with no decimals
     */
    public void updateSliderLabel()
    {
        this.sliderLabel.setText(String.format("%.0f%%",slider.getValue()));
        
    }
    
    public void updateExcuseTextArea()
    {
        String excuses = "Ben's excuses are: \n";
        
        if (this.drinkCheckBox.isSelected())
            excuses += "too many refreshments last night\n";
        
        if (this.fearCheckBox.isSelected())
            excuses += "he is afraid of Jaret's wit\n";
        
        if (this.musclePainCheckBox.isSelected())
            excuses += "too many pushup last week and he is sore\n";
        
        if (this.sleptInCheckBox.isSelected())
            excuses += "slept in\n";
        
        if (this.videoGamesCheckBox.isSelected())
            excuses += "played video games too late last night\n";
        
        if (this.workingCheckBox.isSelected())
            excuses += "called into work";
        
        this.excuseTextArea.setText(excuses);
    }
}
