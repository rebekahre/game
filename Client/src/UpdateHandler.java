


public class UpdateHandler extends Thread{
	
	public int sleep = 0;
	private Window window;
	
	public UpdateHandler(int s, Window w) {
		this.sleep = s;
		this.window = w;
		run();
	}
	
	public void run() {

		//Delta Variable handling
		
   		double timePerTick = 1000000000 / sleep;
   		double delta = 0;
   		long now;
   		long lastTime = System.nanoTime();
		while(true) {
	   		
	   		//delta handling
	  	   	now = System.nanoTime();
	  	   	delta += (now - lastTime) / timePerTick;
	  	   	lastTime = now;
	  	   	if(delta >= 1) {
	  	   		window.update();
	  	   		window.render();
	  	   		delta--;
	  	   	}
	  	   	try{Thread.sleep(1);}catch (Exception e) {e.printStackTrace();}
		}
	}
}
