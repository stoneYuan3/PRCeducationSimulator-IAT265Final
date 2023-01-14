package materials;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.Tools;
import processing.core.PVector;

//class for sign(scene2)
public class Sign extends Materials{
	
	public Sign(PVector position) {
		super(position);
		
	}

	@Override
	protected void imageLoadIdentify() {
		if(objectState==0) {
			img=Tools.imageLoader("assets/sign_state0.png");		
		}
		else if(objectState==1) {
			img=Tools.imageLoader("assets/sign_state1.png");		
		}
	}

}
