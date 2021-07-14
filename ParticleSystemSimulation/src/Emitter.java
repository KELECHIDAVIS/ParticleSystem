import java.awt.Graphics;
import java.util.ArrayList;

public class Emitter
{
	public int amount, increment; 
	public Vector pos; 
	public ArrayList<Particle> particles = new ArrayList<Particle>(); 
	public boolean shower = false; 
	private Panel panel; 
	Emitter(int x , int y	, int amount,boolean shower,int increment,Panel panel)
	{
		this.pos = new Vector(x,y); 
		this.amount = amount; 
		this.panel = panel; 
		this.shower = shower; 
		this.increment = increment; 
	}
	
	public void update()	
	{
		for(int i =0; i<amount; i++)
		{
			particles.add(new Particle(this.pos.x,this.pos.y, this.shower,this.increment,this.panel)); 
		}
		for(Particle part:particles)
		{
			if(!part.finished)
			{
				Vector gravity = new Vector(0.0,.004); 

				part.applyForces(gravity);
				part.update(); 
				part.edges();
				
			}
			
		}
		for(int i = particles.size()-1; i>=0; i--	)
		{
			if(particles.get(i).finished)
			{
				particles.remove(i); 
				
			}
			
		}
		//System.out.println(particles.size());
	}
	public void show(Graphics g)	
	{
		for(Particle part:particles)
		{
			if(!part.finished)
			{
				part.show(g);
				
			}
			
		}
	}

}
