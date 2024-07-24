package gg.terramc.terrafurniture.block.entity

import gg.terramc.terrafurniture.block.custom.SeatBlock
import gg.terramc.terrafurniture.entity.ModEntities
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.network.listener.ClientPlayPacketListener
import net.minecraft.network.packet.Packet
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World


/**
 * <p>
 * Note: This seat entity is almost completely written by EmilsGithub {@link https://github.com/EmilsGithub/Clutter-Mod-Repository/blob/Clutter-1.20.1/src/main/java/net/emilsg/clutter/block/entity/SeatEntity.java}
 * </p>
 */
class SeatEntity(type: EntityType<*>?, world: World?) : Entity(type, world) {
    companion object {
        var IS_OCCUPIED = HashMap<Vec3d, BlockPos>()
    }

    constructor(world: World) :
            this(ModEntities.SEAT, world)

    override fun createSpawnPacket(): Packet<ClientPlayPacketListener> {
        return EntitySpawnS2CPacket(this)
    }

    override fun updatePassengerForDismount(passenger: LivingEntity): Vec3d {
        if (passenger is PlayerEntity) {
            val posX = this.blockPos.x.toDouble()
            val posY = this.blockPos.y.toDouble()
            val posZ = this.blockPos.z.toDouble()

            val pos = IS_OCCUPIED.remove(Vec3d(posX, posY, posZ))
            if (pos !== null) {
                remove(RemovalReason.DISCARDED)
                return Vec3d(posX + 0.5, posY + 1.0, posZ + 0.5)
            }
        }
        remove(RemovalReason.DISCARDED)
        return super.updatePassengerForDismount(passenger)
    }

    override fun tick() {
        if (!world.isClient && !(passengerList.isNotEmpty() || world.getBlockState(this.blockPos).block !is SeatBlock)) {
            remove(RemovalReason.DISCARDED)
        }
    }

    override fun remove(reason: RemovalReason) {
        IS_OCCUPIED.remove(pos)
        super.remove(reason)
    }

    override fun initDataTracker() {}
    override fun readCustomDataFromNbt(nbt: NbtCompound) {}
    override fun writeCustomDataToNbt(nbt: NbtCompound) {}
}