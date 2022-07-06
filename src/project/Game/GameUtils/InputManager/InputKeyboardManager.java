package project.Game.GameUtils.InputManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeyboardManager implements KeyListener
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