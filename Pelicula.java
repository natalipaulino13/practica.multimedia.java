package paq1;

public class Pelicula extends Contenido implements Reproducible, Descargable {

	private String director;
	private int duracionMin;
	private double calidadGB;

	
	public Pelicula(String id, String titulo, int anyo, boolean premium, String director, int duracionMin,
			double calidadGB) {
		super(id, titulo, anyo, premium);
		this.director = director;
		this.duracionMin = duracionMin;
		this.calidadGB = calidadGB;
	}

	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracionMin() {
		return duracionMin;
	}

	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}

	public double getCalidadGB() {
		return calidadGB;
	}

	public void setCalidadGB(double calidadGB) {
		this.calidadGB = calidadGB;
	}

	@Override
	public double tamanyoMB() {
		// TODO Auto-generated method stub
		return this.calidadGB * 1024;
	}

	@Override
	public void descargar() {
		// TODO Auto-generated method stub
		System.out.println("Descargando película " + this.getTitulo() + " (" + this.tamanyoMB() + " MB)...");
		;
	}

	@Override
	public void reproducir() {
		// TODO Auto-generated method stub
		System.out.println("Reproduciendo película: " + this.getTitulo() + "...");
	}

	@Override
	public int duracionSegundos() {
		// TODO Auto-generated method stub
		return this.duracionMin * 60;
	}

	@Override
	public double costeMensual() {
		// TODO Auto-generated method stub
		double base;
		if (this.isPremium()) {
			base = 6.99;
		} else {
			base = 3.99;
		}
		return base + (this.calidadGB * 0.25);
	}

	@Override
	public void mostrarDetalle() {
		// TODO Auto-generated method stub
		System.out.println("[PELÍCULA] " + this.ficha());
		System.out.println("Director: " + this.director);
		System.out.println("Duración: " + this.duracionMin + " min");
		System.out.println("Tamaño aprox.: " + this.calidadGB + " GB.");
	}

}
