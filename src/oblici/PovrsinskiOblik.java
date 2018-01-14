package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik{

	private String bojaUnutrasnjosti;
	private Color colorUnutrasnjosti;
	
	public Color getColorUnutrasnjosti() {
		return colorUnutrasnjosti;
	}

	public void setColorUnutrasnjosti(Color colorUnutrasnjosti) {
		this.colorUnutrasnjosti = colorUnutrasnjosti;
	}

	public String getBojaUnutrasnjosti() {
		return this.bojaUnutrasnjosti;
	}
	
	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public abstract double povrsina();
	public abstract double obim();
	public abstract void popuni(Graphics g);
	
}
