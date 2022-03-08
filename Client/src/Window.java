//Authors: Jarrett Thrasher
//class for rendering items to window

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Window {

	//public var's
	public int width = 0;
	public int height = 0;
	public String name = "";
	public JFrame window;
	public JPanel panel;
    public KeyListener listener;
    public boolean w, a, s, d = false;
    public Player player = new Player(0,0);
	
	public Window(int wi, int he, String n) {
		this.width = wi;
		this.height = he;
		this.name = n;
		
		//new frame
		this.window = new JFrame(name);
		//set the size of the frame
		window.setSize(width, height);
		//when you click x on the window, stop the program
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//allow the window to be resized
		window.setResizable(true);
		//if you want the window to be opened relative to something on the screen
		//if null, it just opens at 0,0 on the main screen
		window.setLocationRelativeTo(null);
		//if the operating system allows for programs to forcibly be resized, set pref size
		window.setPreferredSize(new Dimension(width, height));
		//no bar at the top
		window.setUndecorated(false);
		
		//panel draw
		panel = new JPanel(false) {
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
				super.paintComponent(g);
				//this is called by the render() method
				g.setColor(new Color(255, 0, 255));
				g.fillRect(player.x, player.y, 10, 10);
				
			}
		};

        listener = new KeyListener() {
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_A) a = true;
        		if (e.getKeyCode() == KeyEvent.VK_D) d = true;
        		if (e.getKeyCode() == KeyEvent.VK_W) w = true;
        		if (e.getKeyCode() == KeyEvent.VK_S) s = true;
        	}
            public void keyReleased(KeyEvent e) {
            	if (e.getKeyCode() == KeyEvent.VK_A) a = false;
            	if (e.getKeyCode() == KeyEvent.VK_D) d = false;
            	if (e.getKeyCode() == KeyEvent.VK_W) w = false;
            	if (e.getKeyCode() == KeyEvent.VK_S) s = false;
            }
            public void keyTyped(KeyEvent e) {
                //dont know what im gonna do with this
            	//still dont k e k w
            }
        };
      
      	
      window.addKeyListener(listener);
      window.add(panel);
      window.pack();
      window.setVisible(true);
	}
	
	public void render() {
		this.panel.repaint();
	}
	
	public void update() {
		player.update(w, a, s, d);
	}
	
	
}
