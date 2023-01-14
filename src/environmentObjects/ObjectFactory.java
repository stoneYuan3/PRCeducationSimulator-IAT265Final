package environmentObjects;

import java.awt.Color;
import java.awt.Dimension;

import Student.Student;
import buttons.Button;
import materials.Firewall;
import materials.HistBook;
import materials.Homework;
import materials.Newspaper;
import materials.Poster;
import materials.Seal;
import materials.Sign;
import materials.Speaker;
import processing.core.PVector;

//factory used to create objects

public class ObjectFactory {
	
	Dimension screenSize;
	public ObjectFactory(Dimension screenSize) {
		this.screenSize=screenSize;
	}
	
	//method used to create non-interactive objs
	public EnvObjects constructEnvObjs(String objName) {
		EnvObjects obj=null;
		if(objName=="bg") {
			obj=new Background(new PVector(0,0));
		}
		else if(objName=="info") {
			obj=new Info(new PVector(screenSize.width-30,10));

		}	
		else if(objName=="smock") {
			obj=new Smock(new PVector(screenSize.width/3-87,screenSize.height/8+35));
		}		
		return obj;
	}
	
	//method used to create interactive objs
	public InteractiveObjects constructIntaObjs(String objName) {
		InteractiveObjects obj=null;
		
		if(objName=="button") {
			obj=new Button(new PVector(790,365));
		}
		else if(objName=="speaker") {
			obj=new Speaker(new PVector(screenSize.width/8,screenSize.height/4));
		}	
		else if(objName=="seal") {
			obj=new Seal(new PVector(screenSize.width/2+225,screenSize.height/3+60));
		}
		else if(objName=="histbook") {
			obj=new HistBook(new PVector(screenSize.width/2+300,screenSize.height/3+60));
		}	
		else if(objName=="newspaper") {
			obj=new Newspaper(new PVector(screenSize.width/2+375,screenSize.height/3+60));
		}	
		else if(objName=="poster") {
			obj=new Poster(new PVector(screenSize.width/2+450,screenSize.height/3+60));
		}
		else if(objName=="firewall") {
			obj=new Firewall(new PVector(screenSize.width/2+275,screenSize.height/3+110));
		}	
		else if(objName=="sign") {
			obj=new Sign(new PVector(screenSize.width/2-150,screenSize.height-94));
		}
		else if(objName=="homework") {
			obj=new Homework(new PVector(770,screenSize.height/2-30));
		}	
		
		else if(objName=="student") {
			obj=new Student(new PVector(400,screenSize.height/2+20));
		}	
		
		return obj;
	}
	
//	public Shape createShape(String type) {
//		Shape shape = null;
//	
//		if (type == "circle")
//			shape = new Circle(PAN_W / 2, PAN_H / 2, 10, new Color(0, 250, 250, 150));
//		else if (type == "square")
//			shape = new Square(PAN_W / 2, PAN_H / 2, 10, 10, new Color(250, 150, 0));
//		
//		return shape;
//	}
	
}
