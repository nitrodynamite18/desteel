
package net.mcreator.diamondenrichedsteel.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.diamondenrichedsteel.DiamondenrichedSteelModElements;

@DiamondenrichedSteelModElements.ModElement.Tag
public class NitrosFacePainting extends DiamondenrichedSteelModElements.ModElement {
	public NitrosFacePainting(DiamondenrichedSteelModElements instance) {
		super(instance, 48);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 16).setRegistryName("nitros_face"));
	}
}
