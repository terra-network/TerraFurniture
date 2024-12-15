package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.PostTableBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class StrippedLogPostTable {
    companion object {
        val STRIPPED_OAK_LOG_POST_TABLE = registerBlock(
            "stripped_oak_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_SPRUCE_LOG_POST_TABLE = registerBlock(
            "stripped_spruce_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_MANGROVE_LOG_POST_TABLE = registerBlock(
            "stripped_mangrove_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_JUNGLE_LOG_POST_TABLE = registerBlock(
            "stripped_jungle_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_DARK_OAK_LOG_POST_TABLE = registerBlock(
            "stripped_dark_oak_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_CHERRY_LOG_POST_TABLE = registerBlock(
            "stripped_cherry_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_BIRCH_LOG_POST_TABLE = registerBlock(
            "stripped_birch_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_ACACIA_LOG_POST_TABLE = registerBlock(
            "stripped_acacia_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_CRIMSON_STEM_POST_TABLE = registerBlock(
            "stripped_crimson_stem_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_WARPED_STEM_POST_TABLE = registerBlock(
            "stripped_warped_stem_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_BAMBOO_BLOCK_POST_TABLE = registerBlock(
            "stripped_bamboo_block_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )
    }
}