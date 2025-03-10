package preparestatement;

import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String pass = "root";
        String query = "insert into student (id,name,salary)values(?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");        //load driver


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        try {
                Connection con= DriverManager.getConnection(url, user, pass); //create establish connenction
               PreparedStatement preparedStatement = con.prepareStatement(query);
              preparedStatement.setInt(1,3);
              preparedStatement.setString(2,"pradip");
              preparedStatement.setFloat(3,433431);

              int rowaffected = preparedStatement.executeUpdate();
              if(rowaffected>0){
                  System.out.println("data inserion successfully");


                  }else{
                  System.out.println("data insertion failed");
              }





                preparedStatement.close();
                con.close();
                System.out.println();
                System.out.println("connection close successfully");

            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }


        }
    }


