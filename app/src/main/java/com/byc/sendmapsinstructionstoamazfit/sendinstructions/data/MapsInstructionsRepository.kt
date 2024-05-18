package com.byc.sendmapsinstructionstoamazfit.sendinstructions.data

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import com.byc.sendmapsinstructionstoamazfit.BuildConfig
import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MapsInstructionsRepository @Inject constructor() {
    fun getSettingsList(): List<Setting> =
        listOf(
            Setting(
                icon = Icons.Default.Edit,
                title = "Vibración",
                description = "Establece el modo de vibración",
                type = Setting.SettingType.DIALOG
            ),
            Setting(
                icon = Icons.Default.AccountCircle,
                title = "Esquema de colores",
                description = "Establece colores para los elementos de navegación",
                type = Setting.SettingType.DIALOG
            ),
            Setting(
                icon = Icons.Default.Call,
                title = "Mostrar hora actual",
                description = "Muestra la hora actual durante la navegación",
                type = Setting.SettingType.SWITCH
            ),
        )
}
