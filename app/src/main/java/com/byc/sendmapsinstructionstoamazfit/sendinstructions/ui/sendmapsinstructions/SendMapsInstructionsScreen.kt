package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.connections.ConnectionsSection
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.header.HeaderSection
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.settings.SettingsSection

@Preview
@Composable
fun SendMapsInstructionsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderSection()
        ConnectionsSection()
        SettingsSection()
//        HelpSection()
    }
}
