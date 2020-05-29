
public class HelloThread2 extends Thread{
	
	private int id;
	
	public HelloThread2(int num) {
		id = num;
	}
	
	public void run() {
		System.out.println("Hello Thread " + id);
	}
	
	public static void main(String args[]) {
		
		for (int i = 0; i < 100; i++) {
			
			//CRIA OBJETO
			HelloThread2 ht = new HelloThread2(i);
			
			//INICIALIZA THREAD
			ht.start();	
		}
		
		System.out.println("Fim da thread principal");		
	}
}