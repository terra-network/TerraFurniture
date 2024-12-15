package gg.terramc.terrafurniture.util

import gg.terramc.terrafurniture.TerraFurniture
import gg.terramc.terrafurniture.item.ModItems
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier

class ModItemGroups {
    companion object {
        val TERRAFURNITURE_GROUP = FabricItemGroup.builder().icon { ->
            ItemStack(ModItems.getItem("oak_planks_table"))
        }.displayName(Text.translatable("terrafurniture.terrafurniture_group")).build()
        val TERRAFURNITURE = registerGroup("terrafurniture", TERRAFURNITURE_GROUP)

        private fun registerGroup(key: String, group: ItemGroup): RegistryKey<ItemGroup> {
            val registryKey = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier(TerraFurniture.MOD_ID, key))
            Registry.register(Registries.ITEM_GROUP, registryKey, group)
            return registryKey
        }
    }
}