import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	final static int LISTACURSOS = 1;
	final static int DETALLES = 2;
	final static int RESENIAS = 3;
	final static int SALIR = 0;

//se crea el menu con las opciones correspondientes para que funcione el programa
	public static void Menu() {
//TODO arreglar el menu, funciona mal el bucle 
		  App listar = new App();


Scanner sn = new Scanner(System.in);
boolean salir = false;
int opcion; //Guardaremos la opcion del usuario

while (!salir) {
	System.out.println("------------------");
	System.out.println("BIENVENIDO AL MENU");
	System.out.println("------------------");
	System.out.println("1.Listado de cursos");
	System.out.println("2.Detalle del curso");
	System.out.println("3.Curso con mas Reseñas ");
	System.out.println("4.Salir");
	System.out.println("");


    try {

        System.out.println("Escoje una de las opciones");
        opcion = sn.nextInt();

        switch (opcion) {
            case LISTACURSOS:
        
          listar.listar();
                break;
            case DETALLES:
               listar.detalles();
                break;
            case RESENIAS:
              listar.masResenias();
                break;
            case 4:
                salir = true;
                System.out.println("----------------");
                System.out.println("FIN DEL PROGRAMA");
                System.out.println("----------------");
                break;
            default:
                System.out.println("Solo números entre 1 y 4");
        }
    } catch (InputMismatchException e) {
        System.out.println("Debes insertar un número");
        sn.next();
    }
}

}

}