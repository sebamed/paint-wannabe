package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Linija;
import oblici.Oblik;
import oblici.Pravougaonik;
import oblici.Tacka;

public class Paint extends JFrame {

	private String selektovaniOblik = "";

	private Oblik trenutnoSelektovan = null;

	private boolean linijaPrvi = true;
	private int tempA = 0, tempB = 0;

	private boolean selektovanje = false;

	// SWING
	private JList<String> jlLog;
	private DefaultListModel<String> dlmLog;
	private JLabel lblKoordinate;
	private JButton btnEdituj, btnObrisi;

	public Paint() {
		this.dlmLog = new DefaultListModel<String>();

		this.setTitle("Paint wannabe");

		setBackground(Color.GRAY);
		JPanel jpMain = new JPanel();
		getContentPane().add(jpMain, BorderLayout.CENTER);
		jpMain.setLayout(new BorderLayout(0, 0));

		PanelPovrsina pnlPovrsina = new PanelPovrsina();
		jpMain.add(pnlPovrsina);

		ButtonGroup bgOblici = new ButtonGroup();

		JPanel jpOblici = new JPanel();
		jpOblici.setBorder(new EmptyBorder(10, 10, 10, 10));
		jpMain.add(jpOblici, BorderLayout.WEST);
		jpOblici.setLayout(new GridLayout(6, 1, 0, 10));

		// Dugmici za odabir oblika
		JToggleButton tbtnStrelica = new JToggleButton();
		tbtnStrelica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				Paint.this.lblKoordinate.setText("Kursor");
			}

			@Override
			public void mouseExited(MouseEvent me) {
				Paint.this.lblKoordinate.setText("X:    Y :   ");
			}
		});
		try {
			Image img = ImageIO.read(getClass().getResource("../images/icons8-cursor-50.png"));
			tbtnStrelica.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tbtnStrelica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Paint.this.toggleSelektovanje(false);
				Paint.this.selektovaniOblik = "";
				Paint.this.trenutnoSelektovan = null;
				for(Oblik oblik : pnlPovrsina.getListaOblika()) {
					oblik.setSelektovan(false);
				}
			}
		});
		jpOblici.add(tbtnStrelica);

		JToggleButton tbtnTacka = new JToggleButton();
		tbtnTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				Paint.this.lblKoordinate.setText("Tacka");
			}

			@Override
			public void mouseExited(MouseEvent me) {
				Paint.this.lblKoordinate.setText("X:    Y :   ");
			}
		});
		try {
			Image img = ImageIO.read(getClass().getResource("../images/icons8-sphere-filled-50.png"));
			tbtnTacka.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tbtnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Paint.this.toggleSelektovanje(false);
				Paint.this.selektovaniOblik = "Tacka";
			}
		});
		jpOblici.add(tbtnTacka);

		JToggleButton tbtnLinija = new JToggleButton();
		tbtnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				Paint.this.lblKoordinate.setText("Linija");
			}

			@Override
			public void mouseExited(MouseEvent me) {
				Paint.this.lblKoordinate.setText("X:    Y :   ");
			}
		});
		try {
			Image img = ImageIO.read(getClass().getResource("../images/icons8-line-50.png"));
			tbtnLinija.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tbtnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Paint.this.toggleSelektovanje(false);
				Paint.this.selektovaniOblik = "Linija";
			}
		});
		jpOblici.add(tbtnLinija);

		JToggleButton tbtnKvadrat = new JToggleButton();
		tbtnKvadrat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				Paint.this.lblKoordinate.setText("Kvadrat");
			}

			@Override
			public void mouseExited(MouseEvent me) {
				Paint.this.lblKoordinate.setText("X:    Y :   ");
			}
		});
		try {
			Image img = ImageIO.read(getClass().getResource("../images/icons8-unchecked-checkbox-50.png"));
			tbtnKvadrat.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tbtnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Paint.this.toggleSelektovanje(false);
				Paint.this.selektovaniOblik = "Kvadrat";
			}
		});
		jpOblici.add(tbtnKvadrat);

		JToggleButton tbtnPravougaonik = new JToggleButton();
		tbtnPravougaonik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				Paint.this.lblKoordinate.setText("Pravougaonik");
			}

			@Override
			public void mouseExited(MouseEvent me) {
				Paint.this.lblKoordinate.setText("X:    Y :   ");
			}
		});
		try {
			Image img = ImageIO.read(getClass().getResource("../images/icons8-rectangular-50.png"));
			tbtnPravougaonik.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tbtnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Paint.this.toggleSelektovanje(false);
				Paint.this.selektovaniOblik = "Pravougaonik";
			}
		});
		jpOblici.add(tbtnPravougaonik);

		JToggleButton tbtnKrug = new JToggleButton();
		tbtnKrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				Paint.this.lblKoordinate.setText("Krug");
			}

			@Override
			public void mouseExited(MouseEvent me) {
				Paint.this.lblKoordinate.setText("X:    Y :   ");
			}
		});
		try {
			Image img = ImageIO.read(getClass().getResource("../images/icons8-round-50.png"));
			tbtnKrug.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tbtnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Paint.this.toggleSelektovanje(false);
				Paint.this.selektovaniOblik = "Krug";
			}
		});
		jpOblici.add(tbtnKrug);

		JPanel jpKomande = new JPanel();
		jpMain.add(jpKomande, BorderLayout.NORTH);
		jpKomande.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		ButtonGroup bgKomande = new ButtonGroup();

		JToggleButton tbtnSelektuj = new JToggleButton("Selektuj");
		tbtnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paint.this.toggleSelektovanje(true);
			}
		});
		tbtnSelektuj.setPreferredSize(new Dimension(80, 40));
		jpKomande.add(tbtnSelektuj);

		btnEdituj = new JButton("Edituj");
		btnEdituj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Paint.this.trenutnoSelektovan == null) {
					JOptionPane.showMessageDialog(Paint.this, "Morate selektovati oblik!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				} else {
					if (Paint.this.trenutnoSelektovan instanceof Tacka) { // tacka selektovana
						Tacka temp = (Tacka) Paint.this.trenutnoSelektovan;
						DialogEditTacka deTacka = new DialogEditTacka(Paint.this, "Edituj tacku", true, temp);
						if (deTacka.getSacuvano()) {
							temp.setX(Integer.parseInt(deTacka.tfX.getText()));
							temp.setY(Integer.parseInt(deTacka.tfY.getText()));
							temp.setColor(deTacka.btnBoja.getBackground());
							Paint.this.trenutnoSelektovan = temp;
							Paint.this.dlmLog.addElement("Editovana tacka u: " + temp);
							Paint.this.trenutnoSelektovan.setSelektovan(true);
						}
					} else if (Paint.this.trenutnoSelektovan instanceof Linija) { // linija selektovana
						Linija temp = (Linija) Paint.this.trenutnoSelektovan;
						DialogEditLinija deLinija = new DialogEditLinija(Paint.this, "Edituj liniju", true, temp);
						if (deLinija.getSacuvano()) {
							temp.getPocetna().setX(Integer.parseInt(deLinija.tfXPrva.getText()));
							temp.getPocetna().setY(Integer.parseInt(deLinija.tfYPrva.getText()));
							temp.getKrajnja().setX(Integer.parseInt(deLinija.tfXDruga.getText()));
							temp.getKrajnja().setY(Integer.parseInt(deLinija.tfYDruga.getText()));
							temp.setColor(deLinija.btnBoja.getBackground());
							Paint.this.trenutnoSelektovan = temp;
							Paint.this.dlmLog.addElement("Editovana linija u: " + temp);
							Paint.this.trenutnoSelektovan.setSelektovan(true);
						}

					} else if (Paint.this.trenutnoSelektovan instanceof Pravougaonik) { // pravougaonik selektovan - prvo pravougaonik pa kvadrat jer je p instanca kvadrata
						Pravougaonik temp = (Pravougaonik) Paint.this.trenutnoSelektovan;
						DialogEditPravougaonik dePravougaonik = new DialogEditPravougaonik(Paint.this,
								"Edituj pravougaonik", true, temp);
						if (dePravougaonik.getSacuvano()) {
							temp.getGoreLevo().setX(Integer.parseInt(dePravougaonik.tfX.getText()));
							temp.getGoreLevo().setY(Integer.parseInt(dePravougaonik.tfY.getText()));
							temp.setDuzina(Integer.parseInt(dePravougaonik.tfSirina.getText()));
							temp.setVisina(Integer.parseInt(dePravougaonik.tfVisina.getText()));
							temp.setColor(dePravougaonik.btnBojaOkvira.getBackground());
							temp.setColorUnutrasnjosti(dePravougaonik.btnBojaUnutrasnjosti.getBackground());
							Paint.this.trenutnoSelektovan = temp;
							Paint.this.dlmLog.addElement("Editovan pravougaonik u: " + temp);
							Paint.this.trenutnoSelektovan.setSelektovan(true);
						}
					} else if (Paint.this.trenutnoSelektovan instanceof Kvadrat) { // kvadrat selektovan
						Kvadrat temp = (Kvadrat) Paint.this.trenutnoSelektovan;
						DialogEditKvadrat deKvadrat = new DialogEditKvadrat(Paint.this, "Edituj kvadrat", true, temp);
						if (deKvadrat.getSacuvano()) {
							temp.getGoreLevo().setX(Integer.parseInt(deKvadrat.tfX.getText()));
							temp.getGoreLevo().setY(Integer.parseInt(deKvadrat.tfY.getText()));
							temp.setDuzina(Integer.parseInt(deKvadrat.tfStranica.getText()));
							temp.setColor(deKvadrat.btnBojaOkvira.getBackground());
							temp.setColorUnutrasnjosti(deKvadrat.btnBojaUnutrasnjosti.getBackground());
							Paint.this.trenutnoSelektovan = temp;
							Paint.this.dlmLog.addElement("Editovan kvadrat u: " + temp);
							Paint.this.trenutnoSelektovan.setSelektovan(true);
						}
					} else if (Paint.this.trenutnoSelektovan instanceof Krug) { // krug selektovan
						Krug temp = (Krug) Paint.this.trenutnoSelektovan;
						DialogEditKrug deKrug = new DialogEditKrug(Paint.this, "Edituj Krug", true, temp);
						if (deKrug.getSacuvano()) {
							temp.getCentar().setX(Integer.parseInt(deKrug.tfX.getText()));
							temp.getCentar().setY(Integer.parseInt(deKrug.tfY.getText()));
							temp.setPoluprecnik(Integer.parseInt(deKrug.tfRadius.getText()));
							temp.setColor(deKrug.btnBojaOkvira.getBackground());
							temp.setColorUnutrasnjosti(deKrug.btnBojaUnutrasnjosti.getBackground());
							Paint.this.trenutnoSelektovan = temp;
							Paint.this.dlmLog.addElement("Editovan krug u: " + temp);
							Paint.this.trenutnoSelektovan.setSelektovan(true);
						}
					}
				}
			}
		});
		btnEdituj.setEnabled(false);
		btnEdituj.setPreferredSize(new Dimension(70, 40));
		jpKomande.add(btnEdituj);

		btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Paint.this.trenutnoSelektovan == null) {
					JOptionPane.showMessageDialog(Paint.this, "Morate selektovati oblik!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				} else {
					pnlPovrsina.obrisiOblik(Paint.this.trenutnoSelektovan);
					Paint.this.dlmLog.addElement("Obrisan oblik: " + Paint.this.trenutnoSelektovan + " - "
							+ String.valueOf(Paint.this.trenutnoSelektovan.getClass()).substring(13));
					Paint.this.trenutnoSelektovan = null;
				}
			}
		});
		btnObrisi.setEnabled(false);
		btnObrisi.setPreferredSize(new Dimension(70, 40));
		jpKomande.add(btnObrisi);

		JPanel jpLog = new JPanel();
		jpLog.setBorder(new EmptyBorder(10, 0, 0, 0));
		jpMain.add(jpLog, BorderLayout.SOUTH);
		jpLog.setLayout(new CardLayout(0, 0));

		JScrollPane spLog = new JScrollPane();
		jpLog.add(spLog);

		this.jlLog = new JList<String>(this.dlmLog);
		spLog.setViewportView(this.jlLog);

		JPanel jpKoordinate = new JPanel();
		jpKoordinate.setBackground(Color.ORANGE);
		spLog.setColumnHeaderView(jpKoordinate);

		lblKoordinate = new JLabel("X:    Y :   ");
		jpKoordinate.add(lblKoordinate);

		JPanel jpBoje = new JPanel();
		jpBoje.setBorder(new EmptyBorder(10, 10, 10, 10));
		jpMain.add(jpBoje, BorderLayout.EAST);
		jpBoje.setLayout(new GridLayout(8, 1, 0, 10));

		JLabel lblBojaOkvira = new JLabel("Boja okvira");
		jpBoje.add(lblBojaOkvira);

		JButton btnBojaOkvira = new JButton("");
		btnBojaOkvira.setBackground(Color.BLACK);
		btnBojaOkvira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Paint.this.bojaOkvira(btnBojaOkvira);
			}
		});
		jpBoje.add(btnBojaOkvira);

		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti");
		jpBoje.add(lblBojaUnutrasnjosti);

		JButton btnBojaUnutrasnjosti = new JButton("");
		btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paint.this.bojaUnutrasnjosti(btnBojaUnutrasnjosti);
			}
		});
		jpBoje.add(btnBojaUnutrasnjosti);

		bgOblici.add(tbtnStrelica);
		bgOblici.add(tbtnTacka);
		bgOblici.add(tbtnLinija);
		bgOblici.add(tbtnKvadrat);
		bgOblici.add(tbtnPravougaonik);
		bgOblici.add(tbtnKrug);
		bgOblici.add(tbtnSelektuj);

		// LISTENERI ZA pnlPovrsina
		pnlPovrsina.addMouseMotionListener(new MouseMotionAdapter() { // pomeranje misa po panelu
			@Override
			public void mouseMoved(MouseEvent me) {
				lblKoordinate.setText("X: " + me.getX() + " Y: " + me.getY());
			}
		});

		pnlPovrsina.addMouseListener(new MouseAdapter() { // mis izisao sa panela
			@Override
			public void mouseExited(MouseEvent me) {
				lblKoordinate.setText("X:    Y :   ");
			}

			@Override
			public void mouseClicked(MouseEvent me) { // mis kliknuo levim
				if (Paint.this.selektovanje) { // ukljucen mod za selektovanje
					Collections.reverse(pnlPovrsina.getListaOblika());
					if (Paint.this.trenutnoSelektovan != null) {
						Paint.this.trenutnoSelektovan.setSelektovan(false);
					}
					for (Oblik oblik : pnlPovrsina.getListaOblika()) {
						if (oblik.sadrzi(me.getX(), me.getY())) {
							oblik.setSelektovan(true);
							Paint.this.trenutnoSelektovan = oblik;
							break;
						}
					}
					Collections.reverse(pnlPovrsina.getListaOblika());
				} else {
					switch (Paint.this.selektovaniOblik) {
					case "Tacka":
						Paint.this.linijaPrvi = true;
						pnlPovrsina.dodajOblik(new Tacka(me.getX(), me.getY(), btnBojaOkvira.getBackground()));
						Paint.this.dlmLog.addElement("Dodata tacka: (" + me.getX() + ", " + me.getY() + ")");
						break;
					case "Linija":
						Paint.this.lblKoordinate.setText("Napravite drugo teme linije");
						if (linijaPrvi) { // prvo teme linije
							Paint.this.tempA = me.getX();
							Paint.this.tempB = me.getY();
							Paint.this.linijaPrvi = false;
						} else {
							Linija tempZaLog = new Linija(new Tacka(Paint.this.tempA, Paint.this.tempB),
									new Tacka(me.getX(), me.getY()), btnBojaOkvira.getBackground());
							pnlPovrsina.dodajOblik(tempZaLog);
							Paint.this.linijaPrvi = true;
							Paint.this.dlmLog.addElement("Dodata linija: " + tempZaLog);
						}
						break;
					case "Kvadrat":
						Paint.this.linijaPrvi = true;
						String stranica = JOptionPane.showInputDialog(Paint.this, "Unesite duzinu stranice kvadrata:",
								"Duzina stranice", JOptionPane.QUESTION_MESSAGE);
						try {
							if (stranica != null) {
								int duzinaStranice = Integer.parseInt(stranica);
								if (duzinaStranice >= 0) {
									pnlPovrsina.dodajOblik(new Kvadrat(new Tacka(me.getX(), me.getY()), duzinaStranice,
											btnBojaOkvira.getBackground(), btnBojaUnutrasnjosti.getBackground()));
									Paint.this.dlmLog.addElement("Dodat kvadrat: (" + me.getX() + ", " + me.getY()
											+ "), stranica:" + duzinaStranice);
								}
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Morate uneti pozitivan broj!", "Greska",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
					case "Pravougaonik":
						Paint.this.linijaPrvi = true;
						JTextField visina = new JTextField();
						JTextField sirina = new JTextField();
						Object[] visinaSirina = { "Visina:", visina, "Sirina:", sirina };
						int option = JOptionPane.showConfirmDialog(Paint.this, visinaSirina, "Pravougaonik",
								JOptionPane.OK_CANCEL_OPTION);
						if (option == JOptionPane.OK_OPTION) {
							String visinaPravougaonika = visina.getText();
							String sirinaPravougaonika = sirina.getText();
							try {
								if (visinaPravougaonika != null && sirinaPravougaonika != null) {
									int visinaStranice = Integer.parseInt(visinaPravougaonika);
									int sirinaStranice = Integer.parseInt(sirinaPravougaonika);
									if (visinaStranice >= 0 && sirinaStranice >= 0) {
										pnlPovrsina.dodajOblik(new Pravougaonik(new Tacka(me.getX(), me.getY()),
												visinaStranice, sirinaStranice, btnBojaOkvira.getBackground(),
												btnBojaUnutrasnjosti.getBackground()));
										Paint.this.dlmLog.addElement("Dodat pravougaonik: (" + me.getX() + ", "
												+ me.getY() + "), stranice:" + visinaStranice + ", " + sirinaStranice);
									}
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Morate uneti pozitivne brojeve!", "Greska",
										JOptionPane.ERROR_MESSAGE);
							}
						}
						break;
					case "Krug":
						Paint.this.linijaPrvi = true;
						String radius = JOptionPane.showInputDialog(Paint.this, "Unesite duzinu poluprecnika kruga:",
								"Poluprecnik kruga", JOptionPane.QUESTION_MESSAGE);
						try {
							if (radius != null) {
								int radiusKruga = Integer.parseInt(radius);
								if (radiusKruga >= 0) {
									pnlPovrsina.dodajOblik(new Krug(new Tacka(me.getX(), me.getY()), radiusKruga,
											btnBojaOkvira.getBackground(), btnBojaUnutrasnjosti.getBackground()));
									Paint.this.dlmLog.addElement("Dodat krug: centar (" + me.getX() + ", " + me.getY()
											+ "), poluprecnik:" + radiusKruga);
								}
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Morate uneti pozitivan broj!", "Greska",
									JOptionPane.ERROR_MESSAGE);
						}
						break;
					default:
						Paint.this.linijaPrvi = true;
						Paint.this.lblKoordinate.setText("Selektujte oblik");
						System.out.println("nista jeee");
						break;
					}
				}
			}
		});

		this.pack();
		this.setSize(948, 678);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Paint paint = new Paint();
	}

	private void bojaOkvira(JButton btnBojaOkvira) {
		JColorChooser jccOkvir = new JColorChooser();
		Color colorOkvir = jccOkvir.showDialog(null, "Izaberite boju okvira", Color.BLACK); // vraca kliknutu boju

		if (colorOkvir != null) {
			btnBojaOkvira.setBackground(colorOkvir);
			this.dlmLog.addElement("Promenjena boja okvira u: " + colorOkvir.toString().substring(14));
		} else {
			this.dlmLog.addElement("Boja okvira nije promenjena");
		}
	}

	private void bojaUnutrasnjosti(JButton btnBojaUnutrasnjosti) {
		JColorChooser jccUnutrasnjost = new JColorChooser();
		Color colorUnutrasnjost = jccUnutrasnjost.showDialog(null, "Izaberite boju unutrasnjosti", Color.WHITE);

		if (colorUnutrasnjost != null) {
			btnBojaUnutrasnjosti.setBackground(colorUnutrasnjost);
			this.dlmLog.addElement("Promenjena boja unutrasnjosti u: " + colorUnutrasnjost.toString().substring(14));
		} else {
			this.dlmLog.addElement("Boja unutrasnjosti nije promenjena");
		}
	}

	private void toggleSelektovanje(boolean selected) {
		this.btnEdituj.setEnabled(selected);
		this.btnObrisi.setEnabled(selected);
		this.selektovanje = selected;
	}
}
