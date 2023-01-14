package master;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//utility class
//referenced lecture demos

public class Tools {
	
	//referenced week11-lab-basecode
	public static BufferedImage imageLoader(String filePath) {
		BufferedImage image=null;
		try {
			image=ImageIO.read(new File(filePath));
		}
		catch(IOException error) {
			System.out.println("Image file not found/corrupted");
		}	
		catch(NullPointerException error) {
			System.out.println("Image variable empty");
		}
		return image;
	}
	
	//referenced week13-lec-demo2-perlin-noise 
	public static double random(double x,double y) {
		double returnedNum;
		returnedNum=x+Math.random()*(y-x);
		return returnedNum;
	}
	public static float random(float number) {
		return (float) Math.random() * number;
	}
	public static double radians(double angle){
		return angle/180*Math.PI;		
	}

}
