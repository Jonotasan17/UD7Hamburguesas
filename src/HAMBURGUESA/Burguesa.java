package HAMBURGUESA;
import java.util.*;

public class Burguesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] nombre = {"Mexicano", "Alioli", "CheeseBurger", "Barbacoa"};
		String[] ingredientes = {"carne, pimiento, picante, tomate", "carne, lechuga, tomate, alioli",
				"carne, cebolla, cheddar, lechuga, tomate, mayonesa", 
				"carne, bacon, cebolla, cheddar, lechuga, tomate, mayonesa, barbacoa"};
		double[] precio = {8.50, 11, 12.50, 14};
		int[] stock= {12, 8, 23, 15};
		int opcion = 0;
		
		do {
			System.out.println("[----Bienvenido al menu de JavaBurger----]");
			System.out.println("1.PEDIDO");
			System.out.println("2.LA HAMBURGUESA MAS BARATA");
			System.out.println("3.INFORMACION HAMBURGUESA");
			System.out.println("4.BUSCAR INGREDIENTES");
			System.out.println("5.DISMINUIR STOCK");
			System.out.println("6.HAMBURGUESAS POR PERSONA");
			System.out.println("7.SALIR");
			System.out.println("Elige una opcion: ");
			opcion = sc.nextInt();
			
			switch(opcion) {
				
			case 1:
				pedido(sc, nombre, stock, precio);
				break;
			case 2:
				masBarata(nombre, precio);
				break;
			case 3:
				burgerInfo(sc, nombre, ingredientes, stock);
				break;
			case 4:
				buscarIngredient(sc, nombre, ingredientes);
				break;
			case 5:
				opcionComer(sc, nombre, stock);
				break;
			case 6:
				mediaConsumir(sc, stock);
				break;
			case 7:
				System.out.println("Has salido del programa");
				sc.close();
				break;
			default:
				System.err.println("Esa opcion no es valida, seleccione entre el 1 al 7");
	
			}
			
			
		}while(opcion != 7);
	
	}


	private static void pedido(Scanner sc, String[] nombre, int[] stock, double[] precio) {
		// TODO Auto-generated method stub
		String pedido;
		int unidHamburg;
		boolean existe = false;
		
		System.out.println("Que hamburguesa desea pedir: ");
		pedido = sc.next();
		
		for(int i=0; i < nombre.length; i++) {
			if(pedido.equalsIgnoreCase(nombre[i])) {
				System.out.println("Cuantas unidades de " +pedido+ " quieres? ");
				unidHamburg = sc.nextInt();
				if(stock[i] >= unidHamburg) {
					System.out.println("Hay suficiente stock para las hamburguesas, el precio es " +precio[i] * unidHamburg);
				}else {
					System.err.println("No hay suficientes hamburguesas en el stock, vuelva otro dia");
				}
				existe = true;
				break;
			}
			
		}
		if(existe == false) {
			System.out.println("Esa hambugersa no existe en nuestro menu, nigger");
		}
		
	}
	
	private static void masBarata(String[] nombre, double[] precio) {
		// TODO Auto-generated method stub
		double barato = Integer.MAX_VALUE;
		String nombreMenor = "";
		
		for(int i=0; i< precio.length; i++) {
			if(precio[i] < barato) {
				barato = precio[i];
				nombreMenor = nombre[i];
			}
		}
		System.out.println("La hamburguesa mas barata es esta: " +nombreMenor+ "; Precio: " +barato);
		
	}
	

	private static void burgerInfo(Scanner sc, String[] nombre, String[] ingredientes, int[] stock) {
		// TODO Auto-generated method stub
		String peticion;
		boolean existe = false;
		
		System.out.println("Introduzca el nombre de la hamburguesa que desee la info: ");
		peticion= sc.next();
		
		for(int i=0; i < nombre.length; i++) {
			if(peticion.equalsIgnoreCase(nombre[i])) {
				System.out.println("Los ingredientes de la hamburguesa " +nombre[i]+ " son estos: "
						+ingredientes[i]);
				System.out.println("Hay " +stock[i]+ " unidades en stock");
				existe= true;
				break;
			}
		}
		if(existe == false) {
			System.err.println("La hamburguesa introducida no existe");
		}
		
	}

	private static void buscarIngredient(Scanner sc, String[] nombre, String[] ingredientes) {
		// TODO Auto-generated method stub
		String peticion;
		String listaHam = "";
		boolean contiene = false;
		
		System.out.println("Introduzca el nombre del ingrediente que desea buscar: ");
		peticion= sc.next();
		peticion= peticion.toLowerCase();
		
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i].contains(peticion)) {
				contiene= true;
				listaHam = listaHam + " " + nombre[i];
			}
			
		}
		if(contiene == true) {
			System.out.println("si hay hamburguesas con ese ingrediente en la lista: " +listaHam);
		}else {
			System.out.println("No hay hamburguesas con esos ingredientes");
		}
		
	}
	
	private static void opcionComer(Scanner sc, String[] nombre, int[] stock) {
		// TODO Auto-generated method stub
		String peticion;
		int numHamb;
		boolean existe = false;
		
		System.out.println("Introduzca el nombre de la hamburguesa que desea: ");
		peticion = sc.next();
		peticion = peticion.toLowerCase();
		
		for(int i=0; i< nombre.length; i++) {
			if(peticion.equalsIgnoreCase(nombre[i])) {
				System.out.println("Cuantas hamburguesas deseas: ");
				numHamb = sc.nextInt();
				
				if(stock[i] < numHamb) {
					System.out.println("Lo sentimos, pero no tenemos el stock suficiente para ti nigger");
				} else {
					stock[i] = stock[i] - numHamb;
					System.out.println("El nuevo Stock de hamburguesas de " +nombre[i]+ " es de: " 
							+ stock[i]+ " unidades");
				}
				existe = true;
				break;
			}
		}
		if(existe == false) {
			System.out.println("Menudo bodrio de burger, por favor no pida esas cosas aqui, vete al McBodrio");
		}
	}
	
	private static void mediaConsumir(Scanner sc, int[] stock) {
		// TODO Auto-generated method stub
		int numComensales;
		int mediaHamb = 0;
		
		System.out.println("Introduzca el numero de comensales: ");
		numComensales = sc.nextInt();
		
		if(numComensales > 0) {
			for(int i = 0; i< stock.length; i++) {
				mediaHamb += stock[i];
			}
			mediaHamb = mediaHamb / numComensales;
			System.out.println("El numero de hamburguesa por comensales es: " + mediaHamb);
		}else {
			System.out.println("El numero de comensales es incorrecto");
		}
		
	}


	

}
