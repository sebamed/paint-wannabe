package oblici;

import java.awt.Graphics;

public class Krug extends PovrsinskiOblik implements Pomerljiv {
	private Tacka centar;
	private int poluprecnik;

	public Krug() {

	}

	public Krug(Tacka centar, int poluprecnik) {
		this.centar = centar;
		this.poluprecnik = poluprecnik;
	}

	public Krug(Tacka centar, int poluprecnik, String boja) {
		this(centar, poluprecnik);
		setBoja(boja);
	}

	public Krug(Tacka centar, int poluprecnik, String boja, String bojaUnutrasnjosti) {
		this(centar, poluprecnik);
		setBoja(boja);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Tacka getCentar() {
		return centar;
	}

	public void setCentar(Tacka centar) {
		this.centar = centar;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	public void pomeriNa(int x, int y) {
		this.centar.pomeriNa(x, y);
	}

	public void pomeriZa(int x, int y) {
		this.centar.pomeriZa(x, y);
	}

	public double obim() {
		return 2 * this.poluprecnik * Math.PI;
	}

	public double povrsina() {
		return this.poluprecnik * this.poluprecnik * Math.PI;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Krug) {
			Krug prosledjen = (Krug) o;
			return this.poluprecnik - prosledjen.poluprecnik;
		} else {
			return 0;
		}

	}
}