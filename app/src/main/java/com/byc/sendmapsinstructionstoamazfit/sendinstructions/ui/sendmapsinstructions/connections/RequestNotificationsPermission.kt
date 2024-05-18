package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.connections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RequestNotificationsPermission(
    requestNotificationsPermission: () -> Unit
) {
    Row {
        Icon(
            modifier = Modifier
                .align(Alignment.Top)
                .padding(
                    start = 8.dp,
                    top = 8.dp
                ),
            imageVector = Icons.Default.Warning,
            contentDescription = "Indications Icon",
            tint = Color.Red
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "Esta aplicación necesita acceso a las notificaciones. " +
                        "Debe permitir el acceso en la configuración de su teléfono."
            )
            OutlinedButton(
                onClick = { requestNotificationsPermission() },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Red
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    tint = Color.Red,
                    contentDescription = "Button icon"
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text(text = "PERMITIR")
            }
        }
    }
}