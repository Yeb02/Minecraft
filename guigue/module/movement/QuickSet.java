package guigue.module.movement;

import org.lwjgl.input.Keyboard;

import guigue.event.Event;
import guigue.event.listeners.EventMotion;
import guigue.module.Module;
import guigue.util.Timer;

import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.event.ClickEvent;

public class QuickSet extends Module{

	public QuickSet() {
		super("QuickSet", Keyboard.KEY_F, Category.MOVEMENT, false);	
	}
	
	public Timer timer = new Timer();
	
	public void onEvent(Event e) {
		if (e instanceof EventMotion) {
			if (e.isPre()) {
				EventMotion event = (EventMotion)e;
				if (timer.hasTimeElapsed(10, true)) {
						
				}
			}
		}
	}
	
	public void onEnable() {
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("QuickSet enabled", new Object[0]));
	}
	
	public void onDisable() {
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("QuickSet disabled", new Object[0]));
	}
}