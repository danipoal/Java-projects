package bbdd;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ConnectDB connect = new ConnectDB();
        try{
            connect.connectToBD();
        }catch(SQLException er){
            System.err.println("No se ha podido conectar");
            er.printStackTrace();
        }
	}

}
