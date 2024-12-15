package gg.terramc.terrafurniture.util

import gg.terramc.terrafurniture.block.custom.SofaBlock
import gg.terramc.terrafurniture.block.entity.SeatEntity.Companion.IS_OCCUPIED
import gg.terramc.terrafurniture.entity.ModEntities
import net.fabricmc.fabric.api.event.player.UseBlockCallback
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.AxeItem
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World


class ModCallbackRegistry {
    companion object {
        fun handleSitting() {
            UseBlockCallback.EVENT.register(UseBlockCallback { player: PlayerEntity, world: World, hand: Hand?, hitResult: BlockHitResult ->
                val state = world.getBlockState(hitResult.blockPos)
                val blockPos = hitResult.blockPos
                val comparePos =
                    Vec3d(blockPos.x.toDouble(), blockPos.y.toDouble(), blockPos.z.toDouble())
                val notSneakingAndHandEmpty = !player.isSneaking && player.getStackInHand(hand).isEmpty

                if (world.isClient || !world.canPlayerModifyAt(
                        player,
                        blockPos
                    ) || IS_OCCUPIED.containsKey(comparePos) || !notSneakingAndHandEmpty
                ) {
                    return@UseBlockCallback ActionResult.PASS
                }

                val noAxe = !(player.getStackInHand(Hand.MAIN_HAND)
                    .item is AxeItem || player.getStackInHand(Hand.OFF_HAND).item is AxeItem)

                if (state.block is SofaBlock) {
                    return@UseBlockCallback spawnSeat(world, player, blockPos, 0.2, comparePos)
                }
                ActionResult.PASS
            })
        }

        fun spawnSeat(
            world: World,
            player: PlayerEntity,
            blockPos: BlockPos,
            yOffset: Double,
            comparePos: Vec3d
        ): ActionResult {
            val seatEntity = ModEntities.SEAT.create(world)
            if (seatEntity !== null) {
                val pos = Vec3d(
                    (blockPos.x + 0.5f).toDouble(), blockPos.y + yOffset,
                    (blockPos.z + 0.5f).toDouble()
                )
                IS_OCCUPIED[comparePos] = player.blockPos
                seatEntity.updatePosition(pos.getX(), pos.getY(), pos.getZ())
                world.spawnEntity(seatEntity)
                player.startRiding(seatEntity)
                return ActionResult.SUCCESS
            }
            return ActionResult.PASS
        }
    }
}