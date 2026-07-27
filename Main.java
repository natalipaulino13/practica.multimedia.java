package paq;

import java.util.*;
import paq1.*;

public class Main {

	static Scanner scLine = new Scanner(System.in);
	static Scanner scInt = new Scanner(System.in);
	static Scanner scDouble = new Scanner(System.in);
	static Scanner scBoolean = new Scanner (System.in);
	static Contenido contenido1 = null;
	static Contenido contenido2 = null;
	static Contenido contenido3 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean salir = false;

		do {
			System.out.println("\n---GESTOR MULTIMEDIA---");
			System.out.println("1.-Crear/registrar contenido");
			System.out.println("2.-Mostrar ficha");
			System.out.println("3.-Mostrar detalle");
			System.out.println("4.-Reproducir");
			System.out.println("5.-Descargar");
			System.out.println("6.-Calcular coste mensual");
			System.out.println("7.-Vaciar hueco");
			System.out.println("0.-Salir");
			System.out.println("Elige una opción: ");
			int opcion = scInt.nextInt();

			switch (opcion) {
			case 1:
				registrarContenido();
				break;

			case 2:
				mostrarFicha();
				break;

			case 3:
				mostrarDetalle();
				break;

			case 4:
				reproducir();
				break;

			case 5:
				descargar();
				break;

			case 6:
				calcularCosteMensual();
				break;

			case 7:
				vaciarHueco();
				break;

			case 0:
				salir = true;
				System.out.println("Saliendo del gestor...");
				break;
			}

		} while (!salir);

	}

	private static Contenido obtenerHueco(int num) {
		if (num == 1) {
			return contenido1;
		}

		if (num == 2) {
			return contenido2;
		}

		if (num == 3) {
			return contenido3;
		}
		return null;
	}

	private static void asignarHueco(int num, Contenido conte) {
		if (num == 1) {
			contenido1 = conte;
		}
		if (num == 2) {
			contenido2 = conte;
		}
		if (num == 3) {
			contenido3 = conte;
		}
	}

	private static int pedirHueco() {
		System.out.printf("Hueco (1-3): ");
		return scInt.nextInt();
	}

	private static void vaciarHueco() {
		// TODO Auto-generated method stub
		int hueco = pedirHueco();
		asignarHueco(hueco, null);
		System.out.println("Hueco " + hueco + " vaciado.");
	}

	private static void calcularCosteMensual() {
		// TODO Auto-generated method stub
		Contenido contenido = obtenerHueco(pedirHueco());

		if (contenido != null) {
			double coste = contenido.costeMensual();
			double redondeado = Math.round(coste * 100.0) / 100.0;

			System.out.println("Coste mensual: " + redondeado + " €");
		} else {
			System.out.println("Hueco vacío");
		}
	}

	private static void descargar() {
		// TODO Auto-generated method stub

		Contenido contenido = obtenerHueco(pedirHueco());

		if (contenido instanceof Descargable) {
			Descargable descarga = (Descargable) contenido;
			descarga.descargar();
			System.out.println("Tamaño (MB):" + descarga.tamanyoMB());
		} else {
			System.out.println("Este contenido no es descargable.");
		}
	}

	private static void reproducir() {
		// TODO Auto-generated method stub

		Contenido contenido = obtenerHueco(pedirHueco());

		if (contenido instanceof Reproducible) {
			Reproducible repro = (Reproducible) contenido;
			repro.reproducir();
			System.out.println("Duración (segundos): " + repro.duracionSegundos());
		} else {
			System.out.println("Este contenido no es reproducible.");
		}
	}

	private static void mostrarDetalle() {
		// TODO Auto-generated method stub

		Contenido contenido = obtenerHueco(pedirHueco());

		if (contenido != null) {
			contenido.mostrarDetalle();
		} else {
			System.out.println("Hueco vacío");
		}

	}

	private static void mostrarFicha() {
		// TODO Auto-generated method stub

		Contenido contenido = obtenerHueco(pedirHueco());
		if (contenido != null) {
			System.out.println(contenido.ficha());
		} else {
			System.out.println("Hueco vacío");
		}

	}

	private static void registrarContenido() {
		// TODO Auto-generated method stub
		int numHueco = pedirHueco();

		System.out.printf("Tipo (1=Pelicula, 2=Podcast, 3=Curso): ");
		int tipo = scInt.nextInt();

		System.out.printf("ID: ");
		String id = scLine.nextLine();

		System.out.printf("Título: ");
		String titulo = scLine.nextLine();

		System.out.printf("Año: ");
		int anyo = scInt.nextInt();

		System.out.printf("Premium (s/n):");
		boolean premium = scLine.nextLine().equalsIgnoreCase("s");

		Contenido nuevoContenido = null;

		if (tipo == 1) {

			System.out.printf("Director: ");
			String director = scLine.nextLine();
			System.out.printf("Duración(min): ");
			int duracion = scInt.nextInt();
			System.out.printf("Calidad(GB): ");
			double calidad = scDouble.nextDouble();

			nuevoContenido = new Pelicula(id, titulo, anyo, premium, director, duracion, calidad);

		} else if (tipo == 2) {

			System.out.printf("Anfitrión: ");
			String anfitrion = scLine.nextLine();
			System.out.printf("Episodios: ");
			int episodio = scInt.nextInt();
			System.out.printf("Duración por episodio (min): ");
			int duracion = scInt.nextInt();
			nuevoContenido = new Podcast(id, titulo, anyo, premium, anfitrion, episodio, duracion);

		} else if (tipo == 3) {
			System.out.printf("Plataforma: ");
			String plataforma = scLine.nextLine();
			System.out.printf("Horas: ");
			int horas = scInt.nextInt();
			System.out.printf("Materiales (MB): ");
			double tamanyo = scInt.nextDouble();

			nuevoContenido = new CursoOnline(id, titulo, anyo, premium, plataforma, horas, tamanyo);
		}

		asignarHueco(numHueco, nuevoContenido);
		System.out.println("\nContenido guardado en hueco " + numHueco + ".");

	}

}
	
	



