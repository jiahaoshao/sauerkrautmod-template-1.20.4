package name.sauerkrautmod.mixin;


import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BucketItem.class)
public abstract  class InfiniteBucketMixin extends Item implements FluidModificationItem {
    public InfiniteBucketMixin(Settings settings) {
            super(settings);
        }

    /**
     * @author
     * Fang_yi
     * @reason
     * 让桶可以无限使用
     */
    @Overwrite
    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        int a = EnchantmentHelper.getLevel(Enchantments.INFINITY, stack);//无限
        if (!player.getAbilities().creativeMode & a != 1) {
            return new ItemStack(Items.BUCKET);
        } else {
            return stack;
        }
    }
}
