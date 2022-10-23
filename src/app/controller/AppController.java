package app.controller;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import app.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private Button btnInsertConfirmCustomer;

    @FXML
    private Button btnVisualizeCustomer;

    @FXML
    private Button btnVisualizeAllCustomers;

    @FXML
    private Label labelInsertError;

    @FXML
    private Label labelInsertRequiredField;

    @FXML
    private TextField tfInsertAddress;

    @FXML
    private TextField tfInsertCity;

    @FXML
    private TextField tfInsertCompanyName;

    @FXML
    private TextField tfInsertContactName;

    @FXML
    private TextField tfInsertContactTitle;

    @FXML
    private TextField tfInsertCountry;

    @FXML
    private TextField tfInsertCustomerID;

    @FXML
    private TextField tfInsertFax;

    @FXML
    private TextField tfInsertPhone;

    @FXML
    private TextField tfInsertPostalCode;

    @FXML
    private TextField tfInsertRegion;

    @FXML
    private TextField tfSearchCustomerID;

    @FXML
    void actionCustomers(ActionEvent event) {
        String cmd = event.getSource().toString();
        CustomerController customerController = new CustomerController(tfInsertCompanyName, tfInsertContactName,
                tfInsertAddress, tfInsertCity, tfInsertRegion, tfInsertPostalCode,
                tfInsertCountry, tfInsertPhone, tfInsertFax, null);
        cmd = cmd.substring(cmd.indexOf("=") + 1, cmd.indexOf(","));
        
        try {
            switch (cmd) {
                case "btnInsertConfirmCustomer":
                    if (tfInsertCustomerID.getText().isEmpty()) {
                        labelInsertRequiredField.setVisible(true);
                        labelInsertError.setVisible(true);
                    } else {
                        Customer c = new Customer();
                        c.setCustomerID(tfSearchCustomerID.getText());
                        customerController.insertCustomer(c);
                    }
                    break;
                case "btnVisualizeCustomer":
                    Customer c = new Customer();
                    c.setCustomerID(tfSearchCustomerID.getText());
                    customerController.visualizeCustomer(c);

                    break;
                case "btnVisualizeAllCustomers":
                    customerController.visualizeAllCustomers();
                    break;
                default:
                    break;
            }
        } catch (ClassNotFoundException | SQLException se) {
            se.printStackTrace();
        }
    }

}
