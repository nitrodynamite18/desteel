
package net.mcreator.diamondenrichedsteel.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.diamondenrichedsteel.DiamondenrichedSteelModElements;

@DiamondenrichedSteelModElements.ModElement.Tag
public class DiamondEnrichedSteelSwordItem extends DiamondenrichedSteelModElements.ModElement {
	@ObjectHolder("diamondenriched_steel:diamond_enriched_steel_sword")
	public static final Item block = null;
	public DiamondEnrichedSteelSwordItem(DiamondenrichedSteelModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 3264;
			}

			public float getEfficiency() {
				return 32f;
			}

			public float getAttackDamage() {
				return 11f;
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
		}, 3, 0f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				ItemStack retval = new ItemStack(this);
				retval.setDamage(itemstack.getDamage() + 1);
				if (retval.getDamage() >= retval.getMaxDamage()) {
					return ItemStack.EMPTY;
				}
				return retval;
			}
		}.setRegistryName("diamond_enriched_steel_sword"));
	}
}
