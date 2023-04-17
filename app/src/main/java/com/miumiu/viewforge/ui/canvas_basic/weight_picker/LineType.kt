package com.miumiu.viewforge.ui.canvas_basic.weight_picker

sealed class LineType {
    object Normal: LineType()
    object FiveStep: LineType()
    object TenStep : LineType()
}
