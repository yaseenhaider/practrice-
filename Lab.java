import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class FrontEndDemo extends JFrame {
    public FrontEndDemo() {
        // Form title
        setTitle("Front End Tools Demo");
        setSize(500, 500);
        setLayout(new FlowLayout());

        // Label
        JLabel label = new JLabel("Enter your name:");
        add(label);

        // TextBox
        JTextField textField = new JTextField(20);
        add(textField);

        // Command Button
        JButton B1 = new JButton("Say Hello");
        add(B1);

        // CheckBox
        JCheckBox checkBox = new JCheckBox("Subscribe to newsletter");
        add(checkBox);
        JCheckBox checkBox1 = new JCheckBox("learn something");
        add(checkBox1);

        // Option Buttons
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton nonHuman = new JRadioButton("non of these");
        JRadioButton learn = new JRadioButton("win or learn");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(nonHuman);
        genderGroup.add(learn);

        add(male);
        add(female);
        add(nonHuman);
        add(learn);

        // ListBox
        String[] courses = {"Java", "Python", "C++","my SQL","HTML","c"};
        JList<String> list = new JList<>(courses);
        add(new JScrollPane(list));

        // ComboBox
        JComboBox<String> comboBox = new JComboBox<>(courses);
        add(comboBox);

        // Timer Example
        JLabel timerLabel = new JLabel("Timer: Not Started");
        add(timerLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText("Timer: " + (++count) + "s");
            }
        });

        // Action for Button
        button.addActionListener(e -> {
            String name = textField.getText();
            JOptionPane.showMessageDialog(this, "HI " + name + "!");
            timer.start();
        });

        // Default form settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrontEndDemo();
    }
}
