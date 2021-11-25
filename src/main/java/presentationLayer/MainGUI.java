package presentationLayer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Main GUI.
 * @author Ariana Horvath
 */
public class MainGUI extends JFrame {

    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton registerAdmin;
    private JButton logInAdmin;
    private JButton registerEmployee;
    private JButton logInEmployee;
    private JButton registerClient;
    private JButton logInClient;

    /**
     * Instantiates a new Main gui.
     */
    public MainGUI() {
        this.setTitle("Food Delivery Management");
        this.setSize(505, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setLocationRelativeTo(null);
        initializeForm(panel);
        this.setContentPane(panel);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(246, 189, 238));
    }

    private void initializeForm(JPanel panel) {
        JLabel titleLabel = new JLabel("FOOD DELIVERY MANAGEMENT APPLICATION");
        titleLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        titleLabel.setForeground(new Color(146, 8, 51, 255));
        titleLabel.setBounds(55, 40, 400, 30);
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(20,100,70,30);
        usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        usernameLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(100, 100, 330, 30);
        usernameTextField.setBackground(new Color(246, 206, 239));
        usernameTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        usernameTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(usernameTextField);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(20,150,70,30);
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        passwordLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(passwordLabel);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(100, 150, 330, 30);
        passwordTextField.setBackground(new Color(246, 206, 239));
        panel.add(passwordTextField);

        registerAdmin = new JButton("Register Admin");
        registerAdmin.setBounds(20, 350, 140, 30);
        registerAdmin.setFont(new Font("Calibri", Font.PLAIN, 14));
        registerAdmin.setForeground(new Color(146, 8, 51, 255));
        panel.add(registerAdmin);

        registerEmployee = new JButton("Register Employee");
        registerEmployee.setBounds(170, 350, 150, 30);
        registerEmployee.setFont(new Font("Calibri", Font.PLAIN, 14));
        registerEmployee.setForeground(new Color(146, 8, 51, 255));
        panel.add(registerEmployee);

        registerClient = new JButton("Register Client");
        registerClient.setBounds(330, 350, 140, 30);
        registerClient.setFont(new Font("Calibri", Font.PLAIN, 14));
        registerClient.setForeground(new Color(146, 8, 51, 255));
        panel.add(registerClient);

        logInAdmin = new JButton("Log In Admin");
        logInAdmin.setBounds(20, 400, 140, 30);
        logInAdmin.setFont(new Font("Calibri", Font.PLAIN, 14));
        logInAdmin.setForeground(new Color(146, 8, 51, 255));
        panel.add(logInAdmin);

        logInEmployee = new JButton("Log In Employee");
        logInEmployee.setBounds(170, 400, 150, 30);
        logInEmployee.setFont(new Font("Calibri", Font.PLAIN, 14));
        logInEmployee.setForeground(new Color(146, 8, 51, 255));
        panel.add(logInEmployee);

        logInClient = new JButton("Log In Client");
        logInClient.setBounds(330, 400, 140, 30);
        logInClient.setFont(new Font("Calibri", Font.PLAIN, 14));
        logInClient.setForeground(new Color(146, 8, 51, 255));
        panel.add(logInClient);
    }

    /**
     * Display error message.
     *
     * @param exception the exception
     */
    public void displayErrorMessage(Exception exception) {
        if (exception != null) {
            String message = exception.getMessage();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", new Color(246, 189, 238));
            UI.put("Panel.background", new Color(246, 189, 238));
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Display information message.
     *
     * @param message the message
     */
    public void displayInformationMessage(String message) {
        if (!message.isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", new Color(246, 189, 238));
            UI.put("Panel.background", new Color(246, 189, 238));
            JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Gets username text field.
     *
     * @return the username text field
     */
    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    /**
     * Gets password text field.
     *
     * @return the password text field
     */
    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }

    /**
     * Gets register admin.
     *
     * @return the register admin
     */
    public JButton getRegisterAdmin() {
        return registerAdmin;
    }

    /**
     * Gets log in admin.
     *
     * @return the log in admin
     */
    public JButton getLogInAdmin() {
        return logInAdmin;
    }

    /**
     * Gets register employee.
     *
     * @return the register employee
     */
    public JButton getRegisterEmployee() {
        return registerEmployee;
    }

    /**
     * Gets log in employee.
     *
     * @return the log in employee
     */
    public JButton getLogInEmployee() {
        return logInEmployee;
    }

    /**
     * Gets register client.
     *
     * @return the register client
     */
    public JButton getRegisterClient() {
        return registerClient;
    }

    /**
     * Gets log in client.
     *
     * @return the log in client
     */
    public JButton getLogInClient() {
        return logInClient;
    }
}
