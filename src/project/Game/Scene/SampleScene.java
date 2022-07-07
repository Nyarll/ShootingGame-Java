package project.Game.Scene;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import project.Game.GameObjects.GameObject;
import project.Game.GameObjects.Player;
import project.Game.GameUtils.ComponentFinder.SingletonComponentFinder;

public class SampleScene extends Scene
{
	public SampleScene(int width, int height)
	{
		super(width, height);
		
		this.add(new Player(width / 2, height / 2));
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// 背景
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.m_width, this.m_height);
		
		// fps
		g.setColor(Color.WHITE);
		// frame_rate.process();
		// g.drawString((frame_rate.getFrameRate() / 3.f) + "fps", 0, 10);
		
		var instance = SingletonComponentFinder.getInstance();
		var objects = instance.findComponents("GameObject", true);
		
		if(objects != null)
		{
			for(Component obj : objects)
			{
				((GameObject) obj).Render(g);
			}
		}
	}
}
