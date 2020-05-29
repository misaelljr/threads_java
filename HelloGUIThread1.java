import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HelloGUIThread1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton buttonOK;	
	JTextField nome;
	String WELLCOME = "Bem vindo";
	JLabel label;

	public HelloGUIThread1() {

		super("HelloGUI");

		JPanel jp = (JPanel) this.getContentPane(); 
		label = new JLabel("Hello interface");
		jp.setLayout(new GridLayout(3,1));
		label = new JLabel(WELLCOME);
		nome = new JTextField();
		buttonOK = new JButton("Confirma"); jp.add(label);
		jp.add(nome);
		jp.add(buttonOK);
		
		buttonOK.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		int k = 0;
		String s = nome.getText(); 
		
		try {	
			k = Integer.parseInt(s);
			for (int i = 0; i <= k; i++) {
				s = WELLCOME + " " + i; 
				label.setText(s);
			}
			
			
		} catch (Exception e) {
			label.setText(WELLCOME + " " + s);
		}
	}

	public static void main(String[] args) {

		HelloGUIThread1 frame = new HelloGUIThread1(); 

		frame.setSize(400, 200); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
	}
}