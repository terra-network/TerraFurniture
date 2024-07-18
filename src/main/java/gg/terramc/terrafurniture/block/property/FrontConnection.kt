package gg.terramc.terrafurniture.block.property

import net.minecraft.util.StringIdentifiable

enum class FrontConnection(private val value: String) : StringIdentifiable {
    NONE("none"),

    LEFT("left"),
    RIGHT("right");

    override fun asString() = value
}