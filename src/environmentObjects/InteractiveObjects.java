package environmentObjects;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import processing.core.PVector;

//superclass for all interactive objects
public abstract class InteractiveObjects extends EnvObjects {
	public InteractiveObjects(PVector position) {
		super(position);
	}
	
	//check if clicked
	public boolean checkMouseClick(MouseEvent e) {
		boolean mouseClick=false;
		try {
			
		if(img!=null) {
			//referenced w10 lab basecode
			if(e.getX()>(position.x-(img.getWidth())/2)&&e.getX()<(position.x+(img.getWidth())/2)&&e.getY()>(position.y-(img.getHeight())/2)&&e.getY()<(position.y+(img.getHeight())/2)) {		
				
				mouseClick=true;
			}
		}	
		
		}
		catch(NullPointerException error) {		
			System.out.println("variable empty/undefined");
		}
		
		return mouseClick;
	}
	
	//check if two object collides
	public boolean checkCollision(InteractiveObjects obj) {
		boolean collide=false;
		try {
		//referenced w10 lab basecode
		if (Math.abs(position.x-obj.getPosition().x)<100 && Math.abs(position.y-obj.getPosition().y) < 100) {
			collide=true;
		}
		}
		catch(NullPointerException error) {
			System.out.println("variable empty/undefined");
		}
		return collide;

	}

	public void setPosition(PVector newPosition) {
		position=newPosition;
	}
	public int getImgWidth() {
		return img.getWidth();
	}
	public int getImgHeight() {
		return img.getHeight();
	}
	public int getState() {
		return objectState;
	}

}
