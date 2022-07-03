package project.Game.GameUtils.InputManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.Game.GameUtils.Singleton;

/**
 * <p>this class is Singleton.<br>
 * call the "Initialize()" method first.<br>
 * 
 * @author USER
 *
 */
public final class InputManager implements Singleton
{
	private static InputManager _instance = null;
	
	private InputKeyboardManager _keyListener = null;
	
	/**
	 * コンストラクタ
	 */
	private InputManager()
	{
		_keyListener = new InputKeyboardManager();
	}
	
	public static void Initialize()
	{
		if(_instance == null)
		{
			_instance = new InputManager();
		}
	}
	
	public static InputManager getInstance()
	{
		if(_instance == null)
		{
			_instance = new InputManager();
		}
		return _instance;
	}
	
	public InputKeyboardManager getKeyboard()
	{
		return _keyListener;
	}
}

class InputKeyboardManager implements KeyListener
{
	private boolean isPressedAnyKay = false;

	private boolean[] isKeyPressed = new boolean[KeyEvent.KEY_LAST];
	
	public InputKeyboardManager()
	{
		super();
		for(int i = 0; i < isKeyPressed.length; i++)
		{
			isKeyPressed[i] = false;
		}
	}
	
	public boolean IsKeyPressed(int keyCode)
	{
		if(keyCode > KeyEvent.KEY_LAST)
			return false;

		return isKeyPressed[keyCode];
	}
	
	// 押したとき
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(!isPressedAnyKay)
		{
			isPressedAnyKay = true;
		}
		isKeyPressed[e.getKeyCode()] = true;
	}

	// 押されている間
	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	// 離したとき
	@Override
	public void keyReleased(KeyEvent e)
	{
		if(isPressedAnyKay)
		{
			isPressedAnyKay = false;
		}
		isKeyPressed[e.getKeyCode()] = false;
	}
}