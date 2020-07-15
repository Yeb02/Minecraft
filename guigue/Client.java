package guigue;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.opengl.Display;

import guigue.command.*;
import guigue.event.Event;
import guigue.module.Module;
import guigue.module.movement.Fly;
import guigue.module.movement.MobESP;
import guigue.module.movement.GuigueMain;
import guigue.module.movement.QuickHit;
import guigue.module.movement.QuickSet;
import guigue.module.movement.Sprint;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.TextComponentTranslation;

public class Client {
	public static String name = "gigue", version = "0.1";
	public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
	private static CommandManager cmdManager = new CommandManager();
	public static int lastSize = 0;
	
	public static void Startup(){
		
		System.out.println("Starting " + name + " v." + version);
		Display.setTitle(name + " v " + version);
		modules.add(new Fly());
		modules.add(new GuigueMain());
		modules.add(new QuickSet());
		modules.add(new QuickHit());
		modules.add(new Sprint());
		modules.add(new MobESP());
		
		CommandManager commandList = new CommandManager();
		commandList.AddCommand(new CommandGoThere());
	}
	
	
	public static void onEvent(Event e) {
		for (Module m : modules) {
			if (m.toggled) {m.onEvent(e);}
		}
		
	}
	
	public static void onKeyPress(int key) {
		for (Module m : modules) {
			if (m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	/** returns the last post of the player to the chat */
	public static String lastPost() {
		List<String> u = Minecraft.ingameGUI.getChatGUI().getSentMessages();
		int sizeNow = u.size();
		if (sizeNow > lastSize) {
			lastSize = sizeNow;
			return u.get(sizeNow - 1);	
		}
		else {
			return "";
		}
	}
	
	public static void addChatMessage(String message) {
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("Guigue: " + message, new Object[0]));
	}
	
	
	public static boolean onSendChatMessage() {
		String s = Client.lastPost();
		if (s.startsWith(";")) {
			cmdManager.CallCommand(s.substring(1));
			return false;
		}
		return true;
	}
	
	public static boolean onReceiveChatMessage(SPacketChat packet) {
		return true;
	}
	

}
