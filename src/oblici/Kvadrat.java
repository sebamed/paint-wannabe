package oblici;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{

	protected Tacka goreLevo;
	private int duzina;

	public Kvadrat() {

	}

	public Kvadrat(Tacka goreLevo, int duzina) {
		this.goreLevo = goreLevo;
		this.duzina = duzina;
	}

	public Kvadrat(Tacka goreLevo, int duzina, String boja) {
		this.goreLevo = goreLevo;
		this.duzina = duzina;
		super.setBoja(boja);
	}

	public Kvadrat(Tacka goreLevo, int duzina, String boja, String bojaUnutrasnjosti) {
		this.goreLevo = goreLevo;
		this.duzina = duzina;
		super.setBoja(boja);
		super.setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}
	
	public Linija dijagonala() {
		Tacka goreDesno = new Tacka(this.goreLevo.getX() + this.duzina, goreLevo.getY());
		Tacka doleLevo = new Tacka(goreLevo.getX(), this.goreLevo.getY() + this.duzina);
		
		Linija dijagonala = new Linija(goreDesno, doleLevo);
		
		return dijagonala;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Kvadrat) {
			Kvadrat prosledjen = (Kvadrat) o;
			return this.duzina - prosledjen.duzina;
		} else {
			return 0;
		}
	}

	@Override
	public double povrsina() {
		return this.duzina * this.duzina;
	}

	@Override
	public double obim() {
		return 4*this.duzina;
	}

	@Override
	public void pomeriNa(int x, int y) {
		this.goreLevo.pomeriNa(x, y);
	}

	@Override
	public void pomeriZa(int x, int y) {
		this.goreLevo.pomeriZa(x, y);
	}
	
	@Override
	public String toString() {
		return "Gore levo: " + this.goreLevo + ", duzina stranice: " + this.getDuzina();
	}

}
