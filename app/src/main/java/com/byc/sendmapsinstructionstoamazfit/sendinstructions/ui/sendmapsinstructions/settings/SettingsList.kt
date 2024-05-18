package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.data.Setting
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.SendMapsInstructionsViewModel

@Composable
fun SettingsList(
    viewModel: SendMapsInstructionsViewModel,
    settingsList: List<Setting>
) {
    LazyColumn(
        modifier = Modifier.height(250.dp),
        userScrollEnabled = false,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(
            items = settingsList
        ) { setting ->
            SettingItem(
                viewModel = viewModel,
                setting = setting
            )
        }
    }
}
