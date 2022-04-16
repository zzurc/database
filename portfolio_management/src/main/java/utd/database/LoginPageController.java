package utd.database;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPageController {

    @FXML
    Button cancelButton;
    @FXML
    Label loginMessageLabel;
    @FXML
    TextField usernameTextField;
    @FXML
    PasswordField passwordTextField;

    public void loginButtonOnAction(ActionEvent e) {
        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }

    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseController connectNow = new DatabaseController();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT \t\tcount(1)\n" +
                "FROM \t\t\"UserAccount\"\n" +
                "WHERE \t\t\"UserAccount\".\"Uname\" = '" + usernameTextField.getText() +
                "' AND \t\t\"UserAccount\".\"userPassword\" = '" + passwordTextField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()) {
                if (queryResult.getInt( 1 ) == 1) {
                    loginMessageLabel.setText("Welcome");
                } else {
                    loginMessageLabel.setText("Invalid login. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
