package materials;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import environmentObjects.InteractiveObjects;
import processing.core.PVector;

//superclass for all interactive objects who share the same sets of draw method

public abstract class Materials extends InteractiveObjects {
	public Materials(PVector position) {
		super(position);
	}


	
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		AffineTransform at = g2d.getTransform();
		int imageWid=img.getWidth(),imgHei=img.getHeight();	
		g2d.translate(position.x,position.y);
		g2d.drawImage(img,(int)-imageWid/2,(int)-imgHei/2,imageWid,imgHei, null);	
		g2d.setTransform(at);

	}
}
