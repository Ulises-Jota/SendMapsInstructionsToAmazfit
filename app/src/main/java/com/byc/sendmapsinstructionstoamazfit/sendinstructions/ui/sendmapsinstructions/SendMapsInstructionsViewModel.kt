package com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.data.MapsInstructionsRepository
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.data.Setting
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SendMapsInstructionsViewModel @Inject constructor(
    private val repository: MapsInstructionsRepository
) : ViewModel() {
    // 1. Si la app no tiene permisos para escuchar las notificaciones, mostrar un alert dialog
    // que los solicite y navegar a la configuración de notificaciones de la app.
    // 2. Si la app no está excluida de las optimizaciones de la batería (permisos para ejecutarse en segundo plano),
    // mostrar en pantalla el warning y un switch para permitirlo que abirá el dialog para permitirlo (falta el diseño de ese elemento).
    // 3. Si no recibe solicitudes del reloj (ver si es así), mostrar en pantalla que debe conectar el reloj (SmartwatchDisconnected)
    // 4. Crear e iniciar el servicio que observa las notificaciones de Google Maps
    // 5. Cuando lo anterior está hecho, enviar las instrucciones al reloj.

    // Permisos de notificaciones
    private val _hasListenNotificationsPermission = MutableLiveData<Boolean>()
    val hasListenNotificationsPermission: LiveData<Boolean> = _hasListenNotificationsPermission

    // Permisos para ejecución en segundo plano
    private val _hasBackgroundExecutionPermission = MutableLiveData<Boolean>()
    val hasBackgroundExecutionPermission: LiveData<Boolean> = _hasBackgroundExecutionPermission

    // Conexión del reloj
    private val _isWatchConnected = MutableLiveData<Boolean>()
    val isWatchConnected: LiveData<Boolean> = _isWatchConnected

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    init {
        viewModelScope.launch {
            if (hasBackgroundExecutionPermission()
                && hasListenNotificationsPermission()
                && isWatchAlreadyConnected()
            ) {
                createNotificationListenerService()
            }
        }
    }

    fun onDismissDialog() {
        _showDialog.value = false
    }

    fun onShowDialog() {
        _showDialog.value = true
    }

    fun onSelectedOption() {
        // TODO: Select option?
        onDismissDialog()
    }

    private fun hasListenNotificationsPermission(): Boolean {
        val hasPermission = false // TODO: Add this check
        _hasListenNotificationsPermission.value = hasPermission
        return hasPermission
    }

    private fun hasBackgroundExecutionPermission(): Boolean {
        val hasPermission = true // TODO: Add this check
        _hasBackgroundExecutionPermission.value = hasPermission
        return hasPermission
    }

    private fun isWatchAlreadyConnected(): Boolean {
        val hasPermission = true // TODO: Add this check
        _isWatchConnected.value = hasPermission
        return hasPermission
    }

    private fun createNotificationListenerService() {
        Log.d("JAVI", "createNotificationListenerService")
        if (true)
            sendInstructionToWatch("sendInstructionToWatch")
    }

    private fun sendInstructionToWatch(
        instruction: String
    ) =
        Log.d("JAVI", "$instruction")

    fun getSettingsList(): List<Setting> =
        repository.getSettingsList()

    fun navigateToGoogleMaps(): () -> Unit = {
        Log.d("JAVI", "Test navigateToGoogleMaps")
    }

    fun navigateToZeppApp(): () -> Unit = {
        Log.d("JAVI", "Test navigateToZeppApp")
    }

    fun requestNotificationsPermission(): () -> Unit = {
        Log.d("JAVI", "requestNotificationsPermission")
    }

    fun requestBackgroundExecutionPermission(): () -> Unit = {
        Log.d("JAVI", "requestBackgroundExecutionPermission")
    }
}
