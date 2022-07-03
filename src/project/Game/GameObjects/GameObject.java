package project.Game.GameObjects;

import java.awt.Component;

import project.Game.GameUtils.Vector2;
import project.Game.GameUtils.Collider.ICollider;

public abstract class GameObject extends Component implements IGameObject
{
	// <Field>
	protected Vector2 position = null;		// オブジェクト座標
	protected String tag = null;			// タグ
	protected boolean isAlive = true;		// 生存フラグ
	protected ICollider collider = null;	// コライダー
	
	// <Method>
	
	/**
	 * デフォルトコンストラクタ
	 * 
	 */
	public GameObject()
	{
		init(new Vector2());
	}
	
	public GameObject(float _x, float _y)
	{
		init(new Vector2(_x, _y));
	}
	
	public GameObject(Vector2 vec)
	{
		init(vec);
	}
	
	protected void init(Vector2 vec)
	{
		position = vec.clone();
		this.setName("GameObject");
		tag = "GameObject";
	}
	
	// <Override>
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)	return false;
		if(obj == this)	return true;
		if(!(obj instanceof GameObject)) return false;
		GameObject b = (GameObject)obj;
		if(!this.position.equals(b.position)) return false;
		if(!this.tag.equals(b.tag)) return false;
		if(!this.collider.equals(b.collider)) return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		String result = "Name:" + this.getName() +
				", position:(" + this.position +
				"), tag:" + this.tag +
				", isAlive:" + this.isAlive +
				", collider:{" + collider + "}";
		
		return result;
	}
	
	@Override
	public GameObject clone()
	{
		GameObject result = null;
		try
		{
			result = (GameObject)super.clone();
			result.position = this.position.clone();
			result.tag = this.tag;
			result.collider = this.collider.clone();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
