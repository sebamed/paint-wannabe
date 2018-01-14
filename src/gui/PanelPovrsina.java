package gui;

import javax.swing.JPanel;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Oblik;
import oblici.Pravougaonik;
import oblici.Tacka;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPovrsina extends JPanel{
	
	private ArrayList<Oblik> listaOblika;
	
	public PanelPovrsina() {
		// svi oblici
		this.listaOblika = new ArrayList<Oblik>();
		this.listaOblika.add(new Kvadrat(new Tacka(50, 50), 50, "zuta", "crvena"));
		this.listaOblika.add(new Krug(new Tacka(250, 250), 50, "bela", "plava"));
		this.listaOblika.add(new Pravougaonik(new Tacka(150, 150), 50, 70, "zelena", "crvena"));
		this.setBackground(Color.WHITE);
		this.setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Oblik obl : this.listaOblika) {
			obl.crtajUBoji(g);
		}
		repaint();
	}

	public void dodajOblik(Oblik oblik) {
		this.listaOblika.add(oblik);
	}
	
	public void obrisiOblik(Oblik oblik) {
		this.listaOblika.remove(oblik);
	}
	
	public ArrayList<Oblik> getListaOblika() {
		return this.listaOblika;
	}

}
