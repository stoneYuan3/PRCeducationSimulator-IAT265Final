package Student;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.AppInterface;
import master.MasterApp;
import master.Tools;
import materials.Materials;
import processing.core.PVector;

//class for student(all scenes)
public class Student extends Materials{
	
	public Student(PVector position) {
		super(position);
	}
	
	protected void imageLoadIdentify() {
		if(objectState==0) {
			img=Tools.imageLoader("assets/student_state0.png");
		}
		if(objectState==1) {
			img=Tools.imageLoader("assets/student_state1.png");
		}
		if(objectState==2) {
			img=Tools.imageLoader("assets/student_state4.png");
		}
		if(objectState==3) {
			img=Tools.imageLoader("assets/student_state5.png");
		}
		if(objectState==4) {
			img=Tools.imageLoader("assets/student_state6.png");
		}

	}

	


}
