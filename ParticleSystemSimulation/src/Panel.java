import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Framework.GamePanel;

public class Panel extends GamePanel
{
	
	public boolean shift = false;
	public ArrayList<Emitter> emitters = new ArrayList<Emitter>(); 
	public int width =1200, height=900, perFrame = 1, lifetime=1; 
	
	public ArrayList<Particle> particles = new ArrayList<Particle>(); 
	Panel()
	{
		
		this.start();
	}
	@Override 
	public void paint(Graphics g)
	{
		super.paint(g);
		
		for(Emitter emit : emitters)
		{ 
			emit.update();
			emit.show(g);; 
		}
		
		
		
		

	}

	@Override
	public void update()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_SHIFT: 
			shift = true; 
			break; 
		case KeyEvent.VK_1:
			lifetime = 1; 
			break; 
		case KeyEvent.VK_3:
			lifetime=3; 
			break; 
		case KeyEvent.VK_5:
			lifetime=5; 
			break; 
		case KeyEvent.VK_DOWN:
			if(perFrame>1)
			{
				perFrame--; 
			}
			System.out.println(perFrame);
			break; 
		case KeyEvent.VK_UP:
			if(perFrame<15)
				perFrame++; 
			System.out.println(perFrame);// should maybe put a cap 
			break; 
		case KeyEvent.VK_C:
			emitters.clear();
			break; 
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SHIFT)
		{
			shift = false; 
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		emitters.add(new Emitter(e.getX(),e.getY(),perFrame,shift,lifetime,this)); 
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
