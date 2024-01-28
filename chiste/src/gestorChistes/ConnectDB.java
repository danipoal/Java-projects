package gestorChistes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectDB {
	
    private final String BBDD;
    private final String USER;
    private final String PASSWORD;
    private Connection connect;
    public ConnectDB(){
        this.BBDD = "jdbc:mysql://localhost:3306/chistes";
        this.USER = "daniel";
        this.PASSWORD = "B7NYtwmZzk_a0uQU";
        
        
    }

    public ConnectDB(String BBDD, String USER, String PASSWORD) throws ClassNotFoundException{
    	Class.forName("oracle.jdbc.OracleDriver");
    	this.BBDD = BBDD;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
   }
    public void connectToBD() throws SQLException{
    	try {
    		connect = DriverManager.getConnection(BBDD, USER, PASSWORD); 
    		System.out.println("Conexion establecida con exito");
    	}catch(SQLException e) {
            e.printStackTrace();
    	}
    	
    	
    	
        Statement sentencia = connect.createStatement();

        
        
        String ifExists = "CREATE TABLE chistes(id INTEGER);";
        try {
        	sentencia.executeUpdate(ifExists);
    		System.out.println("Statement exito");

        }catch(SQLException e3) {
        	e3.printStackTrace();
    		System.out.println("Error en la statement");

        }
        

        sentencia.close();
        
    }
    public void disconnectFromBD() throws SQLException{
    	try {
    		 if (connect != null && !connect.isClosed()) {
                 connect.close();
                 System.out.println("Conexión cerrada");
    		 }
    	}catch(SQLException e) {
        e.printStackTrace();
    
    	}
    }
    public void registroConexion() {
    	
    }
    
    public void añadirChistes() {
    	
    }
    
}
