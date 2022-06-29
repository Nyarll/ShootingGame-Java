package project.Game.GameUtils.Collider;

public interface ICollider
{
	void onCollision(ICollider other);
	
	boolean isHit();
}
