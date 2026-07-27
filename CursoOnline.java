package paq1;

public class CursoOnline extends Contenido implements Descargable {

	private String plataforma;
	private int horas;
	private double materialesMB;

	
	public CursoOnline(String id, String titulo, int anyo, boolean premium, String plataforma, int horas,
			double materialesMB) {
		super(id, titulo, anyo, premium);
		this.plataforma = plataforma;
		this.horas = horas;
		this.materialesMB = materialesMB;
	}

	
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getMaterialesMB() {
		return materialesMB;
	}

	public void setMaterialesMB(double materialesMB) {
		this.materialesMB = materialesMB;
	}

	@Override
	public double tamanyoMB() {
		// TODO Auto-generated method stub
		return this.materialesMB;
	}

	@Override
	public void descargar() {
		// TODO Auto-generated method stub
		System.out.println("Descargando curso '" + this.getTitulo() + "' (" + this.materialesMB + " MB)...");
	}

	@Override
	public double costeMensual() {
		// TODO Auto-generated method stub
		double base;
		if (this.isPremium()) {
			base = 9.99;
		} else {
			base = 5.99;
		}
		return base + (this.materialesMB / 1024.0) * 0.20;

	}

	@Override
	public void mostrarDetalle() {
		// TODO Auto-generated method stub
		System.out.println("[CURSO ONLINE] " + this.ficha());
		System.out.println("Plataforma: " + this.plataforma);
		System.out.println("Horas: " + this.horas);
		System.out.println("Materiales: " + this.materialesMB + " MB");
	}

}
