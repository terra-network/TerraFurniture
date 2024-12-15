package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks
import net.minecraft.block.SlabBlock

class BasicSlabs {
    companion object {
        val DIRT_SLAB = registerBlock(
            "dirt_slab",
            SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)),
            ModItemGroups.TERRAFURNITURE
        )
        val COARSE_DIRT_SLAB = registerBlock(
            "coarse_dirt_slab",
            SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE)),
            ModItemGroups.TERRAFURNITURE
        )
//        val GRASS_SLAB = registerBlockTinted(
//            "grass_slab",
//            SlabBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)),
//            ModItemGroups.TERRAFURNITURE
//        )
    }
}