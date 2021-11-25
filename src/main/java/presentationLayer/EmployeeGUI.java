package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The type Employee GUI.
 * - it is an Observer, gets notified when an order is created
 * @author Ariana Horvath
 */
public class EmployeeGUI extends JFrame implements Observer {

    private JButton exitButton;
    private JTextArea ordersTextArea;
    private JScrollPane jScrollPane;
    /**
     * The Panel.
     */
    JPanel panel;

    /**
     * Instantiates a new Employee gui.
     */
    public EmployeeGUI() {
        this.setTitle("Employee");
        this.setSize(505, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        this.setLocationRelativeTo(null);
        initializeForm(panel);
        this.setContentPane(panel);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(246, 189, 238));
    }

    private void initializeForm(JPanel panel) {
        exitButton = new JButton("Exit");
        exitButton.setBounds(175, 420, 140, 30);
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        exitButton.setForeground(new Color(146, 8, 51, 255));
        panel.add(exitButton);

        JLabel ordersLabel = new JLabel("Orders ");
        ordersLabel.setBounds(20,20,70,30);
        ordersLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
        ordersLabel.setForeground(new Color(146, 8, 51, 255));
        panel.add(ordersLabel);

        ordersTextArea = new JTextArea();
        ordersTextArea.setEditable(false);
        ordersTextArea.setBackground(new Color(246, 206, 239));
        ordersTextArea.setFont(new Font("Calibri", Font.PLAIN, 14));
        ordersTextArea.setForeground(new Color(146, 8, 51, 255));
        jScrollPane = new JScrollPane(ordersTextArea);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setBounds(20, 50, 450, 355);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(jScrollPane);
    }

    @Override
    public void update(Observable o, Object arg) {
        ordersTextArea.append((String) arg);
        panel.updateUI();
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
