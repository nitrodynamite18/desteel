package net.mcreator.diamondenrichedsteel.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.diamondenrichedsteel.item.DiamondEnrichedSteelPickaxeItem;
import net.mcreator.diamondenrichedsteel.DiamondenrichedSteelModElements;

import java.util.Map;

@DiamondenrichedSteelModElements.ModElement.Tag
public class BreakBedrockProcedure extends DiamondenrichedSteelModElements.ModElement {
	public BreakBedrockProcedure(DiamondenrichedSteelModElements instance) {
		super(instance, 52);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BreakBedrock!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure BreakBedrock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BreakBedrock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BreakBedrock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BreakBedrock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BreakBedrock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double generator_distance = 0;
		if ((((entity instanceof PlayerEntity) && ((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DiamondEnrichedSteelPickaxeItem.block, (int) (1)))
				: false))
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlockHardness(world,
						new BlockPos((int) x, (int) y, (int) z))) == (-1)))) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.BEDROCK, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
			(new ItemStack(DiamondEnrichedSteelPickaxeItem.block, (int) (1))).setDamage((int) ((((itemstack)).getDamage()) + 1));
		}
	}
}
