package buttons;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import environmentObjects.InteractiveObjects;
import master.Tools;
import materials.Materials;
import processing.core.PVector;

//class for buttons 

public class Button extends Materials{
	public Button(PVector position) {
		super(position);

	}

	@Override
	protected void imageLoadIdentify() {
		// TODO Auto-generated method stub
		if(objectState==0) {
			img=Tools.imageLoader("assets/button_state0.png");
		}
		else if(objectState==3){
			img=Tools.imageLoader("assets/button_end.png");
		}
		else{
			img=Tools.imageLoader("assets/button_advance.png");
		}
	}


}
