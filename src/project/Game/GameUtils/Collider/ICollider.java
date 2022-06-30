package project.Game.GameUtils.Collider;

public interface ICollider extends Cloneable
{
	void onCollision(ICollider other);
	
	boolean isHit();
	
	ICollider clone();
}
