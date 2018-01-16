package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import oblici.Kvadrat;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class StackSortiraj extends JFrame {

	// SWING
	private JTextField tfCurrentCount;
	private JCheckBox checkBox;
	public JComboBox<String> cboxVrstaSortiranja;

	// modeli
	private DefaultListModel<Kvadrat> dfmKvadrat;
	private ArrayList<Kvadrat> listSortirani;
	private DefaultComboBoxModel<String> cboxmVrste;

	public StackSortiraj() {
		setTitle("Sortiranje - Sebastian Dudas IT57/16");

		this.dfmKvadrat = new DefaultListModel<Kvadrat>();
		this.listSortirani = new ArrayList<Kvadrat>();
		this.cboxmVrste = new DefaultComboBoxModel<String>(new String[] { "Manji ka vecim", "Veci ka manjim" });

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnDodaj = new JButton("Dodaj kvadrat na stek");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogKvadrat dlgKvadrat = new DialogKvadrat(StackSortiraj.this, "Dodaj kvadrat", true, true, null);
				if (dlgKvadrat.noviKvadrat != null) {
					StackSortiraj.this.dfmKvadrat.add(0, dlgKvadrat.noviKvadrat);
					StackSortiraj.this.tfCurrentCount.setText(String.valueOf(StackSortiraj.this.dfmKvadrat.size()));
					StackSortiraj.this.listSortirani.add(dlgKvadrat.noviKvadrat);
					StackSortiraj.this.checkBox.setSelected(false);
				} else {
					System.out.println("Kvadrat == null");
				}
			}
		});
		btnDodaj.setBounds(491, 11, 173, 32);
		panel.add(btnDodaj);

		JButton btnSortiraj = new JButton("Sortiraj po velicini");
		btnSortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (StackSortiraj.this.dfmKvadrat.isEmpty()) { // prazna
					System.out.println("Prazan");
					JOptionPane.showMessageDialog(StackSortiraj.this, "Stack je prazan, ne mozete sortirati nista!",
							"Greska", JOptionPane.ERROR_MESSAGE);
				} else if (StackSortiraj.this.dfmKvadrat.size() == 1) {
					System.out.println("Samo jedan");
					JOptionPane.showMessageDialog(StackSortiraj.this,
							"Stack sadrzi samo jedan kvadrat, ne mozete sortirati jedan kvadrat!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				} else { // nije prazna
					int vrstaSortiranja = StackSortiraj.this.cboxVrstaSortiranja.getSelectedIndex(); // 0 - manji ka vecim, 1 - veci ka manjim																									// vecim, 1 -																										// veci ka																										// manjim
					StackSortiraj.this.listSortirani.sort(null);
					if (vrstaSortiranja == 1) { // veci ka manjim
						Collections.reverse(StackSortiraj.this.listSortirani.subList(0, StackSortiraj.this.listSortirani.size()));
						for (int i = 0; i < StackSortiraj.this.listSortirani.size(); i++) {
							StackSortiraj.this.dfmKvadrat.set(i, StackSortiraj.this.listSortirani.get(i));
						}
					} else {
						for (int i = 0; i < StackSortiraj.this.listSortirani.size(); i++) {
							StackSortiraj.this.dfmKvadrat.set(i, StackSortiraj.this.listSortirani.get(i));
						}
					}
					StackSortiraj.this.checkBox.setSelected(true);
				}
			}
		});
		btnSortiraj.setBounds(491, 54, 173, 32);
		panel.add(btnSortiraj);

		JList<Kvadrat> listMainStack = new JList<Kvadrat>(this.dfmKvadrat);
		listMainStack.setBounds(10, 12, 470, 327);
		panel.add(listMainStack);

		JLabel lblTrenutnoUSteku = new JLabel("U steku:");
		lblTrenutnoUSteku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrenutnoUSteku.setBounds(484, 134, 108, 32);
		panel.add(lblTrenutnoUSteku);

		tfCurrentCount = new JTextField();
		tfCurrentCount.setText("0");
		tfCurrentCount.setHorizontalAlignment(SwingConstants.CENTER);
		tfCurrentCount.setEnabled(false);
		tfCurrentCount.setColumns(10);
		tfCurrentCount.setBounds(602, 137, 66, 26);
		panel.add(tfCurrentCount);

		JLabel lblSortirano = new JLabel("Sortirano:");
		lblSortirano.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortirano.setBounds(526, 170, 66, 32);
		panel.add(lblSortirano);

		checkBox = new JCheckBox("");
		checkBox.setEnabled(false);
		checkBox.setBounds(602, 170, 30, 32);
		panel.add(checkBox);

		cboxVrstaSortiranja = new JComboBox<String>(this.cboxmVrste);
		cboxVrstaSortiranja.setBounds(491, 97, 173, 29);
		panel.add(cboxVrstaSortiranja);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(694, 393);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		StackSortiraj stackSortiraj = new StackSortiraj();
	}
}
