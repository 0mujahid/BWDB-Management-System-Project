package BWDBManagementSystem;
import java.awt.*;
import java.sql.ResultSet;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Package2 extends JFrame {

    private final Connection connection;

    private JTextField txtPackageNo, txtDailyMadeBlocks, txtDailyUsedMachines, txtRccCost;
    private JButton btnSubmit;

    public Package2(Connection connection) {
        this.connection = connection;

        // JFrame settings
        setTitle("Package 2 Input Form");
        setBounds(500, 100, 500, 400);
        getContentPane().setBackground(new Color(172,220,237));
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Labels & TextFields
        JLabel lblPackageNo = new JLabel("Package No:");
        lblPackageNo.setBounds(20, 20, 120, 25);
        add(lblPackageNo);

        txtPackageNo = new JTextField();
        txtPackageNo.setBounds(150, 20, 150, 25);
        add(txtPackageNo);

        JLabel lblDailyMadeBlocks = new JLabel("Blocks Made:");
        lblDailyMadeBlocks.setBounds(20, 60, 120, 25);
        add(lblDailyMadeBlocks);

        txtDailyMadeBlocks = new JTextField();
        txtDailyMadeBlocks.setBounds(150, 60, 150, 25);
        add(txtDailyMadeBlocks);

        JLabel lblDailyUsedMachines = new JLabel("Machines Used:");
        lblDailyUsedMachines.setBounds(20, 100, 120, 25);
        add(lblDailyUsedMachines);

        txtDailyUsedMachines = new JTextField();
        txtDailyUsedMachines.setBounds(150, 100, 150, 25);
        add(txtDailyUsedMachines);

        JLabel lblRccCost = new JLabel("RCC Cost:");
        lblRccCost.setBounds(20, 140, 120, 25);
        add(lblRccCost);

        txtRccCost = new JTextField();
        txtRccCost.setBounds(150, 140, 150, 25);
        add(txtRccCost);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(120, 190, 100, 30);
        add(btnSubmit);

        // Button action
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertData();
            }
        });

        setVisible(true);
    }

    private void insertData() {
        try {
            int packageNo = Integer.parseInt(txtPackageNo.getText());
            int dailyMadeBlocks = Integer.parseInt(txtDailyMadeBlocks.getText());
            int dailyUsedMachines = Integer.parseInt(txtDailyUsedMachines.getText());
            int rccCost = Integer.parseInt(txtRccCost.getText());

            String query = "INSERT INTO Package_2(packageNo, dailyMadeBlocks, dailyUsedMachines, rccCost) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, packageNo);
            ps.setInt(2, dailyMadeBlocks);
            ps.setInt(3, dailyUsedMachines);
            ps.setInt(4, rccCost);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Data inserted successfully!");
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Insertion failed!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SQL Error: " + ex.getMessage());
        }
    }

    private void clearForm() {
        txtPackageNo.setText("");
        txtDailyMadeBlocks.setText("");
        txtDailyUsedMachines.setText("");
        txtRccCost.setText("");
    }

    // Call this method from main menu to show the form
    public void Package_2() {
        this.setVisible(true);
    }

    // Stub method for view (implement if needed)
    public void viewPackage2() {
        String query = "SELECT * FROM Package_2";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            String[] columnNames = {"Package No", "Daily Made Blocks", "Daily Used Machines", "RCC Cost"};

            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            Object[][] data = new Object[rowCount][4];
            int row = 0;

            while (resultSet.next()) {
                data[row][0] = resultSet.getInt("PackageNo");
                data[row][1] = resultSet.getInt("DailyMadeBlocks");
                data[row][2] = resultSet.getInt("DailyUsedMachines");
                data[row][3] = resultSet.getInt("RCCCost");
                row++;
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);

            JFrame tableFrame = new JFrame("Package 1 Data");
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            tableFrame.setBounds(500, 100, 500, 400);
            table.setBackground(new Color(172, 220, 237));
            tableFrame.add(scrollPane);
            tableFrame.setLocationRelativeTo(null);
            tableFrame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

}
