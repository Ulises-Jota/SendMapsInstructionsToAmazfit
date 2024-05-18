package com.byc.sendmapsinstructionstoamazfit.sendinstructions.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Setting(
    val icon: ImageVector,
    val title: String,
    val description: String,
    val type: SettingType
) {
    enum class SettingType {
        SWITCH,
        DIALOG
    }
}
