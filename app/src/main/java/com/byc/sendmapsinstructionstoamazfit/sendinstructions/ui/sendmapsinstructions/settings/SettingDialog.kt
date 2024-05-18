package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.data.Setting
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.commons.CustomCard
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.SendMapsInstructionsViewModel

@Composable
fun SettingDialog(
    viewModel: SendMapsInstructionsViewModel,
    setting: Setting
) {
    var selectedItem by rememberSaveable {
        mutableStateOf("Vibración corta") // TODO: Obtener ese valor inicial de forma dinámica
    }
    val showDialog: Boolean by viewModel.showDialog.observeAsState(initial = false)

    if (showDialog) {
        Dialog(
            onDismissRequest = { viewModel.onDismissDialog() },
        ) {
            Column {
                Row(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 8.dp),
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Setting dialog icon",
                        tint = Color.LightGray
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = setting.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = Color.LightGray
                    )
                }
                CustomCard {
                    LazyColumn {
                        items(
                            // TODO: Obtener esta lista de forma dinámica
                            listOf(
                                "Apagado",
                                "Vibración corta",
                                "Vibración larga"
                            )
                        ) { item ->
                            Row {
                                RadioButton(
                                    selected = selectedItem == item,
                                    onClick = { selectedItem = item },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Blue,
                                        unselectedColor = Color.LightGray
                                    )
                                )
                                Text(
                                    modifier = Modifier.align(Alignment.CenterVertically),
                                    text = item,
                                    color = Color.LightGray
                                )
                            }
                        }
                    }
                }
                TextButton(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(8.dp),
                    onClick = { viewModel.onSelectedOption() },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Green,
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(text = "ACEPTAR")
                }
            }
        }
    }
}
