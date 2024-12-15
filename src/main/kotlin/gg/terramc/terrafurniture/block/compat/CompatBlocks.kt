package gg.terramc.terrafurniture.block.compat

import gg.terramc.terrafurniture.block.compat.groups.*

class CompatBlocks {
    companion object {
        fun registerRegionsUnexploredBlocks() {
            LogBasicTable.registerRegionsUnexploredBlocks()
            PlanksBasicTable.registerRegionsUnexploredBlocks()
            StrippedLogBasicTable.registerRegionsUnexploredBlocks()
            LogPostTable.registerRegionsUnexploredBlocks()
            PlanksPostTable.registerRegionsUnexploredBlocks()
            StrippedLogPostTable.registerRegionsUnexploredBlocks()
            LogBasicDrawer.registerRegionsUnexploredBlocks()
            StrippedLogBasicDrawer.registerRegionsUnexploredBlocks()
            PlanksBasicDrawer.registerRegionsUnexploredBlocks()
        }
    }
}