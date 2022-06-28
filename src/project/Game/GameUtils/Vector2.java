package project.Game.GameUtils;


/**
 * 2D Vector class
 * @author unlucky0314
 *
 * @version 1.0.0
 * 
 * @parameter x, y
 * 
 */
public class Vector2 implements Cloneable
{
	// <Field>
	private float x = 0;
	private float y = 0;
	
	// <constant>
	public static final Vector2 up = new Vector2(0, -1);
	public static final Vector2 down = new Vector2(0, 1);
	public static final Vector2 left = new Vector2(-1, 0);
	public static final Vector2 right = new Vector2(1, 0);
	
	
	// <constructor>
	/**
	 * デフォルトコンストラクタ<br>
	 * x = 0, y = 0
	 */
	public Vector2()
	{
		x = 0;
		y = 0;
	}
	
	/**
	 * 
	 * @param _X : float
	 * @param _Y : float
	 */
	public Vector2(float _X, float _Y)
	{
		x = _X;
		y = _Y;
	}
	
	/**
	 * 
	 * @param vec : Vector2
	 */
	public Vector2(Vector2 vec)
	{
		x = vec.getX();
		y = vec.getY();
	}
	
	
	// <method>
	
	/**
	 * 
	 * @param vec
	 * @return this + vec
	 */
	public Vector2 add(Vector2 vec)
	{
		return new Vector2(this.getX() + vec.getX(), this.getY() + vec.getY());
	}
	
	/**
	 * 
	 * @param vec
	 * @return this - vec
	 */
	public Vector2 sub(Vector2 vec)
	{
		return new Vector2(this.getX() - vec.getX(), this.getY() - vec.getY());
	}
	
	/**
	 * 
	 * @param scale
	 * @return this * scale
	 */
	public Vector2 scale(float scale)
	{
		return new Vector2(this.getX() * scale, this.getY() * scale);
	}
	
	/**
	 * 
	 * @return this normalize vec
	 */
	public Vector2 normalize()
	{
		float len = this.length();
		if(len > 0)
		{
			len = 1.f / len;
		}
		return new Vector2(this.getX() * len, this.getY() * len);
	}
	
	/**
	 * 
	 * @return vector length
	 */
	public float length()
	{
		return ((float)Math.sqrt(x * x + y * y));
	}
	
	/**
	 * 
	 * @param vec
	 * @return
	 */
	public float dot(Vector2 vec)
	{
		return (this.getX() * vec.getX() + this.getY() * vec.getY());
	}
	
	/**
	 * 
	 * @param vec
	 * @return
	 */
	public float cross(Vector2 vec)
	{
		return (this.getX() * vec.getY() - vec.getX() * this.getY());
	}
	
	/**
	 * 
	 * @param rad
	 * @return
	 */
	public Vector2 rotate(float rad)
	{
		float _x = this.getX() * (float)Math.cos(rad) - this.getY() * (float)Math.sin(rad);
		float _y = this.getX() * (float)Math.sin(rad) + this.getY() * (float)Math.cos(rad);
		return new Vector2(_x, _y);
	}
	
	/**
	 * this vector angle
	 * @return
	 */
	public float angle()
	{
		return (float)Math.atan2(this.getY(), this.getX());
	}
	
	/**
	 * this vector - vec angle
	 * @param vec
	 * @return
	 */
	public float angle2(Vector2 vec)
	{
		return (float)Math.atan2(vec.getY() - this.getY(), vec.getX() - this.getX());
	}
	
	
	// <getter / setter>
	/**
	 * getter X
	 * @return x : float
	 */
	public float getX()
	{
		return x;
	}
	
	/**
	 * getter Y
	 * @return y : float
	 */
	public float getY()
	{
		return y;
	}
	
	/**
	 * setter X
	 * @param _X
	 */
	public void setX(float _X)
	{
		x = _X;
	}
	
	/**
	 * setter Y
	 * @param _Y
	 */
	public void setY(float _Y)
	{
		y = _Y;
	}
	
	/**
	 * setter X, Y
	 * @param _X
	 * @param _Y
	 */
	public void set(float _X, float _Y)
	{
		x = _X;
		y = _Y;
	}
	
	// <Override>
	
	// <equals>
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof Vector2)) return false;
		Vector2 vec = (Vector2)obj;
		if(Float.compare(this.getX(), vec.getX()) == 1)
			return false;
		if(Float.compare(this.getY(), vec.getY()) == 1)
			return false;
		
		return true;
	}
	
	// <toString>
	@Override
	public String toString()
	{
		return ("x=" + this.getX() + ", y=" + this.getY());
	}
	
	// <clone>
	@Override
	public Vector2 clone()
	{
		Vector2 result = null;
		
		try
		{
			result = (Vector2)super.clone();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}