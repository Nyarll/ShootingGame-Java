package project.Game.GameObjects;

import java.awt.Graphics;

public interface IGameObject extends Cloneable
{
	void Update();
	void Render(Graphics g);
}
