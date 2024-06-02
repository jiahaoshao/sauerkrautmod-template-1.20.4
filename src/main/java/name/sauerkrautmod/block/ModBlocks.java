package name.sauerkrautmod.block;

import name.sauerkrautmod.SauerkrautMod;
import name.sauerkrautmod.item.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BOQI_BLOCK = registerBlock("boqi_block",
            new BoqiBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

//    public static final Block RUBY_BLOCK=registerBlock("ruby_block",
//            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    private static Block registerBlock(String name,Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,SauerkrautMod.id(name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM,SauerkrautMod.id(name),
                new BlockItem(block,new FabricItemSettings()));
    }

//    private static Item registerBlockItem(String name, Block block){
//        BlockItem item = new BlockItem(block, new FabricItemSettings());
//        Registry.register(Registries.ITEM,SauerkrautMod.id(name), item);
//        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.ITEM_GROUP).register(entries -> entries.add(item));
//        return item;
//    }


    public static void registerModBlocks(){
        SauerkrautMod.LOGGER.info("注册一个方块"+ SauerkrautMod.MOD_ID);
    }
}
