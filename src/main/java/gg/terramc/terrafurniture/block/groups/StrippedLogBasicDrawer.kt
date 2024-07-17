package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.DrawersBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class StrippedLogBasicDrawer {
    companion object {

        val STRIPPED_ACACIA_LOG_DRAWER = registerBlock(
            "stripped_acacia_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_OAK_LOG_DRAWER = registerBlock(
            "stripped_oak_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_BAMBOO_BLOCK_DRAWER = registerBlock(
            "stripped_bamboo_block_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_BIRCH_LOG_DRAWER = registerBlock(
            "stripped_birch_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_CHERRY_LOG_DRAWER = registerBlock(
            "stripped_cherry_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_CRIMSON_STEM_DRAWER = registerBlock(
            "stripped_crimson_stem_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_DARK_OAK_LOG_DRAWER = registerBlock(
            "stripped_dark_oak_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_JUNGLE_LOG_DRAWER = registerBlock(
            "stripped_jungle_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_MANGROVE_LOG_DRAWER = registerBlock(
            "stripped_mangrove_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_SPRUCE_LOG_DRAWER = registerBlock(
            "stripped_spruce_log_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val STRIPPED_WARPED_STEM_DRAWER = registerBlock(
            "stripped_warped_stem_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


    }
}