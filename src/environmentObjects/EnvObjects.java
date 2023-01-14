package environmentObjects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import processing.core.PApplet;
import processing.core.PVector;

//superclass for all objects in the environment
public abstract class EnvObjects {
	
	protected BufferedImage img;
	protected int objectState;//used to change the appearance of the object based on state
	protected PVector position;
	
	protected float xGrainStartPt;
	protected float xGrainDist;
	protected float yGrainDist;
	protected PApplet pa;
	
	public EnvObjects(PVector position) {
		this.position=position;
		imageLoadIdentify();
		
		pa = new PApplet();
		objectState=0;
	}
	
	//used to change the appearance of the object based on state
	//subclasses will load different images based on the state they are in
	protected abstract void imageLoadIdentify();
	
	public void draw(Graphics2D g2d) {
		imageLoadIdentify();
	}	
	
	//check which state the object is in
	public int checkState() {
		return objectState;
	}
	
	//reset an object's state
	public void resetState(int newState) {
		objectState=newState;
	}
	
	public PVector getPosition() {
		return position;
	}

	
}
