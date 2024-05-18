package com.byc.sendmapsinstructionstoamazfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.byc.sendmapsinstructionstoamazfit.sendinstructions.ui.sendmapsinstructions.SendMapsInstructionsScreen
import com.byc.sendmapsinstructionstoamazfit.ui.theme.SendMapsInstructionsToAmazfitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SendMapsInstructionsToAmazfitTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SendMapsInstructionsScreen()
                }
            }
        }
    }
}
