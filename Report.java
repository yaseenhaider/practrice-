import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


 class GradeReportGUI extends JFrame {

    private JComboBox<String> courseBox, semesterBox;
    private JButton generateBtn, exportPdfBtn, exportCsvBtn, closeBtn;
    private JTable gradeTable;

    public GradeReportGUI() {
        setTitle("Instructor - Generate Student Grades Report");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top Panel (Controls)
        JPanel topPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        topPanel.add(new JLabel("Select Course:"));
        courseBox = new JComboBox<>(new String[]{"BSE CS 101", "BSc Math 202", "Intro to Java","DBMS","oop","DSA","Operating System"});
        topPanel.add(courseBox);

        topPanel.add(new JLabel("Select Semester:"));
        semesterBox = new JComboBox<>(new String[]{"SP24","SP25","FA23","FA24","FA25","non of these"});
        topPanel.add(semesterBox);

        topPanel.add(new JLabel("You like:"));
        semesterBox = new JComboBox<>(new String[]{"using GUI in programming ","Database connection with java ","simple programming in java","only simple programming"});
        topPanel.add(semesterBox);

        generateBtn = new JButton("Generate Report");
        topPanel.add(generateBtn);

        closeBtn = new JButton("Close");
        topPanel.add(closeBtn);

        add(topPanel, BorderLayout.NORTH);

        // Table
        gradeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(gradeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel (Export Buttons)
        JPanel bottomPanel = new JPanel();
        exportPdfBtn = new JButton("Export as PDF");
        exportCsvBtn = new JButton("Export as CSV");
        bottomPanel.add(exportPdfBtn);
        bottomPanel.add(exportCsvBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        // Action Listeners
        generateBtn.addActionListener(e -> generateReport());
        closeBtn.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void generateReport() {
        // Simulated data (normally from DB)
        String[] columns = {"Student ID", "Student Name", "Grade"};
        Object[][] data = {
                {"1001", "Ali Khan", "A"},
                {"1002", "Hussain Ali", "B+"},
                {"1003", "Yaseen Haider", "A+"},
                {"1004", "Sara Iqbal", "B+"},
                {"1005", "Amna Ali", "A+"},
                {"1006", "Abbas", "A"},
                {"1007", "Ali", "B+"},
                {"1008", "Hassan", "A+"},
                {"1009", "Sadam", "B+"},
                {"1010", "zulfqar", "A+"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        gradeTable.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GradeReportGUI::new);
    }
}
