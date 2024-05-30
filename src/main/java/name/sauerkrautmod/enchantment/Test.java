package name.sauerkrautmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class Test extends Enchantment {
    protected Test(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return true;
    }
}
