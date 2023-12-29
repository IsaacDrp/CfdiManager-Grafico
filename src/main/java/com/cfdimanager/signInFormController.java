package com.cfdimanager;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class signInFormController implements Initializable{

    @FXML
    private TextField txtUserSignIn;

    @FXML
    private TextField txtPassWordSignInMask;

    @FXML
    private PasswordField txtPassWordSignIn;

    @FXML
    private CheckBox checkViewPassSignIn;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnClear;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        maskPassWord(txtPassWordSignIn, txtPassWordSignInMask, checkViewPassSignIn);

        addEventFilter(txtUserSignIn);
        addEventFilter(txtPassWordSignIn);
        addEventFilter(txtPassWordSignInMask);
    }

    private void addEventFilter(TextField textField) {
        textField.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(textField.equals(txtUserSignIn)){
                    if(event.getCharacter().equals(" ") || textField.getText().length() > 5)
                        event.consume();;
                }
                else{
                    if(textField.getText().length() >5)
                        event.consume();
                }
            }
        });
    }

    public void maskPassWord(PasswordField pass, TextField text, CheckBox check){
        
        text.setVisible(false);
        text.setManaged(false);

        text.managedProperty().bind(check.selectedProperty());
        text.visibleProperty().bind(check.selectedProperty());
        pass.managedProperty().bind(check.selectedProperty().not());
        pass.visibleProperty().bind(check.selectedProperty().not());

        text.textProperty().bindBidirectional(pass.textProperty());
    }
    
}
