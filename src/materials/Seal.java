package materials;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.Tools;
import processing.core.PVector;

//class for seal(scene1)
public class Seal extends Materials{
	
	public Seal(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/seal.png");		
	}

}
