package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import oblici.Kvadrat;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StackSortiraj extends JFrame{
	
	// SWING
	private JTextField tfCurrentCount;
	private JCheckBox checkBox;
	
	private DefaultListModel<Kvadrat> dfmKvadrat;
	private ArrayList<Kvadrat> listSortirani;
	
	public StackSortiraj() {
		
		this.dfmKvadrat = new DefaultListModel<Kvadrat>();
		this.listSortirani = new ArrayList<Kvadrat>();
		
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
				if(StackSortiraj.this.dfmKvadrat.isEmpty()) { // prazna
					System.out.println("Prazan");
					JOptionPane.showMessageDialog(StackSortiraj.this, "Stack je prazan, ne mozete sortirati nista!", "Greska", JOptionPane.ERROR_MESSAGE);
				} else { // nije prazna
					StackSortiraj.this.listSortirani.sort(null);
					for(int i = 0; i < StackSortiraj.this.listSortirani.size(); i++) {
						StackSortiraj.this.dfmKvadrat.set(i, StackSortiraj.this.listSortirani.get(i));
					}
					StackSortiraj.this.checkBox.setSelected(true);
				}
			}
		});
		btnSortiraj.setBounds(491, 54, 173, 32);
		panel.add(btnSortiraj);
		
		JList listMainStack = new JList(this.dfmKvadrat);
		listMainStack.setBounds(10, 12, 470, 327);
		panel.add(listMainStack);
		
		JLabel lblTrenutnoUSteku = new JLabel("Trenutno u steku:");
		lblTrenutnoUSteku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTrenutnoUSteku.setBounds(480, 97, 108, 32);
		panel.add(lblTrenutnoUSteku);
		
		tfCurrentCount = new JTextField();
		tfCurrentCount.setText("0");
		tfCurrentCount.setHorizontalAlignment(SwingConstants.CENTER);
		tfCurrentCount.setEnabled(false);
		tfCurrentCount.setColumns(10);
		tfCurrentCount.setBounds(598, 100, 66, 26);
		panel.add(tfCurrentCount);
		
		JLabel lblSortirano = new JLabel("Sortirano:");
		lblSortirano.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSortirano.setBounds(522, 133, 66, 32);
		panel.add(lblSortirano);
		
		checkBox = new JCheckBox("");
		checkBox.setEnabled(false);
		checkBox.setBounds(598, 133, 30, 32);
		panel.add(checkBox);
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(694, 393);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	
	
	public static void main(String[] args) {
		StackSortiraj stackSortiraj = new StackSortiraj();
	}
}
