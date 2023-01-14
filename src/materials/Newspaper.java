package materials;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.Tools;
import processing.core.PVector;

//class for newspaper(scene1)
public class Newspaper extends Materials{
	public Newspaper(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		// TODO Auto-generated method stub
		img=Tools.imageLoader("assets/newspaper.png");	
	}
	
}
