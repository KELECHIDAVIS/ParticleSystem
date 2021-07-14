import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Particle 
{
	public Random rand = new Random(); 
	public Panel panel ; 
	public Vector acc = new Vector(), velocity = new Vector() , pos; 
	boolean finished = false; 
	public int r = 8, lifetime =255, increment; // size; transparency 

	Particle(double x, double y ,boolean shower ,int increment,  Panel panel)
	{
		this.velocity = Vector.random2D(); 
		if(shower)
		{
			this.velocity.mult(rand.nextInt(5-2)+2);
		}
		this.increment = increment; 
		this.pos = new Vector(x,y); 
		this.panel = panel; 
	}
	
	public void applyForces(Vector force) 
	{
		this.acc.add(force); 
	}
	
	
	public void edges()	
	{
		if(this.pos.y+64>= panel.height	)
		{
			this.pos.y = panel.height-64; 
			this.velocity.y *=-1; 
		}
		if(this.pos.x+64>= panel.width	)
		{
			this.pos.x = panel.width-64; 
			this.velocity.x *=-1; 
		}
		else if(this.pos.x<= 0	)
		{
			this.pos.x = 0; 
			this.velocity.x *=-1; 
		}
		
	}
	
	
	public void update()
	{
		
		this.velocity.add(this.acc); 
		this.pos.add(this.velocity); 
		
		if(this.lifetime>1)
		{
			this.lifetime-=increment;  // change this by increments of a number that divides into 255 to change lifetime of each particles
		}else
		{
			finished = true; 
		}
		
		
	}
	
	public void show(Graphics g )
	{
		g.setColor(new Color(255,255,255,this.lifetime));
		
		g.fillOval((int)this.pos.x, (int)this.pos.y, r, r);
	}
}
