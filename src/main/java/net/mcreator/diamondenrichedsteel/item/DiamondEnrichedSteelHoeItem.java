
package net.mcreator.diamondenrichedsteel.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.diamondenrichedsteel.DiamondenrichedSteelModElements;

@DiamondenrichedSteelModElements.ModElement.Tag
public class DiamondEnrichedSteelHoeItem extends DiamondenrichedSteelModElements.ModElement {
	@ObjectHolder("diamondenriched_steel:diamond_enriched_steel_hoe")
	public static final Item block = null;
	public DiamondEnrichedSteelHoeItem(DiamondenrichedSteelModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 3264;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 9f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DiamondEnrichedSteelGemItem.block, (int) (1)));
			}
		}, -2f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("diamond_enriched_steel_hoe"));
	}
}
