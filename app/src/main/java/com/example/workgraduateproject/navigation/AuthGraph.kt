package com.example.workgraduateproject.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.workgraduateproject.view.*
import com.example.workgraduateproject.viewModel.AllWorkViewModel
import com.example.workgraduateproject.viewModel.OrdersViewModel

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(
        startDestination = Screens.AuthScreens.Splash.route,
        route = Screens.AUTH_GRAPH.route
    ) {

        composable(Screens.AuthScreens.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screens.AuthScreens.Login.route) {
            LoginScreen(navController)
        }

        composable(Screens.AuthScreens.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(Screens.AuthScreens.OnBoarding.route) {
            OnBordingScreens(navController)
        }


    }

}