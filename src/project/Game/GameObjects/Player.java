package project.Game.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import project.Game.GameUtils.Vector2;
import project.Game.GameUtils.InputManager.InputManager;

public class Player extends GameObject
{
	
	private Vector2 m_velocity;
	private Vector2 old_position;
	
	public Player()
	{
		super();
		this.m_tag = "Player";
	}
	
	public Player(float _X, float _Y)
	{
		super(_X, _Y);
		this.m_tag = "Player";
	}
	
	@Override
	public void Update()
	{
		Move();
		
		if((m_position.getX() < 0) || (m_position.getX() > 640 - 20))
		{
			m_velocity.setX(-m_velocity.getX());
			m_position = old_position;
		}
		if((m_position.getY() < 0) || (m_position.getY() > 640 - 20 * 2))
		{
			m_velocity.setY(-m_velocity.getY());
			m_position = old_position;
		}
		
		old_position = m_position.clone();
		m_position = m_position.add(m_velocity);
	}
	
	private void Move()
	{
		var keyboard = InputManager.getInstance();
		m_velocity = new Vector2();
		
		Vector2 direction = new Vector2();
		
		final float speed = 2.5f;
		float movement_speed = speed;
		
		if(keyboard.IsKeyPressed(KeyEvent.VK_LEFT))
		{
			direction.setX(-1);
		}
		else if(keyboard.IsKeyPressed(KeyEvent.VK_RIGHT))
		{
			direction.setX(1);
		}

		if(keyboard.IsKeyPressed(KeyEvent.VK_UP))
		{
			direction.setY(-1);
		}
		else if(keyboard.IsKeyPressed(KeyEvent.VK_DOWN))
		{
			direction.setY(1);
		}

		if(keyboard.IsKeyPressed(KeyEvent.VK_SHIFT))
		{
			movement_speed = speed / 2;
		}

		m_velocity = direction.normalize().scale(movement_speed);
	}
	
	@Override
	public void Render(Graphics g)
	{
		g.setColor(Color.CYAN);

		int x = (int)m_position.getX();
		int y = (int)m_position.getY();

		g.fillPolygon(new int[] {x, x + 10, x - 10}, new int[] {y - 12, y + 12, y + 12}, 3);
	
	}
}
