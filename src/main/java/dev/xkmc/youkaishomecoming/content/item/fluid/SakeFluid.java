package dev.xkmc.youkaishomecoming.content.item.fluid;

import dev.xkmc.youkaishomecoming.init.food.YHSake;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class SakeFluid extends ForgeFlowingFluid {
    public final YHSake type;

    public SakeFluid(ForgeFlowingFluid.Properties properties, YHSake type) {
        super(properties);
        this.type = type;
    }

    public Fluid getSource() {
        return super.getSource();
    }

    public Fluid getFlowing() {
        return this;
    }

    public Item getBucket() {
        return Items.AIR;
    }

    protected BlockState createLegacyBlock(FluidState state) {
        return Blocks.AIR.defaultBlockState();
    }

    public boolean isSource(FluidState state) {
        return false;
    }

    public int getAmount(FluidState state) {
        return 0;
    }
}
