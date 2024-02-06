package com.example.project03.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project03.ui.components.CameraX
import com.example.project03.ui.screens.addMushrooms.AddMushroomScreen
import com.example.project03.ui.screens.home.HomeScreen
import com.example.project03.ui.screens.maps.MapScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route){
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = AppScreens.MapScreen.route){
            MapScreen(navController)
        }

        composable(route = AppScreens.AddMushroomScreen.route){
            AddMushroomScreen(navController)
        }


        composable(route = AppScreens.CameraScreen.route){
            CameraX()
        }
    }
}