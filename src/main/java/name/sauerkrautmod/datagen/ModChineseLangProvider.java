package name.sauerkrautmod.datagen;

import com.terraformersmc.modmenu.util.mod.Mod;
import name.sauerkrautmod.SauerkrautMod;
import name.sauerkrautmod.block.ModBlocks;
import name.sauerkrautmod.enchantment.ModEnchantments;
import name.sauerkrautmod.item.ModItemGroups;
import name.sauerkrautmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.util.Identifier;

public class ModChineseLangProvider extends FabricLanguageProvider {
    public ModChineseLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput,"zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItemGroups.ITEM_GROUP,"酸菜の奇思妙想");
        translationBuilder.add(ModItems.PROSPECTOR, "探矿器");
        translationBuilder.add(ModItems.STONE_1, "一级压缩石头");
        translationBuilder.add(ModItems.STONE_2, "二级压缩石头");
        translationBuilder.add(ModItems.PAVING_BALL,"铺路石");
        translationBuilder.add(ModEnchantments.LIGHTNING_ATTACK, "闪电打击");
        translationBuilder.add(ModEnchantments.LIGHTNING_IMMUNE, "闪电免疫");
        translationBuilder.add(ModBlocks.BOQI_BLOCK, "波奇方块");
        //translationBuilder.add(ModBlocks.RUBY_BLOCK,"鲁比方块");
        //translationBuilder.add(new Identifier("item.sauerkrautmod","prospector.tooltip"), "试试用它右键地面吧");
    }
}
