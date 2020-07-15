package guigue.module.movement;

import org.lwjgl.input.Keyboard;

import guigue.event.Event;
import guigue.event.listeners.EventRender;
import guigue.module.Module;
import guigue.util.RenderUtils;
import guigue.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;

public class MobESP extends Module{

	public MobESP() {
		super("MobESP", Keyboard.KEY_U, Category.RENDER, false);
	}
	

	public void onEvent(Event e) {
		if (e instanceof EventRender)
			for (Object o : Minecraft.world.loadedEntityList) {
				if (o instanceof EntityLivingBase) {
					RenderUtils.entityESPBox((Entity)o, 0);
				}
				if (o instanceof EntityFallingBlock) {
					RenderUtils.entityESPBox((Entity)o, 0);
				}
			}
	}
}
