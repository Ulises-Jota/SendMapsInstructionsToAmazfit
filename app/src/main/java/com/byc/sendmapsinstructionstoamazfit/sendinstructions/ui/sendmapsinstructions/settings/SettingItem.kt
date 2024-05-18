package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.data.Setting
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.data.Setting.*
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.SendMapsInstructionsViewModel

@Composable
fun SettingItem(
    viewModel: SendMapsInstructionsViewModel,
    setting: Setting
) {
    var settingType by rememberSaveable { mutableStateOf(SettingType.SWITCH) }
    var switchState by rememberSaveable { mutableStateOf(false) }

    if (settingType == SettingType.DIALOG)
        viewModel.onShowDialog()
        SettingDialog(
            viewModel = viewModel,
            setting = setting
        )

    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                settingType = when (setting.type) {
                    SettingType.DIALOG -> {
                        SettingType.DIALOG
                    }

                    SettingType.SWITCH -> {
                        SettingType.SWITCH
                    }
                }
            }
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            imageVector = setting.icon,
            contentDescription = "Setting icon"
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(12f)
        ) {
            Text(text = setting.title)
            Text(text = setting.description)
        }

        Spacer(modifier = Modifier.weight(2f))

        when (setting.type) {
            SettingType.DIALOG -> {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Setting type icon"
                )
            }

            SettingType.SWITCH -> {
                Switch(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    checked = switchState,
                    onCheckedChange = { switchState = !switchState }
                )
            }
        }
    }
}
