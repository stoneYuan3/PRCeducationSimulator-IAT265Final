package materials;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.Tools;
import processing.core.PVector;

//class for poster(scene1)
public class Poster extends Materials{
	public Poster(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		// TODO Auto-generated method stub
		img=Tools.imageLoader("assets/poster.png");	
	}
	
}
