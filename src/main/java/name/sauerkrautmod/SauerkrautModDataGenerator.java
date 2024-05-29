package name.sauerkrautmod;

import name.sauerkrautmod.datagen.ModBlockTagProvider;
import name.sauerkrautmod.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SauerkrautModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
//		pack.addProvider(ModItemTagProvider::new);
//		pack.addProvider(ModModelsProvider::new);
//		pack.addProvider(ModLootTablesProvider::new);
//		pack.addProvider(ModRecipesProvider::new);
	}
}