package gg.terramc.terrafurniture.block

import gg.terramc.terrafurniture.TerraFurniture
import gg.terramc.terrafurniture.block.entity.DrawerInventoryBlockEntity
import gg.terramc.terrafurniture.block.groups.LogBasicDrawer
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class ModBlockEntities {
    companion object {
        val DRAWER: BlockEntityType<DrawerInventoryBlockEntity> = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier(TerraFurniture.MOD_ID, "drawer"),
            FabricBlockEntityTypeBuilder.create(
                ::DrawerInventoryBlockEntity,
                LogBasicDrawer.OAK_LOG_DRAWER
            ).build()
        )
    }
}