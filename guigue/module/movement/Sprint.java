package guigue.module.movement;

import org.lwjgl.input.Keyboard;

import guigue.event.Event;
import guigue.event.listeners.EventMotion;
import guigue.module.Module;
import guigue.util.Timer;

import net.minecraft.util.text.TextComponentTranslation;

public class Sprint extends Module{

	public Sprint() {
		super("Sprint", Keyboard.KEY_O, Category.MOVEMENT, false);	
	}
	
	public Timer timer = new Timer();
	
	public void onEvent(Event e) {
		if (e instanceof EventMotion) {
			if (e.isPre()) {
				EventMotion event = (EventMotion)e;
				if (timer.hasTimeElapsed(10, true)) {
					mc.player.setSprinting(true);
				}
			}
		}
	}
	
	public void onEnable() {
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("Sprint enabled", new Object[0]));
	}
	
	public void onDisable() {
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("Sprint disabled", new Object[0]));
		mc.player.setSprinting(false);
	}
}