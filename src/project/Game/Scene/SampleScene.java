package project.Game.Scene;

import java.awt.Color;
import java.awt.Graphics;

public class SampleScene extends Scene
{
	public SampleScene(int width, int height)
	{
		super(width, height);
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
		
		for(int y = 0; y < 61; y++)
		{
			for(int x = 0; x < 26; x++)
			{
				g.drawString("Test", "Test".length() * 6 * x,  10 * y);
			}
		}
	}
}
