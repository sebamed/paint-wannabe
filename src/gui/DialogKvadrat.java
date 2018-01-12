package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import oblici.Kvadrat;
import oblici.Tacka;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DialogKvadrat extends JDialog {

	private String[] bojeIvice;
	private String[] bojeUnutrasnjosti;

	public Kvadrat noviKvadrat;

	// SWING
	public JTextField tfGoreLevoX;
	public JTextField tfGoreLevoY;
	public JTextField tfDuzina;
	public JComboBox cboxBojaIvice;
	public JComboBox cboxBojaU;
	public JButton btnDodajKvadrat;
	
	public boolean potvrdjenoBrisanje;

	public DialogKvadrat(JFrame parent, String title, boolean modal, boolean dodavanje, Kvadrat poslednjiKvadrat) {

		super(parent, title, modal);
		

		this.bojeIvice = new String[] { "Bela", "Plava", "Crvena", "Zelena", "Zuta", "Crna" };
		this.bojeUnutrasnjosti = this.bojeIvice;
		
		DefaultComboBoxModel<String> dcbmIvice = new DefaultComboBoxModel<String>(this.bojeIvice);
		DefaultComboBoxModel<String> dcbmUnutrasnjost = new DefaultComboBoxModel<String>(this.bojeUnutrasnjosti);

		JPanel jpMainKvadrat = new JPanel();
		getContentPane().add(jpMainKvadrat, BorderLayout.CENTER);
		jpMainKvadrat.setLayout(null);

		JLabel lblGoreLevoX = new JLabel("Gore levo X: ");
		lblGoreLevoX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGoreLevoX.setBounds(22, 11, 89, 25);
		jpMainKvadrat.add(lblGoreLevoX);

		JLabel lblGoreLevoY = new JLabel("Gore levo Y: ");
		lblGoreLevoY.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGoreLevoY.setBounds(22, 47, 89, 25);
		jpMainKvadrat.add(lblGoreLevoY);

		JLabel label = new JLabel("Duzina stranice: ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(22, 83, 89, 25);
		jpMainKvadrat.add(label);

		JLabel label_1 = new JLabel("Boja ivice: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(22, 119, 89, 25);
		jpMainKvadrat.add(label_1);

		JLabel label_2 = new JLabel("Boja unutrasnjosti: ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(10, 155, 101, 25);
		jpMainKvadrat.add(label_2);

		tfGoreLevoX = new JTextField();
		tfGoreLevoX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if (DialogKvadrat.this.tfGoreLevoX.getText().length() > 4) { // vise od 5 cifara
						DialogKvadrat.this.tooLargeNumberEntered(DialogKvadrat.this.tfGoreLevoX);
					}
				} else { // nije unet broj
					DialogKvadrat.this.notNumberInserted(DialogKvadrat.this.tfGoreLevoX);
				}
			}
		});
		tfGoreLevoX.setBounds(121, 11, 89, 25);
		jpMainKvadrat.add(tfGoreLevoX);
		tfGoreLevoX.setColumns(10);

		tfGoreLevoY = new JTextField();
		tfGoreLevoY.setColumns(10);
		tfGoreLevoY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if (DialogKvadrat.this.tfGoreLevoY.getText().length() > 4) { // vise od 5 cifara
						DialogKvadrat.this.tooLargeNumberEntered(DialogKvadrat.this.tfGoreLevoY);
					}
				} else { // nije unet broj
					DialogKvadrat.this.notNumberInserted(DialogKvadrat.this.tfGoreLevoY);
				}
			}
		});
		tfGoreLevoY.setBounds(121, 49, 89, 25);
		jpMainKvadrat.add(tfGoreLevoY);

		tfDuzina = new JTextField();
		tfDuzina.setColumns(10);
		tfDuzina.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if (DialogKvadrat.this.tfDuzina.getText().length() > 4) { // vise od 5 cifara
						DialogKvadrat.this.tooLargeNumberEntered(DialogKvadrat.this.tfDuzina);
					}
				} else { // nije unet broj
					DialogKvadrat.this.notNumberInserted(DialogKvadrat.this.tfDuzina);
				}
			}
		});
		tfDuzina.setBounds(121, 85, 89, 25);
		jpMainKvadrat.add(tfDuzina);

		cboxBojaIvice = new JComboBox();
		cboxBojaIvice.setModel(dcbmIvice);
		cboxBojaIvice.setBounds(121, 119, 89, 25);
		jpMainKvadrat.add(cboxBojaIvice);

		cboxBojaU = new JComboBox();
		cboxBojaU.setModel(dcbmUnutrasnjost);
		cboxBojaU.setBounds(121, 157, 89, 25);
		jpMainKvadrat.add(cboxBojaU);
		
		btnDodajKvadrat = new JButton("Dodaj Kvadrat");
		btnDodajKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(DialogKvadrat.this.checkForEmptyFields()) {
					DialogKvadrat.this.noviKvadrat = new Kvadrat(new Tacka(Integer.parseInt(DialogKvadrat.this.tfGoreLevoX.getText()), Integer.parseInt(DialogKvadrat.this.tfGoreLevoY.getText())), Integer.parseInt(DialogKvadrat.this.tfDuzina.getText()), String.valueOf(DialogKvadrat.this.cboxBojaIvice.getSelectedItem()), String.valueOf(DialogKvadrat.this.cboxBojaU.getSelectedItem()));
					System.out.println(DialogKvadrat.this.noviKvadrat);
					DialogKvadrat.this.potvrdjenoBrisanje = true;
					DialogKvadrat.this.dispose();
				}
			}
		});
		btnDodajKvadrat.setBounds(10, 191, 200, 37);
		jpMainKvadrat.add(btnDodajKvadrat);
		
		if(!dodavanje) { // nije dodavanje nego brisanje
			DialogKvadrat.this.potvrdjenoBrisanje = false;
			this.setTitle("Obrisi kvadrat");
			this.btnDodajKvadrat.setText("Obrisi");
			// postavljanje vrednosti 
			this.tfGoreLevoX.setText(String.valueOf(poslednjiKvadrat.getGoreLevo().getX()));
			this.tfGoreLevoY.setText(String.valueOf(poslednjiKvadrat.getGoreLevo().getY()));
			this.tfDuzina.setText(String.valueOf(poslednjiKvadrat.getDuzina()));
			this.cboxBojaIvice.setSelectedItem(poslednjiKvadrat.getBoja());
			this.cboxBojaU.setSelectedItem(poslednjiKvadrat.getBojaUnutrasnjosti());
			
			this.tfGoreLevoX.setEnabled(false);
			this.tfGoreLevoY.setEnabled(false);
			this.tfDuzina.setEnabled(false);
			this.cboxBojaIvice.setEnabled(false);
			this.cboxBojaU.setEnabled(false);
		}

		this.setSize(235, 278);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

	private void notNumberInserted(JTextField tf) {
		JOptionPane.showMessageDialog(DialogKvadrat.this, "Mozete uneti samo brojeve!", "Greska",
				JOptionPane.ERROR_MESSAGE);
		tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
	}

	private void tooLargeNumberEntered(JTextField tf) {
		JOptionPane.showMessageDialog(DialogKvadrat.this, "To je prevelik broj!", "Greska", JOptionPane.ERROR_MESSAGE);
		tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
	}

	private boolean checkForEmptyFields() {
		if (this.tfDuzina.getText().isEmpty() || this.tfGoreLevoX.getText().isEmpty()
				|| this.tfGoreLevoY.getText().isEmpty()) { // neki je prazan
			JOptionPane.showMessageDialog(DialogKvadrat.this, "Morate popuniti sva polja!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else { // sve popunjeno
			return true;
		}
	}
}
