package guigue.module.movement;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import guigue.event.Event;
import guigue.event.listeners.EventMotion;
import guigue.module.Module;
import guigue.util.Timer;
import net.minecraft.util.text.TextComponentTranslation;

public class QuickHit extends Module{

	public QuickHit() {
		super("QuickHit", Keyboard.KEY_R, Category.MOVEMENT, false);	
	}
	
	public Timer timer = new Timer();
	
	public void onEvent(Event e) {
		if (e instanceof EventMotion) {
			if (e.isPre()) {
				EventMotion event = (EventMotion)e;
				if (timer.hasTimeElapsed(10, true)) {
						boolean k = Mouse.isButtonDown(0);
				}
			}
		}
	}
	
	public void onEnable() {
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("QuickHit enabled", new Object[0]));
	}
	
	public void onDisable() {
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("QuickHit disabled", new Object[0]));
	}
}