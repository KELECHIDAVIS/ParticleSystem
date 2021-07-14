import java.util.Random;

public class Vector
{
	public double x=0, y=0, z=0; 
	public Vector()
	{
		
	}
	public Vector(double x , double y)
	{
		this.x = x; 
		this.y= y; 
		
	}
	public Vector(double x,double y,double z)
	{
		this.x = x; 
		this.y= y; 
		this.z = z; 
	}
	
	public void add(double scalar ) //scalar 
	{
		this.x +=scalar; 
		this.y+=scalar; 
		this.z+= scalar; 
		
	}
	public static Vector add(Vector first , Vector second ) // two vectors 
	{
		Vector result = new Vector(); 
		result.x = first.x+second.x; 
		result.y = first.y+second.y; 
		result.z = first.z+second.z; 
		
		return result; 
		
	}
	public  void add( Vector second ) // two vectors 
	{
		
		 this.x+=second.x; 
		this.y+=second.y; 
		this.z+=second.z; 
		
		
		
	}
	public void sub(double scalar ) //scalar 
	{
		this.x -=scalar; 
		this.y-=scalar; 
		this.z-= scalar; 
		
	}
	public void mult(double scalar ) //scalar 
	{
		this.x *=scalar; 
		this.y*=scalar; 
		this.z*= scalar; 
		
	}
	public static Vector sub(Vector first , Vector second ) // two vectors 
	{
		Vector result = new Vector(); 
		result.x = first.x-second.x; 
		result.y = first.y-second.y; 
		result.z = first.z-second.z; 
		
		return result; 
		
	}
	/**
     * Gives the length of the vector
     */
    public double modulus() {
        return Math.hypot(x, Math.hypot(y, z));
    }
    /**
     * Check if two vectors are parallel or not
     */
    public boolean isParallel(Vector v) {
        if (modulus() == 0 || v.modulus() == 0) {
            return true;
        }
        if ((x == 0) != (v.x == 0) || (y == 0) != (v.y == 0) || (z == 0) != (v.z == 0)) {
            return false;
        }
        double ratio = 0;
        if (x != 0) {
            ratio = v.x / x;
        }
        if (y != 0) {
            if (ratio == 0) {
                ratio = v.y / y;
            } else {
                if (v.y / y != ratio) {
                    return false;
                }
            }
        }
        if (z != 0) {
            if (ratio != 0 && v.y / y != ratio) {
                return false;
            }
        }
        return true;
    }
    public Vector unit() {
        double mod = modulus();
        if (mod == 0 || mod == 1) {
            return this;
        }
        return new Vector(x / mod, y / mod, z / mod);
    }

	  /**Computes and return the dot product between two vector*/
    /**
     * Computes and returns the dot product between two vector
     */
    public double dot(Vector v) {
        return x * v.x + y * v.y + z * v.z;
    }
	    
	    /**
	     * Compute and returns the angle between two vectors in radians
	     */
	    public double angle(Vector v) {
	        double dotPro = dot(v);
	        double modObj = modulus();
	        double modV = v.modulus();
	        double angle = Math.acos(dotPro / (modObj * modV));
	        return angle;
	    }
	    /**
	     * Computes and returns the cross product of the two vector
	     */
	    public Vector cross(Vector v) {
	        double resx = (y * v.z) - (v.y * z);
	        double resy = -((x * v.z) - (v.x * z));
	        double resz = (x * v.y) - (v.x * y);
	        return new Vector(resx, resy, resz);
	    }
	    
	    public static Vector random2D()
	    {
	    	Vector random = new Vector(); 
	    	Random rand = new Random(); 
	    	double f = rand.nextFloat()*2-1; 
	    	double s = rand.nextFloat()*2-1; 
	    	
	    	random.x = f; 
	    	random.y = s; 
	    	
	    	
	    	return random; 
	    }
}
