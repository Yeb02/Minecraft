package guigue.module.movement;

import java.util.LinkedList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import guigue.Client;
import guigue.event.Event;
import guigue.event.listeners.EventMotion;
import guigue.event.listeners.EventPostedToChat;
import guigue.event.listeners.EventRender;
import guigue.event.listeners.EventUpdate;
import guigue.module.Module;
import guigue.util.RenderUtils;
import guigue.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

public class GuigueMain extends Module{

	public GuigueMain() {
		super("Pathfinder", Keyboard.KEY_P, Category.MOVEMENT, false);	
	}
	
	public Timer timer = new Timer();
	
	public void onEvent(Event e) {
		if (e instanceof EventPostedToChat) {
			if (mc.ingameGUI.getChatGUI().getChatOpen() == true) {System.out.println("ouvert");}
		}
		
		if (e instanceof EventRender) {
			String destination = String.valueOf(mc.objectMouseOver.entityHit.getPosition().getX());
			mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation(destination, new Object[0]));
			Entity destination2 = mc.objectMouseOver.entityHit;
			RenderUtils.entityESPBox(destination2, 0);
		}

		
		if (e instanceof EventUpdate) {
			if (e.isPre()) {
				Client.onSendChatMessage(); 	
				mc.player.movementInput.jump = true;
				mc.player.movementInput.moveStrafe = 1F;
				mc.player.movementInput.updatePlayerMoveState();
				//String destination = String.valueOf(mc.objectMouseOver.entityHit.getPosition().getX());
				//mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation(destination, new Object[0]));
				//if (mc.ingameGUI.getChatGUI().getChatOpen() == true) {System.out.println("ouvert");}  //Fonctionne
			}
			
		}
		if (e instanceof EventMotion) {
			if (e.isPre()) {
				EventMotion event = (EventMotion)e;
				mc.player.movementInput.jump = true;
				mc.player.movementInput.moveStrafe = 1F;
				mc.player.movementInput.updatePlayerMoveState();
				//if (timer.hasTimeElapsed(10, true)) {
					//mc.thePlayer.movementInput.moveForward = 1;
					//mc.thePlayer.motionX = -.2F * Math.sin(Math.toRadians((double)mc.thePlayer.getRotationYawHead()));
					//mc.thePlayer.motionZ = .2F * Math.cos(Math.toRadians((double)mc.thePlayer.getRotationYawHead()));
					//BlockPos destination = mc.objectMouseOver.getBlockPos();
					//mc.playerController.clickBlock(destination, mc.objectMouseOver.sideHit);
					if (!mc.player.isPushedByWater()) {mc.player.movementInput.jump = true;}
					//mc.player.moveToBlockPosAndAngles(destination, 90, 90);
					mc.player.movementInput.forwardKeyDown = true;
					
				//}
				
			}
		}
	}
	
	public void onEnable() {
		////mc.player.sendChatMessage("/gamemode 0");
		//// mc.skipRenderWorld = !mc.skipRenderWorld;   //permet de ne pas afficher, tres pratique pour multibot
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("Guigue enabled", new Object[0]));
	}
	
	public void onDisable() {
		mc.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("Guigue disabled", new Object[0]));
	}

}