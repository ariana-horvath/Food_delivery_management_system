package presentationLayer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Client GUI.
 * @author Ariana Horvath
 */
public class ClientGUI extends JFrame {

    private JButton exitButton;
    private JButton viewProductsButton;
    private JButton showCProductButton;
    private JButton searchButton;
    private JButton makeOrderButton;
    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JScrollPane scrollPane;
    private JTextArea compositeProductTextArea;
    private JTextArea productsTextArea;
    private  JScrollPane scrollPane2;
    private JTextField clientTextField;

    /**
     * Instantiates a new Client gui.
     */
    public ClientGUI() {
        this.setTitle("Client");
        this.setSize(1000, 750);
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
        scrollPane = new JScrollPane();
    }

    private void initializeForm(JPanel panel) {
        JLabel baseProduct = new JLabel("Products ");
        baseProduct.setBounds(10,10,200,30);
        baseProduct.setFont(new Font("Calibri", Font.PLAIN, 14));
        baseProduct.setForeground(new Color(146, 8, 51, 255));
        panel.add(baseProduct);

        JLabel ordersLabel = new JLabel("Orders ");
        ordersLabel.setBounds(570,10,200,30);
        ordersLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        ordersLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(ordersLabel);

        JLabel clientLabel = new JLabel("Client: ");
        clientLabel.setBounds(590,40,200,30);
        clientLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        clientLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(clientLabel);

        clientTextField = new JTextField();
        clientTextField.setBounds(660, 40, 300, 30);
        clientTextField.setBackground(new Color(246, 206, 239));
        clientTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        clientTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(clientTextField);

        JLabel productsLabel = new JLabel("Products: ");
        productsLabel.setBounds(590,80,200,30);
        productsLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        productsLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(productsLabel);

        productsTextArea = new JTextArea();
        productsTextArea.setEditable(true);
        productsTextArea.setBackground(new Color(246, 206, 239));
        productsTextArea.setFont(new Font("Calibri", Font.PLAIN, 14));
        productsTextArea.setForeground(new Color(146, 8, 51, 255));
        scrollPane2 = new JScrollPane(productsTextArea);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(660, 80, 300, 150);
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane2);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setBounds(30,40,70,30);
        titleLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        titleLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(titleLabel);

        titleTextField = new JTextField();
        titleTextField.setBounds(90, 40, 300, 30);
        titleTextField.setBackground(new Color(246, 206, 239));
        titleTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        titleTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(titleTextField);

        JLabel ratingLabel = new JLabel("Rating: ");
        ratingLabel.setBounds(30,80,70,30);
        ratingLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        ratingLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(ratingLabel);

        ratingTextField = new JTextField();
        ratingTextField.setBounds(90, 80, 300, 30);
        ratingTextField.setBackground(new Color(246, 206, 239));
        ratingTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        ratingTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(ratingTextField);

        JLabel caloriesLabel = new JLabel("Calories: ");
        caloriesLabel.setBounds(30,120,70,30);
        caloriesLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        caloriesLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(caloriesLabel);

        caloriesTextField = new JTextField();
        caloriesTextField.setBounds(90, 120, 300, 30);
        caloriesTextField.setBackground(new Color(246, 206, 239));
        caloriesTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        caloriesTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(caloriesTextField);

        JLabel proteinLabel = new JLabel("Protein: ");
        proteinLabel.setBounds(30,160,70,30);
        proteinLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        proteinLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(proteinLabel);

        proteinTextField = new JTextField();
        proteinTextField.setBounds(90, 160, 300, 30);
        proteinTextField.setBackground(new Color(246, 206, 239));
        proteinTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        proteinTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(proteinTextField);

        JLabel fatLabel = new JLabel("Fat: ");
        fatLabel.setBounds(30,200,70,30);
        fatLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        fatLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(fatLabel);

        fatTextField = new JTextField();
        fatTextField.setBounds(90, 200, 300, 30);
        fatTextField.setBackground(new Color(246, 206, 239));
        fatTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        fatTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(fatTextField);

        JLabel sodiumLabel = new JLabel("Sodium: ");
        sodiumLabel.setBounds(30,240,70,30);
        sodiumLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        sodiumLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(sodiumLabel);

        sodiumTextField = new JTextField();
        sodiumTextField.setBounds(90, 240, 300, 30);
        sodiumTextField.setBackground(new Color(246, 206, 239));
        sodiumTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        sodiumTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(sodiumTextField);

        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(30,280,70,30);
        priceLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        priceLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(priceLabel);

        priceTextField = new JTextField();
        priceTextField.setBounds(90, 280, 300, 30);
        priceTextField.setBackground(new Color(246, 206, 239));
        priceTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        priceTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(priceTextField);

        viewProductsButton = new JButton("View Products");
        viewProductsButton.setBounds(420, 40, 140, 30);
        viewProductsButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        viewProductsButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(viewProductsButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(420, 80, 140, 30);
        searchButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        searchButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(searchButton);

        showCProductButton = new JButton("Show Product");
        showCProductButton.setBounds(420, 120, 140, 30);
        showCProductButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        showCProductButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(showCProductButton);

        makeOrderButton = new JButton("Place Order");
        makeOrderButton.setBounds(420, 160, 140, 30);
        makeOrderButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        makeOrderButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(makeOrderButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(420, 660, 140, 30);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        exitButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(exitButton);

        compositeProductTextArea = new JTextArea();
        compositeProductTextArea.setEditable(false);
        compositeProductTextArea.setBackground(new Color(246, 206, 239));
        compositeProductTextArea.setFont(new Font("Calibri", Font.PLAIN, 14));
        compositeProductTextArea.setForeground(new Color(146, 8, 51, 255));
        scrollPane2 = new JScrollPane(compositeProductTextArea);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(420, 240, 540, 70);
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane2);

        JLabel compositeLabel = new JLabel("Composite Product");
        compositeLabel.setBounds(420,210,200,30);
        compositeLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        compositeLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(compositeLabel);
    }

    /**
     * Add table.
     *
     * @param productsTable the products table
     */
    public void addTable(JTable productsTable) {
        scrollPane.setBounds(30, 330, 930, 310);
        scrollPane.setBackground(new Color(246, 206, 239));

        productsTable.setVisible(true);
        productsTable.setEnabled(true);
        scrollPane.setViewportView(productsTable);
        this.getContentPane().add(scrollPane);
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
     * Gets make order button.
     *
     * @return the make order button
     */
    public JButton getMakeOrderButton() {
        return makeOrderButton;
    }

    /**
     * Gets products text area.
     *
     * @return the products text area
     */
    public JTextArea getProductsTextArea() {
        return productsTextArea;
    }

    /**
     * Gets client text field.
     *
     * @return the client text field
     */
    public JTextField getClientTextField() {
        return clientTextField;
    }

    /**
     * Gets exit button.
     *
     * @return the exit button
     */
    public JButton getExitButton() {
        return exitButton;
    }

    /**
     * Gets view products button.
     *
     * @return the view products button
     */
    public JButton getViewProductsButton() {
        return viewProductsButton;
    }

    /**
     * Gets show c product button.
     *
     * @return the show c product button
     */
    public JButton getShowCProductButton() {
        return showCProductButton;
    }

    /**
     * Gets search button.
     *
     * @return the search button
     */
    public JButton getSearchButton() {
        return searchButton;
    }

    /**
     * Gets title text field.
     *
     * @return the title text field
     */
    public JTextField getTitleTextField() {
        return titleTextField;
    }

    /**
     * Gets rating text field.
     *
     * @return the rating text field
     */
    public JTextField getRatingTextField() {
        return ratingTextField;
    }

    /**
     * Gets calories text field.
     *
     * @return the calories text field
     */
    public JTextField getCaloriesTextField() {
        return caloriesTextField;
    }

    /**
     * Gets protein text field.
     *
     * @return the protein text field
     */
    public JTextField getProteinTextField() {
        return proteinTextField;
    }

    /**
     * Gets fat text field.
     *
     * @return the fat text field
     */
    public JTextField getFatTextField() {
        return fatTextField;
    }

    /**
     * Gets sodium text field.
     *
     * @return the sodium text field
     */
    public JTextField getSodiumTextField() {
        return sodiumTextField;
    }

    /**
     * Gets price text field.
     *
     * @return the price text field
     */
    public JTextField getPriceTextField() {
        return priceTextField;
    }

    /**
     * Gets scroll pane.
     *
     * @return the scroll pane
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Gets composite product text area.
     *
     * @return the composite product text area
     */
    public JTextArea getCompositeProductTextArea() {
        return compositeProductTextArea;
    }
}
