package project.Game.GameObjects;

import java.awt.Component;

import project.Game.GameUtils.Vector2;

public abstract class GameObject extends Component implements IGameObject
{
	// <Field>
	protected Vector2 position = null;
	protected String tag = null;
	protected boolean isAlive = true;
	
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
}
