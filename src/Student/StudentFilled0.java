package Student;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import environmentObjects.InteractiveObjects;
import master.Tools;
import processing.core.PVector;

//class displaying filled student brain in scene 1
//studentFilled1,2,3,4 all serves the same purpose but loads different images
public class StudentFilled0 extends StudentDecr{
	
	public StudentFilled0(PVector position,InteractiveObjects student) {
		super(position, student);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/student_state2.png");
	}


}

