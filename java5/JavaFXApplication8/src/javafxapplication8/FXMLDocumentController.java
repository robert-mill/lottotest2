package javafxapplication8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author rmill_000
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private Button button;
    @FXML
    private void handleButtonAction() {
        System.out.println("You clicked me!");
        button.setText("don't push this button again!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
