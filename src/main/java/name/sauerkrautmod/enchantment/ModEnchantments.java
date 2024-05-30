package name.sauerkrautmod.enchantment;

import name.sauerkrautmod.SauerkrautMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

        public static Enchantment TEST =register("test",
                new Test(Enchantment.Rarity.UNCOMMON,EnchantmentTarget.VANISHABLE , new EquipmentSlot[]{EquipmentSlot.FEET}));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(SauerkrautMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments(){
        System.out.println("注册附魔");
    }
}
