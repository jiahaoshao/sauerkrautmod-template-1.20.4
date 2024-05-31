package name.sauerkrautmod.datagen;

import com.terraformersmc.modmenu.util.mod.Mod;
import name.sauerkrautmod.item.ModItemGroups;
import name.sauerkrautmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ModChineseLangProvider extends FabricLanguageProvider {
    public ModChineseLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput,"zh_cn");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.PROSPECTOR, "探矿器");
        translationBuilder.add(ModItems.STONE_1, "一级压缩石头");
        translationBuilder.add(ModItems.STONE_2, "二级压缩石头");
        translationBuilder.add(ModItems.PAVING_BALL,"铺路石");
        translationBuilder.add(ModItemGroups.ITEM_GROUP,"酸菜の奇思妙想");
    }
}
