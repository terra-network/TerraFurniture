package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.PostTableBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class LogPostTable {
    companion object {
        val OAK_LOG_POST_TABLE = registerBlock(
            "oak_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val SPRUCE_LOG_POST_TABLE = registerBlock(
            "spruce_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val MANGROVE_LOG_POST_TABLE = registerBlock(
            "mangrove_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val JUNGLE_LOG_POST_TABLE = registerBlock(
            "jungle_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val DARK_OAK_LOG_POST_TABLE = registerBlock(
            "dark_oak_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val CHERRY_LOG_POST_TABLE = registerBlock(
            "cherry_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val BIRCH_LOG_POST_TABLE = registerBlock(
            "birch_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val ACACIA_LOG_POST_TABLE = registerBlock(
            "acacia_log_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val CRIMSON_STEM_POST_TABLE = registerBlock(
            "crimson_stem_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val WARPED_STEM_POST_TABLE = registerBlock(
            "warped_stem_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val BAMBOO_BLOCK_POST_TABLE = registerBlock(
            "bamboo_block_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )
    }
}