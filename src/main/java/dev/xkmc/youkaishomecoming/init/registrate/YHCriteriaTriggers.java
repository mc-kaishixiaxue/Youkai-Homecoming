package dev.xkmc.youkaishomecoming.init.registrate;

import dev.xkmc.youkaishomecoming.init.YoukaisHomecoming;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.PlayerTrigger;

public class YHCriteriaTriggers {

	public static final PlayerTrigger SUWAKO_WEAR = CriteriaTriggers.register(new PlayerTrigger(YoukaisHomecoming.loc("suwako_wear")));
	public static final PlayerTrigger KOISHI_RING = CriteriaTriggers.register(new PlayerTrigger(YoukaisHomecoming.loc("koishi_ring")));

	private static PlayerTrigger reg(String id) {
		return CriteriaTriggers.register(new PlayerTrigger(YoukaisHomecoming.loc(id)));
	}

	public static void register() {

	}


}
