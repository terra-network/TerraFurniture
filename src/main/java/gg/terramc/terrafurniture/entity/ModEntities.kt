package gg.terramc.terrafurniture.entity

import gg.terramc.terrafurniture.TerraFurniture
import gg.terramc.terrafurniture.block.entity.SeatEntity
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class ModEntities {
    companion object {
        val SEAT: EntityType<SeatEntity> = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier(TerraFurniture.MOD_ID, "seat"),
            FabricEntityTypeBuilder.create<SeatEntity>(SpawnGroup.MISC, ::SeatEntity).dimensions(
                EntityDimensions.fixed(0.001F, 0.001F)
            ).build()
        )
    }
}