
public class HelloThread extends Thread{
	
	public void run() {
		System.out.println("Hello Thread");
	}
	
	public static void main(String args[]) {
		
		//CRIA OBJETO
		HelloThread ht = new HelloThread();
			
		//INICIALIZA THREAD
		ht.start();	
				
	}
}