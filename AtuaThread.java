import javax.swing.JLabel;

public class AtuaThread extends Thread{
	
	private JLabel jl;
	private int n;
	String WELLCOME = "Bem vindo";
	
	public AtuaThread(JLabel label, int k) {
		jl = label;
		n = k;	
	}
	
	public void run() {
		String s;
		
		for (int i = 0; i <= n; i++) {
			s = WELLCOME + " " + i; 
			jl.setText(s);
		}
	}
}
