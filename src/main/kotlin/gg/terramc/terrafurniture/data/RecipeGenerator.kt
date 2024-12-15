package gg.terramc.terrafurniture.data

import gg.terramc.terrafurniture.block.ModBlocks
import gg.terramc.terrafurniture.block.compat.CompatBlocks
import gg.terramc.terrafurniture.item.ModItems
import gg.terramc.terrafurniture.util.ModItemGroups
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import java.util.function.Consumer

class RecipeGenerator(output: FabricDataOutput?) : FabricRecipeProvider(output) {
    fun getTagKey(name: String): TagKey<Item> {
        return TagKey.of(RegistryKeys.ITEM, Identifier(name))
    }

    fun getItem(name: String): Item {
        return Registries.ITEM.get(Identifier(name))
    }

    override fun generate(exporter: Consumer<RecipeJsonProvider>?) {

        ModItemGroups
        ModItems
        ModBlocks
        CompatBlocks.registerRegionsUnexploredBlocks()

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LOG_TABLES.OAK_LOG_TABLE).pattern("ttt")
            .pattern("i i")
            .pattern("i i").input('t', getTagKey("minecraft:oak_log")).input('i', getTagKey("minecraft:stick"))
            .criterion(
                hasItem(getItem("minecraft:oak_log")), conditionsFromItem(getItem("minecraft:oak_log"))
            )
            .criterion(
                hasItem(getItem("minecraft:stick")), conditionsFromItem(getItem("minecraft:stick"))
            )
            .offerTo(exporter)
    }

}