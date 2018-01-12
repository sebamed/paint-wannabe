package oblici;

public class Pravougaonik extends Kvadrat {

	private int visina;

	public Pravougaonik() {

	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina) {
		super(goreLevo, sirina);
		this.visina = visina;
	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina, String boja) {
		this(goreLevo, visina, sirina);
		this.setBoja(boja);
	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina, String boja, String bojaUnutrasnjosti) {
		this(goreLevo, visina, sirina);
		this.setBoja(boja);
		this.setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	public int getVisina() {
		return visina;
	}
	
	public void setVisina(int visina) {
		this.visina = visina;
	}
	
	public double obim() {
		return 2*visina+2*super.getDuzina();
	}
	
	public double povrsina() {
		return visina*super.getDuzina();
	}
	
	@Override
	public String toString() {
		return "Gore levo: " + super.getGoreLevo() + ", duzina stranice: " + super.getDuzina() + ", visina stranice: " + this.getVisina();
	}
	
	@Override
	public Linija dijagonala() {
		Tacka goreDesno = new Tacka(super.goreLevo.getX() + super.getDuzina(), super.goreLevo.getY());		
		Tacka doleLevo = new Tacka(super.goreLevo.getX(), super.goreLevo.getY() + this.visina);	
		
		Linija dijagonala = new Linija(goreDesno, doleLevo);
		
		return dijagonala;
	}

}
