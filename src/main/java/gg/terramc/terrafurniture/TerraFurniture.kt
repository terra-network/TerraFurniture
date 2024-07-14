package gg.terramc.terrafurniture

import gg.terramc.terrafurniture.block.ModBlocks
import gg.terramc.terrafurniture.item.ModItems
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TerraFurniture : ModInitializer {

    companion object {
        val MOD_ID = TerraFurniture::class.java.simpleName.lowercase()
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }

    override fun onInitialize() {
        LOGGER.info("[INIT] TerraFurniture 0.1-SNAPSHOT")
        ModItemGroups
        ModItems
        ModBlocks
    }

}