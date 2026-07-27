package paq1;

public abstract class Contenido {

	private String id;
	private String titulo;
	private int anyo;
	private boolean premium;

	
	public Contenido(String id, String titulo, int anyo, boolean premium) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anyo = anyo;
		this.premium = premium;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public String ficha() {
		return this.id + " - " + this.titulo + "(" + this.anyo + ") Premium=" + this.premium;
	}

	public abstract double costeMensual();

	public abstract void mostrarDetalle();

}
	
	
	
	
	
	
	
	
	
	
	

