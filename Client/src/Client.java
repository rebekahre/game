
public class Client {

	public static void main(String[] args) {
		
		//new window
		Window window = new Window(800, 500, "Game");
		UpdateHandler uh = new UpdateHandler(60, window);
	}
}
