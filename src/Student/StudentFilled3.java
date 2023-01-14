package Student;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import environmentObjects.InteractiveObjects;
import master.Tools;
import processing.core.PVector;

public class StudentFilled3 extends StudentDecr{
	
	public StudentFilled3(PVector position,InteractiveObjects student) {
		super(position, student);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/student_state2_3.png");
	}


}

