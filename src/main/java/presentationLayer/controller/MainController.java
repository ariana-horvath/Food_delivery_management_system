package presentationLayer.controller;

import businessLayer.DeliveryService;
import businessLayer.Role;
import businessLayer.User;
import businessLayer.validator.Validator;
import dataLayer.Serializator;
import exception.InputValidationFailedException;
import presentationLayer.MainGUI;

/**
 * The type Main controller.
 * - opens the principal frame and initializes listeners for the buttons
 * - validates the input from GUI (through Validator) and passes it to delivery service
 * @author Ariana Horvath
 */
public class MainController {

    private MainGUI mainGui;
    private DeliveryService deliveryService;
    private Serializator serializator;
    private Validator validator;

    /**
     * Instantiates a new Main controller.
     */
    public MainController() {
        mainGui = new MainGUI();
        serializator = new Serializator();
        deliveryService = serializator.deserialize();
        validator = new Validator();
        initializeListeners();
    }

    /**
     * Initialize listeners.
     */
    public void initializeListeners() {
        mainGui.getRegisterAdmin().addActionListener(e->{
            try {
                validator.validateTextField(mainGui.getUsernameTextField().getText());
                validator.validateTextField(mainGui.getPasswordTextField().getText());
                deliveryService.registerUser(new User(Role.ADMINISTRATOR, mainGui.getUsernameTextField().getText(),
                                                                          mainGui.getPasswordTextField().getText()));
                mainGui.displayInformationMessage("Administrator successfully registered");
                serializator.serialize(deliveryService);
            } catch (InputValidationFailedException exception) {
                mainGui.displayErrorMessage(exception);
            }
        });

        mainGui.getRegisterEmployee().addActionListener(e->{
            try {
                validator.validateTextField(mainGui.getUsernameTextField().getText());
                validator.validateTextField(mainGui.getPasswordTextField().getText());
                deliveryService.registerUser(new User(Role.EMPLOYEE, mainGui.getUsernameTextField().getText(),
                                                                     mainGui.getPasswordTextField().getText()));
                mainGui.displayInformationMessage("Employee successfully registered");
                serializator.serialize(deliveryService);
            } catch (InputValidationFailedException exception) {
                mainGui.displayErrorMessage(exception);
            }
        });

        mainGui.getRegisterClient().addActionListener(e->{
            try {
                validator.validateTextField(mainGui.getUsernameTextField().getText());
                validator.validateTextField(mainGui.getPasswordTextField().getText());
                deliveryService.registerUser(new User(Role.CLIENT, mainGui.getUsernameTextField().getText(),
                                                                   mainGui.getPasswordTextField().getText()));
                mainGui.displayInformationMessage("Client successfully registered");
                serializator.serialize(deliveryService);
            } catch (InputValidationFailedException exception) {
                mainGui.displayErrorMessage(exception);
            }
        });

        mainGui.getLogInAdmin().addActionListener(e->{
            try {
                validator.validateTextField(mainGui.getUsernameTextField().getText());
                validator.validateTextField(mainGui.getPasswordTextField().getText());
                deliveryService.logInUser(mainGui.getUsernameTextField().getText(), mainGui.getPasswordTextField().getText(), Role.ADMINISTRATOR);
                new AdministratorController(deliveryService);
            } catch (InputValidationFailedException exception) {
                mainGui.displayErrorMessage(exception);
            }
        });

        mainGui.getLogInEmployee().addActionListener(e->{
            try {
                validator.validateTextField(mainGui.getUsernameTextField().getText());
                validator.validateTextField(mainGui.getPasswordTextField().getText());
                deliveryService.logInUser(mainGui.getUsernameTextField().getText(), mainGui.getPasswordTextField().getText(), Role.EMPLOYEE);
                new EmployeeController(deliveryService);
            } catch (InputValidationFailedException exception) {
                mainGui.displayErrorMessage(exception);
            }
        });

        mainGui.getLogInClient().addActionListener(e->{
            try {
                validator.validateTextField(mainGui.getUsernameTextField().getText());
                validator.validateTextField(mainGui.getPasswordTextField().getText());
                deliveryService.logInUser(mainGui.getUsernameTextField().getText(), mainGui.getPasswordTextField().getText(), Role.CLIENT);
                new ClientController(deliveryService);
            } catch (InputValidationFailedException exception) {
                mainGui.displayErrorMessage(exception);
            }
        });
    }
}
