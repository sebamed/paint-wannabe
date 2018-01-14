package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import oblici.Linija;
import oblici.Tacka;

public class DialogEditLinija extends JDialog{


	public JTextField tfXPrva, tfYPrva, tfXDruga, tfYDruga;
	public JButton btnBoja;
	private boolean sacuvano = false;

	public DialogEditLinija(JFrame parent, String title, boolean modal, Linija tempTacka) {
		super(parent, title, modal);

		JPanel jpMain = new JPanel();
		jpMain.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(jpMain, BorderLayout.NORTH);
		GridBagLayout gbl_jpMain = new GridBagLayout();
		jpMain.setLayout(gbl_jpMain);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblXPrva = new JLabel("Prva tacka X:");
		jpMain.add(lblXPrva, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		tfXPrva = new JTextField(10);
		tfXPrva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if(tfXPrva.getText().length() > 4) {
						tooLargeNumberEntered(tfXPrva);
					}
				} else { // nije unet broj
					if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER) { // pritisnut backspace
						return;
					}
					notNumberInserted(tfXPrva);
				}
			}
		});
		jpMain.add(tfXPrva, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblYPrva = new JLabel("Prva tacka Y:");
		jpMain.add(lblYPrva, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		tfYPrva = new JTextField(10);
		tfYPrva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if(tfYPrva.getText().length() > 4) {
						tooLargeNumberEntered(tfYPrva);
					}
				} else { // nije unet broj
					if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER) { // pritisnut backspace
						return;
					}
					notNumberInserted(tfYPrva);
				}
			}
		});
		jpMain.add(tfYPrva, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblXDruga = new JLabel("Druga tacka X:");
		jpMain.add(lblXDruga, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		tfXDruga = new JTextField(10);
		tfXDruga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if(tfXDruga.getText().length() > 4) {
						tooLargeNumberEntered(tfXDruga);
					}
				} else { // nije unet broj
					if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER) { // pritisnut backspace
						return;
					}
					notNumberInserted(tfXDruga);
				}
			}
		});
		jpMain.add(tfXDruga, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		JLabel lblYDruga = new JLabel("Druga tacka Y:");
		jpMain.add(lblYDruga, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		tfYDruga = new JTextField(10);
		tfYDruga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if(tfYDruga.getText().length() > 4) {
						tooLargeNumberEntered(tfYDruga);
					}
				} else { // nije unet broj
					if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER) { // pritisnut backspace
						return;
					}
					notNumberInserted(tfYDruga);
				}
			}
		});
		jpMain.add(tfYDruga, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		JLabel lblBoja = new JLabel("Boja:");
		jpMain.add(lblBoja, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 4;
		btnBoja = new JButton(" ");
		jpMain.add(btnBoja, gbc);
		btnBoja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				DialogEditLinija.this.boja(btnBoja);
			}
		});

		JButton btnPotvrdi = new JButton("Sacuvaj");
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 5;
		jpMain.add(btnPotvrdi, gbc);

		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				DialogEditLinija.this.sacuvano = true;
				dispose();
			}
		});

		this.insertInfo(tempTacka);

		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	private void insertInfo(Linija temp) {
		this.tfXPrva.setText(String.valueOf(temp.getPocetna().getX()));
		this.tfYPrva.setText(String.valueOf(temp.getPocetna().getY()));
		this.tfXDruga.setText(String.valueOf(temp.getKrajnja().getX()));
		this.tfYDruga.setText(String.valueOf(temp.getKrajnja().getY()));
		this.btnBoja.setBackground(temp.getColor());
	}

	private void boja(JButton btnBoja) {
		JColorChooser jccUnutrasnjost = new JColorChooser();
		Color colorUnutrasnjost = jccUnutrasnjost.showDialog(null, "Izaberite boju", btnBoja.getBackground());

		if (colorUnutrasnjost != null)
			btnBoja.setBackground(colorUnutrasnjost);

	}

	public boolean getSacuvano() {
		return this.sacuvano;
	}
	
	private void notNumberInserted(JTextField tf) {
		JOptionPane.showMessageDialog(this, "Mozete uneti samo brojeve!", "Greska",
				JOptionPane.ERROR_MESSAGE);
		tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
	}

	private void tooLargeNumberEntered(JTextField tf) {
		JOptionPane.showMessageDialog(this, "To je prevelik broj!", "Greska", JOptionPane.ERROR_MESSAGE);
		tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
	}

	
}
