package gestorChistes;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import java.util.Date;

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
    
    //METODO PRINCIPAL PARA CREAR LA CONEXION A LA BBDD
    public void connectToBD() throws SQLException{
    	try {
    		connect = DriverManager.getConnection(BBDD, USER, PASSWORD); 
    		System.out.println("Conexion establecida con exito");
    		}catch(SQLException e) {
            e.printStackTrace();
    		}
    	registroConexion();
 /*	
        Statement sentencia = connect.createStatement();

        String ifExists = "CREATE TABLE chist(id INTEGER);";
        
        try {
        	sentencia.executeUpdate(ifExists);
    		System.out.println("Statement exito");

        	}catch(SQLException e3) {
        	e3.printStackTrace();
    		System.out.println("Error en la statement");

        	}

        sentencia.close();
     */   
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
    	//Registrar conexion en la tabla SESION, el n_sesion, usuario y fecha
        try {
        	
        	
			Statement sentenciaConexion = connect.createStatement();
			//LocalDateTime fechaHoraActual = LocalDateTime.now();		//Linea que coge la fecha y hora actual para introducir en la bbdd
			Date fechaActualMilisegundos = new Date();
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		    String fechaActual = formato.format(fechaActualMilisegundos);
			
			String insertConexion = "INSERT INTO sesion (usuario, fecha) VALUES ('" + USER +"', '" + fechaActual +"');";
					
        	sentenciaConexion.executeUpdate(insertConexion);
        	sentenciaConexion.close();
        	
        	//Creamos la sentencia que nos devolvera la n_sesion de la ultima sesion realizada, osea la mas grande
        	try {				
        		Statement sentenciaUltimaConexion = connect.createStatement();
        		String insertUltimaConexion = "SELECT MAX(n_sesion) AS id_sesion_maximo FROM sesion;";
        		//El executeQuerry siempre devuelve un ResultSet por lo que habrá que convertirlo
        		ResultSet resultado_sesion_maximo = sentenciaUltimaConexion.executeQuery(insertUltimaConexion);
        		int id_sesion_maximo= 0;
        		if(resultado_sesion_maximo.next()) {
        			id_sesion_maximo = resultado_sesion_maximo.getInt("id_sesion_maximo");
        		}else {
        			System.out.println("No hay ultima sesion que sacar");
        		}
        		
        		sentenciaUltimaConexion.close();
        		System.out.println("Registro de Sesion Creado con el ID : " + id_sesion_maximo);
        	}catch(SQLException e5) {
        		e5.printStackTrace();
        		System.out.print("Error en recuperar el id de la sesion actual");
        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    
    public void añadirChistes() {
    	
    }
    
}
