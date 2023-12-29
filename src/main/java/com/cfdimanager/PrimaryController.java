package com.cfdimanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable{

    @FXML
    private Button btnSign;

    @FXML
    private StackPane containerForm;

    private VBox signInForm;
    private VBox signUpForm;

    @FXML
    private Label txtWelcome;
    @FXML
    private Label txtQuestion;

    @FXML
    private void swapSignForms(ActionEvent e){

        if (btnSign.getText().equals("¡Regístrate!")){
            btnSign.setText("¡Inicia sesión!");
            txtWelcome.setText("¡Bienvenido a CAM!");
            txtQuestion.setText("¿Ya tienes cuenta?");
            signInForm.setVisible(false);
            signUpForm.setVisible(true);

        }
        else if (btnSign.getText().equals("¡Inicia sesión!")){
            btnSign.setText("¡Regístrate!");
            txtWelcome.setText("¡Bienvenido de nuevo!");
            txtQuestion.setText("¿Aún no tienes cuenta?");
            signInForm.setVisible(true);
            signUpForm.setVisible(false);
        }
    }
    

    private VBox loadForm(String fxmlPath) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        return loader.load();
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        try {
            this.signInForm = loadForm("/com/cfdimanager/signInForm.fxml");
            this.signUpForm = loadForm("/com/cfdimanager/signUpForm.fxml");
            containerForm.getChildren().addAll(signInForm, signUpForm);
            signInForm.setVisible(true);
            signUpForm.setVisible(false);
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e);
        }
    }
}
