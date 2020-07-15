package guigue.module;

import guigue.event.Event;
import net.minecraft.client.Minecraft;

public class Module {
	
	public String name;
	public boolean toggled;
	public int keyCode;
	public Category category;
	public Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, int key, Category category, boolean toggleDefault) {
		
		this.name = name;
		this.keyCode = key;
		this.category = category;
		this.toggled = toggleDefault;
		
	}
	
	public boolean isEnabled() {
		return toggled;
	}
	
	public int getKey() {
		return keyCode;
	}
	
	public void toggle() {
		toggled = !toggled;
		if (toggled) {
			onEnable();
			
		}else{
			onDisable();
			
		}
	}
	
	public void onEnable() {
		
	}
	
	public void onDisable() {
		
	}
	
	public enum Category{
		COMBAT,
		MOVEMENT,
		PLAYER,
		RENDER;
	}
	
	public void onEvent(Event e) {
		
		
	}
	
	
}
