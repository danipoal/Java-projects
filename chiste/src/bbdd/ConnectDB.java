package bbdd;
import java.sql.*;

public class ConnectDB {
    private final String BBDD;
    private final String USER;
    private final String PASSWORD;

    public ConnectDB(){
        //this.BBDD = "jdbc:mysql://192.168.1.54:3306";		Esta es para el phpAdmin del NAS
        this.BBDD = "jdbc:oracle:thin:@localhost:1521/orcl";
        this.USER = "daniel";
        this.PASSWORD = "B7NYtwmZzk_a0uQU";
    }

    public ConnectDB(String BBDD, String USER, String PASSWORD){
        this.BBDD = BBDD;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
   }
    public void connectToBD() throws SQLException{
        Connection connect = DriverManager.getConnection(BBDD, USER, PASSWORD); 
        Statement sentencia = connect.createStatement();

        String ifExists = "CREATE DATABASE chistes;";
        sentencia.executeUpdate(ifExists);

        sentencia.close();
        connect.close();
    }

}
