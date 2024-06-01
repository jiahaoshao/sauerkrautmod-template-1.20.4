package name.sauerkrautmod.mixin;

import name.sauerkrautmod.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LivingEntity.class)
public abstract class LightningImmuneMixin extends Entity {

    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    public LightningImmuneMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    //通过修改该函数实现身上有闪电免疫附魔时闪电伤害无效
    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        this.setFireTicks(this.getFireTicks() + 1);
        if (this.getFireTicks() == 0) {
            this.setOnFireFor(8);
        }
        if(!isLightningImmune())
            this.damage(this.getDamageSources().lightningBolt(), 5.0f);
    }

    @Unique
    public boolean isLightningImmune() {
        Iterable<ItemStack> itemStacks = this.getArmorItems();
        for(ItemStack itemStack : itemStacks)
        {
            int k = EnchantmentHelper.getLevel(ModEnchantments.LIGHTNING_IMMUNE, itemStack);
            if(k != 0)
                return true;
        }
        return false;
    }
}
