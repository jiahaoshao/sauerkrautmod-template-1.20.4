package name.sauerkrautmod.entity;

import name.sauerkrautmod.SauerkrautMod;
import name.sauerkrautmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.SetBlockCommand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PavingBallEntity extends ThrownItemEntity {
    public PavingBallEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);

    }

    public PavingBallEntity(LivingEntity owner, World world) {
        super(ModEntities.PAVING_BALL, owner, world);
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.PAVING_BALL;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    private ParticleEffect getParticleParameters() {
       ItemStack itemStack = this.getItem();
       return itemStack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack);
   }

   @Override
   public void handleStatus(byte status) {
       if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
           ParticleEffect particleEffect = this.getParticleParameters();
           for (int i = 0; i < 8; ++i) {
               this.getWorld().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
           }
       }
   }

    @ Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 0;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), i);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
//        if (!this.getWorld().isClient) {
//            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
//            this.discard();
//        }
    }

    private BlockPos pos1 = null, pos2 = null;


    public void place()
    {
        double x1 = pos1.getX(), y1 = pos1.getY(), z1 = pos1.getZ();
        double x2 = pos2.getX(), y2 = pos2.getY(), z2 = pos2.getZ();
        //double A = 1, B = (x2-x1)/(y2-y1), C = -x1-B*y1 + 2*(x2-x1)/(z2-z1)*z1;
        if(x1 > x2)
        {
            double t = x1;
            x1 = x2;
            x2 = t;
        }
        if(y1 > y2)
        {
            double t = y1;
            y1 = y2;
            y2 = t;
        }
        if(z1 > z2)
        {
            double t = z1;
            z1 = z2;
            z2 = t;
        }
        for(double a = x1; a <= x2; a ++)
        {
            for(double b = y1; b <= y2; b ++)
            {
                for(double c = z1; c <= z2; c ++)
                {
//                    SauerkrautMod.LOGGER.info(String.valueOf(Math.abs(A*a + B*b + C*c)));
//
//                    if(Math.abs(A*a + B*b + C*c) <= 1)
//                    {
//                        BlockPos bp = new BlockPos((int)a, (int)b, (int)c);
//                        SauerkrautMod.LOGGER.info(a + "," + b + "," + c + "YES");
//                        World world = this.getWorld();
//                        world.setBlockState(bp, Blocks.DIAMOND_BLOCK.getDefaultState());
//                    }
                    BlockPos bp = new BlockPos((int)a, (int)b, (int)c);
                    World world = this.getWorld();
                    world.setBlockState(bp, Blocks.STONE.getDefaultState());
                    //SauerkrautMod.LOGGER.info(a + "," + b + "," + c);
                }
            }
        }
    }


    private final BlockPos firstPos = BlockPos.ofFloored(this.getPos());

    public double dis(BlockPos pos)
    {
        int x = pos.getX() - firstPos.getX();
        int y = pos.getY() - firstPos.getY();
        int z = pos.getZ() - firstPos.getZ();
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public void tick() {
        BlockPos pos = BlockPos.ofFloored(this.getPos());
        Entity owner =  this.getOwner();
        if(owner != null)
        {
            if(owner.getHorizontalFacing() == Direction.EAST)
                pos = new BlockPos(pos.getX() + 2, pos.getY(), pos.getZ());
            if(owner.getHorizontalFacing() == Direction.WEST)
                pos = new BlockPos(pos.getX() - 2, pos.getY(), pos.getZ());
            if(owner.getHorizontalFacing() == Direction.NORTH)
                pos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 2);
            if(owner.getHorizontalFacing() == Direction.SOUTH)
                pos = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 2);
            if(owner.getHorizontalFacing() == Direction.DOWN)
                pos = new BlockPos(pos.getX(), pos.getY() - 2, pos.getZ());
            if(owner.getHorizontalFacing() == Direction.UP)
                pos = new BlockPos(pos.getX() , pos.getY() + 2, pos.getZ());

            pos2 = pos1;
            if(pos2 == null)
                pos2 = pos;
            pos1 = pos;
            if(pos2 != null)
                place();
        }

        if(dis(pos) >= 100)
            this.discard();


        float h;
        super.tick();
        HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
        boolean bl = false;
        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockPos = ((BlockHitResult)hitResult).getBlockPos();
            BlockState blockState = this.getWorld().getBlockState(blockPos);
            if (blockState.isOf(Blocks.NETHER_PORTAL)) {
                this.setInNetherPortal(blockPos);
                bl = true;
            } else if (blockState.isOf(Blocks.END_GATEWAY)) {
                BlockEntity blockEntity = this.getWorld().getBlockEntity(blockPos);
                if (blockEntity instanceof EndGatewayBlockEntity && EndGatewayBlockEntity.canTeleport(this)) {
                    EndGatewayBlockEntity.tryTeleportingEntity(this.getWorld(), blockPos, blockState, this, (EndGatewayBlockEntity)blockEntity);
                }
                bl = true;
            }
        }
        if (hitResult.getType() != HitResult.Type.MISS && !bl) {
            this.onCollision(hitResult);
        }
        this.checkBlockCollision();
        Vec3d vec3d = this.getVelocity();
        double d = this.getX() + vec3d.x;
        double e = this.getY() + vec3d.y;
        double f = this.getZ() + vec3d.z;
        this.updateRotation();
        if (this.isTouchingWater()) {
            for (int i = 0; i < 4; ++i) {
                float g = 0.25f;
                this.getWorld().addParticle(ParticleTypes.BUBBLE, d - vec3d.x * 0.25, e - vec3d.y * 0.25, f - vec3d.z * 0.25, vec3d.x, vec3d.y, vec3d.z);
            }
            h = 0.8f;
        } else {
            h = 0.99f;
        }
        this.setVelocity(vec3d.multiply(h));
        //this.setVelocity(vec3d.getX() * h, 0, vec3d.getZ() * h);
        if (!this.hasNoGravity()) {
            Vec3d vec3d2 = this.getVelocity();
            this.setVelocity(vec3d2.x, vec3d2.y - (double)this.getGravity(), vec3d2.z);
        }
        this.setPosition(d, e, f);
    }


    @Override
    protected float getGravity() {
        return 0.0f;
    }
}
