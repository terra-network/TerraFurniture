package gg.terramc.terrafurniture.block

import gg.terramc.terrafurniture.TerraFurniture
import gg.terramc.terrafurniture.block.custom.PostTableBlock
import gg.terramc.terrafurniture.block.custom.TableBlock
import gg.terramc.terrafurniture.block.groups.LogBasicTable
import gg.terramc.terrafurniture.item.ModItems
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

class ModBlocks {
    companion object {

        val LOG_TABLES = LogBasicTable

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

        val ACACIA_POST_TABLE = registerBlock(
            "acacia_planks_post_table", PostTableBlock(
                FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)
            ), ModItemGroups.TERRAFURNITURE
        )

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

        fun registerBlock(name: String, block: Block, group: RegistryKey<ItemGroup>): Block {
            ModItems.registerItem(name, BlockItem(block, FabricItemSettings()), group)
            return Registry.register(Registries.BLOCK, Identifier(TerraFurniture.MOD_ID, name), block)
        }
    }
}