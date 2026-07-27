package paq1;

public class Podcast extends Contenido implements Reproducible {

	private String anfitrion;

	private int episodios;

	private int duracionMinPorEpisodio;

	
	public Podcast(String id, String titulo, int anyo, boolean premium, String anfitrion, int episodios,
			int duracionMinPorEpisodio) {
		super(id, titulo, anyo, premium);
		this.anfitrion = anfitrion;
		this.episodios = episodios;
		this.duracionMinPorEpisodio = duracionMinPorEpisodio;
	}

	
	public String getAnfitrion() {
		return anfitrion;
	}

	public void setAnfitrion(String anfitrion) {
		this.anfitrion = anfitrion;
	}

	public int getEpisodios() {
		return episodios;
	}

	public void setEpisodios(int episodios) {
		this.episodios = episodios;
	}

	public int getDuracionMinPorEpisodio() {
		return duracionMinPorEpisodio;
	}

	public void setDuracionMinPorEpisodio(int duracionMinPorEpisodio) {
		this.duracionMinPorEpisodio = duracionMinPorEpisodio;
	}

	@Override
	public void reproducir() {
		// TODO Auto-generated method stub
		System.out.println("Reproduciendo podcast: " + this.getTitulo() + "...");
	}

	@Override
	public int duracionSegundos() {
		// TODO Auto-generated method stub
		return this.episodios * this.duracionMinPorEpisodio * 60;
	}

	@Override
	public double costeMensual() {
		// TODO Auto-generated method stub
		double base;

		if (this.isPremium()) {
			base = 4.99;
		} else {
			base = 0.00;
		}

		return base + (this.episodios * 0.05);

	}

	@Override
	public void mostrarDetalle() {
		// TODO Auto-generated method stub
		System.out.println("[PODCAST] " + this.ficha());
		System.out.println("Anfitrión: " + this.anfitrion);
		System.out.println("Episodios: " + this.episodios);
		System.out.println("Duración total: " + this.duracionSegundos() + " segundos");

	}

}
