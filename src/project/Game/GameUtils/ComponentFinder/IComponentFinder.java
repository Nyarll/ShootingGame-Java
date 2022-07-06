package project.Game.GameUtils.ComponentFinder;

import java.awt.Component;

/**
 * 
 * @author unlucky0314
 *
 */
public interface IComponentFinder
{
	/**
	 * 
	 * @param name : 検索対象コンポーネント名称
	 * @param recurse : 再帰的に検索をするか否か
	 * @return Component
	 */
	Component findComponent(String name, boolean recurse);
	
	/**
	 * 
	 * @param name : 検索対象コンポーネント名称
	 * @param recurse : 再帰的に検索をするか否か
	 * @return Component List
	 */
	Component[] findComponents(String name, boolean recurse);
}
