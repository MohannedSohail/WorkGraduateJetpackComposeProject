package com.example.workgraduateproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.workgraduateproject.view.*
import com.example.workgraduateproject.viewModel.AllWorkViewModel


@Composable
fun NavigationBuild(controller: NavHostController, myViewModel: AllWorkViewModel) {
    NavHost(navController = controller, startDestination = Screens.AUTH_GRAPH.route) {


        navigation(
            startDestination = Screens.AuthScreens.Splash.route,
            route = Screens.AUTH_GRAPH.route
        ){
            composable(Screens.AuthScreens.Splash.route) {
                SplashScreen(controller)
            }
            composable(Screens.AuthScreens.Login.route) {
                LoginScreen(controller)
            }

            composable(Screens.AuthScreens.SignUp.route) {
                SignUpScreen(controller)
            }
            composable(Screens.AuthScreens.OnBoarding.route) {
                OnBordingScreens(controller)
            }


        }



        navigation(
            startDestination = Screens.AddOrderScreen.AddOrder.route,
            route = Screens.ADD_ORDER_GRAPH.route
        ){
            composable(Screens.AddOrderScreen.OrderDone.route) {
                OrderDoneScreen(controller)
            }

            composable(Screens.AddOrderScreen.AddOrder.route) {
                AddOrder(controller)
            }
            composable(Screens.AddOrderScreen.AddLocation.route) {
                LocationScreen(controller)
            }


        }


        bottomNavGraph(controller, myViewModel)
    }
}