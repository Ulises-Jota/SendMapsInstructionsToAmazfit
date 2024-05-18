package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.header

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.commons.CustomCard

@Composable
fun HeaderSection() {
    CustomCard {
        Text(
            text = "App Name",
            modifier = Modifier.padding(8.dp)
        )
    }
}
