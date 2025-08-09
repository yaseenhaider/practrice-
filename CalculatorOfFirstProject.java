import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorOfFirstProject extends JFrame implements ActionListener 
{
    // Declare components
    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton, equalButton, clearButton;
    private String operator;
    private double num1, num2, result;

    public CalculatorOfFirstProject() 
    {
        // Set up the frame
        setTitle("Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display field
        display = new JTextField();
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.GREEN);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setForeground(Color.WHITE);
            buttonPanel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        // Set colors for operator buttons
        addButton.setBackground(Color.WHITE);
        subButton.setBackground(Color.WHITE);
        mulButton.setBackground(Color.WHITE);
        divButton.setBackground(Color.WHITE);
        equalButton.setBackground(Color.BLACK);
        clearButton.setBackground(Color.GREEN);

        // Set foreground colors
        addButton.setForeground(Color.WHITE);
        subButton.setForeground(Color.WHITE);
        mulButton.setForeground(Color.WHITE);
        divButton.setForeground(Color.WHITE);
        equalButton.setForeground(Color.BLACK);
        clearButton.setForeground(Color.BLACK);

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(clearButton);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
     {
        // Handle button clicks
        String command = e.getActionCommand();

        // Number button pressed
        for (int i = 0; i < 10; i++) {
            if (command.equals(String.valueOf(i))) 
            {
                display.setText(display.getText() + i);
                return;
            }
        }

        // Operator button pressed
        if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) 
        {
            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }

        // Equal button pressed
        if (command.equals("="))
         {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
        }

        // Clear button pressed
        if (command.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        // Create and display the calculator
        CalculatorOfFirstProject calculator = new CalculatorOfFirstProject();
        calculator.setVisible(true);
    }
}