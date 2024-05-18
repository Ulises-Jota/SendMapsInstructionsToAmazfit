package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.connections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SmartwatchConnected() {
    Row {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(
                    start = 8.dp
                ),
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Smartwatch Icon",
            tint = Color.Green
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Amazfit T-Rex 2",
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = "Conectado"
            )
        }
    }
}
