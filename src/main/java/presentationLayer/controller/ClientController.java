package presentationLayer.controller;

import businessLayer.DeliveryService;
import businessLayer.validator.Validator;
import dataLayer.Serializator;
import exception.InputValidationFailedException;
import presentationLayer.ClientGUI;

import javax.swing.*;

/**
 * The type Client controller.
 * - opens the frame for the client and initializes listeners for the buttons
 *  - validates the input from GUI (through Validator) and passes it to delivery service
 * @author Ariana Horvath
 */
public class ClientController {

    private ClientGUI clientGUI;
    private Serializator serializator;
    private DeliveryService deliveryService;
    private Validator validator;

    /**
     * Instantiates a new Client controller.
     *
     * @param deliveryService the delivery service
     */
    public ClientController(DeliveryService deliveryService) {
        clientGUI = new ClientGUI();
        serializator = new Serializator();
        this.deliveryService = deliveryService;
        validator = new Validator();
        initializeListeners();
    }

    /**
     * Initialize listeners.
     */
    public void initializeListeners() {
        clientGUI.getExitButton().addActionListener(e->{
            clientGUI.setVisible(false);
        });

        clientGUI.getViewProductsButton().addActionListener(e->{
            JTable productsTable = deliveryService.createProductsTable(deliveryService.getMenuItems());
            clientGUI.addTable(productsTable);
        });

        clientGUI.getShowCProductButton().addActionListener(e->{
            try {
                validator.validateTextField(clientGUI.getTitleTextField().getText());
                clientGUI.getCompositeProductTextArea().setText(deliveryService.createCProductString(clientGUI.getTitleTextField().getText()));
            } catch (InputValidationFailedException exception) {
                clientGUI.displayErrorMessage(exception);
            }
        });

        clientGUI.getSearchButton().addActionListener(e->{
            try {
                JTable productsTable = deliveryService.createProductsTable(
                deliveryService.searchProducts (clientGUI.getTitleTextField().getText(), clientGUI.getRatingTextField().getText(),
                                                clientGUI.getCaloriesTextField().getText(), clientGUI.getProteinTextField().getText(),
                                                clientGUI.getFatTextField().getText(), clientGUI.getSodiumTextField().getText(),
                                                clientGUI.getPriceTextField().getText()));
                clientGUI.addTable(productsTable);
            } catch (InputValidationFailedException exception) {
                clientGUI.displayErrorMessage(exception);
            }
        });

        clientGUI.getMakeOrderButton().addActionListener(e->{
            try {
                validator.validateTextField(clientGUI.getClientTextField().getText());
                validator.validateTextField(clientGUI.getProductsTextArea().getText());
                deliveryService.createOrder(clientGUI.getClientTextField().getText(), clientGUI.getProductsTextArea().getText());

                clientGUI.displayInformationMessage("Order successfully placed!");
                serializator.serialize(deliveryService);
            } catch (InputValidationFailedException exception) {
                clientGUI.displayErrorMessage(exception);
            }
        });
    }
}
