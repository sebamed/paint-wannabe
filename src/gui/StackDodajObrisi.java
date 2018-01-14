package gui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JScrollPane;

import oblici.Kvadrat;

import java.awt.ScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class StackDodajObrisi extends JFrame {

	private DefaultListModel<Kvadrat> dfmKvadrat;
	private JList<Kvadrat> listStack;
	private JTextField tfCurrentCount;

	public StackDodajObrisi() {
		this.dfmKvadrat = new DefaultListModel<Kvadrat>();

		setTitle("Stek - Dodaj/Obrisi - Sebastian Dudas IT56/2016");
		setResizable(false);
		getContentPane().setLayout(null);
		this.setSize(694, 393);

		JPanel jpMain = new JPanel();
		jpMain.setBounds(0, 0, 675, 351);
		getContentPane().add(jpMain);
		jpMain.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 472, 329);
		jpMain.add(scrollPane);

		listStack = new JList<Kvadrat>(this.dfmKvadrat);
		scrollPane.setViewportView(listStack);

		JButton btnDodajNaStek = new JButton("Dodaj kvadrat na stek");
		btnDodajNaStek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogKvadrat dlgKvadrat = new DialogKvadrat(StackDodajObrisi.this, "Dodaj kvadrat", true, true, null);
				if (dlgKvadrat.noviKvadrat != null) {
					StackDodajObrisi.this.dfmKvadrat.add(0, dlgKvadrat.noviKvadrat);
					StackDodajObrisi.this.tfCurrentCount.setText(String.valueOf(StackDodajObrisi.this.dfmKvadrat.size()));
				} else {
					System.out.println("Kvadrat == null");
				}
			}
		});
		
		btnDodajNaStek.setBounds(492, 11, 173, 32);
		jpMain.add(btnDodajNaStek);

		JButton btnObrisiSaSteka = new JButton("Obrisi kvadrat sa steka");
		btnObrisiSaSteka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StackDodajObrisi.this.dfmKvadrat.isEmpty()) {
					System.out.println("Prazan");
					JOptionPane.showMessageDialog(StackDodajObrisi.this, "Stack je prazan, ne mozete obrisati nista!", "Greska", JOptionPane.ERROR_MESSAGE);
				} else {
					Kvadrat tempK = (Kvadrat) StackDodajObrisi.this.dfmKvadrat.getElementAt(0);
					DialogKvadrat dlgKvadratObrisi = new DialogKvadrat(StackDodajObrisi.this, "Obrisi kvadrat", true, false, tempK);
					if(dlgKvadratObrisi.potvrdjenoBrisanje) {						
						JOptionPane.showMessageDialog(StackDodajObrisi.this, "Kvadrat koji ce biti obrisan: \n" + tempK, "Brisanje", JOptionPane.INFORMATION_MESSAGE);
						StackDodajObrisi.this.dfmKvadrat.removeElementAt(0);
						StackDodajObrisi.this.tfCurrentCount.setText(String.valueOf(StackDodajObrisi.this.dfmKvadrat.size()));
					}
				}
			}
		});
		btnObrisiSaSteka.setBounds(492, 54, 173, 32);
		jpMain.add(btnObrisiSaSteka);
		
		JLabel lblTrenutnoUSteku = new JLabel("Trenutno u steku:");
		lblTrenutnoUSteku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrenutnoUSteku.setBounds(481, 97, 108, 32);
		jpMain.add(lblTrenutnoUSteku);
		
		tfCurrentCount = new JTextField();
		tfCurrentCount.setEnabled(false);
		tfCurrentCount.setHorizontalAlignment(SwingConstants.CENTER);
		tfCurrentCount.setText("0");
		tfCurrentCount.setBounds(599, 100, 66, 26);
		jpMain.add(tfCurrentCount);
		tfCurrentCount.setColumns(10);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		StackDodajObrisi stek = new StackDodajObrisi();
		stek.setVisible(true);
	}
}
