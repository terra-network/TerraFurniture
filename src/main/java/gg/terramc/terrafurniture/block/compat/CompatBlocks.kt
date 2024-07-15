package gg.terramc.terrafurniture.block.compat

import gg.terramc.terrafurniture.block.compat.groups.LogBasicTable
import gg.terramc.terrafurniture.block.compat.groups.PlanksBasicTable
import gg.terramc.terrafurniture.block.compat.groups.StrippedLogBasicTable

class CompatBlocks {
    companion object {
        fun registerRegionsUnexploredBlocks() {
            LogBasicTable.registerRegionsUnexploredBlocks()
            PlanksBasicTable.registerRegionsUnexploredBlocks()
            StrippedLogBasicTable.registerRegionsUnexploredBlocks()
        }
    }
}