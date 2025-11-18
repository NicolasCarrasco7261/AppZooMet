package cl.zoomet.appzoomet.view.home.zoo.mapazoo

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavController

@Composable
fun MapaZooScreen(navController: NavController){
    Surface (
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp,
        shadowElevation = 4.dp
    ) {
        Text(
            text = "Hola desde Surface",
            modifier = Modifier.padding(16.dp)
        )
    }

}