package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv {

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
	
	public Kvadrat(Tacka goreLevo, int duzina, Color color, Color colorUnutrasnjosti) {
		this.goreLevo = goreLevo;
		this.duzina = duzina;
		super.setColor(color);
		super.setColorUnutrasnjosti(colorUnutrasnjosti);
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
		return 4 * this.duzina;
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
		return "Gore levo: " + this.goreLevo + ", duzina stranice: " + this.getDuzina() + ", boja ivice: " + this.getBoja() + ", boja unutrasnjosti: " + this.getBojaUnutrasnjosti();
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(this.getColor());
		g.drawRect(this.goreLevo.getX(), this.goreLevo.getY(), this.duzina, this.duzina);

		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor(this.getColorUnutrasnjosti());
		g.fillRect(goreLevo.getX(), goreLevo.getY(), this.duzina, this.duzina);
	}

	@Override
	public void selektovan(Graphics g) {
		goreLevo.selektovan(g);
		this.dijagonala().getPocetna().selektovan(g);
		this.dijagonala().getKrajnja().selektovan(g);
		Tacka doleDesno = new Tacka(goreLevo.getX() + duzina, goreLevo.getY() + duzina);
		doleDesno.selektovan(g);
		Linija l1 = new Linija(goreLevo, this.dijagonala().getPocetna());
		l1.sredinaLinije().selektovan(g);
		Linija l2 = new Linija(this.dijagonala().getKrajnja(), doleDesno);
		l2.sredinaLinije().selektovan(g);
		Linija l3 = new Linija(goreLevo, this.dijagonala().getKrajnja());
		l3.sredinaLinije().selektovan(g);
		Linija l4 = new Linija(this.dijagonala().getPocetna(), doleDesno);
		l4.sredinaLinije().selektovan(g);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		if (this.goreLevo.getX() <= x && x <= this.goreLevo.getX() + this.duzina && this.goreLevo.getY() <= y
				&& y <= this.goreLevo.getY() + this.duzina) {
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
