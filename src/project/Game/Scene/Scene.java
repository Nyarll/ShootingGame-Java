package project.Game.Scene;

import javax.swing.JPanel;

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
		
	}
}
