package materials;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.Tools;
import processing.core.PVector;

//class for homework(scene3)
public class Homework extends Materials{
	public Homework(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		// TODO Auto-generated method stub
		img=Tools.imageLoader("assets/homework.png");	
	}
	
}
