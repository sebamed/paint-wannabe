package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable {

	private String boja;
	private boolean selektovan;

	public Oblik() {

	}

	public boolean isSelektovan() {
		return selektovan;
	}

	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}

	public String getBoja() {
		return this.boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public static Color pronadjiBoju(String string) {
		switch (string) {
		case "bela":
			return Color.WHITE;
		case "plava":
			return Color.BLUE;
		case "crvena":
			return Color.RED;
		case "zelena":
			return Color.GREEN;
		case "zuta":
			return Color.YELLOW;
		default:
			return Color.BLACK;
		}
	}

	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
}
