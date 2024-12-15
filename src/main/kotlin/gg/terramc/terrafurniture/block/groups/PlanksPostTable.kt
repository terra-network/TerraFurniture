package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.PostTableBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class PlanksPostTable {
    companion object {
        val OAK_PLANKS_POST_TABLE = registerBlock(
            "oak_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val SPRUCE_PLANKS_POST_TABLE = registerBlock(
            "spruce_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val MANGROVE_PLANKS_POST_TABLE = registerBlock(
            "mangrove_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val JUNGLE_PLANKS_POST_TABLE = registerBlock(
            "jungle_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val DARK_OAK_PLANKS_POST_TABLE = registerBlock(
            "dark_oak_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val CHERRY_PLANKS_POST_TABLE = registerBlock(
            "cherry_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val BIRCH_PLANKS_POST_TABLE = registerBlock(
            "birch_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val ACACIA_PLANKS_POST_TABLE = registerBlock(
            "acacia_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val CRIMSON_PLANKS_POST_TABLE = registerBlock(
            "crimson_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val WARPED_PLANKS_POST_TABLE = registerBlock(
            "warped_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

        val BAMBOO_PLANKS_POST_TABLE = registerBlock(
            "bamboo_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )
    }
}