package environmentObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import master.AppInterface;
import master.Tools;
import processing.core.PVector;

//class displaying smock for deployed firewall in scene 1
public class Smock extends EnvObjects{

	public Smock(PVector position) {
		super(position);
		xGrainStartPt = Tools.random(10);
		xGrainDist = xGrainStartPt;
		yGrainDist = Tools.random(10);
	}

	@Override
	protected void imageLoadIdentify() {
		// TODO Auto-generated method stub
		
	}
	
	//referenced week13-lec-demo2-perlin-noise) 
	//move this into a new class and call it in the main panel
	public void draw(Graphics2D g2) {
		float grainPropFactor;
		AffineTransform at = g2.getTransform();
		g2.translate(position.x, position.y);

		for(int i=0;i<=30;i+=4) {
			yGrainDist += 0.1;//modify y and xnoise to make grains more seperated
			xGrainDist = xGrainStartPt;
			for(int j=0;j<=120;j+=4) {
				xGrainDist+= 0.1;
				grainPropFactor = pa.noise(xGrainDist,yGrainDist);

				AffineTransform af=g2.getTransform();
				g2.translate(i, j);
				
				g2.rotate(grainPropFactor*Tools.radians(720));
				float grainSize=grainPropFactor*30;
				
				int opacity=(int) Tools.random(0,100);
				g2.setColor(new Color(0,0,0,opacity));

				g2.fill(new Ellipse2D.Float(-grainSize/2, -grainSize/4, grainSize/2, grainSize/2));
				g2.setTransform(af);
			}

		}
		g2.setTransform(at);
	}
}
