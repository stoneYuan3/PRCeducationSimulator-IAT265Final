package materials;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import environmentObjects.InteractiveObjects;
import master.Tools;
import processing.core.PVector;

//DECORATIVE pattern,class for activated speaker(scene1,scene3)

public class SpeakerActivated extends SpeakerDecr{
	
	public SpeakerActivated(PVector position,InteractiveObjects speaker) {
		super(position, speaker);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/speaker_state1.png");
	}
	
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
	
		AffineTransform at = g2d.getTransform();
		g2d.translate(position.x,position.y);
		
		float angleRandom=(float) Tools.random(20,40);
		drawLine(g2d,angleRandom);
		
		g2d.setTransform(at);
	
	}
	
	//recursive
	//draw lines around the speaker, showing it is activated
	public void drawLine(Graphics2D g2d, float angle) {
		g2d.setColor(Color.BLACK);
		g2d.rotate(angle);
		int lineEndPt=(int) Tools.random(60,90);
		g2d.drawLine(0, -40, 0, -lineEndPt);
		if(angle<720) {
			angle+=angle;
			drawLine(g2d,angle);
		}
	}

}

