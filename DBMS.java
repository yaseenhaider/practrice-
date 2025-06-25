import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class CalculatorForm extends JFrame implements ActionListener {
    JTextField text1, text2, text3;
    JButton addBtn, subBtn, mulBtn, divBtn, exitBtn;

    public CalculatorForm() {
        setTitle("Simple Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Labels
        add(new JLabel("Enter First Number:"));
        text1 = new JTextField();
        add(text1);

        add(new JLabel("Enter Second Number:"));
        text2 = new JTextField();
        add(text2);

        add(new JLabel("Result:"));
        text3 = new JTextField();
        text3.setEditable(false);
        add(text3);

        // Buttons
        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        add(addBtn);

        subBtn = new JButton("Subtract");
        subBtn.addActionListener(this);
        add(subBtn);

        mulBtn = new JButton("Multiply");
        mulBtn.addActionListener(this);
        add(mulBtn);

        divBtn = new JButton("Divide");
        divBtn.addActionListener(this);
        add(divBtn);

        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(this);
        add(exitBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1, num2;
        try {
            num1 = Double.parseDouble(text1.getText());
            num2 = Double.parseDouble(text2.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            return;
        }

        if (e.getSource() == addBtn) {
            text3.setText(String.valueOf(num1 + num2));
        } else if (e.getSource() == subBtn) {
            text3.setText(String.valueOf(num1 - num2));
        } else if (e.getSource() == mulBtn) {
            text3.setText(String.valueOf(num1 * num2));
        } else if (e.getSource() == divBtn) {
            if (num2 == 0) {
                text3.setText("Cannot divide by zero");
            } else {
                text3.setText(String.valueOf(num1 / num2));
            }
        } else if (e.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CalculatorForm();
    }
}
