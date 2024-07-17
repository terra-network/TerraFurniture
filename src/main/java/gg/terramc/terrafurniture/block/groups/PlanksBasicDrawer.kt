package gg.terramc.terrafurniture.block.groups

import gg.terramc.terrafurniture.block.ModBlocks.Companion.registerBlock
import gg.terramc.terrafurniture.block.custom.DrawersBlock
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Blocks

class PlanksBasicDrawer {
    companion object {

        val ACACIA_PLANKS_DRAWER = registerBlock(
            "acacia_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val OAK_PLANKS_DRAWER = registerBlock(
            "oak_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val BAMBOO_PLANKS_DRAWER = registerBlock(
            "bamboo_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val BIRCH_PLANKS_DRAWER = registerBlock(
            "birch_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val CHERRY_PLANKS_DRAWER = registerBlock(
            "cherry_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val CRIMSON_PLANKS_DRAWER = registerBlock(
            "crimson_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val DARK_OAK_PLANKS_DRAWER = registerBlock(
            "dark_oak_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val JUNGLE_PLANKS_DRAWER = registerBlock(
            "jungle_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val MANGROVE_PLANKS_DRAWER = registerBlock(
            "mangrove_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val SPRUCE_PLANKS_DRAWER = registerBlock(
            "spruce_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


        val WARPED_PLANKS_DRAWER = registerBlock(
            "warped_planks_drawer",
            DrawersBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)),
            ModItemGroups.TERRAFURNITURE
        )


    }
}