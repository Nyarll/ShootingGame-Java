package project.Game;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.Game.Scene.SampleScene;

/**
 * 
 * @author unlucky0314
 *
 */
public class Game
{
	private String title;
	private String version = "";
	
	private int width = 0;
	private int height = 0;
	
	JsonNode config = null;
	
	public Game()
	{
		importConfig("./config/config.json");
		var game_window = new GameWindow(title + " " + version, width, height);
		
		game_window.change(new SampleScene(width, height));
		game_window.setVisible(true);
		
		game_window.run();
	}
	
	private void importConfig(String config_path)
	{
		Path path = Paths.get(config_path);
		
		ObjectMapper obj_mapper = new ObjectMapper();
		
		try
		{
			config = obj_mapper.readTree(path.toFile());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		settingConfig();
	}
	
	private void settingConfig()
	{
		JsonNode windowConfig = config.get("GameWindowConfig");
		this.title = windowConfig.get("title").asText();
		this.version = windowConfig.get("version").asText();
		this.width = windowConfig.get("width").asInt();
		this.height = windowConfig.get("height").asInt();
	}
}
