package name.sauerkrautmod.item;

import name.sauerkrautmod.SauerkrautMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SaddleItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, SauerkrautMod.id("item_group"));


    public static void registerItemGroups(){
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.PROSPECTOR))
                .displayName(Text.translatable("itemgroup.sauerkrautmod.item_group"))
                .entries((content, entries) -> {
                })
                .build());

        SauerkrautMod.LOGGER.info("注册一个自定义物品TAB"+SauerkrautMod.MOD_ID);
    }
}
