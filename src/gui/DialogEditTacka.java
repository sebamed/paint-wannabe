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

import oblici.Tacka;

public class DialogEditTacka extends JDialog {

	public JTextField tfX;
	public JTextField tfY;
	public JButton btnBoja;
	private boolean sacuvano = false;

	public DialogEditTacka(JFrame parent, String title, boolean modal, Tacka tempTacka) {
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
		JLabel lblX = new JLabel("X:");
		jpMain.add(lblX, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		tfX = new JTextField(10);
		tfX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if(tfX.getText().length() > 4) {
						DialogEditTacka.this.tooLargeNumberEntered(tfX);
					}
				} else { // nije unet broj
					if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER) { // pritisnut backspace
						return;
					}
					DialogEditTacka.this.notNumberInserted(tfX);
				}
			}
		});
		jpMain.add(tfX, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblY = new JLabel("Y:");
		jpMain.add(lblY, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		tfY = new JTextField(10);
		tfY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if (Character.isDigit(ke.getKeyChar())) { // unet je broj
					if(tfY.getText().length() > 4) {
						DialogEditTacka.this.tooLargeNumberEntered(tfY);
					}
				} else { // nije unet broj
					if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER) { // pritisnut backspace
						return;
					}
					DialogEditTacka.this.notNumberInserted(tfY);
				}
			}
		});
		jpMain.add(tfY, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblBoja = new JLabel("Boja:");
		jpMain.add(lblBoja, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 2;
		btnBoja = new JButton(" ");
		jpMain.add(btnBoja, gbc);
		btnBoja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				DialogEditTacka.this.boja(btnBoja);
			}
		});

		JButton btnPotvrdi = new JButton("Sacuvaj");
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 3;
		jpMain.add(btnPotvrdi, gbc);

		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				DialogEditTacka.this.sacuvano = true;
				dispose();
			}
		});

		this.insertInfo(tempTacka);

		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	private void insertInfo(Tacka temp) {
		this.tfX.setText(String.valueOf(temp.getX()));
		this.tfY.setText(String.valueOf(temp.getX()));
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
