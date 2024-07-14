package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.TableBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class StrippedLogBasicTable {
    companion object {

        val STRIPPED_OAK_LOG_TABLE = registerBlock(
            "stripped_oak_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.OAK_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_SPRUCE_LOG_TABLE = registerBlock(
            "stripped_spruce_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.SPRUCE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_MANGROVE_LOG_TABLE = registerBlock(
            "stripped_mangrove_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.MANGROVE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_JUNGLE_LOG_TABLE = registerBlock(
            "stripped_jungle_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.JUNGLE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_DARK_OAK_LOG_TABLE = registerBlock(
            "stripped_dark_oak_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.DARK_OAK_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_CHERRY_LOG_TABLE = registerBlock(
            "stripped_cherry_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.CHERRY_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_BIRCH_LOG_TABLE = registerBlock(
            "stripped_birch_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.BIRCH_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val STRIPPED_ACACIA_LOG_TABLE = registerBlock(
            "stripped_acacia_log_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.ACACIA_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )
    }
}