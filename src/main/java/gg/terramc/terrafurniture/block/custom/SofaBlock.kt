package gg.terramc.terrafurniture.block.custom

import gg.terramc.terrafurniture.block.property.FrontConnection
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.EnumProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.WorldAccess
import java.util.stream.Stream

class SofaBlock(settings: Settings?) : Block(settings) {
    companion object {
        val FACING = Properties.HORIZONTAL_FACING
        val CONNECTED_LEFT = BooleanProperty.of("left")
        val CONNECTED_RIGHT = BooleanProperty.of("right")
        val FRONT_CONNECTION = EnumProperty.of("front", FrontConnection::class.java)

        val SHAPE: VoxelShape = Stream.of(
            createCuboidShape(3.0, 2.0, 0.0, 13.0, 7.0, 13.0),
            createCuboidShape(0.0, 2.0, 13.0, 16.0, 16.0, 16.0),
            createCuboidShape(0.0, 2.0, 0.0, 3.0, 12.0, 13.0),
            createCuboidShape(13.0, 2.0, 0.0, 16.0, 12.0, 13.0),
            Stream.of(
                createCuboidShape(13.0, 0.0, 1.0, 15.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 1.0, 3.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 13.0, 3.0, 2.0, 15.0),
                createCuboidShape(13.0, 0.0, 13.0, 15.0, 2.0, 15.0)
            ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()

        val SHAPE_CORNER_RIGHT: VoxelShape = Stream.of(
            createCuboidShape(3.0, 0.0, 0.0, 16.0, 7.0, 13.0),
            createCuboidShape(0.0, 2.0, 13.0, 16.0, 16.0, 16.0),
            createCuboidShape(0.0, 2.0, 0.0, 3.0, 16.0, 13.0),
            Stream.of(
                createCuboidShape(13.0, 0.0, 1.0, 15.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 1.0, 3.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 13.0, 3.0, 2.0, 15.0),
                createCuboidShape(13.0, 0.0, 13.0, 15.0, 2.0, 15.0)
            ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()

        val SHAPE_CORNER_LEFT: VoxelShape = Stream.of(
            createCuboidShape(0.0, 2.0, 0.0, 13.0, 7.0, 13.0),
            createCuboidShape(0.0, 2.0, 13.0, 16.0, 16.0, 16.0),
            createCuboidShape(13.0, 2.0, 0.0, 16.0, 16.0, 13.0),
            Stream.of(
                createCuboidShape(13.0, 0.0, 1.0, 15.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 1.0, 3.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 13.0, 3.0, 2.0, 15.0),
                createCuboidShape(13.0, 0.0, 13.0, 15.0, 2.0, 15.0)
            ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()

        val SHAPE_ARM_RIGHT: VoxelShape = Stream.of(
            createCuboidShape(3.0, 2.0, 0.0, 16.0, 7.0, 13.0),
            createCuboidShape(0.0, 2.0, 13.0, 16.0, 16.0, 16.0),
            createCuboidShape(0.0, 2.0, 0.0, 3.0, 12.0, 13.0),
            Stream.of(
                createCuboidShape(13.0, 0.0, 1.0, 15.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 1.0, 3.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 13.0, 3.0, 2.0, 15.0),
                createCuboidShape(13.0, 0.0, 13.0, 15.0, 2.0, 15.0)
            ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
        val SHAPE_ARM_LEFT: VoxelShape = Stream.of(
            createCuboidShape(0.0, 2.0, 0.0, 13.0, 7.0, 13.0),
            createCuboidShape(0.0, 2.0, 13.0, 16.0, 16.0, 16.0),
            createCuboidShape(13.0, 2.0, 0.0, 16.0, 12.0, 13.0),
            Stream.of(
                createCuboidShape(13.0, 0.0, 1.0, 15.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 1.0, 3.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 13.0, 3.0, 2.0, 15.0),
                createCuboidShape(13.0, 0.0, 13.0, 15.0, 2.0, 15.0)
            ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()

        val SHAPE_CENTER: VoxelShape = Stream.of(
            createCuboidShape(0.0, 2.0, 0.0, 16.0, 7.0, 13.0),
            createCuboidShape(0.0, 2.0, 13.0, 16.0, 16.0, 16.0),
            Stream.of(
                createCuboidShape(13.0, 0.0, 1.0, 15.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 1.0, 3.0, 2.0, 3.0),
                createCuboidShape(1.0, 0.0, 13.0, 3.0, 2.0, 15.0),
                createCuboidShape(13.0, 0.0, 13.0, 15.0, 2.0, 15.0)
            ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }.get()
    }

    init {
        defaultState = defaultState
            .with(FRONT_CONNECTION, FrontConnection.NONE)
            .with(CONNECTED_LEFT, false)
            .with(CONNECTED_RIGHT, false)
    }

    fun rotateShape(shape: VoxelShape, to: Direction): VoxelShape {
        if (Direction.NORTH === to) return shape
        val buffer = arrayOf<VoxelShape>(shape, VoxelShapes.empty())


        val times: Int = when (to) {
            Direction.SOUTH -> 2
            Direction.EAST -> 1
            Direction.WEST -> 3
            else -> 0
        }
        repeat(times) {
            buffer[0].forEachBox { minX, minY, minZ, maxX, maxY, maxZ ->
                buffer[1] =
                    VoxelShapes.union(buffer[1], VoxelShapes.cuboid((1.0 - maxZ), minY, minX, (1.0 - minZ), maxY, maxX))
            }
            buffer[0] = buffer[1]
            buffer[1] = VoxelShapes.empty()
        }

        return buffer[0]
    }

    enum class SOFA_SHAPE {
        DEFAULT,
        ARM_RIGHT,
        ARM_LEFT,
        CENTER,
        CORNER_LEFT,
        CORNER_RIGHT
    }

    fun getWhatShape(state: BlockState): VoxelShape {
        val left = state.get(CONNECTED_LEFT)
        val right = state.get(CONNECTED_RIGHT)
        val front = state.get(FRONT_CONNECTION)

        if (front === FrontConnection.LEFT) return SHAPE_CORNER_LEFT
        if (front === FrontConnection.RIGHT) return SHAPE_CORNER_RIGHT

        if (!left && !right) return SHAPE
        if (left && right) return SHAPE_CENTER
        if (left) return SHAPE_ARM_RIGHT
        if (right) return SHAPE_ARM_LEFT
        return SHAPE
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        val i = state.get(FACING)
        val shape = getWhatShape(state)
        return when (i) {
            Direction.NORTH -> shape
            Direction.SOUTH -> rotateShape(shape, Direction.SOUTH)
            Direction.EAST -> rotateShape(shape, Direction.EAST)
            Direction.WEST -> rotateShape(shape, Direction.WEST)
            else -> VoxelShapes.empty()
        }
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
        builder.add(FACING, CONNECTED_RIGHT, CONNECTED_LEFT, FRONT_CONNECTION)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return updateConnections(
            defaultState.with(FACING, ctx.horizontalPlayerFacing.opposite),
            ctx.world,
            ctx.blockPos
        )
    }

    override fun getStateForNeighborUpdate(
        state: BlockState,
        direction: Direction,
        neighborState: BlockState,
        world: WorldAccess,
        pos: BlockPos,
        neighborPos: BlockPos
    ): BlockState {
        return updateConnections(state, world, pos)
    }

    fun updateConnections(state: BlockState, world: WorldAccess, pos: BlockPos): BlockState {
        val direction = state.get(FACING)
        val leftState = world.getBlockState(pos.offset(direction.rotateYClockwise()))
        val rightState = world.getBlockState(pos.offset(direction.rotateYCounterclockwise()))
        val frontState = world.getBlockState(pos.offset(direction))

        val connectedLeft =
            leftState.block is SofaBlock && (leftState[FACING] == direction || (leftState[FACING] == direction.rotateYCounterclockwise() && leftState[FRONT_CONNECTION] != FrontConnection.NONE))
        val connectedRight =
            rightState.block is SofaBlock && (rightState[FACING] == direction || (rightState[FACING] == direction.rotateYClockwise() && rightState[FRONT_CONNECTION] != FrontConnection.NONE))

        val connectedFront = frontState.block is SofaBlock
        val connectedFrontLeft =
            connectedFront && !connectedLeft && frontState[FACING] == direction.rotateYCounterclockwise()
        val connectedFrontRight =
            connectedFront && !connectedRight && frontState[FACING] == direction.rotateYClockwise()
        val frontConnection = when {
            connectedFrontLeft -> FrontConnection.LEFT
            connectedFrontRight -> FrontConnection.RIGHT
            else -> FrontConnection.NONE
        }

        return state
            .with(CONNECTED_LEFT, connectedLeft)
            .with(CONNECTED_RIGHT, connectedRight)
            .with(FRONT_CONNECTION, frontConnection)
    }
}