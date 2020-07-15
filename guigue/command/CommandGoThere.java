package guigue.command;

import guigue.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;

public class CommandGoThere extends Command{

	public String getAlias() {
		return "GOTO";
	}

	public String getDescription() {
		return "Go where the player looks. Can't be the moon.";
	}

	@Override
	public String getSyntax() {
		return "GOTO";
	}

	
	public void onCommand(String[] args) throws Exception {
		BlockPos destination = Minecraft.objectMouseOver.getBlockPos();
		RenderUtils.entityESPBox(Minecraft.objectMouseOver.entityHit, 0);
	}

}
