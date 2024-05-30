package name.sauerkrautmod.mixin.enchantmentmixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {

    @Shadow @Final
    public  EnchantmentTarget target;


    /**
     * @author
     * Fang_yi
     * @reason
     * 让不死图腾可以附魔
     */
    @Overwrite
    public boolean isAcceptableItem(ItemStack stack) {
        if(stack.isOf(Items.TOTEM_OF_UNDYING))
            return true;
        return this.target.isAcceptableItem(stack.getItem());
    }
}
