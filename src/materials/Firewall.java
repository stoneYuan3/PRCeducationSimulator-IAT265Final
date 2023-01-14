package materials;

import master.Tools;
import processing.core.PVector;

//class for firewall(scene1)
public class Firewall extends Materials {
	public Firewall(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/fireWall.png");		
	}
}
