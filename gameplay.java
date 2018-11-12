package GameDemo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.MemoryImageSource;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GameDemo.gameplay;
import GameDemo.gameplay.MyThread;


public class gameplay extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean left,right,up,down,space;
	schiff s1 = new schiff(50,50,900,900);
	schiff s2 = new schiff(50,50,1100,- 50);
	schiff s3 = new schiff(50,50,1000,- 50);
	schiff s4 = new schiff(50,50,900,- 50);
	schiff s5 = new schiff(50,50,800,- 50);
	schiff s6 = new schiff(50,50,700,- 50);
	
	private boolean threadrun;
	Timer t1 = new Timer();
	Timer t2 = new Timer();
	JLabel scoreL = new JLabel();
	JLabel ingametext = new JLabel();
	JLabel leben = new JLabel();
	JLabel scoreend = new JLabel();
	String neu,neu2;
	JLabel ILabel = new JLabel();
	boolean stopt = false;
	int score = 0;
	boolean firststart = true;
	
	JButton startB = new JButton();
	JButton stoppB = new JButton();
	JButton option = new JButton();
	JButton back = new JButton();
	
	JLabel scoreingame = new JLabel();
	JLabel life = new JLabel();
	
	
	JPanel B1 = new JPanel();
	JPanel B2 = new JPanel();
	boolean bots2 = true;
	boolean bots3 = true;
	boolean bots4 = true;
	boolean bots5 = true;
	boolean bots6 = true;
	private boolean an = false,bn = false,newt,cn = false;
	shot a = new shot(s1.getX() + 20,s1.getY()+ 20);
	shot b = new shot(s1.getX() + 20,s1.getY()+ 20);
	shot c = new shot(s1.getX() + 20,s1.getY()+ 20);
	int ax,bx,cx   ;
	int lebencount = 3;
	int count = 0;
	long a1;
	long a2;
	int test;
	boolean restart = false;
	
	

	public gameplay() {
		this.setLayout(null);
		this.setSize(1920, 1080);
		this.setLocation(0, 0);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setSize(1920, 1080);
		this.setDefaultCloseOperation(3);
		this.add(contentPane);
		this.setUndecorated(true);
		this.addKeyListener(this);
		this.setVisible(true);
		contentPane.add(s1);
		contentPane.add(s2);
		contentPane.add(s3);
		contentPane.add(s4);
		contentPane.add(s5);
		contentPane.add(s6);
		
		
		startB.setBounds(810, 500, 200, 50);
		startB.setFocusable(false);
		startB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startB_ActionPerformed(evt);
			}
		});
		contentPane.add(startB);
		startB.setText("Start");
		
		
		option.setBounds(810, 600, 200, 50);
		option.setFocusable(false);
		option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				option_ActionPerformed(evt);
			}
		});
		contentPane.add(option);
		option.setText("Options");
		
		
		stoppB.setBounds(810, 700, 200, 50);
		stoppB.setFocusable(false);
		stoppB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				stoppB_ActionPerformed(evt);
			}
		});
		contentPane.add(stoppB);
		stoppB.setText("Exit");
		
		back.setBounds(810, 800, 200, 50);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				back_ActionPerformed(evt);
			}
		});
		contentPane.add(back);
		back.setText("Back");
		
		
		
		leben.setBounds(150, 500, 300, 150);
		leben.setBackground(Color.WHITE);
		leben.setFont(new Font("Arial", Font.BOLD, 80));
		contentPane.add(leben);
		neu = Integer.toString(lebencount);
		leben.setText(neu);
		
		life.setBounds(150, 400, 300, 150);
		life.setBackground(Color.WHITE);
		life.setFont(new Font("Arial", Font.BOLD, 80));
		contentPane.add(life);
		life.setText("Lifes");
		
		
		scoreend.setBounds(780, 800, 1000, 150);
		scoreend.setBackground(Color.WHITE);
		scoreend.setFont(new Font("Arial", Font.BOLD, 80));
		contentPane.add(scoreend);
		
		ILabel.setBounds(700, 100, 800, 800);
		ILabel.setBackground(Color.WHITE);
		ILabel.setFont(new Font("Arial", Font.BOLD, 40));
		contentPane.add(ILabel);
		
		
		scoreL.setBounds(1500, 500, 300, 150);
		scoreL.setBackground(Color.WHITE);
		scoreL.setFont(new Font("Arial", Font.BOLD, 80));
		contentPane.add(scoreL);
		neu2 = Integer.toString(score);
		scoreL.setText(neu2);
		
		scoreingame.setBounds(1500, 400, 300, 150);
		scoreingame.setBackground(Color.WHITE);
		scoreingame.setFont(new Font("Arial", Font.BOLD, 80));
		contentPane.add(scoreingame);
		scoreingame.setText("Score");
		
		B1.setBounds(0, 0, 500, 1080);
		B1.setBackground(Color.BLACK);
		contentPane.add(B1);
		
		
		B2.setBounds(1420, 0, 500, 1080);
		B2.setBackground(Color.BLACK);
		contentPane.add(B2);
		
		
		
		ingametext.setBounds(820, 200, 800, 300);
		contentPane.add(ingametext);
		
		ingametext.setFont(new Font("Arial", Font.BOLD, 80));
		ingametext.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(a);
		a.setVisible(false);
		a.setBackground(Color.black);
		contentPane.add(b);
		b.setVisible(false);
		b.setBackground(Color.black);
		contentPane.add(c);
		c.setVisible(false);
		c.setBackground(Color.black);
		
		this.mainmenü();

	}

	public static void main(String[] args) {
		new gameplay();
	}
	
	public void mainmenü() {
		leben.setVisible(false);
		life.setVisible(false);
		scoreL.setVisible(false);
		scoreingame.setVisible(false);
		B1.setVisible(false);
		B2.setVisible(false);
		ingametext.setVisible(false);
		s1.setVisible(false);
		startB.setVisible(true);
		stoppB.setVisible(true);
		scoreend.setVisible(false);
		contentPane.setBackground(Color.GRAY);
		ILabel.setVisible(false);
		option.setVisible(true);
		back.setVisible(false);
		
		
	}
	
	public void gamestart() {
		leben.setVisible(true);
		life.setVisible(true);
		scoreL.setVisible(true);
		scoreingame.setVisible(true);
		B1.setVisible(true);
		B2.setVisible(true);
		ingametext.setVisible(true);
		s1.setVisible(true);
		startB.setVisible(false);
		stoppB.setVisible(false);
		if(firststart) {
		this.laufen();
		firststart = false;
		}
		
		if(firststart == false) {
		this.start();	
		lebencount = 3;
		}
		scoreend.setVisible(false);
		ILabel.setVisible(false);
		option.setVisible(false);
		
	}
	
	public void restart() {
		stoppB.setVisible(true);
		leben.setVisible(false);
		life.setVisible(false);
		scoreL.setVisible(false);
		scoreingame.setVisible(false);
		B1.setVisible(false);
		B2.setVisible(false);
		ingametext.setVisible(true);
		s1.setVisible(false);
		startB.setVisible(true);
		scoreend.setVisible(true);
		ILabel.setVisible(false);
		option.setVisible(false);
	}
	
	public void option() {
		ILabel.setVisible(true);
		stoppB.setVisible(false);
		startB.setVisible(false);
		option.setVisible(false);
		back.setVisible(true);
	}
	
	public void stoppB_ActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	

	public void startB_ActionPerformed(ActionEvent evt) {
		gamestart();
	}
	
	public void option_ActionPerformed(ActionEvent evt) {
		ILabel.setText("<html>Key &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Action<p/>"+                  
					         "Up Arrow &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Up<p/>"+
					         "Down Arrow&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Down<p/>"+
					         "Left Arrow &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Left<p/>"+
					         "Right Arrow &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Right<p/>"+
					         "Space &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp Shoot<p/>"+
					         "ESC &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp Exit<p/>"+
					          "</html>");
		option();
	}
	
	public void back_ActionPerformed(ActionEvent evt) {
		mainmenü();
	}

	public void move (int x,int y,String st) {
		
		if(st == "s1") {
		if(x < 0) {
		this.stopp();	
		}
		
		if(x > 1920) {
		this.stopp();	
		}
		
		if(y < 0) {
		this.stopp();	
		}
		
		if(y > 1080) {
		this.stopp();	
		}
		
		else{
		s1.setLocation(x, y);
		}
		
		}
		
		if(st == "s2") {
			if(y > 1080) {
				botstopp("s2");
				lebencount --;
			}
			
			if(s1.getX() >= s2.getX() - 55 && s1.getX() <= s2.getX() + 55 && s1.getY() >= s2.getY() - 55 && s1.getY() <= s2.getY() + 55) {
				this.stopp();
				}
			
			else {
			s2.setLocation(x, y);
			}
		}
		
		if(st == "s3") {
			if(y > 1080) {
				botstopp("s3");
				lebencount --;
			}
			
			if(s1.getX() >= s3.getX() - 55 && s1.getX() <= s3.getX() + 55 && s1.getY() >= s3.getY() - 55 && s1.getY() <= s3.getY() + 55) {
				this.stopp();
				}
			
			else {
			s3.setLocation(x, y);
			}
		}
		
		if(st == "s4") {
			if(y > 1080) {
				botstopp("s4");
				lebencount --;
			}
			
			if(s1.getX() >= s4.getX() - 55 && s1.getX() <= s4.getX() + 55 && s1.getY() >= s4.getY() - 55 && s1.getY() <= s4.getY() + 55) {
				this.stopp();
				}
			
			else {
			s4.setLocation(x, y);
			}
		}
		
		if(st == "s5") {
			if(y > 1080) {
				botstopp("s5");
				lebencount --;
			}
			
			if(s1.getX() >= s5.getX() - 55 && s1.getX() <= s5.getX() + 55 && s1.getY() >= s5.getY() - 55 && s1.getY() <= s5.getY() + 55) {
				this.stopp();
				}
			
			else {
			s5.setLocation(x, y);
			}
		}
		
		if(st == "s6") {
			if(y > 1080) {
				botstopp("s6");
				lebencount --;
			}
			
			if(s1.getX() >= s6.getX() - 55 && s1.getX() <= s6.getX() + 55 && s1.getY() >= s6.getY() - 55 && s1.getY() <= s6.getY() + 55) {
				this.stopp();
				}
			
			else {
			s6.setLocation(x, y);
			}
		}
		
		if(st == "a") {
			if(a.getX() >= s2.getX() - 5 && a.getX() <= s2.getX() + 55 && a.getY() >= s2.getY() - 5 && a.getY() <= s2.getY() + 55) {
				a.setLocation(0, 0);
				botstopp("s2");
				score = score + 10;
			}
			
			if(a.getX() >= s3.getX() - 5 && a.getX() <= s3.getX() + 55 && a.getY() >= s3.getY() - 5 && a.getY() <= s3.getY() + 55) {
				a.setLocation(0, 0);
				botstopp("s3");
				score = score + 10;
			}
			
			if(a.getX() >= s4.getX() - 5 && a.getX() <= s4.getX() + 55 && a.getY() >= s4.getY() - 5 && a.getY() <= s4.getY() + 55) {
				a.setLocation(0, 0);
				botstopp("s4");
				score = score + 10;
			}
			
			if(a.getX() >= s5.getX() - 5 && a.getX() <= s5.getX() + 55 && a.getY() >= s5.getY() - 5 && a.getY() <= s5.getY() + 55) {
				a.setLocation(0, 0);
				botstopp("s5");
				score = score + 10;
			}
			
			if(a.getX() >= s6.getX() - 5 && a.getX() <= s6.getX() + 55 && a.getY() >= s6.getY() - 5 && a.getY() <= s6.getY() + 55) {
				a.setLocation(0, 0);
				botstopp("s6");
				score = score + 10;
			}
			
			if(a.getY() <= 0) {
				a.setLocation(- 100, 0);
			}
			
			else {
			a.setLocation(x, y);
			}
		}
		
		if(st == "b") {
			if(b.getX() >= s2.getX() - 5 && b.getX() <= s2.getX() + 55 && b.getY() >= s2.getY() - 5 && b.getY() <= s2.getY() + 55) {
				b.setLocation(0, 0);
				botstopp("s2");
				score = score + 10;
			}
			
			if(b.getX() >= s3.getX() - 5 && b.getX() <= s3.getX() + 55 && b.getY() >= s3.getY() - 5 && b.getY() <= s3.getY() + 55) {
				b.setLocation(0, 0);
				botstopp("s3");
				score = score + 10;
			}
			
			if(b.getX() >= s4.getX() - 5 && b.getX() <= s4.getX() + 55 && b.getY() >= s4.getY() - 5 && b.getY() <= s4.getY() + 55) {
				b.setLocation(0, 0);
				botstopp("s4");
				score = score + 10;
			}
			
			if(b.getX() >= s5.getX() - 5 && b.getX() <= s5.getX() + 55 && b.getY() >= s5.getY() - 5 && b.getY() <= s5.getY() + 55) {
				b.setLocation(0, 0);
				botstopp("s5");
				score = score + 10;
			}
			
			if(b.getX() >= s6.getX() - 5 && b.getX() <= s6.getX() + 55 && b.getY() >= s6.getY() - 5 && b.getY() <= s6.getY() + 55) {
				b.setLocation(0, 0);
				botstopp("s6");
				score = score + 10;
			}
			
			if(b.getY() <= 0) {
				b.setLocation(- 100, 0);
			}
			
			else {
			b.setLocation(x, y);
			}
		}
		
		if(st == "c") {
			if(c.getX() >= s2.getX() - 5 && c.getX() <= s2.getX() + 55 && c.getY() >= s2.getY() - 5 && c.getY() <= s2.getY() + 55) {
				c.setLocation(0, 0);
				botstopp("s2");
				score = score + 10;
			}
			
			if(c.getX() >= s3.getX() - 5 && c.getX() <= s3.getX() + 55 && c.getY() >= s3.getY() - 5 && c.getY() <= s3.getY() + 55) {
				c.setLocation(0, 0);
				botstopp("s3");
				score = score + 10;
			}
			
			if(c.getX() >= s4.getX() - 5 && c.getX() <= s4.getX() + 55 && c.getY() >= s4.getY() - 5 && c.getY() <= s4.getY() + 55) {
				c.setLocation(0, 0);
				botstopp("s4");
				score = score + 10;
			}
			
			if(c.getX() >= s5.getX() - 5 && c.getX() <= s5.getX() + 55 && c.getY() >= s5.getY() - 5 && c.getY() <= s5.getY() + 55) {
				c.setLocation(0, 0);
				botstopp("s5");
				score = score + 10;
			}
			
			if(c.getX() >= s6.getX() - 5 && c.getX() <= s6.getX() + 55 && c.getY() >= s6.getY() - 5 && c.getY() <= s6.getY() + 55) {
				c.setLocation(0, 0);
				botstopp("s6");
				score = score + 10;
			}
			
			if(c.getY() <= 0) {
				c.setLocation(- 100, 0);
			}
			
			else {
			c.setLocation(x, y);
			} 
		}
		
	}
	  

	
	
	MyThread t;
	int periodendauer = 10; 
	
	public void laufen() {
		newt = true;
			t = new MyThread();
			t.start();
			threadrun = true;
			s1.setLocation(900, 900);
			ingametext.setText("Start");
			
			t1.schedule(new TimerTask() {
				public void run() {
				ingametext.setText(" ");
				}
			}, 1000);
		}
	
	public void stopp() {
		
		newt = false;
		threadrun = false;
		s1.setLocation(900, 900);
		stopt = true;
		
		scoreL.setText("0");
		botstopp("s2");
		botstopp("s3");
		botstopp("s4");
		botstopp("s5");
		botstopp("s6");
		ingametext.setLocation(700, 200);
		ingametext.setText("Game Over");
		leben.setText("0");
		left = false;
		down = false;
		right = false;
		up = false;
		a.setLocation(0, 0);
		b.setLocation(0, 0);
		c.setLocation(0, 0);
		restart();
		neu2 = Integer.toString(score);
		scoreend.setText("score "  + neu2);
		score = 0;
	}
	
	public void start() {
		newt = true;
		s1.setLocation(900, 900);


			threadrun = true;
			ingametext.setLocation(820, 200);
			ingametext.setText("Start");

		
		t1.schedule(new TimerTask() {
			public void run() {
			ingametext.setText(" ");
			}
		}, 3000);
		
	}	
	
	public void botstopp(String st) {
		
		
		
		if(st == "s2") {
		bots2 = false;
		t2.schedule(new TimerTask() {
			public void run() {
			s2.setLocation(1100, - 100); 
			}
		}, 100);
		
		t2.schedule(new TimerTask() {
			public void run() {
			botstart("s2");
			}
		}, 1000);
	}
		
		if(st == "s3") {
			bots3 = false;
			t2.schedule(new TimerTask() {
				public void run() {
				s3.setLocation(1000, - 100); 
				}
			}, 100);
			
			t2.schedule(new TimerTask() {
				public void run() {
				botstart("s3");
				}
			}, 1000);
		}
		
		if(st == "s4") {
			bots4 = false;
			t2.schedule(new TimerTask() {
				public void run() {
				s4.setLocation(900, - 100); 
				}
			}, 100);
			
			t2.schedule(new TimerTask() {
				public void run() {
				botstart("s4");
				}
			}, 1000);
		}
		
		if(st == "s5") {
			bots5 = false;
			t2.schedule(new TimerTask() {
				public void run() {
				s5.setLocation(800, - 100); 
				}
			}, 100);
			
			t2.schedule(new TimerTask() {
				public void run() {
				botstart("s5");
				}
			}, 1000);
		}
		
		if(st == "s6") {
			bots6 = false;
			t2.schedule(new TimerTask() {
				public void run() {
				s6.setLocation(700, - 100); 
				}
			}, 100);
			
			t2.schedule(new TimerTask() {
				public void run() {
				botstart("s6");
				}
			}, 1000);
		}
	}
	
	public void botstart(String st) {
		if(st == "s2") {
			bots2 = true;
		}
		
		if(st == "s3") {
			bots3 = true;
		}
		
		if(st == "s4") {
			bots4 = true;
		}
		
		if(st == "s5") {
			bots5 = true;
		}
		
		if(st == "s6") {
			bots6 = true;
		}
	}
	public void shooting (int x , int y) {

		if(count == 0) {
			a.setLocation(x + 20, y - 20);
			a.setVisible(true);
			an = true;
		}
		
		if(count == 1) {
			b.setLocation(x + 20, y - 20);
			b.setVisible(true);
			bn = true;
		}
		
		if(count == 2) {
			c.setLocation(x + 20, y - 20);
			c.setVisible(true);
			cn = true;
		}
		
	}

	class MyThread extends Thread {
		public void run() {
			int speed = 6;
			int speedbot = 2;
			int countd = 10;
			int difficulty = 0;
			
			
				while (true) {
					
					
				
					
					while(threadrun == true) {
			
				neu = Integer.toString(lebencount);
				leben.setText(neu);
				
				
				
				
				
				difficulty = difficulty + 1;
				if(difficulty >= 20000){
					speedbot ++;
					difficulty = -25000;
				}
				
				
				countd = countd  + 1 * speedbot;
				if(countd > 200) {
					score = score + 1;	
					countd = 10;
				}
				
				
				
				
				neu2 = Integer.toString(score);
				scoreL.setText(neu2);
				
				
				
				
				int x = s1.getX();
				int y = s1.getY();
				int x2= s2.getX();
				int y2= s2.getY();
				int x3= s3.getX();
				int y3= s3.getY();
				int x4= s4.getX();
				int y4= s4.getY();
				int x5= s5.getX();
				int y5= s5.getY();
				int x6= s6.getX();
				int y6= s6.getY();
				
				if(left == true) {
					x = x - speed; 
					move(x, y,"s1");
				}
				
				if(right == true) {
					x = x + speed; 
					move(x, y,"s1");
				}
				
				if(up == true) {
					y = y - speed; 
					move(x, y,"s1");
				}
				
				if(down == true) {
					y = y + speed; 
					move(x, y,"s1");
				}
				
				 a1 = System.currentTimeMillis();

				if(space == true && a1 - a2 >= 250 || space == true && newt == true) {
					a2 = System.currentTimeMillis();
					shooting(x, y);
					ax = a.getX();
					bx = b.getX();
					cx = c.getX();
					newt = false;
					
					if(count == 0 && an == true) {
						count = 1;
					}
					
					else if(count == 1 && bn == true) {
						count = 2;
						}
					
					else if(count == 2 && cn == true) {
						count = 0;
						}
					
						
				}
				
				
				if(bots2 == true) {
				y2 = y2 + speedbot;
				move(x2,y2,"s2");
				}
				
				if(bots3 == true) {
					y3 = y3 + speedbot;
					move(x3,y3,"s3");
					}
				
				if(bots4 == true) {
					y4 = y4 + speedbot;
					move(x4,y4,"s4");
					}
				
				if(bots5 == true) {
					y5 = y5 + speedbot;
					move(x5,y5,"s5");
					}
				
				if(bots6 == true) {
					y6 = y6 + speedbot;
					move(x6,y6,"s6");
					}
				
				
				if(lebencount <= 0) {
					stopp();	
				}
				
			
				if(an == true) {
					move(ax ,a.getY() - 14, "a");
				}
				
				if(bn == true) {
					move(bx,b.getY() - 14, "b");
				}
				
				if(cn == true) {
					move(cx,c.getY() - 14, "c");
				}
				
				try {
					sleep(periodendauer);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}	
				try {
					sleep(1000);
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				}
			}
	}

	public void keyTyped(KeyEvent e) {

	}
	

	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = true;
		}
		

		
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = false;
		}
	}

}
	
	
	
	
	

