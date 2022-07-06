package project.Game;

import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import project.Game.GameUtils.ComponentFinder.SingletonComponentFinder;
import project.Game.GameUtils.InputManager.InputManager;
import project.Game.Scene.IScene;

/**
 * GameWindow class : main window<br>
 * extends JFrame<br>
 * implements Runnable<br>
 * 
 * @author unlucky0314
 *
 */
public class GameWindow extends JFrame implements Runnable
{
	/**
	 * 
	 * @param title	: window title
	 * @param width	: window width
	 * @param height	: window height
	 */
	public GameWindow(String title, int width, int height)
	{
		// <Main Window Initialize>
		super(title);	// JFrameクラスのコンストラクタ
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	
		
		this.setName("GameWindow");
		
		InputManager.Initialize();
		this.addKeyListener(InputManager.getInstance().getKeyboard());
		
		SingletonComponentFinder.Initialize(this);
	}
	
	/**
	 * Sceme Change
	 * @param panel
	 */
	public synchronized void change(JPanel panel)
	{
		this.getContentPane().removeAll();
		Insets inset = getInsets();
		panel.setBounds(-inset.left, -inset.top, this.getWidth(), this.getHeight());
		panel.setName("ActiveScene");
		super.add(panel);
		this.validate();
		this.repaint();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				if(InputManager.getInstance().IsKeyPressed(KeyEvent.VK_ESCAPE))
				{
					System.out.println("[ESCAPE] Game Exit.");
					break;
				}
				
				var instance = SingletonComponentFinder.getInstance();
				IScene activeScene = (IScene)instance.findComponent("ActiveScene", true);
				
				activeScene.Update();
				
				this.repaint();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
}
