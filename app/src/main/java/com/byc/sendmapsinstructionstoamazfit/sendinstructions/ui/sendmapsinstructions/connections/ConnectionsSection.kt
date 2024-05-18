package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.connections

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.commons.CustomCard
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.SendMapsInstructionsViewModel

@Composable
fun ConnectionsSection(
    sendMapsInstructionsViewModel: SendMapsInstructionsViewModel = viewModel()
) {
    val isWatchConnected: Boolean by sendMapsInstructionsViewModel
        .isWatchConnected
        .observeAsState(initial = false)

    val hasBackgroundExecutionPermission: Boolean by sendMapsInstructionsViewModel
        .hasBackgroundExecutionPermission
        .observeAsState(initial = false)

    val hasListenNotificationsPermission: Boolean by sendMapsInstructionsViewModel
        .hasListenNotificationsPermission
        .observeAsState(initial = false)

    CustomCard {
        if (isWatchConnected) {
            SmartwatchConnected()
        } else {
            SmartwatchDisconnected(sendMapsInstructionsViewModel.navigateToZeppApp())
        }

        if (!hasBackgroundExecutionPermission) {
            RequestBackgroundExecutionPermissionDialog(sendMapsInstructionsViewModel.requestBackgroundExecutionPermission())
        }

        if (!hasListenNotificationsPermission) {
            RequestNotificationsPermission(sendMapsInstructionsViewModel.requestNotificationsPermission())
        }

        Spacer(modifier = Modifier.size(8.dp))

        InitializeGoogleMapsNavigation(sendMapsInstructionsViewModel.navigateToGoogleMaps())
    }
}
