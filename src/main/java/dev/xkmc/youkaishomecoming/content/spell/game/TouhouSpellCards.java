package dev.xkmc.youkaishomecoming.content.spell.game;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.init.InitItems;
import dev.xkmc.youkaishomecoming.content.entity.fairy.CirnoEntity;
import dev.xkmc.youkaishomecoming.content.entity.youkai.GeneralYoukaiEntity;
import dev.xkmc.youkaishomecoming.content.entity.youkai.MaidenEntity;
import dev.xkmc.youkaishomecoming.content.spell.game.cirno.CirnoIceStorm;
import dev.xkmc.youkaishomecoming.content.spell.game.koishi.KoishiTest;
import dev.xkmc.youkaishomecoming.content.spell.game.reimu.StagedHoming;
import dev.xkmc.youkaishomecoming.content.spell.game.youmu.YoumuSlash;
import dev.xkmc.youkaishomecoming.content.spell.game.yukari.DoubleButterfly;
import dev.xkmc.youkaishomecoming.content.spell.game.yukari.LightHole;
import dev.xkmc.youkaishomecoming.content.spell.game.yuyuko.YuyukoTest;
import dev.xkmc.youkaishomecoming.content.spell.spellcard.ListSpellCard;
import dev.xkmc.youkaishomecoming.content.spell.spellcard.SpellCard;
import dev.xkmc.youkaishomecoming.content.spell.spellcard.SpellCardWrapper;
import dev.xkmc.youkaishomecoming.init.registrate.YHItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class TouhouSpellCards {

	private static final Map<String, Supplier<SpellCard>> MAP = new ConcurrentHashMap<>();

	public static void registerSpell(String id, Supplier<SpellCard> card) {
		MAP.put(id, card);
	}

	public static void registerSpells() {
		registerSpell("touhou_little_maid:yukari_yakumo", () -> ListSpellCard.of(new LightHole(), new DoubleButterfly()));
		registerSpell("touhou_little_maid:hakurei_reimu", () -> ListSpellCard.of(new StagedHoming()));
		registerSpell("touhou_little_maid:komeiji_koishi", () -> ListSpellCard.of(new KoishiTest()));
		registerSpell("touhou_little_maid:konpaku_youmu", () -> ListSpellCard.of(new YoumuSlash()));
		registerSpell("touhou_little_maid:saigyouji_yuyuko", () -> ListSpellCard.of(new YuyukoTest()));
		registerSpell("touhou_little_maid:cirno", () -> ListSpellCard.of(new CirnoIceStorm()));
	}

	public static void setSpell(GeneralYoukaiEntity e, String id) {
		e.spellCard = new SpellCardWrapper();
		e.spellCard.modelId = id;
		var sup = MAP.get(id);
		if (sup != null) e.spellCard.card = sup.get();
		e.syncModel();
		var rl = new ResourceLocation(id);
		var name = Component.translatable(rl.toLanguageKey("model") + ".name");
		var desc = Component.translatable(rl.toLanguageKey("model") + ".desc");
		e.setCustomName(name.append(" - ").append(desc));
	}

	public static void setReimu(MaidenEntity e) {
		setSpell(e, "touhou_little_maid:hakurei_reimu");
		if (ModList.get().isLoaded(TouhouLittleMaid.MOD_ID)) {
			e.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(InitItems.HAKUREI_GOHEI.get(), 1));
		}
		e.setItemInHand(InteractionHand.OFF_HAND, YHItems.REIMU_SPELL.asStack());
		e.setDropChance(EquipmentSlot.OFFHAND, 1);
	}

	public static void setCirno(CirnoEntity e) {
		setSpell(e, "touhou_little_maid:cirno");
	}

}
