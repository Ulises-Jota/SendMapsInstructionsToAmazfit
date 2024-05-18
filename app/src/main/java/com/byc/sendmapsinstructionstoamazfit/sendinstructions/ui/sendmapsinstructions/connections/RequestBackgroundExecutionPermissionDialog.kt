package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.connections

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun RequestBackgroundExecutionPermissionDialog(
    requestBackgroundExecutionPermission: () -> Unit
) {
    AlertDialog(
        title = {
            Text(
                text = "Optimizaciones de batería habilitadas",
                color = Color.LightGray
            )
        },
        text = {
            Text(
                text = "Esta aplicación debe exluirse de las optimizaciones de la batería. " +
                        "Debe permitir que esta aplicación se ejecute en segundo plano en la configuración " +
                        "de su teléfono.",
                color = Color.LightGray,
                fontSize = 18.sp
            )
        },
        containerColor = Color.DarkGray,
        onDismissRequest = { /* OnDismiss() */ },
        dismissButton = {
            TextButton(
                onClick = { /* OnDismiss() */ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Gray,
                    containerColor = Color.Transparent
                )
            ) {
                Text(text = "CANCELAR")
            }
        },
        confirmButton = {
            TextButton(
                onClick = { requestBackgroundExecutionPermission() },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Green,
                    containerColor = Color.Transparent
                )
            ) {
                Text(text = "PERMITIR")
            }
        }
    )
}
