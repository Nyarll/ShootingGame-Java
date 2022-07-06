package project.Game.GameUtils.ComponentFinder;

import java.awt.Container;

import project.Game.GameUtils.Singleton;

public class SingletonComponentFinder extends DefaultComponentFinder implements Singleton
{
	private static SingletonComponentFinder _instance;
	
	private SingletonComponentFinder(Container container)
	{
		super(container);
	}
	
	public static void Initialize(Container container)
	{
		if(_instance == null)
		{
			_instance = new SingletonComponentFinder(container);
		}
	}
	
	public static IComponentFinder getInstance()
	{
		if(_instance == null)
		{
			throw new IllegalStateException("初期化がされていません. init()を使用して初期化をしてください.");
		}
		return _instance;
	}
}
