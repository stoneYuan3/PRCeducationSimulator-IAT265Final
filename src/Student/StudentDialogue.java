package Student;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import environmentObjects.InteractiveObjects;
import master.Tools;
import processing.core.PApplet;
import processing.core.PVector;

//class for student dialogues(scene 2), dialogue1,1b,2,2b all serve the same purpose
public abstract class StudentDialogue extends StudentDecr{

	public StudentDialogue(PVector position,InteractiveObjects student) {
		super(position, student);
	}
	
	public void draw(Graphics2D g2d) {
		super.drawStudentOnly(g2d);
//		student.draw(g2d);
		drawDialogue(g2d);	
	}
	
	public void drawDialogue(Graphics2D g2d) {
		AffineTransform at = g2d.getTransform();
		int imageWid=img.getWidth(),imgHei=img.getHeight();
		g2d.translate(position.x,position.y);
		//position is different from other objects
		g2d.drawImage(img,(int)-imageWid/2,(int)-imgHei/2-248,imageWid,imgHei, null);		
		g2d.setTransform(at);
	}

}

