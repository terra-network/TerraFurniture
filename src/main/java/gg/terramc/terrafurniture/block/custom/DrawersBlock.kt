package gg.terramc.terrafurniture.block.custom

import gg.terramc.terrafurniture.block.entity.DrawerInventoryBlockEntity
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.*
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import java.util.stream.Stream


class DrawersBlock(settings: Settings) : BlockWithEntity(settings) {
    companion object {
        val FACING: DirectionProperty = Properties.HORIZONTAL_FACING
        val OPEN: BooleanProperty = Properties.OPEN

        val SHAPE: VoxelShape = Stream.of(
            VoxelShapes.combineAndSimplify(
                createCuboidShape(1.0, 1.0, 14.0, 15.0, 7.0, 15.0),
                createCuboidShape(6.0, 4.0, 15.0, 10.0, 5.0, 16.0),
                BooleanBiFunction.OR
            ),
            VoxelShapes.combineAndSimplify(
                createCuboidShape(1.0, 9.0, 14.0, 15.0, 15.0, 15.0),
                createCuboidShape(6.0, 12.0, 15.0, 10.0, 13.0, 16.0),
                BooleanBiFunction.OR
            ),
            createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 14.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()

        val SHAPE_SOUTH: VoxelShape = Stream.of(
            VoxelShapes.combineAndSimplify(
                createCuboidShape(1.0, 1.0, 1.0, 15.0, 7.0, 2.0),
                createCuboidShape(6.0, 4.0, 0.0, 10.0, 5.0, 1.0),
                BooleanBiFunction.OR
            ),
            VoxelShapes.combineAndSimplify(
                createCuboidShape(1.0, 9.0, 1.0, 15.0, 15.0, 2.0),
                createCuboidShape(6.0, 12.0, 0.0, 10.0, 13.0, 1.0),
                BooleanBiFunction.OR
            ),
            createCuboidShape(0.0, 0.0, 2.0, 16.0, 16.0, 16.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()

        val SHAPE_EAST: VoxelShape = Stream.of(
            VoxelShapes.combineAndSimplify(
                createCuboidShape(1.0, 1.0, 1.0, 2.0, 7.0, 15.0),
                createCuboidShape(0.0, 4.0, 6.0, 1.0, 5.0, 10.0),
                BooleanBiFunction.OR
            ),
            VoxelShapes.combineAndSimplify(
                createCuboidShape(1.0, 9.0, 1.0, 2.0, 15.0, 15.0),
                createCuboidShape(0.0, 12.0, 6.0, 1.0, 13.0, 10.0),
                BooleanBiFunction.OR
            ),
            createCuboidShape(2.0, 0.0, 0.0, 16.0, 16.0, 16.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()

        val SHAPE_WEST: VoxelShape = Stream.of(
            VoxelShapes.combineAndSimplify(
                createCuboidShape(14.0, 1.0, 1.0, 15.0, 7.0, 15.0),
                createCuboidShape(15.0, 4.0, 6.0, 16.0, 5.0, 10.0),
                BooleanBiFunction.OR
            ),
            VoxelShapes.combineAndSimplify(
                createCuboidShape(14.0, 9.0, 1.0, 15.0, 15.0, 15.0),
                createCuboidShape(15.0, 12.0, 6.0, 16.0, 13.0, 10.0),
                BooleanBiFunction.OR
            ),
            createCuboidShape(0.0, 0.0, 0.0, 14.0, 16.0, 16.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()
    }

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return DrawerInventoryBlockEntity(pos, state)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(FACING, OPEN)
    }

    override fun onPlaced(
        world: World,
        pos: BlockPos,
        state: BlockState,
        placer: LivingEntity?,
        itemStack: ItemStack
    ) {
        if (itemStack.hasCustomName()) {
            val blockEntity = world.getBlockEntity(pos)
            if (blockEntity is DrawerInventoryBlockEntity) {
                blockEntity.customName = itemStack.name
            }
        }
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        val i = state.get(FACING)
        return when (i) {
            Direction.NORTH -> SHAPE
            Direction.SOUTH -> SHAPE_SOUTH
            Direction.EAST -> SHAPE_EAST
            Direction.WEST -> SHAPE_WEST
            else -> VoxelShapes.empty()
        }
    }

    override fun getPlacementState(ctx: ItemPlacementContext?): BlockState? {
        var blockPos: BlockPos
        val worldAccess = ctx!!.world
        return defaultState.with(FACING, ctx.horizontalPlayerFacing)
    }

    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
        return state.with(FACING, rotation.rotate(state.get(FACING)))
    }

    override fun mirror(state: BlockState, mirror: BlockMirror): BlockState {
        return state.rotate(mirror.getRotation(state.get(FACING)))
    }

    override fun scheduledTick(state: BlockState, world: ServerWorld, pos: BlockPos, random: Random) {
        val blockEntity = world.getBlockEntity(pos)
        if (blockEntity is DrawerInventoryBlockEntity) {
            blockEntity.tick()
        }
    }

    override fun getRenderType(state: BlockState?): BlockRenderType {
        return BlockRenderType.MODEL
    }

    override fun onStateReplaced(
        state: BlockState,
        world: World,
        pos: BlockPos?,
        newState: BlockState,
        moved: Boolean
    ) {
        if (state.isOf(newState.block)) {
            return
        }
        val blockEntity = world.getBlockEntity(pos)
        if (blockEntity is Inventory) {
            ItemScatterer.spawn(world, pos, blockEntity as Inventory?)
            world.updateComparators(pos, this)
        }
        super.onStateReplaced(state, world, pos, newState, moved)
    }

    override fun onUse(
        state: BlockState?,
        world: World,
        pos: BlockPos?,
        player: PlayerEntity,
        hand: Hand?,
        hit: BlockHitResult?
    ): ActionResult {
        if (world.isClient) {
            return ActionResult.SUCCESS
        }
        val blockEntity = world.getBlockEntity(pos)
        if (blockEntity is DrawerInventoryBlockEntity) {
            player.openHandledScreen(blockEntity)
        }
        return ActionResult.CONSUME
    }
}