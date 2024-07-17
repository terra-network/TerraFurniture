package gg.terramc.terrafurniture.block.entity

import gg.terramc.terrafurniture.block.ModBlockEntities
import gg.terramc.terrafurniture.block.custom.DrawersBlock
import gg.terramc.terrafurniture.util.ModScreenHandler
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.entity.LootableContainerBlockEntity
import net.minecraft.block.entity.ViewerCountManager
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.screen.GenericContainerScreenHandler
import net.minecraft.screen.ScreenHandler
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3i
import net.minecraft.world.World


class DrawerInventoryBlockEntity(
    blockPos: BlockPos, blockState: BlockState
) : LootableContainerBlockEntity(ModBlockEntities.DRAWER, blockPos, blockState) {
    var inventory = DefaultedList.ofSize(18, ItemStack.EMPTY)

    override fun size(): Int {
        return 18
    }

    override fun getContainerName(): Text {
        return Text.translatable("container.terrafurniture.drawer")
    }

    override fun createScreenHandler(syncId: Int, playerInventory: PlayerInventory): ScreenHandler {
        return ModScreenHandler.createGeneric9x2(syncId, playerInventory, this)
    }

    override fun getInvStackList(): DefaultedList<ItemStack> {
        return this.inventory
    }

    override fun setInvStackList(list: DefaultedList<ItemStack>?) {
        this.inventory = list
    }

    override fun writeNbt(nbt: NbtCompound?) {
        super.writeNbt(nbt)
        if (!this.serializeLootTable(nbt)) {
            Inventories.writeNbt(nbt, this.inventory)
        }
    }

    override fun readNbt(nbt: NbtCompound?) {
        super.readNbt(nbt)
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY)
        if (!this.deserializeLootTable(nbt)) {
            Inventories.readNbt(nbt, this.inventory)
        }
    }

    override fun onOpen(player: PlayerEntity) {
        if (!this.removed && !player.isSpectator) {
            this.stateManager.openContainer(player, this.getWorld(), this.getPos(), this.cachedState)
        }
    }

    override fun onClose(player: PlayerEntity) {
        if (!this.removed && !player.isSpectator) {
            this.stateManager.closeContainer(player, this.getWorld(), this.getPos(), this.cachedState)
        }
    }

    fun tick() {
        if (!this.removed) {
            this.stateManager.updateViewerCount(this.getWorld(), this.getPos(), this.cachedState)
        }
    }

    fun setOpen(state: BlockState, open: Boolean) {
        this.world?.setBlockState(this.getPos(), state.with(DrawersBlock.OPEN, open), Block.NOTIFY_ALL)
    }


    private val stateManager: ViewerCountManager = object : ViewerCountManager() {
        override fun onContainerOpen(world: World, pos: BlockPos, state: BlockState) {
            this@DrawerInventoryBlockEntity.playSound(state, SoundEvents.BLOCK_BARREL_OPEN)
            this@DrawerInventoryBlockEntity.setOpen(state, true)
        }

        override fun onContainerClose(world: World, pos: BlockPos, state: BlockState) {
            this@DrawerInventoryBlockEntity.playSound(state, SoundEvents.BLOCK_BARREL_CLOSE)
            this@DrawerInventoryBlockEntity.setOpen(state, false)
        }

        override fun onViewerCountUpdate(
            world: World,
            pos: BlockPos,
            state: BlockState,
            oldViewerCount: Int,
            newViewerCount: Int
        ) {
        }

        override fun isPlayerViewing(player: PlayerEntity): Boolean {
            if (player.currentScreenHandler is GenericContainerScreenHandler) {
                val inventory = (player.currentScreenHandler as GenericContainerScreenHandler).inventory
                return inventory === this@DrawerInventoryBlockEntity
            }
            return false
        }
    }


    fun playSound(state: BlockState, soundEvent: SoundEvent?) {
        val vec3i: Vec3i = state.get(DrawersBlock.FACING).vector
        val d = pos.x.toDouble() + 0.5 + (vec3i.x.toDouble() / 2.0)
        val e = pos.y.toDouble() + 0.5 + (vec3i.y.toDouble() / 2.0)
        val f = pos.z.toDouble() + 0.5 + (vec3i.z.toDouble() / 2.0)
        world!!.playSound(
            null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5f,
            world!!.random.nextFloat() * 0.1f + 0.7f
        )
    }
}