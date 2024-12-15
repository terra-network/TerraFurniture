package gg.terramc.terrafurniture.block.custom

import gg.terramc.terrafurniture.block.entity.SeatEntity
import gg.terramc.terrafurniture.block.entity.SeatEntity.Companion.IS_OCCUPIED
import net.minecraft.block.BlockState
import net.minecraft.block.HorizontalFacingBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import net.minecraft.world.event.GameEvent


open class SeatBlock(settings: Settings) : HorizontalFacingBlock(settings) {
    companion object {
        val HORIZONTAL_FACING: DirectionProperty = Properties.HORIZONTAL_FACING
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return this.defaultState.with(HORIZONTAL_FACING, ctx.horizontalPlayerFacing.opposite)
    }

    override fun onBreak(world: World, pos: BlockPos, state: BlockState?, player: PlayerEntity?) {
        val xPos = pos.x.toDouble()
        val yPos = pos.y.toDouble()
        val zPos = pos.z.toDouble()

        val entities = world.getEntitiesByClass(
            SeatEntity::class.java,
            Box(xPos, yPos, zPos, xPos + 1, yPos + 1, zPos + 1),
            Entity::hasPassengers
        )
        for (entity in entities) {
            entity.remove(Entity.RemovalReason.DISCARDED)
        }

        this.spawnBreakParticles(world, player, pos, state)
        world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos)

        IS_OCCUPIED.remove(Vec3d(xPos, yPos, zPos))
    }

}