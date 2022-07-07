package project.Game.Scene;

import java.awt.Component;

import javax.swing.JPanel;

import project.Game.GameObjects.GameObject;
import project.Game.GameUtils.ComponentFinder.SingletonComponentFinder;

public abstract class Scene extends JPanel implements IScene
{
	// フレームレート
	// TODO made FrameRate class
	//protected FrameRate frame_rate = new FrameRate(500);
	
	// 画面サイズ
	protected int m_width, m_height;
	
	/**
	 * コンストラクタ
	 * @param width 画面横幅
	 * @param height 画面縦幅
	 */
	public Scene(int width, int height)
	{
		this.m_width = width;
		this.m_height = height;
	}
	
	// 更新
	@Override
	public void Update()
	{
		var instance = SingletonComponentFinder.getInstance();
		GameObject player = null;
		var game_objects = instance.findComponents("GameObject", true);
		
		if(game_objects != null)
		{
			for(Component obj : game_objects)
			{
				if(obj instanceof GameObject)
				{
					((GameObject) obj).Update();

					if(((GameObject) obj).getTag() == "Player")
					{
						player = ((GameObject) obj);
					}
				}
			}
			
			for(Component obj : game_objects)
			{
				if(!((GameObject) obj).isAlive())
				{
					obj = null;
				}
			}
		}
	}
}
