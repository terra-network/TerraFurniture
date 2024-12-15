package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.TableBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class LogBasicTable {
    companion object {

        val OAK_LOG_TABLE = registerBlock(
            "oak_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.OAK_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val SPRUCE_LOG_TABLE = registerBlock(
            "spruce_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.SPRUCE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val MANGROVE_LOG_TABLE = registerBlock(
            "mangrove_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.MANGROVE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val JUNGLE_LOG_TABLE = registerBlock(
            "jungle_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.JUNGLE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val DARK_OAK_LOG_TABLE = registerBlock(
            "dark_oak_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.DARK_OAK_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val CHERRY_LOG_TABLE = registerBlock(
            "cherry_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.CHERRY_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val BIRCH_LOG_TABLE = registerBlock(
            "birch_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.BIRCH_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val ACACIA_LOG_TABLE = registerBlock(
            "acacia_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.ACACIA_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val BAMBOO_BLOCK_TABLE = registerBlock(
            "bamboo_block_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.BAMBOO_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val WARPED_STEM_TABLE = registerBlock(
            "warped_stem_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.WARPED_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val CRIMSON_STEM_TABLE = registerBlock(
            "crimson_stem_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.CRIMSON_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )
    }
}