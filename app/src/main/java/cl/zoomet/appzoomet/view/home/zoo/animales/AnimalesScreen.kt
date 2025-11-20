package cl.zoomet.appzoomet.view.home.zoo.animales

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import cl.zoomet.appzoomet.R
import cl.zoomet.appzoomet.ui.theme.ZooAnimalGreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun AnimalesScreen(
    animalesViewModel: AnimalesViewModel = viewModel(),
    navController: NavController
) {
    // 1. Recolectamos la lista de animales desde el ViewModel
    val animales by animalesViewModel.animales.collectAsState()

    // 2. Usaremos un PagerState para controlar el carrusel
    val pagerState = rememberPagerState(pageCount = { animales.size })

    Scaffold(
        containerColor = ZooAnimalGreen
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // Centra el contenido verticalmente
        ) {
            // Si la lista de animales no está vacía, mostramos el carrusel
            if (animales.isNotEmpty()) {
                // 3. Usamos HorizontalPager para crear el carrusel scrolleable
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp) // Deja espacio a los lados
                ) { page ->
                    // El índice 'page' nos dice qué animal mostrar
                    val animal = animales[page]
                    AnimalCard(animal = animal)
                }
            } else {
                // Muestra un indicador de carga mientras se obtienen los datos
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun AnimalCard(animal: Animal) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        // Fondo con la imagen del animal
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(24.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Gradiente oscuro en la parte inferior para que el texto sea legible
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                                startY = 500f
                            )
                        )
                )

                Image(
                    painter = painterResource(id = animal.imagen),
                    contentDescription = "Imagen de ${animal.nombre}",
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .align(Alignment.BottomCenter)
                        .alpha(0.7f),
                    contentScale = ContentScale.Crop
                )
                // Texto de estado de conservación
                Text(
                    text = "Estado conservación: ${animal.estadoConservacion}",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(24.dp).offset(y = -30.dp)

                )
            }
        }

        // Tarjeta de información superior
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center // Centra el contenido de este Box
        ) {
            // Tarjeta de información superior
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .align(Alignment.TopCenter) // Alinea esta tarjeta en la parte superior
                    .padding(top = 32.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF6B5B3B))
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = animal.nombre,
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = animal.descripcion,
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Icono central (ahora se centrará gracias al contentAlignment del Box padre)
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF6B5B3B)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Icono",
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        }
}

@Preview(showBackground = true)
@Composable
fun AnimalesScreenPreview() {
    AnimalesScreen( navController = rememberNavController())
}
