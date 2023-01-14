package materials;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import environmentObjects.InteractiveObjects;
import processing.core.PVector;

//DECORATIVE pattern,class for speaker's decr(scene1,scene3)
public abstract class SpeakerDecr extends Materials{
	InteractiveObjects speaker;
	
	protected int x,y;
	protected double scale;
	
	public SpeakerDecr(PVector position,InteractiveObjects speaker) {
		super(position);
		this.speaker=speaker;

	}

	public void draw(Graphics2D g2d) {

		speaker.draw(g2d);
		
		super.draw(g2d);

	}
	

}
