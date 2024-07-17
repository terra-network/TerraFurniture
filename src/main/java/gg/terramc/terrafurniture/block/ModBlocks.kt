package gg.terramc.terrafurniture.block

import gg.terramc.terrafurniture.TerraFurniture
import gg.terramc.terrafurniture.block.groups.*
import gg.terramc.terrafurniture.item.ModItems
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

class ModBlocks {
    companion object {

        val LOG_TABLES = LogBasicTable
        val PLANKS_TABLE = PlanksBasicTable
        val STRIPPED_LOG_TABLE = StrippedLogBasicTable

        val LOG_POST_TABLE = LogPostTable
        val PLANKS_POST_TABLE = PlanksPostTable
        val STRIPPED_LOG_POST_TABLE = StrippedLogPostTable

        val LOG_DRAWERS = LogBasicDrawer
        val STRIPPED_LOG_DRAWERS = StrippedLogBasicDrawer
        val PLANKS_DRAWERS = PlanksBasicDrawer

        fun registerBlock(name: String, block: Block, group: RegistryKey<ItemGroup>): Block {
            ModItems.registerItem(name, BlockItem(block, FabricItemSettings()), group)
            return Registry.register(Registries.BLOCK, Identifier(TerraFurniture.MOD_ID, name), block)
        }
    }
}