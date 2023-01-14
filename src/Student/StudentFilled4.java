package Student;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import environmentObjects.InteractiveObjects;
import master.Tools;
import processing.core.PApplet;
import processing.core.PVector;

public class StudentFilled4 extends StudentDecr{
	
	public StudentFilled4(PVector position,InteractiveObjects student) {
		super(position, student);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/student_state3.png");
	}
	
	public void draw(Graphics2D g2d) {
		super.draw(g2d);

		drawEyes(g2d,100,240,510);
		drawEyes(g2d,100,540,510);
	}
	
	//draw student's eyes, shows dizziness
	//referenced week13-lec-demo-3-fractal
	public void drawEyes(Graphics2D g2d, int eyeSize, int x,int y) {
		AffineTransform at = g2d.getTransform();
		g2d.translate(x,y);
		g2d.setColor(new Color(237,215,186));
		g2d.fillOval(-eyeSize/2, -eyeSize/2, eyeSize, eyeSize);
		g2d.setColor(Color.BLACK);
		g2d.drawOval(-eyeSize/2, -eyeSize/2, eyeSize, eyeSize);
		g2d.setTransform(at);
		
		if(eyeSize>40) {
			drawEyes(g2d,(int) (eyeSize/1.2),x,y);
		}
		if(eyeSize>20) {
			drawEyes(g2d,(int) (eyeSize/2),x,y);
		}
	}

}

