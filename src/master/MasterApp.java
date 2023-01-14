package master;

import javax.swing.JFrame;
import java.awt.Dimension;


//class that spawns the panel

public class MasterApp extends JFrame{
	
	public static final int SCREEN_WIDTH=1000;
	public static final int SCREEN_HEIGHT=600;	
	
	
	public MasterApp(String title) {
		super(title);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		
		AppInterface interfaceSpawn=new AppInterface(this.getSize());
		this.add(interfaceSpawn);
		
		this.setVisible(true);
	}
	
	public static void main (String[] args){
		new MasterApp("Chinese Dream Realizer");
		
	}
}
