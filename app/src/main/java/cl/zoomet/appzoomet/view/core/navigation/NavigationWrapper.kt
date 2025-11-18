package cl.zoomet.appzoomet.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cl.zoomet.appzoomet.view.home.HomeScreen
import cl.zoomet.appzoomet.view.home.HomeViewModel
import cl.zoomet.appzoomet.view.home.zoo.animales.AnimalesScreen
import cl.zoomet.appzoomet.view.home.zoo.mapazoo.MapaZooScreen


@Composable
fun NavigationWrapper(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(
                homeViewModel = HomeViewModel(),
                navController = navController
            )
        }
        composable<MapaZoo> {
            MapaZooScreen(
                navController = navController
            )
        }
        composable<Animales> {
            AnimalesScreen(
                navController= navController
            )
        }
    }
}