package oblici;

import java.awt.Color;
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
	
	public Krug(Tacka centar, int poluprecnik, Color color, Color colorUnutrasnjosti) {
		this(centar, poluprecnik);
		super.setColor(color);
		super.setColorUnutrasnjosti(colorUnutrasnjosti);
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

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(this.getColor());
		g.drawOval(this.centar.getX() - this.poluprecnik, this.centar.getY() - this.poluprecnik, 2 * this.poluprecnik,
				2 * this.poluprecnik);

		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor(this.getColorUnutrasnjosti());
		g.fillOval(this.centar.getX() - this.poluprecnik, this.centar.getY() - this.poluprecnik, 2 * this.poluprecnik,
				2 * this.poluprecnik);
	}

	@Override
	public void selektovan(Graphics g) {
		centar.selektovan(g);
		Tacka levo = new Tacka(centar.getX() - poluprecnik, centar.getY());
		Tacka desno = new Tacka(centar.getX() + poluprecnik, centar.getY());
		Tacka gore = new Tacka(centar.getX(), centar.getY() - poluprecnik);
		Tacka dole = new Tacka(centar.getX(), centar.getY() + poluprecnik);

		levo.selektovan(g);
		desno.selektovan(g);
		gore.selektovan(g);
		dole.selektovan(g);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		Tacka klik = new Tacka(x, y);
		if (this.centar.udaljenost(klik) <= this.poluprecnik) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void crtajUBoji(Graphics g) {
		this.popuni(g);
		this.crtajSe(g);
	}
}