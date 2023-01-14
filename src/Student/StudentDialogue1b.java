package Student;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import environmentObjects.InteractiveObjects;
import master.Tools;
import processing.core.PApplet;
import processing.core.PVector;

public class StudentDialogue1b extends StudentDialogue{


	public StudentDialogue1b(PVector position,InteractiveObjects student) {
		super(position, student);

	}

	@Override
	protected void imageLoadIdentify() {

		img=Tools.imageLoader("assets/student_dialogue_1b.png");

	}

	


}

