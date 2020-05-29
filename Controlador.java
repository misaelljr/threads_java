import javax.swing.*;


public class Controlador extends Thread{

	String first = null;
	int nRunners, len, sleep;
	JProgressBar[] pb;
	JLabel result;

	public Controlador(int n, int x, int s, JProgressBar[] jpb, JLabel jl){

		nRunners = n;
		len = x;
		sleep = s;
		pb = jpb;
		result = jl;
	}
		
	public synchronized void setFirst(String s){
		
		if (first == null )
			first = s;
	}

	public synchronized String getFirst(){
		
		return first;
	}


	public void run(){

		for (int i = 0; i < nRunners; i++){
			Runner r = new Runner(this, "Corredor " + (i+1), pb[i], sleep, len);
			r.start();
		}
		do{
			try{
				Thread.sleep(100);
			}
			catch (Exception e)
			{;}
		} while ( getFirst() == null);
		result.setText(getFirst());
	}

}