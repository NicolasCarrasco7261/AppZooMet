package cl.zoomet.appzoomet.view.home.zoo.mapazoo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cl.zoomet.appzoomet.R
import cl.zoomet.appzoomet.ui.theme.ZooButtonGreen

@Composable
fun MapaZooScreen(navController: NavController){
    // Estados para controlar el zoom (escala) y el desplazamiento (offset/paneo).
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    // Usamos un Box para centrar la imagen y aplicar las transformaciones.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, ZooButtonGreen.copy(alpha = 0.9f)),
                    startY = 200f
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        // El estado transformable que escucha los gestos del usuario.
        val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
            // Actualizamos la escala, asegurando que no sea menor a 1 (tamaño original).
            scale = (scale * zoomChange).coerceAtLeast(1f)

            // Si la escala es mayor a 1, permitimos el desplazamiento.
            if (scale > 1f) {
                // Actualizamos el desplazamiento con el cambio detectado.
                offset += offsetChange
            }

            // Si la escala vuelve a 1, reseteamos el desplazamiento para centrar la imagen.
            if (scale == 1f) {
                offset = Offset.Zero
            }
        }

        Image(
            painter = painterResource(id = R.drawable.mapazoo),
            contentDescription = "Mapa del Zoológico Nacional",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                // Aplicamos las transformaciones de escala y desplazamiento a la capa gráfica.
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    translationX = offset.x
                    translationY = offset.y
                }
                // 4. Hacemos que el modifier sea "transformable" usando el estado.
                .transformable(state = state)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapaZooScreenPreview() {
    MapaZooScreen(navController = rememberNavController())
}