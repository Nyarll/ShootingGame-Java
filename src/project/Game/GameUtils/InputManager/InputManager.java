package project.Game.GameUtils.InputManager;

import project.Game.GameUtils.Singleton;

/**
 * <p>this class is Singleton.<br>
 * call the "Initialize()" method first.<br>
 * 
 * @author unlucky0314
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
	
	public boolean IsKeyPressed(int keyCode)
	{
		return this._keyListener.IsKeyPressed(keyCode);
	}
}

