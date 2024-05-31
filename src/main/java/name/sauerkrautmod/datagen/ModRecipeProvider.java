package name.sauerkrautmod.datagen;

import com.terraformersmc.modmenu.util.mod.Mod;
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

//        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items.STONE,
//                RecipeCategory.MISC, ModItems.STONE_1);

        offerCompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.STONE_1,
                Items.STONE, "stone_1_from_stone");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.STONE, 9)
                .input(ModItems.STONE_1)
                .criterion(hasItem(ModItems.STONE_1),conditionsFromItem(ModItems.STONE_1)).
                offerTo(exporter, new Identifier("stone_from_stone_1"));

        offerCompactingRecipe(exporter, RecipeCategory.MISC, ModItems.STONE_2,
                ModItems.STONE_1, "stone_2_from_stone_1");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STONE_1, 9)
                .input(ModItems.STONE_2)
                .criterion(hasItem(ModItems.STONE_2),conditionsFromItem(ModItems.STONE_2)).
                offerTo(exporter, new Identifier("stone_1_from_stone_2"));



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PAVING_BALL, 1)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .input('#',ModItems.STONE_2)
                .criterion(hasItem(ModItems.STONE_2), conditionsFromItem(ModItems.STONE_2))
                .offerTo(exporter, new Identifier("paving_ball_from_stone_2"));
    }
}
