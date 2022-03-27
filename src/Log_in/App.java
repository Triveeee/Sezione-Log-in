package Log_in;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JButton btnNewButton;
	private PersonList personlist;
	private JPanel empty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		empty = new JPanel();
		personlist = new PersonList(PersonList.TXT_TYPE);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Log in", TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial" , Font.BOLD , 25), new Color(255, 0, 0)));
		contentPane.addMouseListener(new GestioneMouse());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nome utente");
		lblNewLabel.setBounds(95, 78, 73, 14);
		
		textField = new JTextField("Inserisci Nome Utente");
		textField.setBounds(191, 75, 151, 20);
		textField.setEnabled(false);
		textField.addMouseListener(new GestioneMouse());
		
		
		contentPane.add(textField);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(95, 121, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("ACCEDI");
	
		btnNewButton.setBounds(95, 155, 110, 26);
		btnNewButton.setBackground(Color.blue);
		btnNewButton.setForeground(Color.red);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new GestioneMouse());
		btnNewButton.addActionListener(new GestioneBottone());
		
		lblNewLabel_2 = new JLabel("nome utente non registrato");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(191, 61, 138, 14);
		lblNewLabel_2.setVisible(false);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("password non registrata");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(191, 104, 138, 14);
		lblNewLabel_3.setVisible(false);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField("Inserisci Password");
		textField_1.setBounds(191, 118, 151, 20);
		contentPane.add(textField_1);
		textField_1.addMouseListener(new GestioneMouse());
		textField_1.setEnabled(false);
	}
	
	public void SelectionBorder(JTextField x) {
		
		Border border = BorderFactory.createLineBorder(Color.black, 2 , true);
		
		textField.setBorder(null);
		if(textField.getText().equals("")) {
			textField.setText("Inserisci Nome Utente");
			textField.setEnabled(false);
		}
		
		textField_1.setBorder(null);
		if(textField_1.getText().equals("")) {
			textField_1.setText("Inserisci Password");
			textField_1.setEnabled(false);
		}
		
		if(x != null) {
			x.setBorder(border);
			x.setEnabled(true);
			
			if(x.getText().equals("Inserisci Nome Utente") || x.getText().equals("Inserisci Password" )) {
				x.setText("");
			}
		}
		
	}
	
	public class GestioneMouse extends MouseAdapter{
		
		public void mousePressed(MouseEvent arg0) {
			
			if(arg0.getSource().equals(textField)) {
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				SelectionBorder(textField);
			}
			if(arg0.getSource().equals(textField_1)) {
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				SelectionBorder(textField_1);
			}
			if(arg0.getSource().equals(contentPane)) {
				SelectionBorder(null);
			}
		}
		public void mouseEntered(MouseEvent e) {
			if(e.getSource().equals(btnNewButton)) {
				btnNewButton.setBounds(95, 155, 120, 35);
				btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black, 3, true));
			}
		}
		public void mouseExited(MouseEvent e) {
			if(e.getSource().equals(btnNewButton)) {
				btnNewButton.setBounds(95, 155, 110, 26);
				btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
			}
		}
	}
	
	public class GestioneBottone implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			boolean exit = false;
			String nome = textField.getText();
			String password = textField_1.getText();
			
			for(Persona i : personlist) {
				if(i.getNomeUtente().equals(nome) && i.getPassword().equals(password)) {
					exit = true;
					break;
				}
			}
			
			if(exit == true) {
				setContentPane(empty);
				revalidate();
			}
			else {
				lblNewLabel_2.setVisible(true);
				lblNewLabel_3.setVisible(true);
			}
			
		}
		
	}
	
	
	public class GestioneFinestra implements WindowStateListener {
		@Override
		public void windowStateChanged(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
			
			
		}

		
		
	}
}
