package gg.terramc.terrafurniture.item

import gg.terramc.terrafurniture.TerraFurniture
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier


class ModItems {
    companion object {
        val TEST_ITEM = registerItem(
            "test_item",
            Item(Item.Settings().food(FoodComponent.Builder().build())),
            ModItemGroups.TERRAFURNITURE
        )

        fun registerItem(name: String, item: Item, group: RegistryKey<ItemGroup>): Item {
            addToItemGroup(group, item)
            return Registry.register(Registries.ITEM, Identifier(TerraFurniture.MOD_ID, name), item)
        }

        fun getItem(name: String): Item {
            return Registries.ITEM.get(Identifier(TerraFurniture.MOD_ID, name))
        }

        private fun addToItemGroup(group: RegistryKey<ItemGroup>, item: Item) {
            ItemGroupEvents.modifyEntriesEvent(group).register { entries -> entries.add(item) }
        }
    }
}