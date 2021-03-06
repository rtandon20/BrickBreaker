import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class BrickbreakerMain extends JFrame implements Action
{
	private ArrayList<Updatable> objects;
	private ArrayList<JLabel> scoreLabels;
	private ArrayList<Updatable> bricks;
	private int leftNum;
	private int rightNum;
	private Timer t1;

	public BrickbreakerMain()
	{
		//Hi guys I'm sorry for the amount of stuff commented out on here most of it is stuff I was removing from Pong but
		//I'd just left there for the time being and the other stuff is laggy code that we need to make better so the game
		//actually works.
		//-Riya
		
		objects = new ArrayList<Updatable>();
		scoreLabels = new ArrayList<JLabel>();
		bricks = new ArrayList<Updatable>();
		
		leftNum = 0;
		rightNum = 0;

		Color blue = new Color(177, 226, 232);
				
		setLayout(null);
		setBounds(100,0,800,760);
		setResizable(false);
		this.getContentPane().setBackground(blue);
		
		setPreferredSize(new Dimension(800,760));
		pack();
		
		int trueWidth = this.getContentPane().getWidth();
		int trueHeight = this.getContentPane().getHeight();
	
		
		int paddleDistance = 100;
		
		Paddle left = new Paddle(paddleDistance,trueHeight/2 - 15);
		objects.add(left);
		Paddle right = new Paddle(trueWidth-paddleDistance,trueHeight/2);
		objects.add(right);
		((Paddle)(objects.get(1))).setVisible(false);
		Ball ball = new Ball(125,(trueHeight/2) + 30);
		objects.add(ball);
		
		
		//creating bricks --> I know this is a ton of literals and I should have just made constants and multiplied them but I'll fix it when we're doing final touches -Riya
		bricks.add(new Brick(trueWidth - 30, 0));
		bricks.add(new Brick(trueWidth - 30, 90));
		bricks.add(new Brick(trueWidth - 30, 180));
		bricks.add(new Brick(trueWidth - 30, 270));
		bricks.add(new Brick(trueWidth - 30, 360));
		bricks.add(new Brick(trueWidth - 30, 450));
		bricks.add(new Brick(trueWidth - 30, 540));
		bricks.add(new Brick(trueWidth - 30, 630));	
		
		bricks.add(new Brick(trueWidth - 60, 0));
		bricks.add(new Brick(trueWidth - 60, 90));
		bricks.add(new Brick(trueWidth - 60, 180));
		bricks.add(new Brick(trueWidth - 60, 270));
		bricks.add(new Brick(trueWidth - 60, 360));
		bricks.add(new Brick(trueWidth - 60, 450));
		bricks.add(new Brick(trueWidth - 60, 540));
		bricks.add(new Brick(trueWidth - 60, 630));	
		
		bricks.add(new Brick(trueWidth - 90, 0));
		bricks.add(new Brick(trueWidth - 90, 90));
		bricks.add(new Brick(trueWidth - 90, 180));
		bricks.add(new Brick(trueWidth - 90, 270));
		bricks.add(new Brick(trueWidth - 90, 360));
		bricks.add(new Brick(trueWidth - 90, 450));
		bricks.add(new Brick(trueWidth - 90, 540));
		bricks.add(new Brick(trueWidth - 90, 630));	
		
		bricks.add(new Brick(trueWidth - 120, 0));
		bricks.add(new Brick(trueWidth - 120, 90));
		bricks.add(new Brick(trueWidth - 120, 180));
		bricks.add(new Brick(trueWidth - 120, 270));
		bricks.add(new Brick(trueWidth - 120, 360));
		bricks.add(new Brick(trueWidth - 120, 450));
		bricks.add(new Brick(trueWidth - 120, 540));
		bricks.add(new Brick(trueWidth - 120, 630));	
		
		bricks.add(new Brick(trueWidth - 150, 0));
		bricks.add(new Brick(trueWidth - 150, 90));
		bricks.add(new Brick(trueWidth - 150, 180));
		bricks.add(new Brick(trueWidth - 150, 270));
		bricks.add(new Brick(trueWidth - 150, 360));
		bricks.add(new Brick(trueWidth - 150, 450));
		bricks.add(new Brick(trueWidth - 150, 540));
		bricks.add(new Brick(trueWidth - 150, 630));	
		
		bricks.add(new Brick(trueWidth - 180, 0));
		bricks.add(new Brick(trueWidth - 180, 90));
		bricks.add(new Brick(trueWidth - 180, 180));
		bricks.add(new Brick(trueWidth - 180, 270));
		bricks.add(new Brick(trueWidth - 180, 360));
		bricks.add(new Brick(trueWidth - 180, 450));
		bricks.add(new Brick(trueWidth - 180, 540));
		bricks.add(new Brick(trueWidth - 180, 630));	
		
		
		JLabel leftScore = new JLabel("");
		leftScore.setBounds(trueWidth - 70, 60, 60, 50);
		leftScore.setBackground(blue);
		leftScore.setForeground(blue);
		leftScore.setFont(new Font("Calibri", Font.BOLD, 40));
		scoreLabels.add(leftScore);
		JLabel rightScore = new JLabel("");
		rightScore.setBounds(50, 60, 60, 50);
		rightScore.setBackground(blue);
		rightScore.setForeground(blue);
		rightScore.setFont(new Font("Calibri", Font.BOLD, 40));
		scoreLabels.add(rightScore);
		
//		JLabel leftWin = new JLabel("");
//		leftWin.setBounds(trueWidth - 70, 110, 60, 20);
//		leftWin.setBackground(blue);
//		leftWin.setForeground(blue);
//		leftWin.setFont(new Font("Calibri", Font.BOLD, 20));
//		scoreLabels.add(leftWin);
//		JLabel rightWin = new JLabel("");
//		rightWin.setBounds(50, 110, 60, 20);
//		rightWin.setBackground(blue);
//		rightWin.setForeground(blue);
//		rightWin.setFont(new Font("Calibri", Font.BOLD, 20));
//		scoreLabels.add(rightWin);
		
		
		for(JLabel c : scoreLabels)
		{
			add((JComponent)c);
		}
		
		for(Updatable c : objects)
		{
			add((JComponent)c);
		}
		
		for(Updatable c : bricks)
		{
			add((JComponent)c);
		}
		
		this.addKeyListener(new KeyListener()
		{
			
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_W && ((Paddle)(objects.get(0))).getY() > 0)
						((Paddle)(objects.get(0))).setDy(-3);
				if(e.getKeyCode() == e.VK_S && ((Paddle)(objects.get(0))).getY() < trueHeight - 50)
						((Paddle)(objects.get(0))).setDy(3);
//				if(e.getKeyCode() == e.VK_UP && ((Paddle)(objects.get(1))).getY() > 0)
//						((Paddle)(objects.get(1))).setDy(-3);
//				if(e.getKeyCode() == e.VK_DOWN && ((Paddle)(objects.get(1))).getY() < trueHeight - 50)
//						((Paddle)(objects.get(1))).setDy(3);
				if(e.getKeyCode() == e.VK_SPACE && ball.getDx() == 0 && ball.getDy() == 0)
				{
//					int negY = (int)(Math.random()*2 + 1);
//					if(negY == 1)
//						ball.setDy(-1*(int)(Math.random()*6 + 1));
//					else
						ball.setDy((int)(Math.random()*6 + 1));
//					int negX = (int)(Math.random()*2 + 1);
//					if(negX == 1)
//						ball.setDx(-1*(int)(Math.random()*6 + 1));
//					else
						ball.setDx((int)(Math.random()*6 + 1));
				}
			}
			
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == e.VK_W)
					((Paddle)(objects.get(0))).setDy(0);
				if(e.getKeyCode() == e.VK_S)
					((Paddle)(objects.get(0))).setDy(0);
//				if(e.getKeyCode() == e.VK_UP)
//					((Paddle)(objects.get(1))).setDy(0);
//				if(e.getKeyCode() == e.VK_DOWN)
//					((Paddle)(objects.get(1))).setDy(0);
			}
				
			public void keyTyped(KeyEvent arg0) 
			{
				// TODO Auto-generated method stub
				
			}
			
		});
				
		t1 = new Timer(7,this);
		t1.start();
		
		setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		for(Updatable c : objects)
		{
			c.updateX();
			c.updateY();
		}
		
		//left paddle
		if(((Paddle)(objects.get(0))).getY() < 0)
		{
			((Paddle)(objects.get(0))).setLocation(((Paddle)(objects.get(0))).getX(), 0);
		}
		else if(((Paddle)(objects.get(0))).getY() + ((Paddle)(objects.get(0))).getHeight() > this.getContentPane().getHeight())
		{
			((Paddle)(objects.get(0))).setLocation(((Paddle)(objects.get(0))).getX(), this.getContentPane().getHeight() - ((Paddle)(objects.get(0))).getHeight());
		}
//		//right paddle
//		if(((Paddle)(objects.get(1))).getY() < 0)
//		{
//			((Paddle)(objects.get(1))).setLocation(((Paddle)(objects.get(1))).getX(), 0);
//		}
//		else if(((Paddle)(objects.get(1))).getY() + ((Paddle)(objects.get(1))).getHeight() > this.getContentPane().getHeight())
//		{
//			((Paddle)(objects.get(1))).setLocation(((Paddle)(objects.get(1))).getX(), this.getContentPane().getHeight() - ((Paddle)(objects.get(1))).getHeight());
//		}
		//ball
		if(((Ball)(objects.get(2))).getY() < 0)
		{
			((Ball)(objects.get(2))).setDy(-1*((Ball)(objects.get(2))).getDy());
		}
		else if(((Ball)(objects.get(2))).getY() + ((Ball)(objects.get(2))).getHeight() > this.getContentPane().getHeight())
		{
			((Ball)(objects.get(2))).setDy(-1*((Ball)(objects.get(2))).getDy());
		}
		
		//score
		if(((Ball)(objects.get(2))).getX() <= 0)
		{
			((Ball)(objects.get(2))).setDy(0);
			((Ball)(objects.get(2))).setDx(0);
			scoreLabels.get(2).setText("You lose :(");
			t1.stop();
//			leftNum++;
//			((Ball)(objects.get(2))).setLocation(this.getContentPane().getWidth()/2,(this.getContentPane().getHeight()/2) + 25);
//			int negY = (int)(Math.random()*2 + 1);
//			if(negY == 1)
//			{
//				((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				}
//			}
//			else
//			{
//				((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				}
//			}
//			int negX = (int)(Math.random()*2 + 1);
//			if(negX == 1)
//			{
//				((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				}
//			}
//			else
//			{
//				((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				}
//			}
//			
//			scoreLabels.get(0).setText("" + leftNum);
//			if(scoreLabels.get(0).getText().equals("10"))
//			{
//				((Ball)(objects.get(2))).setDy(0);
//				((Ball)(objects.get(2))).setDx(0);
//				scoreLabels.get(2).setText("I win!");
//				t1.stop();
//			}
		}
//		if(((Ball)(objects.get(2))).getX() >= this.getContentPane().getWidth())
//		{
//			rightNum++;
//			((Ball)(objects.get(2))).setLocation(this.getContentPane().getWidth()/2,(this.getContentPane().getHeight()/2) + 25);
//			int negY = (int)(Math.random()*2 + 1);
//			if(negY == 1)
//			{
//				((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				}
//			}
//			else
//			{
//				((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				}
//			}
//			int negX = (int)(Math.random()*2 + 1);
//			if(negX == 1)
//			{
//				((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy(-1*(int)(Math.random()*7 - 3));
//				}
//			}
//			else
//			{
//				((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				while(((Ball)(objects.get(2))).getDy() <  2 && ((Ball)(objects.get(2))).getDy() >  -2)
//				{
//					((Ball)(objects.get(2))).setDy((int)(Math.random()*7 - 3));
//				}
//			}
//			
//
//			scoreLabels.get(1).setText("" + rightNum);
//			if(scoreLabels.get(1).getText().equals("10"))
//			{
//				((Ball)(objects.get(2))).setDy(0);
//				((Ball)(objects.get(2))).setDx(0);
//				scoreLabels.get(3).setText("I win!");
//				t1.stop();
//			}
//		}
		
		//intersection
		if(((Ball)(objects.get(2))).getBounds().intersects(((Paddle)(objects.get(0))).getBounds()))
		{
			if(((Ball)(objects.get(2))).getDx() < 0)
			{
				((Ball)(objects.get(2))).bounceY();
			}
		}
		
		//I know this will be laggy af so we should probably find a better way of doing it but I just did this for now -Riya
		//ok update in theory I think this should work but I think its so laggy that it won't even open so... -Riya
		//I'm commenting it out just for now so it atleast opens when you guys try to run it to take a look at it but heres the laggy code -Riya
//		for(int i = 0; i < bricks.size(); i ++)
//		{
//			while(((Brick)(bricks.get(i))).active())
//			{
//				if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(i))).getBounds()))
//				{
//					((Ball)(objects.get(2))).bounceY();
//					((Brick)(bricks.get(i))).kill();	
//				}
//			}
//		}
		
		//just one row of bricks to test -Riya
		//nvm its all so laggy I'm confused we'll need to figure this out together when we talk -Riya
//		while(((Brick)(bricks.get(41))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(41))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(41))).kill();	
//			}
//		}
//		while(((Brick)(bricks.get(42))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(42))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(42))).kill();	
//			}
//		}
//		while(((Brick)(bricks.get(43))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(43))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(43))).kill();	
//			}
//		}
//		while(((Brick)(bricks.get(44))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(44))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(44))).kill();	
//			}
//		}
//		while(((Brick)(bricks.get(45))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(45))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(45))).kill();	
//			}
//		}
//		while(((Brick)(bricks.get(46))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(46))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(46))).kill();	
//			}
//		}
//		while(((Brick)(bricks.get(47))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(47))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(47))).kill();	
//			}
//		}
//		while(((Brick)(bricks.get(48))).active())
//		{
//			if(((Ball)(objects.get(2))).getBounds().intersects(((Brick)(bricks.get(48))).getBounds()))
//			{
//				((Ball)(objects.get(2))).bounceY();
//				((Brick)(bricks.get(48))).kill();	
//			}
//		}
//		
		
		repaint();
	}
	
	public static void main(String[] args) 
	{
		new BrickbreakerMain();

	}

	@Override
	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
