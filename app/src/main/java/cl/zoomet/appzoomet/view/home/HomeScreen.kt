package cl.zoomet.appzoomet.view.home

import android.content.Intent
import android.net.Uri
import cl.zoomet.appzoomet.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cl.zoomet.appzoomet.view.core.navigation.Animales
import cl.zoomet.appzoomet.view.core.navigation.MapaZoo

// Definición de colores extraídos de la imagen
val ZooBrown = Color(0xFF7B6032)
val ZooButtonYellow = Color(0xFFE0C29A)

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    navController: NavController
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    fun abrirGoogleMaps() {
        // Puedes usar coordenadas o una búsqueda. Aquí un ejemplo de búsqueda de un lugar.
        val uri = "google.navigation:q=Parque+Metropolitano+de+Santiago"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.setPackage("com.google.android.apps.maps")
        context.startActivity(intent)
    }

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // --- CAPA DE FONDO (IMÁGENES) ---
            Column(Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.lion),
                    contentDescription = "leon decorativo", // Decorativo
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.42f),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(id = R.drawable.manchasleopardo),
                    contentDescription = "manchas decorativas", // Decorativo
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.58f),
                    contentScale = ContentScale.Crop
                )
            }

            // --- CAPA FRONTAL (BANNER Y BOTONES) ---
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Espaciador para empujar el banner hasta la unión de las imágenes
                Spacer(modifier = Modifier.weight(0.48f))

                // Banner "ZOO NACIONAL" (se centrará en la unión)
                Surface(
                    color = ZooBrown,
                    modifier = Modifier
                        .width(240.dp)
                        .offset(y = (-24).dp) // Sube la mitad de su altura para centrarse
                ) {
                    Text(
                        text = "ZOO NACIONAL",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
                        textAlign = TextAlign.Center
                    )
                }

                // Contenido de la parte inferior (botones)
                Column(
                    modifier = Modifier.weight(0.6f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ZooButton(
                        text = "ANIMALES",
                        icon = Icons.Default.Favorite,
                        onClick = { navController.navigate(Animales) }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    ZooButton(
                        text = "MAPA ZOO",
                        icon = Icons.Default.Info,
                        onClick = { navController.navigate(MapaZoo) }
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    ZooButton(
                        text = "DIRECCIÓN",
                        icon = Icons.Default.LocationOn,
                        onClick = { abrirGoogleMaps() }
                    )
                }
            }
        }
    }
}

@Composable
fun ZooButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = ZooButtonYellow,
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .padding(horizontal = 24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(72.dp))
            Text(
                text = text,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}