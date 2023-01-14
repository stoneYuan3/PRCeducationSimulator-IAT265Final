package materials;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import environmentObjects.InteractiveObjects;
import master.Tools;
import processing.core.PVector;

//class for speaker(scene1,scene3)
public class Speaker extends Materials{
	public Speaker(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/speaker_state0.png");

	}

}
