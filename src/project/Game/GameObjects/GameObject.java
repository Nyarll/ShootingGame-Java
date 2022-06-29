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
	
	public GameObject()
	{
		init(new Vector2(0, 0));
	}
	
	public GameObject(float _x, float _y)
	{
		init(new Vector2(_x, _y));
	}
	
	public GameObject(Vector2 vec)
	{
		init(vec);
	}
	
	private void init(Vector2 vec)
	{
		position = vec.clone();
		this.setName("GameObject");
		tag = "GameObject";
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
			result.collider = this.collider;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
