package Student;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import environmentObjects.InteractiveObjects;
import materials.Materials;
import processing.core.PVector;

//DECORATIVE pattern,class for student's decr(all scenes)
public abstract class StudentDecr extends Materials{
	InteractiveObjects student;
	
	protected int x,y;
	protected double scale;
	
	public StudentDecr(PVector position,InteractiveObjects student) {
		super(position);
		this.student=student;
	}

	//for classes that adds on the original student pic(like dialogue)
	public void draw(Graphics2D g2d) {
		student.draw(g2d);		
		super.draw(g2d);
	}
	
	//for classes that replaces the original student pic
	public void drawStudentOnly(Graphics2D g2d) {
		student.draw(g2d);
	}
}
