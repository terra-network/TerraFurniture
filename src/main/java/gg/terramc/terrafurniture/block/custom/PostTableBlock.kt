package gg.terramc.terrafurniture.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

class PostTableBlock(settings: Settings?) : Block(settings) {
    companion object {
        val SHAPE: VoxelShape = VoxelShapes.combineAndSimplify(
            createCuboidShape(7.0, 0.0, 7.0, 9.0, 14.0, 9.0),
            createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0),
            BooleanBiFunction.OR
        )
    }

    override fun getOutlineShape(
        state: BlockState?,
        world: BlockView?,
        pos: BlockPos?,
        context: ShapeContext?
    ): VoxelShape {
        return SHAPE
    }
}