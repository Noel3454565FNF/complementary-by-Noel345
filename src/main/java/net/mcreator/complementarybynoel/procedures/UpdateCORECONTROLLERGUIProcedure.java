package net.mcreator.complementarybynoel.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.complementarybynoel.network.ComplementaryByNoel345ModVariables;

import java.util.HashMap;

public class UpdateCORECONTROLLERGUIProcedure {
	public static void execute(LevelAccessor world, HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.get("text:label_coretemp") instanceof EditBox _tf)
			_tf.setValue(("" + ComplementaryByNoel345ModVariables.MapVariables.get(world).CORE_TEMPERATURE));
		if (guistate.get("text:label_power") instanceof EditBox _tf)
			_tf.setValue(("" + ComplementaryByNoel345ModVariables.MapVariables.get(world).CORE_TEMPERATURE));
	}
}
