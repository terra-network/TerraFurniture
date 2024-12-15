package gg.terramc.terrafurniture.util

import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventory
import net.minecraft.screen.GenericContainerScreenHandler
import net.minecraft.screen.ScreenHandlerType

class ModScreenHandler(
    type: ScreenHandlerType<*>,
    syncId: Int,
    playerInventory: PlayerInventory,
    inventory: Inventory,
    rows: Int
) : GenericContainerScreenHandler(type, syncId, playerInventory, inventory, rows) {
    companion object {
        fun createGeneric9x2(syncId: Int, playerInventory: PlayerInventory, inventory: Inventory): ModScreenHandler {
            return ModScreenHandler(ScreenHandlerType.GENERIC_9X2, syncId, playerInventory, inventory, 2)
        }
    }
}