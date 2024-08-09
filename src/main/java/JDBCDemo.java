import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        /*
        * Database credentials
        * */
        String URL = "jdbc:mysql://localhost:3306/census";
        String USER = "root";
        String PASSWORD = "root";

        /*
        * Creating connection
        * */

        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        if(connection!=null){
            System.out.println("Connected to the database");
        }
        /*
         * Creating statement
         * */
        assert connection != null;
        Statement statement = connection.createStatement();
        String sql = "select id,name,gender,aadhar_id,is_nri from citizens";

        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("Id is : "+ resultSet.getInt("id")+"\t");
            System.out.println("Name is : "+ resultSet.getString("name")+"\t");
            System.out.println("Aadhar number is : "+ resultSet.getString("aadhar_id")+"\t");
            System.out.println();
        }
    }
}
