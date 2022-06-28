package project.Game;

/**
 * 
 * @author unlucky0314
 *
 */
public class Game
{
	static final String version = "0.0.1 - develop";
	
	static final int width = 640;
	static final int height = 640;
	
	public Game()
	{
		var game_window = new GameWindow("GameWindow " + version, width, height);
		
		game_window.setVisible(true);
		
		game_window.run();
	}
}
