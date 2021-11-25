package presentationLayer;
import javax.swing.*;
import java.awt.*;

/**
 * The type Administrator GUI.
 * @author Ariana Horvath
 */
public class AdministratorGUI extends JFrame {

    private JButton importProducts;
    private JButton exitButton;
    private JButton viewProductsButton;
    private JButton addBaseProductButton;
    private JButton updateBaseProductButton;
    private JButton deleteBaseProductButton;
    private JButton addCompositeProductButton;
    private JButton showCProductButton;
    private JButton report1Button;
    private JButton report2Button;
    private JButton report3Button;
    private JButton report4Button;
    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JTextField compositeTitleTextField;
    private JTextField productTextField;
    private JTextField startHourTextField;
    private JTextField endHourTextField;
    private JTextField noTimesTextField;
    private JTextField noTimes2TextField;
    private JTextField amountTextField;
    private JTextField dayTextField;
    private JScrollPane scrollPane;
    private JTextArea compositeProductTextArea;
    private JScrollPane scrollPane2;

    /**
     * Instantiates a new Administrator gui.
     */
    public AdministratorGUI() {
        this.setTitle("Administrator");
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

        JLabel baseProduct = new JLabel("Base Product ");
        baseProduct.setBounds(10,10,200,30);
        baseProduct.setFont(new Font("Calibri", Font.PLAIN, 14));
        baseProduct.setForeground(new Color(146, 8, 51, 255));
        panel.add(baseProduct);

        JLabel reportsLabel = new JLabel("Reports");
        reportsLabel.setBounds(580,10,200,30);
        reportsLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        reportsLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(reportsLabel);

        JLabel dummy = new JLabel("Report1: orders placed");
        dummy.setBounds(790,30,200,30);
        dummy.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy);

        JLabel dummy2 = new JLabel("between start hour and end hour");
        dummy2.setBounds(790,50,200,30);
        dummy2.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy2.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy2);

        JLabel dummy3 = new JLabel("Report2: products ordered more");
        dummy3.setBounds(790,80,200,30);
        dummy3.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy3.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy3);

        JLabel dummy4 = new JLabel("than no. of times");
        dummy4.setBounds(790,100,200,30);
        dummy4.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy4.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy4);

        JLabel dummy5 = new JLabel("Report3: clients that ordered");
        dummy5.setBounds(790,140,200,30);
        dummy5.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy5.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy5);

        JLabel dummy6 = new JLabel("more than no. of times and");
        dummy6.setBounds(790,160,200,30);
        dummy6.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy6.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy6);

        JLabel dummy7 = new JLabel("price is greater than amount");
        dummy7.setBounds(790,180,200,30);
        dummy7.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy7.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy7);

        JLabel dummy8 = new JLabel("Report4: products ordered in the");
        dummy8.setBounds(790,220,200,30);
        dummy8.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy8.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy8);

        JLabel dummy9 = new JLabel("specified date");
        dummy9.setBounds(790,240,200,30);
        dummy9.setFont(new Font("Calibri", Font.PLAIN, 14));
        dummy9.setForeground(new Color(146, 8, 51, 255));
        panel.add(dummy9);

        JLabel startHourLabel = new JLabel("Start hour:");
        startHourLabel.setBounds(600,40,200,30);
        startHourLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        startHourLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(startHourLabel);

        startHourTextField = new JTextField();
        startHourTextField.setBounds(690, 40, 80, 30);
        startHourTextField.setBackground(new Color(246, 206, 239));
        startHourTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        startHourTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(startHourTextField);

        JLabel endHourLabel = new JLabel("End hour:");
        endHourLabel.setBounds(600,80,200,30);
        endHourLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        endHourLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(endHourLabel);

        endHourTextField = new JTextField();
        endHourTextField.setBounds(690, 80, 80, 30);
        endHourTextField.setBackground(new Color(246, 206, 239));
        endHourTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        endHourTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(endHourTextField);

        JLabel nbTimesLabel = new JLabel("No. of times:");
        nbTimesLabel.setBounds(600,120,200,30);
        nbTimesLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        nbTimesLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(nbTimesLabel);

        noTimesTextField = new JTextField();
        noTimesTextField.setBounds(690, 120, 80, 30);
        noTimesTextField.setBackground(new Color(246, 206, 239));
        noTimesTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        noTimesTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(noTimesTextField);

        JLabel nbTimesLabel2 = new JLabel("No. of times:");
        nbTimesLabel2.setBounds(600,160,200,30);
        nbTimesLabel2.setFont(new Font("Calibri", Font.PLAIN, 14));
        nbTimesLabel2.setForeground(new Color(146, 8, 51, 255));
        panel.add(nbTimesLabel2);

        noTimes2TextField = new JTextField();
        noTimes2TextField.setBounds(690, 160, 80, 30);
        noTimes2TextField.setBackground(new Color(246, 206, 239));
        noTimes2TextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        noTimes2TextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(noTimes2TextField);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(600,200,200,30);
        amountLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        amountLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(amountLabel);

        amountTextField = new JTextField();
        amountTextField.setBounds(690, 200, 80, 30);
        amountTextField.setBackground(new Color(246, 206, 239));
        amountTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        amountTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(amountTextField);

        JLabel dayLabel = new JLabel("Date:");
        dayLabel.setBounds(600,240,200,30);
        dayLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        dayLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(dayLabel);

        JLabel dateLabel = new JLabel("(DD/MM/YYYY)");
        dateLabel.setBounds(575,255,200,30);
        dateLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        dateLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(dateLabel);

        dayTextField = new JTextField();
        dayTextField.setBounds(690, 240, 80, 30);
        dayTextField.setBackground(new Color(246, 206, 239));
        dayTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        dayTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(dayTextField);

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

        JLabel compositeProduct = new JLabel("Composite Product ");
        compositeProduct.setBounds(10,320,200,30);
        compositeProduct.setFont(new Font("Calibri", Font.PLAIN, 14));
        compositeProduct.setForeground(new Color(146, 8, 51, 255));
        panel.add(compositeProduct);

        JLabel compositeTitle = new JLabel("Title: ");
        compositeTitle.setBounds(30,350,70,30);
        compositeTitle.setFont(new Font("Calibri", Font.PLAIN, 14));
        compositeTitle.setForeground(new Color(146, 8, 51, 255));
        panel.add(compositeTitle);

        compositeTitleTextField = new JTextField();
        compositeTitleTextField.setBounds(90, 350, 300, 30);
        compositeTitleTextField.setBackground(new Color(246, 206, 239));
        compositeTitleTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        compositeTitleTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(compositeTitleTextField);

        JLabel productLabel = new JLabel("Products: ");
        productLabel.setBounds(30,390,70,30);
        productLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        productLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(productLabel);

        productTextField = new JTextField();
        productTextField.setBounds(90, 390, 300, 30);
        productTextField.setBackground(new Color(246, 206, 239));
        productTextField.setFont(new Font("Calibri", Font.PLAIN, 14));
        productTextField.setForeground(new Color(146, 8, 51, 255));
        panel.add(productTextField);

        viewProductsButton = new JButton("View Products");
        viewProductsButton.setBounds(420, 80, 140, 30);
        viewProductsButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        viewProductsButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(viewProductsButton);

        importProducts = new JButton("Import Products");
        importProducts.setBounds(420, 40, 140, 30);
        importProducts.setFont(new Font("Calibri", Font.PLAIN, 14));
        importProducts.setForeground(new Color(146, 8, 51, 255));
        panel.add(importProducts);

        addBaseProductButton = new JButton("Add Product");
        addBaseProductButton.setBounds(420, 120, 140, 30);
        addBaseProductButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        addBaseProductButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(addBaseProductButton);

        updateBaseProductButton = new JButton("Update Product");
        updateBaseProductButton.setBounds(420, 160, 140, 30);
        updateBaseProductButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        updateBaseProductButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(updateBaseProductButton);

        deleteBaseProductButton = new JButton("Delete Product");
        deleteBaseProductButton.setBounds(420, 200, 140, 30);
        deleteBaseProductButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        deleteBaseProductButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(deleteBaseProductButton);

        report1Button = new JButton("Generate Rep. 1");
        report1Button.setBounds(420, 240, 140, 30);
        report1Button.setFont(new Font("Calibri", Font.PLAIN, 14));
        report1Button.setForeground(new Color(146, 8, 51, 255));
        panel.add(report1Button);

        report2Button = new JButton("Generate Rep. 2");
        report2Button.setBounds(420, 280, 140, 30);
        report2Button.setFont(new Font("Calibri", Font.PLAIN, 14));
        report2Button.setForeground(new Color(146, 8, 51, 255));
        panel.add(report2Button);

        report3Button = new JButton("Generate Rep. 3");
        report3Button.setBounds(610, 280, 140, 30);
        report3Button.setFont(new Font("Calibri", Font.PLAIN, 14));
        report3Button.setForeground(new Color(146, 8, 51, 255));
        panel.add(report3Button);

        report4Button = new JButton("Generate Rep. 4");
        report4Button.setBounds(800, 280, 140, 30);
        report4Button.setFont(new Font("Calibri", Font.PLAIN, 14));
        report4Button.setForeground(new Color(146, 8, 51, 255));
        panel.add(report4Button);

        addCompositeProductButton = new JButton("Add Product");
        addCompositeProductButton.setBounds(420, 350, 140, 30);
        addCompositeProductButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        addCompositeProductButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(addCompositeProductButton);

        showCProductButton = new JButton("Show Product");
        showCProductButton.setBounds(420, 390, 140, 30);
        showCProductButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        showCProductButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(showCProductButton);

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
        scrollPane2.setBounds(590, 350, 350, 70);
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scrollPane2);
    }

    /**
     * Add table.
     *
     * @param productsTable the products table
     */
    public void addTable(JTable productsTable) {
        scrollPane.setBounds(40, 440, 900, 200);
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
     * Gets report 1 button.
     *
     * @return the report 1 button
     */
    public JButton getReport1Button() {
        return report1Button;
    }

    /**
     * Gets report 2 button.
     *
     * @return the report 2 button
     */
    public JButton getReport2Button() {
        return report2Button;
    }

    /**
     * Gets report 3 button.
     *
     * @return the report 3 button
     */
    public JButton getReport3Button() {
        return report3Button;
    }

    /**
     * Gets report 4 button.
     *
     * @return the report 4 button
     */
    public JButton getReport4Button() {
        return report4Button;
    }

    /**
     * Gets start hour text field.
     *
     * @return the start hour text field
     */
    public JTextField getStartHourTextField() {
        return startHourTextField;
    }

    /**
     * Gets end hour text field.
     *
     * @return the end hour text field
     */
    public JTextField getEndHourTextField() {
        return endHourTextField;
    }

    /**
     * Gets no times text field.
     *
     * @return the no times text field
     */
    public JTextField getNoTimesTextField() {
        return noTimesTextField;
    }

    /**
     * Gets no times 2 text field.
     *
     * @return the no times 2 text field
     */
    public JTextField getNoTimes2TextField() {
        return noTimes2TextField;
    }

    /**
     * Gets amount text field.
     *
     * @return the amount text field
     */
    public JTextField getAmountTextField() {
        return amountTextField;
    }

    /**
     * Gets day text field.
     *
     * @return the day text field
     */
    public JTextField getDayTextField() {
        return dayTextField;
    }

    /**
     * Gets composite product text area.
     *
     * @return the composite product text area
     */
    public JTextArea getCompositeProductTextArea() {
        return compositeProductTextArea;
    }

    /**
     * Gets add composite product button.
     *
     * @return the add composite product button
     */
    public JButton getAddCompositeProductButton() {
        return addCompositeProductButton;
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
     * Gets delete base product button.
     *
     * @return the delete base product button
     */
    public JButton getDeleteBaseProductButton() {
        return deleteBaseProductButton;
    }

    /**
     * Gets update base product button.
     *
     * @return the update base product button
     */
    public JButton getUpdateBaseProductButton() {
        return updateBaseProductButton;
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
     * Gets add base product button.
     *
     * @return the add base product button
     */
    public JButton getAddBaseProductButton() {
        return addBaseProductButton;
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
     * Gets composite title text field.
     *
     * @return the composite title text field
     */
    public JTextField getCompositeTitleTextField() {
        return compositeTitleTextField;
    }

    /**
     * Gets product text field.
     *
     * @return the product text field
     */
    public JTextField getProductTextField() {
        return productTextField;
    }

    /**
     * Gets import products.
     *
     * @return the import products
     */
    public JButton getImportProducts() {
        return importProducts;
    }

    /**
     * Gets exit button.
     *
     * @return the exit button
     */
    public JButton getExitButton() {
        return exitButton;
    }
}
