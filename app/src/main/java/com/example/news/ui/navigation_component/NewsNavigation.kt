package com.example.newsappcompose.ui.navigation_component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsappcompose.ui.screens.categoires.CategoriesNews
import com.example.newsappcompose.ui.screens.home.NewsFragment
import com.example.newsappcompose.ui.screens.home_details.HomeDetails
import com.example.newsappcompose.ui.screens.settings.Settings
import com.example.newsappcompose.ui.screens.settings.SplashContent

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun NewsNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NewsScreens.SplashScreen.name) {
        composable(NewsScreens.SplashScreen.name){
            SplashContent(navController = navController)
        }

        composable(NewsScreens.CategoriesScreen.name){
            CategoriesNews(navController)
        }

        composable(
            NewsScreens.HomeScreen.name + "/{category}" + "/{catName}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            },navArgument("catName") {
                type = NavType.IntType
            })
        ) {
            val category = it.arguments?.getString("category")
            val catName = it.arguments?.getInt("catName")
            NewsFragment(category, navController = navController,catName = catName)
        }

        composable(NewsScreens.HomeDetailsScreen.name){
            HomeDetails(navController = navController)
        }

        composable(NewsScreens.SettingScreen.name){
            Settings(navController = navController)
        }


    }
}


