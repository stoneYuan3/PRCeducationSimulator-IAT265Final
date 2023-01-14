package environmentObjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import master.MasterApp;
import master.Tools;
import processing.core.PVector;

//info panel displaying guides
public class Info extends EnvObjects{
	public Info(PVector position) {
		super(position);
	}

	@Override
	protected void imageLoadIdentify() {
		img=Tools.imageLoader("assets/infoPanel.png");
	}
	
	public void draw(Graphics2D g2d) {
		AffineTransform at = g2d.getTransform();		
		g2d.translate(position.x,position.y);
		
//		g2d.setColor(new Color(255,255,255));
//		g2d.fillRect(0,0,MasterApp.SCREEN_WIDTH/4,MasterApp.SCREEN_HEIGHT/3);
		
		int imageWid=img.getWidth(),imgHei=img.getHeight();
//		g2d.drawImage(img,(int)-imageWid/2,(int)-imgHei/2,imageWid,imgHei, null);	
		g2d.drawImage(img,-imageWid,0,imageWid,imgHei, null);	

	    Font font=new Font("Hevetica",Font.PLAIN,11);
	    g2d.setFont(font);
	    setInstruction();
	    

		g2d.setColor(Color.BLACK);
		int stringStartPos=60;
		g2d.drawString(bgInfo,-imageWid+25,stringStartPos);
		g2d.drawString(bgInfo2,-imageWid+25,stringStartPos+15);
		g2d.drawString(bgInfo3,-imageWid+25,stringStartPos+30);
		g2d.setColor(Color.RED);
		g2d.drawString(ins,-imageWid+25,115);
		g2d.drawString(ins2,-imageWid+25,130);
		g2d.drawString(ins3,-imageWid+25,145);
		
		g2d.setTransform(at);
	}
	
	private String bgInfo,bgInfo2,bgInfo3,ins,ins2,ins3;
	//spawning instructions
	private void setInstruction() {
	
		if(objectState==0) {
			bgInfo="It's a new day,";
			bgInfo2="time to study for the motherland!";
			bgInfo3=" ";
			ins="click the speaker to";
			ins2="start the class";
			ins3="";
		}
		else if(objectState==1) {
			bgInfo="Now let's bring the student";
			bgInfo2="to attention";
			bgInfo3=" ";
			ins="click the student";
			ins2="";
			ins3="";
		}
		else if(objectState==2) {
			bgInfo="Firstable they shouldn't be";
			bgInfo2="thinking too much.It makes them";
			bgInfo3="prone to western capitalist lures";
			ins="put the seal in to seal thir brain";
			ins2="(you can find it on the grey";
			ins3="cabinet at the right)";
		}
		else if(objectState==3) {
			bgInfo="Then let's fill some history books";
			bgInfo2="in, of course they are written";
			bgInfo3="in a revolutionary perceptive";
			ins="put the red book in";
			ins2="";
			ins3="";
		}
		else if(objectState==4) {
			bgInfo="Time to read some news, corrected";
			bgInfo2="news reflecting the corruptness";
			bgInfo3="of the west would be perfect";
			
			ins="put the newspaper in";
			ins2="";
			ins3="";
			
		}
		else if(objectState==5) {
			bgInfo="Having some propagandas reflec-";
			bgInfo2="-ting the greatness of our party";
			bgInfo3="would be extra helpful";
			
			ins="put the propaganda poster in";
			ins2="(the red paper at far right)";
			ins3="";
		}
		else if(objectState==6) {
			bgInfo="Now don't forget to seal all";
			bgInfo2="of them with our Great Firewall";
			bgInfo3="we don't want any western pollutants in";
			
			ins="put the firewall in";
			ins2="";
			ins3="";
		}
		else if(objectState==7) {
			bgInfo="Good! now let it ferment for a while...";
			bgInfo2="";
			bgInfo3="";
			
			ins="wait for it...";
			ins2="";
			ins3="";
		}
		
		//state2
		else if(objectState==8) {
			bgInfo="Great leader said there is only";
			bgInfo2="one party,one nation,one... and so on";
			bgInfo3="now it's time to practice it.";
			
			ins="check what language they are";
			ins2="speaking by clicking the students";
			ins3="";
		}
		else if(objectState==9) {
			bgInfo="No, they are speaking their local";
			bgInfo2="language, one nation, remember?";
			bgInfo3="that can't be allowed";
			
			ins="put the \"Mandarin Only\" board on ";
			ins2="(click that white board at the";
			ins3="bottom, it has red texts on it. )";
		}
		else if(objectState==10) {
			bgInfo="Good! that should do it";
			bgInfo2="You may check if they are speaking";
			bgInfo3="the right language but it's up to you.";
			
			ins="check the students by clicking them";
			ins2="it's optional";
			ins3="";
		}
		else if(objectState==11) {
			bgInfo="It's dusk now, class is over.";
			bgInfo2="BUT that is not the end, we cant";
			bgInfo3="let these kids have too much free time";
			
			ins="Assign the student tons of homework";
			ins2="by clicking on the homework at";
			ins3="the cabinet";
		}
		else if(objectState==12) {
			bgInfo="Good!Now since they are very ";
			bgInfo2="occuplied they wont have time";
			bgInfo3="to doubt things they learnt!";
			
			ins="That is it for today, you may";
			ins2="end the class by clicking";
			ins3="the speaker";
		}
		else if(objectState==-1) {
			bgInfo="Good! we are done for this phrase";
//			bgInfo2="";
//			bgInfo3="";
			ins="go to the next phrase";
		}
	}
}
