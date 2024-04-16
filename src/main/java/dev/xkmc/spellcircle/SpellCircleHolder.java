package dev.xkmc.spellcircle;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public interface SpellCircleHolder {

	@Nullable
	ResourceLocation getSpellCircle();

	float getCircleSize(float pTick);

}
