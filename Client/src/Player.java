
public class Player {
	
	public int x = 0;
	public int y = 0;
	public int moveSpeed = 10;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(boolean w, boolean a, boolean s, boolean d) {
		if(w) y -= moveSpeed;
		if(s) y += moveSpeed;
		if(a) x -= moveSpeed;
		if(d) x += moveSpeed;
	}
}
