package cl.zoomet.appzoomet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.zoomet.appzoomet.ui.theme.AppZooMetTheme
import cl.zoomet.appzoomet.view.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppZooMetTheme() {
                NavigationWrapper()
            }
        }
    }
}