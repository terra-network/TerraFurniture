package gg.terramc.terrafurniture.client

import gg.terramc.terrafurniture.TerraFurniture
import gg.terramc.terrafurniture.entity.EmptySeatRenderer
import gg.terramc.terrafurniture.entity.ModEntities
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry

class TerraFurnitureClient : ClientModInitializer {
    override fun onInitializeClient() {
        TerraFurniture.LOGGER.info("[INIT] TerraFurniture Client")
        EntityRendererRegistry.register(ModEntities.SEAT, ::EmptySeatRenderer)
    }

}
