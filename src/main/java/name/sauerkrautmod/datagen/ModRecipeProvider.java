package name.sauerkrautmod.datagen;

import com.terraformersmc.modmenu.util.mod.Mod;
import name.sauerkrautmod.SauerkrautMod;
import name.sauerkrautmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items.STONE, RecipeCategory.MISC, ModItems.STONE_1, "stone_1_from_stone", SauerkrautMod.MOD_ID, "stone_from_stone_1", SauerkrautMod.MOD_ID);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.STONE_1, RecipeCategory.MISC, ModItems.STONE_2, "stone_2_from_stone_1", SauerkrautMod.MOD_ID, "stone_1_from_stone_2", SauerkrautMod.MOD_ID);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PAVING_BALL, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#',ModItems.STONE_2)
                .group(SauerkrautMod.MOD_ID)
                .criterion(hasItem(ModItems.STONE_2), conditionsFromItem(ModItems.STONE_2))
                .offerTo(exporter, new Identifier("paving_ball_from_stone_2"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PROSPECTOR, 1)
                .pattern("BAB")
                .pattern("BCB")
                .pattern("BDB")
                .input('A', Items.GLASS_PANE)
                .input('B', Items.IRON_INGOT)
                .input('C', Items.DIAMOND)
                .input('D', Items.REDSTONE)
                .group(SauerkrautMod.MOD_ID)
                .criterion(hasItem(Items.GLASS_PANE), conditionsFromItem(Items.GLASS_PANE))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier("prospector"));

    }
}
