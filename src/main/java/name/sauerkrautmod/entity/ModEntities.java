package name.sauerkrautmod.entity;

import name.sauerkrautmod.SauerkrautMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PavingBallEntity> PAVING_BALL = Registry.register(Registries.ENTITY_TYPE,
            SauerkrautMod.id("paving_ball"),
            EntityType.Builder.<PavingBallEntity>create(PavingBallEntity::new, SpawnGroup.MISC)
                    .setDimensions(0.25f, 0.25f)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
                    .build());
}
