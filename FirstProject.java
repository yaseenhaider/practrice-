import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FirstProject {
    // Create the frame and the components
    private JFrame frame;
    private JTextField textField;
    private double num1 = 0, num2 = 0;
    private String operator = "";

    public static void main(String[] args) {
        // Run the calculator
        SwingUtilities.invokeLater(() -> {
            try {
                Main window = new Main();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor to initialize the GUI
    public FirstProject() {
        // Set up the main frame
        frame = new JFrame("Calculator");
        frame.setBounds(100, 100, 400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create and set the text field
        textField = new JTextField();
        textField.setEditable(false);
        frame.add(textField, BorderLayout.NORTH);

        // Create the panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        
        };

        // Action listeners for buttons
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);
    }

    // Action listener to handle button clicks
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String command = source.getText();

            // Handle the numeric and decimal input
            if (command.matches("[0-9]") || command.equals(".")) {
                textField.setText(textField.getText() + command);
            }
            // Handle operators
            else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                double result = performCalculation();
                textField.setText(String.valueOf(result));
                num1 = result;  // store result for further calculations
            }
            else {
                // Store the first number and the operator
                if (!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = command;
                    textField.setText("");  // clear the screen
                }
            }
        }
    }

    // Method to perform calculations
    private double performCalculation() {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(frame, "Error: Division by Zero");
                    return 0;
                }
            default:
                return num2;  // Just in case of an empty operator
        }
    }
}
