package name.sauerkrautmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;

public class LightingAttackEnchantment extends Enchantment {
    protected LightingAttackEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }


    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 9;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }


    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity entity){
            if(!user.getWorld().isClient()){
                ServerWorld world = (ServerWorld) user.getWorld();
                for(int i = 0; i < level; i ++)
                {
                    EntityType.LIGHTNING_BOLT.spawn(world, null, null, entity.getBlockPos(),null,  false, false);
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }

}
