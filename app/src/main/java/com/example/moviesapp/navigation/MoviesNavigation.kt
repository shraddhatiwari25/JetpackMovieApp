package com.example.moviesapp.navigation

import android.telecom.Call.Details
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviesapp.screens.home.HomeScreen
import com.example.moviesapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation(){
    val navContoller= rememberNavController()
    NavHost(navController = navContoller,
        startDestination =MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            //here we pass here this should lead us to
           HomeScreen(navController = navContoller)
        }
   //www.google.com/detail-screen/id=34
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
        arguments = listOf(navArgument(name = "movie"){type= NavType.StringType})
        ){
            backStackEntry ->

            DetailsScreen(navController = navContoller,
                backStackEntry.arguments?.getString("movie"))
        }
    }


}


