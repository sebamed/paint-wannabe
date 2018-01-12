package oblici;

import java.awt.Graphics;

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
		return 2 * visina + 2 * super.getDuzina();
	}

	public double povrsina() {
		return visina * super.getDuzina();
	}

	@Override
	public String toString() {
		return "Gore levo: " + super.getGoreLevo() + ", duzina stranice: " + super.getDuzina() + ", visina stranice: "
				+ this.getVisina();
	}

	@Override
	public Linija dijagonala() {
		Tacka goreDesno = new Tacka(super.goreLevo.getX() + super.getDuzina(), super.goreLevo.getY());
		Tacka doleLevo = new Tacka(super.goreLevo.getX(), super.goreLevo.getY() + this.visina);

		Linija dijagonala = new Linija(goreDesno, doleLevo);

		return dijagonala;
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(pronadjiBoju(this.getBoja()));
		g.drawRect(goreLevo.getX(), goreLevo.getY(), super.getDuzina(), this.visina);

		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor(pronadjiBoju(this.getBojaUnutrasnjosti()));
		g.fillRect(goreLevo.getX(), goreLevo.getY(), super.getDuzina(), visina);
	}

	@Override
	public void selektovan(Graphics g) {
		goreLevo.selektovan(g);
		this.dijagonala().getPocetna().selektovan(g);
		this.dijagonala().getKrajnja().selektovan(g);
		Tacka doleDesno = new Tacka(goreLevo.getX() + super.getDuzina(), goreLevo.getY() + visina);
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
		if (super.goreLevo.getX() <= x && x <= super.goreLevo.getX() + super.getDuzina() && super.goreLevo.getY() <= y
				&& y <= super.goreLevo.getY() + visina) {
			return true;
		} else {
			return false;
		}
	}
}
