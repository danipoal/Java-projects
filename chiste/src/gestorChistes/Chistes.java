package gestorChistes;

import java.sql.SQLException;
import java.util.Scanner;

public class Chistes extends RepositorioMetodosChistes{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //Inicializamos los datos necesarios iniciales
        Scanner sc = new Scanner(System.in);
        iniciarChistes();
        //Inicializamos el menú
        int numeroMenu;
        do{
            numeroMenu = -1;
            System.out.printf("\n-------MENU PRINCIPAL-------\n");
            System.out.println("1: Introduce un chiste");
            System.out.println("2: Elimina un chiste");
            System.out.println("3: Colorea un chiste");
            System.out.println("4: Ver todos los chistes");
            System.out.println("5: Ver un chiste aleatorio");
            System.out.println("6: Cuenta el chiste que elijas");
            System.out.println("7: Rellena unos cuantos chistes");
            System.out.println("8: Abre el menú de la BBDD");
            System.out.printf("\n0: EXIT\n");

            System.out.printf("Introduce opcion\n");
            numeroMenu = sc.nextInt();
            while(numeroMenu < 0 || numeroMenu > 8){
                System.out.println("Opcion Incorrecta\n Repite: ");
                numeroMenu = sc.nextInt();
                
            }
            sc.nextLine();
            switch (numeroMenu) {
                case 1:
                    System.out.printf("Introduce tu mejor chiste!\n");
                    introducirChiste(sc.nextLine());
                    break;
                case 2:
                    System.out.printf("Que numero de chiste quieres eliminar: ");
                    eliminarChiste(sc.nextInt());
                    break;
                case 3:
                    System.out.println("De que color quieres pintarlo ? [rojo, azul o amarillo]");
                    String color = sc.nextLine();
                    System.out.println("Que chiste quieres colorear? Indica el numero");
                    int nColor = sc.nextInt();      //Si se introduce algo que no es int, de momento da error.
                    colorear(color, nColor);
                    break;

                case 4:
                    System.out.printf(getChistes());
                    break;

                case 5:
                    System.out.printf(getRandomChiste());
                    break;
                case 6:                                     //En desarrollo
                    break;
                case 7:
                    fillChistes();
                    break;
                case 8:
                	menuDB();
                	break;
                case 0:
                    System.out.printf("Gracias por usar este programa\n");
                    break;
                default:
                    System.out.printf("No hay tantas opciones en el menu\n");
                    break;
            }
            
        }while(numeroMenu != 0);
        sc.close();
    }

	private static void menuDB() {
		ConnectDB conexion = new ConnectDB();
		
		try {
			conexion.connectToBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conexion.disconnectFromBD();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
