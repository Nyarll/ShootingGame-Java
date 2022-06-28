package project;

import project.GameUtils.Vector2;

public class Main 
{
	public static void main(String[] args) 
	{
		Vector2 vec1 = new Vector2(4, 8);
		Vector2 vec2 = vec1.clone();
		
		System.out.println(vec1);
		System.out.println(vec2);
		
		vec1.set(1, 2);
		
		System.out.println(vec1);
		System.out.println(vec2);
		
		vec1 = vec1.add(vec2);
		
		System.out.println(vec1);
		System.out.println(vec2);
		
		vec1 = vec1.rotate((float)Math.toRadians(30));
		
		System.out.println(vec1);
		System.out.println(vec2);
	}

}
