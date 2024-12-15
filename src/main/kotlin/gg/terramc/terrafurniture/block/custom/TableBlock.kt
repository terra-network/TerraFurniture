package gg.terramc.terrafurniture.block.custom

import gg.terramc.terrafurniture.block.custom.TableBlock.LegPosition
import gg.terramc.terrafurniture.util.ModProperties
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.block.Waterloggable
import net.minecraft.entity.LivingEntity
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.EnumProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.StringIdentifiable
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import java.util.stream.Stream


class TableBlock(settings: Settings?) : Block(settings), Waterloggable {
    companion object {
        val SHAPE: VoxelShape = Stream.of(
            createCuboidShape(1.0, 0.0, 13.0, 3.0, 14.0, 15.0),
            createCuboidShape(1.0, 0.0, 1.0, 3.0, 14.0, 3.0),
            createCuboidShape(13.0, 0.0, 1.0, 15.0, 14.0, 3.0),
            createCuboidShape(13.0, 0.0, 13.0, 15.0, 14.0, 15.0),
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0)
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()

        val NORTH_SHAPE: VoxelShape = Stream.of(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(13.0, 0.0, 13.0, 15.0, 14.0, 15.0),
            createCuboidShape(1.0, 0.0, 13.0, 3.0, 14.0, 15.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()

        val SOUTH_SHAPE: VoxelShape = Stream.of(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(13.0, 0.0, 1.0, 15.0, 14.0, 3.0),
            createCuboidShape(1.0, 0.0, 1.0, 3.0, 14.0, 3.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()

        val EAST_SHAPE: VoxelShape = Stream.of(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(1.0, 0.0, 13.0, 3.0, 14.0, 15.0),
            createCuboidShape(1.0, 0.0, 1.0, 3.0, 14.0, 3.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()

        val WEST_SHAPE: VoxelShape = Stream.of(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(13.0, 0.0, 1.0, 15.0, 14.0, 3.0),
            createCuboidShape(13.0, 0.0, 13.0, 15.0, 14.0, 15.0)
        ).reduce { v1: VoxelShape?, v2: VoxelShape? ->
            VoxelShapes.combineAndSimplify(
                v1,
                v2,
                BooleanBiFunction.OR
            )
        }.get()

        val NORTH_EAST_SHAPE: VoxelShape = VoxelShapes.combineAndSimplify(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(1.0, 0.0, 13.0, 3.0, 14.0, 15.0),
            BooleanBiFunction.OR
        )

        val NORTH_WEST_SHAPE: VoxelShape = VoxelShapes.combineAndSimplify(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(13.0, 0.0, 13.0, 15.0, 14.0, 15.0),
            BooleanBiFunction.OR
        )

        val SOUTH_EAST_SHAPE: VoxelShape = VoxelShapes.combineAndSimplify(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(1.0, 0.0, 1.0, 3.0, 14.0, 3.0),
            BooleanBiFunction.OR
        )

        val SOUTH_WEST_SHAPE: VoxelShape = VoxelShapes.combineAndSimplify(
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            createCuboidShape(13.0, 0.0, 1.0, 15.0, 14.0, 3.0),
            BooleanBiFunction.OR
        )

        val NONE_SHAPE: VoxelShape = createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0)

        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED
        val LEG_POSITIONS: EnumProperty<LegPosition> = EnumProperty.of("leg_positions", LegPosition::class.java)
        val LEGS: BooleanProperty = ModProperties.LEGS
    }

    @Deprecated(
        "Deprecated in Java",
        ReplaceWith("SHAPE", "gg.terramc.terrafurniture.block.custom.OakPlanksTable.Companion.SHAPE")
    )
    override fun getOutlineShape(
        state: BlockState?,
        world: BlockView?,
        pos: BlockPos?,
        context: ShapeContext?
    ): VoxelShape {
        val i = state!![LEG_POSITIONS]
        return when (i) {
            LegPosition.NORTH -> NORTH_SHAPE
            LegPosition.SOUTH -> SOUTH_SHAPE
            LegPosition.EAST -> EAST_SHAPE
            LegPosition.WEST -> WEST_SHAPE
            LegPosition.SOUTH_WEST -> SOUTH_WEST_SHAPE
            LegPosition.SOUTH_EAST -> SOUTH_EAST_SHAPE
            LegPosition.NORTH_EAST -> NORTH_EAST_SHAPE
            LegPosition.NORTH_WEST -> NORTH_WEST_SHAPE
            LegPosition.NONE -> NONE_SHAPE
            LegPosition.ALL -> SHAPE
            else -> VoxelShapes.empty()
        }
    }

    enum class LegPosition(val descriptor: String) : StringIdentifiable {
        NONE("none"),
        NORTH("north"),
        SOUTH("south"),
        EAST("east"),
        WEST("west"),
        NORTH_WEST("north_west"),
        NORTH_EAST("north_east"),
        SOUTH_WEST("south_west"),
        SOUTH_EAST("south_east"),
        ALL("all");

        override fun asString(): String {
            return this.descriptor
        }

        override fun toString(): String {
            return this.descriptor
        }

        companion object {
            fun fromNeighborBlocks(west: Boolean, north: Boolean, east: Boolean, south: Boolean): LegPosition {
                return if (west && north) {
                    NORTH_WEST
                } else if (west && south) {
                    SOUTH_WEST
                } else if (east && north) {
                    NORTH_EAST
                } else if (east && south) {
                    SOUTH_EAST
                } else if (west) {
                    WEST
                } else if (east) {
                    EAST
                } else if (north) {
                    NORTH
                } else if (south) {
                    SOUTH
                } else {
                    NONE
                }
            }
        }
    }

    override fun getStateForNeighborUpdate(
        state: BlockState,
        direction: Direction?,
        neighborState: BlockState?,
        world: WorldAccess?,
        pos: BlockPos?,
        neighborPos: BlockPos?
    ): BlockState {
        val eastTable = world!!.getBlockState(pos!!.east()).block is TableBlock
        val westTable = world.getBlockState(pos.west()).block is TableBlock
        val northTable = world.getBlockState(pos.north()).block is TableBlock
        val southTable = world.getBlockState(pos.south()).block is TableBlock
        val northWestTable = world.getBlockState(pos.north().west()).block is TableBlock
        val southWestTable = world.getBlockState(pos.south().west()).block is TableBlock
        val northEastTable = world.getBlockState(pos.north().east()).block is TableBlock
        val southEastTable = world.getBlockState(pos.south().east()).block is TableBlock

        if (!eastTable && !westTable && !northTable && !southTable) {
            return state.with(LEG_POSITIONS, LegPosition.ALL).with(LEGS, true)
        }
        if (eastTable && westTable && northTable && southTable) {
            return state.with(LEG_POSITIONS, LegPosition.NONE).with(LEGS, false)
        }
        if (eastTable && westTable) {
            return state.with(LEG_POSITIONS, LegPosition.NONE).with(LEGS, false)
        }
        if (northTable && southTable) {
            return state.with(LEG_POSITIONS, LegPosition.NONE).with(LEGS, false)
        }
        if (westTable && southTable && !northWestTable) {
            return state.with(LEG_POSITIONS, LegPosition.SOUTH_WEST).with(LEGS, true)
        }
        if (westTable && northTable && !southWestTable) {
            return state.with(LEG_POSITIONS, LegPosition.NORTH_WEST).with(LEGS, true)
        }
        if (eastTable && northTable && !southEastTable) {
            return state.with(LEG_POSITIONS, LegPosition.NORTH_EAST).with(LEGS, true)
        }
        if (eastTable && southTable && !northEastTable) {
            return state.with(LEG_POSITIONS, LegPosition.SOUTH_EAST).with(LEGS, true)
        }

        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world))
        }

        val legPositions = LegPosition.fromNeighborBlocks(westTable, northTable, eastTable, southTable)
        val legs = legPositions != LegPosition.NONE
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos).with(
            LEG_POSITIONS, legPositions
        ).with(LEGS, legs)
    }

    private fun updateTableLegs(world: World, pos: BlockPos, state: BlockState) {
        val eastTable = world.getBlockState(pos.east()).block is TableBlock
        val westTable = world.getBlockState(pos.west()).block is TableBlock
        val northTable = world.getBlockState(pos.north()).block is TableBlock
        val southTable = world.getBlockState(pos.south()).block is TableBlock

        if (eastTable && westTable && northTable && southTable) {
            world.setBlockState(pos, state.with(LEG_POSITIONS, LegPosition.NONE).with(LEGS, false))
        } else if (!eastTable && !westTable && !northTable && !southTable) {
            world.setBlockState(pos, state.with(LEG_POSITIONS, LegPosition.ALL).with(LEGS, true))
        } else if (eastTable && westTable) {
            world.setBlockState(pos, state.with(LEG_POSITIONS, LegPosition.NONE).with(LEGS, false))
        } else if (northTable && southTable) {
            world.setBlockState(pos, state.with(LEG_POSITIONS, LegPosition.NONE).with(LEGS, false))
        } else {
            val legPositions = LegPosition.fromNeighborBlocks(westTable, northTable, eastTable, southTable)
            val legs = legPositions != LegPosition.NONE
            world.setBlockState(pos, state.with(LEG_POSITIONS, legPositions).with(LEGS, legs))
        }
    }


    override fun onPlaced(
        world: World?,
        pos: BlockPos?,
        state: BlockState?,
        placer: LivingEntity?,
        itemStack: ItemStack?
    ) {
        super.onPlaced(world, pos, state, placer, itemStack)
        updateTableLegs(world!!, pos!!, state!!)
    }

    override fun appendProperties(builder: StateManager.Builder<Block?, BlockState?>) {
        builder.add(LEG_POSITIONS, LEGS, WATERLOGGED)
    }


    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        var blockPos: BlockPos?
        val worldAccess = ctx.world
        val bl = worldAccess.getFluidState(ctx.blockPos.also { blockPos = it }).fluid === Fluids.WATER
        return defaultState.with(WATERLOGGED, bl) as BlockState
    }
}