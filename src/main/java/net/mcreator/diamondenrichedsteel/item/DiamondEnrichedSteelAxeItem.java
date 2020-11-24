
package net.mcreator.diamondenrichedsteel.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.diamondenrichedsteel.DiamondenrichedSteelModElements;

@DiamondenrichedSteelModElements.ModElement.Tag
public class DiamondEnrichedSteelAxeItem extends DiamondenrichedSteelModElements.ModElement {
	@ObjectHolder("diamondenriched_steel:diamond_enriched_steel_axe")
	public static final Item block = null;
	public DiamondEnrichedSteelAxeItem(DiamondenrichedSteelModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3264;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 14f;
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
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("diamond_enriched_steel_axe"));
	}
}
