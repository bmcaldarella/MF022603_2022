import java.util.Scanner;

public class Menu {

	final static int LISTACURSOS = 1;
	final static int DETALLES = 2;
	final static int RESENIAS = 3;
	final static int SALIR = 0;
//se crea el menu con las opciones correspondientes para que funcione el programa
	public static void Menu() {
//TODO arreglar el menu, funciona mal el bucle 
		Scanner sc = new Scanner(System.in);
		boolean bucle = false;

		do {
			try {
				System.out.println("------------------");
				System.out.println("BIENVENIDO AL MENU");
				System.out.println("------------------");
				System.out.println("1.Listado de cursos");
				System.out.println("2.Detalle del curso");
				System.out.println("3.Reseñas del curso");
				System.out.println("0.Salir");
				System.out.println("");
				System.out.println("Escoja una opcion ");
				int opcion = sc.nextInt();

				switch (opcion) {
				case LISTACURSOS:
					bucle = false;
					System.out.println("hola");

					break;
				case DETALLES:
					bucle = false;
					System.out.println("hola2");
					break;

				case RESENIAS:
					bucle = false;
					System.out.println("Hola3");

				case SALIR:
			
					System.out.println("..................");
					System.out.println(".FIN DEL PROGRAMA.");
					System.out.println("..................");
					break;

				default:
					bucle = true;
					System.out.println("Error, Las opciones son del 1-3");
					break;
				}

			} catch (Exception e) {
		
				System.out.println("........................");
				System.out.println("ERROR DATO INVALIDO");
				break;

			}
		} while (bucle==true);
	}
}
