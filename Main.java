package preparestatement;

import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String pass = "root";
        String query = "select * from student  where name = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");        //load driver


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }


        try {
                Connection con= DriverManager.getConnection(url, user, pass); //create establish connenction
               PreparedStatement preparedStatement = con.prepareStatement(query);
               preparedStatement.setString(1,"rahul" );
               ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String salary  = resultSet.getString("salary");
                    System.out.println(id);
                    System.out.println(name);
                    System.out.println(salary);



                }

               resultSet.close();
                preparedStatement.close();
                con.close();
                System.out.println();
                System.out.println("connection close successfully");

            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }


        }
    }


