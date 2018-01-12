package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv {

	private int x, y;

	public Tacka() {

	}

	public Tacka(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Tacka(int x, int y, String boja) {
		this.x = x;
		this.y = y;
		super.setBoja(boja);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(Object druga) {
		if (druga instanceof Tacka) { // jeste tacka
			Tacka drugaTacka = (Tacka) druga;
			return (int) (this.udaljenost(new Tacka(0, 0)) - drugaTacka.udaljenost(new Tacka(0, 0)));
		} else {
			return 0;
		}
	}

	@Override
	public void pomeriNa(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	@Override
	public void pomeriZa(int x, int y) {
		this.setX(this.x + x);
		this.setY(this.y + y);
	}

	public double udaljenost(Tacka druga) {
		return Math.sqrt((druga.getX() - this.getX()) * (druga.getX() - this.getX())
				+ (druga.getY() - this.getY()) * (druga.getY() - this.getY()));
	}

	@Override
	public String toString() {
		return "(" + this.getX() + ", " + this.getY() + ")";
	}

	public boolean equals(Object druga) {
		if (druga instanceof Tacka) { // jeste tacka
			Tacka drugaTacka = (Tacka) druga;
			if (this.getX() == drugaTacka.getX() && this.getY() == drugaTacka.getY()) { // iste su
				return true;
			} else { // nisu iste
				return false;
			}
		} else { // nije tacka
			System.out.println("Tacka - equals: NIJE PROSLEDJENA TACKA");
			return false;
		}
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(super.pronadjiBoju(this.getBoja()));
		g.drawLine(x - 1, y - 1, x + 1, y + 1);
		g.drawLine(x - 1, y + 1, x + 1, y - 1);

		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x - 3, y - 3, 6, 6);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		Tacka klik = new Tacka(x, y);
		if (this.udaljenost(klik) <= 3) {
			return true;
		} else {
			return false;
		}
	}

}
