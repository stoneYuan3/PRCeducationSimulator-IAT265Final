package materials;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.Tools;
import processing.core.PVector;

//class for history book(scene1)
public class HistBook extends Materials{
	public HistBook(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		// TODO Auto-generated method stub
		img=Tools.imageLoader("assets/history.png");	
	}

}
