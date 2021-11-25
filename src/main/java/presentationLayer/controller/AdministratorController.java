package presentationLayer.controller;

import businessLayer.BaseProduct;
import businessLayer.DeliveryService;
import businessLayer.validator.Validator;
import dataLayer.Serializator;
import exception.InputValidationFailedException;
import presentationLayer.AdministratorGUI;

import javax.swing.*;

/**
 * The type Administrator controller.
 * - opens the frame for the administrator and initializes listeners for the buttons
 * - validates the input from GUI (through Validator) and passes it to delivery service
 * @author Ariana Horvath
 */
public class AdministratorController {

    private AdministratorGUI administratorGUI;
    private Serializator serializator;
    private DeliveryService deliveryService;
    private Validator validator;

    /**
     * Instantiates a new Administrator controller.
     *
     * @param deliveryService the delivery service
     */
    public AdministratorController(DeliveryService deliveryService) {
        administratorGUI = new AdministratorGUI();
        serializator = new Serializator();
        this.deliveryService = deliveryService;
        validator = new Validator();
        initializeListeners();
    }

    /**
     * Initialize listeners.
     */
    public void initializeListeners() {
        administratorGUI.getExitButton().addActionListener(e->{
            administratorGUI.setVisible(false);
        });

        administratorGUI.getImportProducts().addActionListener(e->{
           try {
               deliveryService.importProducts();
               serializator.serialize(deliveryService);
           } catch (InputValidationFailedException exception) {
               administratorGUI.displayErrorMessage(exception);
           }
        });

        administratorGUI.getViewProductsButton().addActionListener(e->{
            JTable productsTable = deliveryService.createProductsTable(deliveryService.getMenuItems());
            administratorGUI.addTable(productsTable);
        });

        administratorGUI.getAddBaseProductButton().addActionListener(e->{
            try{
                validator.validateTextField(administratorGUI.getTitleTextField().getText());
                validator.validateNumberTextFields(administratorGUI.getRatingTextField().getText(), administratorGUI.getCaloriesTextField().getText(),
                        administratorGUI.getProteinTextField().getText(), administratorGUI.getSodiumTextField().getText(),
                        administratorGUI.getFatTextField().getText(), administratorGUI.getPriceTextField().getText());
                deliveryService.addBaseProduct(new BaseProduct(administratorGUI.getTitleTextField().getText(),
                                                    Double.parseDouble(administratorGUI.getRatingTextField().getText()),
                                                    Integer.parseInt(administratorGUI.getCaloriesTextField().getText()),
                                                    Integer.parseInt(administratorGUI.getProteinTextField().getText()),
                                                    Integer.parseInt(administratorGUI.getSodiumTextField().getText()),
                                                    Integer.parseInt(administratorGUI.getFatTextField().getText()),
                                                    Integer.parseInt(administratorGUI.getPriceTextField().getText())));
                administratorGUI.displayInformationMessage("Product successfully added");
                JTable productsTable = deliveryService.createProductsTable(deliveryService.getMenuItems());
                administratorGUI.addTable(productsTable);
                serializator.serialize(deliveryService);

            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getUpdateBaseProductButton().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getTitleTextField().getText());
                validator.validateNumberTextFields(administratorGUI.getRatingTextField().getText(), administratorGUI.getCaloriesTextField().getText(),
                        administratorGUI.getProteinTextField().getText(), administratorGUI.getSodiumTextField().getText(),
                        administratorGUI.getFatTextField().getText(), administratorGUI.getPriceTextField().getText());
                deliveryService.updateBaseProduct(new BaseProduct(administratorGUI.getTitleTextField().getText(),
                        Double.parseDouble(administratorGUI.getRatingTextField().getText()),
                        Integer.parseInt(administratorGUI.getCaloriesTextField().getText()),
                        Integer.parseInt(administratorGUI.getProteinTextField().getText()),
                        Integer.parseInt(administratorGUI.getSodiumTextField().getText()),
                        Integer.parseInt(administratorGUI.getFatTextField().getText()),
                        Integer.parseInt(administratorGUI.getPriceTextField().getText())));
                administratorGUI.displayInformationMessage("Product successfully updated");
                JTable productsTable = deliveryService.createProductsTable(deliveryService.getMenuItems());
                administratorGUI.addTable(productsTable);
                serializator.serialize(deliveryService);
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getDeleteBaseProductButton().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getTitleTextField().getText());
                deliveryService.deleteBaseProduct(administratorGUI.getTitleTextField().getText());
                administratorGUI.displayInformationMessage("Product successfully deleted");
                JTable productsTable = deliveryService.createProductsTable(deliveryService.getMenuItems());
                administratorGUI.addTable(productsTable);
                serializator.serialize(deliveryService);
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getAddCompositeProductButton().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getCompositeTitleTextField().getText());
                validator.validateTextField(administratorGUI.getProductTextField().getText());
                deliveryService.addCompositeProduct(administratorGUI.getCompositeTitleTextField().getText(),
                                                    administratorGUI.getProductTextField().getText());
                administratorGUI.displayInformationMessage("Composite Product successfully added");
                JTable productsTable = deliveryService.createProductsTable(deliveryService.getMenuItems());
                administratorGUI.addTable(productsTable);
                serializator.serialize(deliveryService);
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getShowCProductButton().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getCompositeTitleTextField().getText());
                administratorGUI.getCompositeProductTextArea().setText(deliveryService.createCProductString(administratorGUI.getCompositeTitleTextField().getText()));
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getReport1Button().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getStartHourTextField().getText());
                validator.validateTextField(administratorGUI.getEndHourTextField().getText());
                int start = validator.validateHour(administratorGUI.getStartHourTextField().getText());
                int end = validator.validateHour(administratorGUI.getEndHourTextField().getText());
                validator.validateHoursInMinutes(start, end);
                deliveryService.generateReport1(start, end);
                administratorGUI.displayInformationMessage("Report 1 successfully created. See Report1.txt.");
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getReport2Button().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getNoTimesTextField().getText());
                validator.validateInt(administratorGUI.getNoTimesTextField().getText());
                deliveryService.generateReport2(Integer.parseInt(administratorGUI.getNoTimesTextField().getText()));
                administratorGUI.displayInformationMessage("Report 2 successfully created. See Report2.txt.");
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getReport3Button().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getNoTimes2TextField().getText());
                validator.validateTextField(administratorGUI.getAmountTextField().getText());
                validator.validateInt(administratorGUI.getNoTimes2TextField().getText());
                validator.validateInt(administratorGUI.getAmountTextField().getText());
                deliveryService.generateReport3(Integer.parseInt(administratorGUI.getNoTimes2TextField().getText()),
                                                Integer.parseInt(administratorGUI.getAmountTextField().getText()));
                administratorGUI.displayInformationMessage("Report 3 successfully created. See Report3.txt.");
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });

        administratorGUI.getReport4Button().addActionListener(e->{
            try {
                validator.validateTextField(administratorGUI.getDayTextField().getText());
                int[] date = validator.validateDate(administratorGUI.getDayTextField().getText());
                deliveryService.generateReport4(date[0], date[1], date[2]);
                administratorGUI.displayInformationMessage("Report 4 successfully created. See Report4.txt.");
            } catch (InputValidationFailedException exception) {
                administratorGUI.displayErrorMessage(exception);
            }
        });
    }
}
