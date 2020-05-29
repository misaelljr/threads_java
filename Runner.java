import javax.swing.*;

public class Runner extends Thread
{
	String name;
	Controlador ct;
	int len, sleep;
	JProgressBar pb;
	static final int FIM_CONT = 200;
	static final int SLEEP_TIME = 50;

	public Runner(Controlador c, String n, JProgressBar jpb,
			int sl, int x)
	{
		ct = c;
		name = n;
		len = x;
		sleep = sl;
		pb = jpb;
	}


	public Runner(Controlador c, String n, JProgressBar jpb)
	{
		this(c, n, jpb, SLEEP_TIME, FIM_CONT);
	}

	public void run(){
		
		for (int i = 0; i < len; i++){
			try{
				Thread.sleep(sleep);
			}
			catch (Exception e){
				;
			}
			if ( ct.getFirst() != null )break;
			pb.setValue(i+1);
		}
		ct.setFirst(name);
	}
	
}