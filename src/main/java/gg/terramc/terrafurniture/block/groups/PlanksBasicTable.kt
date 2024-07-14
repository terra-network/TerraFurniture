package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.TableBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class PlanksBasicTable {
    companion object {

        val OAK_PLANKS_TABLE = registerBlock(
            "oak_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.OAK_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val SPRUCE_PLANKS_TABLE = registerBlock(
            "spruce_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.SPRUCE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val MANGROVE_PLANKS_TABLE = registerBlock(
            "mangrove_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.MANGROVE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val JUNGLE_PLANKS_TABLE = registerBlock(
            "jungle_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.JUNGLE_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val DARK_OAK_PLANKS_TABLE = registerBlock(
            "dark_oak_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.DARK_OAK_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val CHERRY_PLANKS_TABLE = registerBlock(
            "cherry_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.CHERRY_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val BIRCH_PLANKS_TABLE = registerBlock(
            "birch_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.BIRCH_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )

        val ACACIA_PLANKS_TABLE = registerBlock(
            "acacia_planks_table", TableBlock(
                FabricBlockSettings.copyOf(
                    Blocks.ACACIA_PLANKS
                )
            ), ModItemGroups.TERRAFURNITURE
        )
    }
}