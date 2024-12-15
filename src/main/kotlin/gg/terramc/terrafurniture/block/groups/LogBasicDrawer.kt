package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.DrawersBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class LogBasicDrawer {
    companion object {

        val ACACIA_LOG_DRAWER = registerBlock(
            "acacia_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val OAK_LOG_DRAWER = registerBlock(
            "oak_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val BAMBOO_BLOCK_DRAWER = registerBlock(
            "bamboo_block_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val BIRCH_LOG_DRAWER = registerBlock(
            "birch_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val CHERRY_LOG_DRAWER = registerBlock(
            "cherry_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val CRIMSON_STEM_DRAWER = registerBlock(
            "crimson_stem_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val DARK_OAK_LOG_DRAWER = registerBlock(
            "dark_oak_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val JUNGLE_LOG_DRAWER = registerBlock(
            "jungle_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val MANGROVE_LOG_DRAWER = registerBlock(
            "mangrove_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val SPRUCE_LOG_DRAWER = registerBlock(
            "spruce_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val WARPED_STEM_DRAWER = registerBlock(
            "warped_stem_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


    }
}