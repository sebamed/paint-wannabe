package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Paint extends JFrame {

	public Paint() {
		setBackground(Color.GRAY);
		JPanel jpMain = new JPanel();
		jpMain.setBackground(Color.GRAY);
		getContentPane().add(jpMain, BorderLayout.CENTER);
		jpMain.setLayout(new BorderLayout(0, 0));
		
		
		PanelPovrsina pnlPovrsina = new PanelPovrsina();
		jpMain.add(pnlPovrsina);

		ButtonGroup bgOblici = new ButtonGroup();

		JPanel jpOblici = new JPanel();
		jpOblici.setBorder(new EmptyBorder(10, 10, 10, 10));
		jpMain.add(jpOblici, BorderLayout.WEST);
		jpOblici.setLayout(new GridLayout(6, 1, 0, 10));
		jpOblici.setBackground(Color.CYAN);

		JToggleButton tbtnStrelica = new JToggleButton("Strelica");
		jpOblici.add(tbtnStrelica);

		JToggleButton tbtnTacka = new JToggleButton("Tacka");
		jpOblici.add(tbtnTacka);

		JToggleButton tbtnLinija = new JToggleButton("Linija");
		jpOblici.add(tbtnLinija);

		JToggleButton tbtnKvadrat = new JToggleButton("Kvadrat");
		jpOblici.add(tbtnKvadrat);

		JToggleButton tbtnPravougaonik = new JToggleButton("Pravou");
		jpOblici.add(tbtnPravougaonik);

		JToggleButton tbtnKrug = new JToggleButton("Krug");
		jpOblici.add(tbtnKrug);

		JPanel jpKomande = new JPanel();
		jpMain.add(jpKomande, BorderLayout.NORTH);
		jpKomande.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		jpKomande.setBackground(Color.YELLOW);

		JToggleButton tbtnSelektuj = new JToggleButton("Selektuj");
		tbtnSelektuj.setPreferredSize(new Dimension(70, 40));
		jpKomande.add(tbtnSelektuj);

		JToggleButton tbtnEdituj = new JToggleButton("Edituj");
		tbtnEdituj.setPreferredSize(new Dimension(70, 40));
		jpKomande.add(tbtnEdituj);

		JToggleButton tbtnObrisi = new JToggleButton("Obrisi");
		tbtnObrisi.setPreferredSize(new Dimension(70, 40));
		jpKomande.add(tbtnObrisi);

		JPanel jpLog = new JPanel();
		jpMain.add(jpLog, BorderLayout.SOUTH);
		jpLog.setLayout(new CardLayout(0, 0));

		JScrollPane spLog = new JScrollPane();
		jpLog.add(spLog);

		JTextArea taLog = new JTextArea();
		taLog.setEditable(false);
		taLog.setRows(7);
		spLog.setViewportView(taLog);
		
		JPanel jpKoordinate = new JPanel();
		jpKoordinate.setBackground(Color.ORANGE);
		spLog.setColumnHeaderView(jpKoordinate);
		
		JLabel lblKoordinate = new JLabel("X:    Y :   ");
		jpKoordinate.add(lblKoordinate);

		JPanel jpBoje = new JPanel();
		jpBoje.setBackground(Color.MAGENTA);
		jpBoje.setBorder(new EmptyBorder(10, 10, 10, 10));
		jpMain.add(jpBoje, BorderLayout.EAST);
		jpBoje.setLayout(new GridLayout(8, 1, 0, 10));
		
		JLabel lblBojaOkvira = new JLabel("Boja okvira");
		jpBoje.add(lblBojaOkvira);
		
		JButton btnBojaOkvira = new JButton("");
		jpBoje.add(btnBojaOkvira);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti");
		jpBoje.add(lblBojaUnutrasnjosti);
		
		JButton btnBojaUnutrasnjosti = new JButton("");
		jpBoje.add(btnBojaUnutrasnjosti);

		bgOblici.add(tbtnStrelica);
		bgOblici.add(tbtnTacka);
		bgOblici.add(tbtnLinija);
		bgOblici.add(tbtnKvadrat);
		bgOblici.add(tbtnPravougaonik);
		bgOblici.add(tbtnKrug);
		
		
		// LISTENERI ZA pnlPovrsina
		pnlPovrsina.addMouseMotionListener(new MouseMotionAdapter() { // pomeranje misa po panelu
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblKoordinate.setText("X: " + arg0.getX() + " Y: " + arg0.getY());
			}
		});
		
		pnlPovrsina.addMouseListener(new MouseAdapter() { // mis izisao sa panela
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblKoordinate.setText("X:    Y :   ");
			}
		});
		

		this.setSize(796, 557);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Paint paint = new Paint();
	}

}
