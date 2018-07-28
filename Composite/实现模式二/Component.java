package com.yangfan.patterns.composite2;

import java.util.List;

public interface Component
{
	public void doSomething();
	
	public void add(Component component);
	
	public void remove(Component component);
	
	public List<Component> getAll();
}
