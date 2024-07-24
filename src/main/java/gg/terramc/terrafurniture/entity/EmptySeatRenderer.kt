package gg.terramc.terrafurniture.entity

import gg.terramc.terrafurniture.block.entity.SeatEntity
import net.minecraft.client.render.Frustum
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.util.Identifier


class EmptySeatRenderer(ctx: EntityRendererFactory.Context) : EntityRenderer<SeatEntity>(ctx) {
    override fun shouldRender(entity: SeatEntity?, frustum: Frustum?, d: Double, e: Double, f: Double): Boolean {
        return false
    }

    override fun getTexture(entity: SeatEntity?): Identifier? {
        return null
    }
}