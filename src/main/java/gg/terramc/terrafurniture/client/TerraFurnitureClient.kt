package gg.terramc.terrafurniture.client

import gg.terramc.terrafurniture.TerraFurniture
import net.fabricmc.api.ClientModInitializer

class TerraFurnitureClient : ClientModInitializer {
    override fun onInitializeClient() {
        TerraFurniture.LOGGER.info("[INIT] TerraFurniture Client")
    }

}
