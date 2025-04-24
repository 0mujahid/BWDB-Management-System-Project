package BWDBManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class targetValue extends JFrame {
  private final   Connection connection;


    public targetValue(Connection connection) {
        this.connection = connection;


    }
public void targetValue(){
        this.setVisible(true);
}

    public void viewtargetValue() {
        String query = "SELECT * FROM targetValue";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet resultSet = preparedStatement.executeQuery();

            String[] columnNames = {"Package_1", "Package_2"};

            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            Object[][] data = new Object[rowCount][4];
            int row = 0;

            while (resultSet.next()) {
                data[row][0] = resultSet.getInt("package_1");
                data[row][1] = resultSet.getInt("package_2");
                row++;
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);

            JFrame tableFrame = new JFrame("Target Value");
            tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            tableFrame.setBounds(500, 100, 500, 400);
            table.setBackground(new Color(172, 220, 237));

            tableFrame.add(scrollPane);
            tableFrame.setLocationRelativeTo(null);
            tableFrame.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();

        }
    }

}
