package master;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import Student.Student;
import Student.StudentDecr;
import Student.StudentDialogue1;
import Student.StudentDialogue1b;
import Student.StudentDialogue2;
import Student.StudentDialogue2b;
import Student.StudentFilled0;
import Student.StudentFilled1;
import Student.StudentFilled2;
import Student.StudentFilled3;
import Student.StudentFilled4;
import buttons.Button;
import environmentObjects.Background;
import environmentObjects.EnvObjects;
import environmentObjects.Info;
import environmentObjects.InteractiveObjects;
import environmentObjects.ObjectFactory;
import environmentObjects.Smock;
import materials.Firewall;
import materials.HistBook;
import materials.Newspaper;
import materials.Poster;
import materials.Seal;
import materials.Speaker;
import materials.SpeakerActivated;
import processing.core.PVector;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.Minim;
import ddf.minim.Minim;

//main panel class 

public class AppInterface extends JPanel implements ActionListener {
	
	private int state=-1,infoState=0;
	private Timer timer;
	
	private EnvObjects bg,info,smock;
	private InteractiveObjects button,speaker,student,sign,homework;
//	private Materials 
	
	private ArrayList<InteractiveObjects> interactiveList;
	
	private Minim mi;
	private AudioPlayer bgm,bgmList[]=new AudioPlayer[2],bgm1,clickStudent,clickSpeaker,clickBook;
	private AudioPlayer steam,putInSeal,putInBook,clickObj,clickFirewall,signOnSound,clickHw;
	
	private Dimension screenSize;
	
	private ObjectFactory factory;
	
	public AppInterface(Dimension screenSize) {
		this.screenSize=screenSize;
		
		factory=new ObjectFactory(screenSize);
		

		bg=factory.constructEnvObjs("bg");
		info=factory.constructEnvObjs("info");
		smock=factory.constructEnvObjs("smock");
		
		button=factory.constructIntaObjs("button");
		
		sign=factory.constructIntaObjs("sign");

		
		interactiveList=new ArrayList<InteractiveObjects>();

		interactiveList.add(factory.constructIntaObjs("seal"));
		interactiveList.add(factory.constructIntaObjs("histbook"));
		interactiveList.add(factory.constructIntaObjs("newspaper"));
		interactiveList.add(factory.constructIntaObjs("poster"));	
		interactiveList.add(factory.constructIntaObjs("firewall"));

		mi = new Minim(new MinimHelper());
			
		bgm=mi.loadFile("socialismIsGood.mp3");
//		bgmList[0]=mi.loadFile("socialismIsGood.mp3");
//		bgmList[1]=mi.loadFile("HK97_ILoveBeijingTiananmen.mp3");
		
		clickStudent=mi.loadFile("click1.mp3");
		clickSpeaker=mi.loadFile("clickSpeaker.mp3");
		clickBook=mi.loadFile("clickBook.mp3");
		clickObj=mi.loadFile("clickObj.mp3");
		clickFirewall=mi.loadFile("clickFirewall.mp3");
		clickHw=mi.loadFile("clickHomework.mp3");
		
		putInSeal=mi.loadFile("putInSeal.mp3");
		putInBook=mi.loadFile("putInBook.mp3");
		
		signOnSound=mi.loadFile("signOn.mp3");
		steam=mi.loadFile("steam.mp3");
		
		
		timer = new Timer(33, this);
		timer.start();
		
		MouseClickListenerCustom mouseClick = new MouseClickListenerCustom();
		MouseMotionListenerCustom mouseMove = new MouseMotionListenerCustom();
		
		addMouseListener(mouseClick);	
		addMouseMotionListener(mouseMove);
	}
	
	private boolean state2Finished=false;
	//values for the ending screen animation
	private int endScreenOpacity=0,opacityGain=2;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (state==-1) {
			button.resetState(0);
			bg.draw(g2d);
			button.draw(g2d);
		} 
		else if(state==0) {
			bg.draw(g2d);
			student.draw(g2d);
			info.draw(g2d);
			speaker.draw(g2d);
		}
		else if (state==1) {
			bg.draw(g2d);
			student.draw(g2d);
			info.draw(g2d);
			speaker.draw(g2d);
		}
		else if (state==2) {
			bg.draw(g2d);
			student.draw(g2d);
			info.draw(g2d);
			speaker.draw(g2d);
			for(int i=0;i<interactiveList.size();i++) {
				InteractiveObjects obj=interactiveList.get(i);
				obj.draw(g2d);
//				System.out.println(true);
			}
			if(fireWallAnimDisp) {
				//smock animation for firewall
				smock.draw(g2d);
			}
			if(state2Finished) {
				button.resetState(1);
				button.setPosition(new PVector(825,200));
				button.draw(g2d);
			}
		}
		else if(state==3) {
			bg.draw(g2d);
			student.draw(g2d);
			info.draw(g2d);
			sign.draw(g2d);
			if(signOn) {
				button.draw(g2d);
			}
		}
		else if(state==4) {
			bg.draw(g2d);
			student.draw(g2d);
			info.draw(g2d);
			speaker.draw(g2d);
			homework.draw(g2d);
			
			//endgame animation
			if(cycleEnded) {
				endScreenOpacity+=opacityGain;
				g2d.setColor(new Color(0,0,0,endScreenOpacity));
				g2d.fillRect(0, 0, screenSize.width, screenSize.height);
				if(endScreenOpacity>=254) {
					opacityGain=0;
					state=-2;
				}
			}

		}
		
		//ending scene with replay button 
		else if(state==-2) {
			bg.draw(g2d);
			button.resetState(3);
			button.setPosition(new PVector(825,465));
			button.draw(g2d);
		}
	}
	int textn=1;
	
	//value used to determine which images should be displayed for student
	//when putting materials into the student's brain
	int materialIn=0;
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		bg.resetState(state);
		
		//firewall animation counter
		if(state==2) {
			if(fireWallAnimDisp) {
				fireWallAnimTimer--;
			}
			//allows shifting to the next stage when the animation is displayed
			if(interactiveList.size()==0 && fireWallAnimTimer<0) {
				fireWallAnimDisp=false;
				info.resetState(-1);
				state2Finished=true;
			}	
		}
		
		else if(state==3) {
			//spawing dialogues and dialogue animations
			//1st student at the left
			if(s2studentAnimTimer>0) {
				s2studentAnimTimer--;
				if(!signOn) {	
					student=new StudentDialogue1(new PVector(600,screenSize.height/2+97), student);
				}
				else {
					student=new StudentDialogue1b(new PVector(600,screenSize.height/2+97), student);
				}
				
				if(s2studentAnimTimer<=0) {
					s2studentAnimTimer2=dialogueDisplay;						
				}
			}
			//2nd student at the right
			if(s2studentAnimTimer2>0) {
				s2studentAnimTimer2--;
				if(!signOn) {	
					student=factory.constructIntaObjs("student");
					student.setPosition(new PVector(600,screenSize.height/2+97));
					student.resetState(2);
					student=new StudentDialogue2(new PVector(600,screenSize.height/2+97), student);
				}
				else {
					student=factory.constructIntaObjs("student");
					student.setPosition(new PVector(600,screenSize.height/2+97));
					student.resetState(2);
					student=new StudentDialogue2b(new PVector(600,screenSize.height/2+97), student);
				}	
				if(s2studentAnimTimer2<=0) {
					student=factory.constructIntaObjs("student");
					student.setPosition(new PVector(600,screenSize.height/2+97));
					student.resetState(2);
				}
			}
		}
		repaint();
	}
	
//	int timer1=180;
	private int dialogueDisplay=90;
	private int s2studentAnimTimer=0,s2studentAnimTimer2=0;
	private boolean signOn=false,cycleEnded=false,classEnded=false;
	private int bgmDJ;
	public class MouseClickListenerCustom extends MouseAdapter {

		public void mouseClicked(MouseEvent e) {
//			if(button.checkMouseClick(e)) {
//				clickObj.play(0);
//			}
			if(state==-1) {
				if(button.checkMouseClick(e)) {
					state=0;		
					student=factory.constructIntaObjs("student");
					speaker=factory.constructIntaObjs("speaker");
					clickObj.play(0);
				}
			}
			//click the speaker
			else if(state==0) {
				if(speaker.checkMouseClick(e)) {
					clickSpeaker.play(0);
//					speaker.resetState(1);
					speaker=new SpeakerActivated(new PVector(screenSize.width/8,screenSize.height/4),speaker);
					infoState=1;
					info.resetState(infoState);
					state=1;	
					
//					bgmDJ=(int) Tools.random(0,2);
//					bgm=bgmList[bgmDJ];					
//					bgm=bgmList[0];	

					bgm.rewind(); 
					bgm.loop();
					
				}
			}
			//click the student
			else if(state==1) {			
				if(student.checkMouseClick(e)) {
					clickStudent.play(0);
					if(studentState==0) {
						student.resetState(1);
						student.setPosition(new PVector(400,screenSize.height/2+97));
//						student=new Student1(new PVector(400,screenSize.height/2+97),student);

						studentState=1;
						infoState=2;
						info.resetState(infoState);
					}
					state=2;
				}
			}
			
			else if(state==2) {
				//click sound effect for scene 1 objs
				for(int i=0;i<interactiveList.size();i++) {
					InteractiveObjects obj=interactiveList.get(i);
					
					if(obj.checkMouseClick(e)) {
						clickObj.play(0);
					}
				}	
				//after firewall animation displayed, allow clicking button and shift
				//to the next stage
				if(state2Finished) {
					if(button.checkMouseClick(e)) {
						clickObj.play(0);
						state=3;	
						infoState=8;
						info.resetState(infoState);
						student=factory.constructIntaObjs("student");
						student.setPosition(new PVector(600,screenSize.height/2+97));
						student.resetState(2);
						studentState=0;
					}	
				}
			}
			else if(state==3) {
				//display the dialogue animation when the student is clicked
				if(s2studentAnimTimer<=0 && s2studentAnimTimer2<=0) {
					if(student.checkMouseClick(e)) {
						clickStudent.play(0);
						s2studentAnimTimer=dialogueDisplay;
						
						if(infoState!=10) {
							infoState=9;
							info.resetState(infoState);
						}
						
					}
				}
				//put the sign on and off based on clicks
				if(sign.checkMouseClick(e)) {
					if(!signOn) {
						infoState=10;
						info.resetState(infoState);
						
						sign.setPosition(new PVector(screenSize.width/2-120,screenSize.height/2-100));
						sign.resetState(1);
						signOn=true;
						
						signOnSound.play(0);
						
						textn=2;
					}
					else {
						sign.setPosition(new PVector(screenSize.width/2-150,screenSize.height-94));
						sign.resetState(0);
						signOn=false;
						putInSeal.play(0);
						
						textn=1;
					}
				}
				//allow shifting to next stage when sign is on
				if(signOn) {
					if(button.checkMouseClick(e)) {
						clickObj.play(0);
						state=4;
						homework=factory.constructIntaObjs("homework");
//						interactiveList.add(homework);
						student=factory.constructIntaObjs("student");
//						student.setPosition(new PVector(300,screenSize.height/2+20));
						student.resetState(3);
						
						infoState=11;
						info.resetState(infoState);
					}	
				}

			}
			
			else if(state==4) {
				if(homework.checkMouseClick(e)){
					clickHw.play(0);
					infoState=12;
					info.resetState(infoState);
					student.resetState(4);
				}
				if(infoState==12) {
					if(speaker.checkMouseClick(e)) {
						clickSpeaker.play(0);
//						speaker.resetState(1);
						speaker=new Speaker(new PVector(screenSize.width/8,screenSize.height/4));
//						infoState=1;
//						info.resetState(infoState);
//						state=1;	
//						bgm.rewind(); 
//						bgm.loop();
						bgm.pause();
						cycleEnded=true;				
					}
				}

//				if(button.checkMouseClick(e)) {
//					state=-2;	
//				}	
			}
			
			else if(state==-2) {
				//temporary
				if(button.checkMouseClick(e)) {
					clickObj.play(0);
					button.setPosition(new PVector(790,365));
					resetAll();
				}	
			}
		}
	}
	
	//method resetting all values for the next loop and shift back
	//to the starting screen when replay is clicked
	private void resetAll() {
		state=-1;	
		studentState=0;
		materialIn=0;
		fireWallAnimTimer=180;
		s2studentAnimTimer=0;
		s2studentAnimTimer2=0;
		info.resetState(0);
//		speaker.resetState(0);
		state2Finished=false;
		interactiveList.add(factory.constructIntaObjs("seal"));
		interactiveList.add(factory.constructIntaObjs("histbook"));
		interactiveList.add(factory.constructIntaObjs("newspaper"));
		interactiveList.add(factory.constructIntaObjs("poster"));	
		interactiveList.add(factory.constructIntaObjs("firewall"));
		
		signOn=false;
		sign.setPosition(new PVector(screenSize.width/2-150,screenSize.height-94));
		sign.resetState(0);
		opacityGain=2;
		endScreenOpacity=0;
		cycleEnded=false;
		
	}
//	public int getFireWallTimer() {
//		return fireWallAnimTimer;
//	}
	//determine whether the firewall animation should be displayed
	private boolean fireWallAnimDisp=false;
	//timer for firewall anim
	private int fireWallAnimTimer=180;
	
	private int studentState=0;
	public class MouseMotionListenerCustom extends MouseAdapter{
		public void mouseDragged(MouseEvent e) {
			
			//dragging mechanisms mainly for scene 1
			if(state==2) {
				for(int i=0;i<interactiveList.size();i++) {
					InteractiveObjects obj=interactiveList.get(i);
					
					//sound effect upon click
					if(obj.checkMouseClick(e)) {
						obj.setPosition(new PVector(e.getX(), e.getY()));
						if(obj instanceof HistBook || obj instanceof Newspaper || obj instanceof Poster) {
							clickBook.play(0);
						}
					}
					
					if(obj.checkCollision(student)) {
						//put seal in first before everything else
						//must put seal in first before putting in other materials
						if(studentState==1) {
							if(obj instanceof Seal) {
								putInSeal.play(0);
								studentState=2;
								student=new StudentFilled0(new PVector(400,screenSize.height/2+97),student);

								infoState=3;
								info.resetState(infoState);
								interactiveList.remove(obj);
							}
						}
						else if(studentState==2) {
							//value used to determine which images should be displayed for student
							//when putting materials into the student's brain
							if(materialIn<3) {
								if(!(obj instanceof Firewall)) {
									putInBook.play(0);
									materialIn+=1;
//									student.resetMaterialIn(materialIn);
									if(materialIn==1) {
										student=new StudentFilled1(new PVector(400,screenSize.height/2+97),student);
									}
									else if(materialIn==2) {
										student=new StudentFilled2(new PVector(400,screenSize.height/2+97),student);

									}
									else if(materialIn==3) {
										student=new StudentFilled3(new PVector(400,screenSize.height/2+97),student);

									}
									interactiveList.remove(obj);
									infoState+=1;
									info.resetState(infoState);
								}
							}
							//allowing to drag in firewall only when 3 materials are all in
							else {
								if(obj instanceof Firewall) {
									steam.play(0);
									clickFirewall.play(0);
//									student.resetState(3);
									student=new StudentFilled4(new PVector(400,screenSize.height/2+97),student);
									studentState=3;
									fireWallAnimDisp=true;
									interactiveList.remove(obj);
									infoState=7;
									info.resetState(infoState);
									
									
								}
							}
						}
					
						
					}
					
				}
			}		
			
			repaint();
			
		}
	}

}
