package project.Game.GameUtils.Collider;

import project.Game.GameUtils.Vector2;

public class CircleCollider implements ICollider
{
	// <Field>
	private Vector2 center;		// 中心点
	private float radius;		// 半径
	
	private boolean isHit = false;
	
	public CircleCollider(float radius)
	{
		this.radius = radius;
	}
	
	@Override
	public boolean isHit()
	{
		return this.isHit;
	}
	
	@Override
	public void onCollision(ICollider other)
	{
		this.isHit = false;
		if(other == null)
			return;
		if(other == this)
			return;
		
		if(other instanceof CircleCollider)
			this.isHit = onCollisionEnter((CircleCollider)other);
	}
	
	private boolean onCollisionEnter(CircleCollider other)
	{
		float hl = this.radius + other.getRadius();
		float xl = this.center.getX() - other.getCenter().getX();
		float yl = this.center.getY() - other.getCenter().getX();
		
		if(hl * hl >= xl * xl + yl * yl)
			return true;
		
		return false;
	}
	
	public Vector2 getCenter()
	{
		return this.center;
	}
	
	public float getRadius()
	{
		return this.radius;
	}
	
	@Override
	public String toString()
	{
		String result = "center:(" + this.center + "), radius:" + radius +
				", isHit:" + isHit;
		
		return result;
	}
	
	@Override
	public ICollider clone()
	{
		CircleCollider result = null;
		
		try
		{
			result = (CircleCollider)super.clone();
			result.center = this.center.clone();
			result.radius = this.radius;
			result.isHit = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
