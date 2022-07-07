package project.Game.GameObjects;

import java.awt.Component;
import java.awt.Graphics;

import project.Game.GameUtils.Vector2;
import project.Game.GameUtils.Collider.ICollider;

/**
 * 
 * @author unlucky0314
 *
 */
public abstract class GameObject extends Component implements IGameObject
{
	// <Field>
	protected Vector2 m_position = null;		// オブジェクト座標
	protected String m_tag = null;			// タグ
	protected boolean m_isAlive = true;		// 生存フラグ
	protected ICollider m_collider = null;	// コライダー
	
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
		m_position = vec.clone();
		this.setName("GameObject");
		m_tag = "GameObject";
	}
	
	@Override
	public abstract void Update();
	
	@Override
	public abstract void Render(Graphics g);
	
	public String getTag()
	{
		return m_tag;
	}
	
	public boolean isAlive()
	{
		return m_isAlive;
	}
	
	// <Override>
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)	return false;
		if(obj == this)	return true;
		if(!(obj instanceof GameObject)) return false;
		GameObject b = (GameObject)obj;
		if(!this.m_position.equals(b.m_position)) return false;
		if(!this.m_tag.equals(b.m_tag)) return false;
		if(!this.m_collider.equals(b.m_collider)) return false;
		
		return true;
	}
	
	@Override
	public String toString()
	{
		String result = "Name:" + this.getName() +
				", position:(" + this.m_position +
				"), tag:" + this.m_tag +
				", isAlive:" + this.m_isAlive +
				", collider:{" + m_collider + "}";
		
		return result;
	}
	
	@Override
	public GameObject clone()
	{
		GameObject result = null;
		try
		{
			result = (GameObject)super.clone();
			result.m_position = this.m_position.clone();
			result.m_tag = this.m_tag;
			result.m_collider = this.m_collider.clone();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
