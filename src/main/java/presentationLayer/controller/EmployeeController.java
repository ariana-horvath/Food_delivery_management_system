package presentationLayer.controller;

import businessLayer.DeliveryService;
import dataLayer.Serializator;
import presentationLayer.EmployeeGUI;

/**
 * The type Employee controller.
 * - opens the frame for the employee and initializes listeners for the buttons
 * @author Ariana Horvath
 */
public class EmployeeController {

    private EmployeeGUI employeeGUI;
    private DeliveryService deliveryService;

    /**
     * Instantiates a new Employee controller.
     *
     * @param deliveryService the delivery service
     */
    public EmployeeController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        employeeGUI = new EmployeeGUI();
        this.deliveryService.addObserver(employeeGUI);
        initializeListeners();
    }

    /**
     * Initialize listeners.
     */
    public void initializeListeners() {
        employeeGUI.getExitButton().addActionListener(e->{
            employeeGUI.setVisible(false);
        });
    }
}
