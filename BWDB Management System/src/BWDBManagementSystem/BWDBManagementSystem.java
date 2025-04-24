package BWDBManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BWDBManagementSystem {


    private static final String url="jdbc:mysql://localhost:3306/BWDB";
    public static final String user = "root";
    private static final String password = "Mujahid508@#";

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try{
            Connection connection= DriverManager.getConnection(url,user,password);
            Package1 package1=new Package1(connection);
            Package2 package2=new Package2(connection);
            targetValue targetvalue = new targetValue(connection);

            new myFrame(package1, package2, targetvalue);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
