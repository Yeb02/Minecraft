package guigue.module.movement;

import org.lwjgl.input.Keyboard;

import guigue.event.Event;
import guigue.event.listeners.EventUpdate;
import guigue.module.Module;

public class Fly extends Module{

	public Fly() {
		super("Fly", Keyboard.KEY_I, Category.MOVEMENT, false);
		
	}
	
	public void onEvent(Event e) {
		if (e instanceof EventUpdate) {
			mc.player.capabilities.isFlying = true;
		}
		
	}
	
	public void onDisable() {
		mc.player.capabilities.isFlying = false;
	}

}
