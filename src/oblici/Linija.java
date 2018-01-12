package oblici;

public class Linija extends Oblik implements Pomerljiv {
	private Tacka pocetna, krajnja;

	public Linija() {

	}

	public Linija(Tacka pocetna, Tacka krajnja) {
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	}
	
	public Linija(Tacka pocetna, Tacka krajnja, String boja) {
		this.pocetna = pocetna;
		this.krajnja = krajnja;
		super.setBoja(boja);
	}

	public Tacka getKrajnja() {
		return krajnja;
	}

	public void setKrajnja(Tacka krajnja) {
		this.krajnja = krajnja;
	}

	public Tacka getPocetna() {
		return pocetna;
	}

	public void setPocetna(Tacka pocetna) {
		this.pocetna = pocetna;
	}

	public double duzina() {
		return this.pocetna.udaljenost(this.krajnja);
	}

	public int compareTo(Object druga) {
		if(druga instanceof Linija) {
			Linija drugaLinija = (Linija) druga;
			return (int) (this.duzina() - drugaLinija.duzina());
		}else {
		return 0;
		}
	}

	public Tacka sredinaLinije() {
		return new Tacka((this.pocetna.getX() + this.krajnja.getX()) / 2,
				(this.pocetna.getY() + this.krajnja.getY()) / 2);
	}
	
	@Override
	public String toString() {
		return "Pocetna: "  + this.pocetna + ", Krajnja: " + this.krajnja;
	}

	@Override
	public void pomeriNa(int x, int y) {
		this.pocetna.pomeriNa(x, y);
		this.krajnja.pomeriZa(x - this.pocetna.getX(), y - this.pocetna.getY());
	}

	@Override
	public void pomeriZa(int x, int y) {
		this.pocetna.pomeriZa(x, y);
		this.krajnja.pomeriZa(x, y);
	}

}
