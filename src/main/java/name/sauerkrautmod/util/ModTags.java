package name.sauerkrautmod.util;

import name.sauerkrautmod.SauerkrautMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> PROSPECTOR_LIST = createTag("prospector_list");
        public static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(SauerkrautMod.MOD_ID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> ACCEPT_ENCHANTMENT_LIST = createTag("accept_enchantment_list");
        public static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, new Identifier(SauerkrautMod.MOD_ID, name));
        }
    }
}
