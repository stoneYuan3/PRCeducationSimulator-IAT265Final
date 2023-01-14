package environmentObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import master.MasterApp;
import master.Tools;
import processing.core.PApplet;
import processing.core.PVector;

//class for background image
public class Background extends EnvObjects{

	public Background(PVector position){
		super(position);
		objectState=-1;
		
		xGrainStartPt = Tools.random(10);
		xGrainDist = 20;
		yGrainDist = 20;
		
		
	}
	
	protected void imageLoadIdentify() {
		if(objectState==-1) {
			img=Tools.imageLoader("assets/background_state0.png");

		}
		
		//scene 1
		if(objectState>=0 && objectState<=2) {
			img=Tools.imageLoader("assets/background_state1.png");
		}
		//scene 2
		if(objectState==3) {
			img=Tools.imageLoader("assets/background_state2.png");
		}
		//scene 3
		if(objectState==4) {
			img=Tools.imageLoader("assets/background_state3.png");
		}
		//scene END
		if(objectState==-2) {
			img=Tools.imageLoader("assets/background_end.png");
		}
	}
	
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		
		AffineTransform at = g2d.getTransform();
		g2d.drawImage(img,(int)position.x,(int)position.y,MasterApp.SCREEN_WIDTH, MasterApp.SCREEN_HEIGHT, null);			
		g2d.setTransform(at);
		
		if(objectState>=0&&objectState<=2||objectState==4) {
			drawFly(g2d);
		}


	}
	
	//draws the fly animation for the garbage can
	//referenced week13-lec-demo2-perlin-noise) 
	private void drawFly(Graphics2D g2) {
		float grainPropFactor;
		AffineTransform at = g2.getTransform();
		g2.translate(590,340);

		for(int i=0;i<=50;i+=7) {
			yGrainDist+=5;
			for(int j=0;j<=50;j+=7) {
				
				xGrainDist+=5;
				grainPropFactor = pa.noise(xGrainDist,yGrainDist);

				AffineTransform at1 = g2.getTransform();
				g2.translate(i, j);
				g2.rotate(grainPropFactor*Tools.radians(720));
				
				float grainSize=grainPropFactor*28;

	
				int opacity=(int) Tools.random(50,100);
				g2.setColor(new Color(0,0,0,opacity));
				g2.fill(new Ellipse2D.Float(-grainSize/2, -grainSize/2, grainSize/6, grainSize/6));
				g2.setTransform(at1);
			}

		}
		g2.setTransform(at);
	}
	
}
