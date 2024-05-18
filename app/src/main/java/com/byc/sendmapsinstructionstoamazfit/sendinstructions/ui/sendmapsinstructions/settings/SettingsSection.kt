package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.commons.CustomCard
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.SendMapsInstructionsViewModel

@Composable
fun SettingsSection(
    sendMapsInstructionsViewModel: SendMapsInstructionsViewModel = viewModel()
) {
    CustomCard {
        Column {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Ajustes"
            )

            SettingsList(
                viewModel = sendMapsInstructionsViewModel,
                settingsList = sendMapsInstructionsViewModel.getSettingsList()
            )
        }
    }
}
