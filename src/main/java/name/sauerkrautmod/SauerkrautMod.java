package name.sauerkrautmod;

import name.sauerkrautmod.item.ModItemGroups;
import name.sauerkrautmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SauerkrautMod implements ModInitializer {
	public static final String MOD_ID="sauerkrautmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


//	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, id("item_group"));
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

//		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
//				.icon(() -> new ItemStack(ModItems.PROSPECTOR))
//				.displayName(Text.translatable("itemGroup.sauerkrautmod.item_group"))
//				.entries((content, entries) -> {
//				})
//				.build());

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
	public static Identifier id(String name) {
		return new Identifier(MOD_ID, name);
	}
}