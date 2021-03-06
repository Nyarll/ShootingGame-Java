package project.Game.GameUtils.ComponentFinder;

import java.awt.Component;
import java.awt.Container;

import javax.swing.RootPaneContainer;

public class DefaultComponentFinder implements IComponentFinder
{
	// 基点コンテナオブジェクト
	private Container _container;
	
	public DefaultComponentFinder(Container container)
	{
		this._container = container;
	}
	
	
	@Override
	/**
	 * @param name : 検索したいコンポーネント名
	 * @param recurse : 再帰的に検索するか否か
	 */
	public Component findComponent(String name, boolean recurse)
	{
		if(name == null || name.trim().equals(""))
		{
			throw new IllegalArgumentException("The value of \"name\" is invalid.");
		}
		Component result = null;
		if(_container instanceof RootPaneContainer)
		{
			result = findComponent(((RootPaneContainer)_container).getContentPane(), name, recurse);
		}
		else
		{
			result = findComponent(_container, name, recurse);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param current
	 * @param name
	 * @param recurse
	 * @return component
	 */
	protected Component findComponent(Container current, String name, boolean recurse)
	{
		Component result = null;
		for(Component component : current.getComponents())
		{
			if(component.getName().equals(name))
			{
				result = component;
				break;
			}
			if((component instanceof Container) && recurse)
			{
				Component temp = findComponent((Container)component, name, recurse);
				if(temp != null)
				{
					result = temp;
					break;
				}
			}
		}
		return result;
	}
	
	@Override
	public Component[] findComponents(String name, boolean recurse)
	{
		if(name == null || name.trim().equals(""))
		{
			throw new IllegalArgumentException("The value of \"name\" is invalid.");
		}
		Component[] result = null;
		
		if(_container instanceof RootPaneContainer)
		{
			result = findComponents(((RootPaneContainer)_container).getContentPane(), name, recurse);
		}
		else
		{
			result = findComponents(_container, name, recurse);
		}
		
		return result;
	}
	
	
	static final private int TEMP_COMPONENTS_SIZE = 100;
	
	protected Component[] findComponents(Container current, String name, boolean recurse)
	{
		Component[] result = new Component[TEMP_COMPONENTS_SIZE];
		boolean isExist = false;
		
		var components = current.getComponents();
		int component_count = 0;
		
		for(int i = 0; i < components.length; i++)
		{
			if(components[i] == null)
			{
				continue;
			}
			if(components[i].getName().equals(name))
			{
				result[component_count] = components[i];
				component_count++;
				isExist = true;
				if(result.length <= component_count)
				{
					result = remakeComponents(result, result.length + TEMP_COMPONENTS_SIZE);
				}
			}
			if((components[i] instanceof Container) && recurse)
			{
				Component[] work = findComponents((Container)components[i], name, recurse);
				if(work != null)
				{
					isExist = true;
					for(var value : work)
					{
						result[component_count] = value;
						component_count++;
						if(result.length <= component_count)
						{
							System.out.println(result.length + ", " + component_count);
							result = remakeComponents(result, result.length + TEMP_COMPONENTS_SIZE);
						}
					}
				}
			}
		}
		
		if(!isExist)
		{
			result = null;
		}
		else
		{
			result = remakeComponents(result, component_count);
		}
		
		return result;
	}
	
	private Component[] remakeComponents(Component[] original, int remake_size)
	{
		Component[] remake = new Component[remake_size];

		if(original.length < remake_size)
		{
			for(int i = 0;i < original.length; i++)
			{
				remake[i] = original[i];
			}
		}
		else
		{
			for(int i = 0;i < remake_size; i++)
			{
				remake[i] = original[i];
			}
		}
		return remake;
	}
}
