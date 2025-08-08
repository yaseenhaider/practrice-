import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class ShipmentForm {

    private JFrame frame;
    private JComboBox<String> supplierCombo, customerCombo, productCombo;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShipmentForm().createGUI());
    }

    private void createGUI() {
        frame = new JFrame(" Shipment Entry");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Shipment Entry Form ", JLabel.CENTER);
        title.setFont(new Font("Segue UI", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 2, 15, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        // Hardcoded sample data
        String[] suppliers = {"1 - Supplier x", "2 - Supplier y", "3 - Supplier z"};
        String[] customers = {"1 -  Ali", "2 - Haider", "3 -  Noor", "4 - iqbal", "5 - Abbas"};
        String[] products = {"1 - AK47", "2 - M416", "3 - KR98", "4 - rocket", "5 - hand grenade"};

        supplierCombo = new JComboBox<>(suppliers);
        customerCombo = new JComboBox<>(customers);
        productCombo = new JComboBox<>(products);

        panel.add(new JLabel("Supplier:"));
        panel.add(supplierCombo);
        panel.add(new JLabel("Customer:"));
        panel.add(customerCombo);
        panel.add(new JLabel("Product:"));
        panel.add(productCombo);

        frame.add(panel, BorderLayout.CENTER);

        JButton submitBtn = new JButton("Submit Shipment");
        submitBtn.setFont(new Font("Segue UI", Font.BOLD, 14));
        submitBtn.setBackground(new Color(0xEF323A));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);

        submitBtn.addActionListener(this::simulateInsert);

        JPanel btnPanel = new JPanel();
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        btnPanel.add(submitBtn);
        frame.add(btnPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void simulateInsert(ActionEvent e) {
        String supplier = (String) supplierCombo.getSelectedItem();
        String customer = (String) customerCombo.getSelectedItem();
        String product = (String) productCombo.getSelectedItem();

        JOptionPane.showMessageDialog(frame,
                "Simulated Shipment Submitted:\n\n" +
                        "Supplier: " + supplier + "\n" +
                        "Customer: " + customer + "\n" +
                        "Product: " + product,
                "Order Successfully submitted",
                JOptionPane.INFORMATION_MESSAGE);
    }
}


//use array in combo box(for the increment every time  in customer and get products on deadline via shipment