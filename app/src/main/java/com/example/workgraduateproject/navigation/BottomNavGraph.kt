package com.example.workgraduateproject.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.workgraduateproject.view.MoreSettings
import com.example.workgraduateproject.view.OrdersScreen
import com.example.workgraduateproject.view.ProfileScreen
import com.example.workgraduateproject.view.ServiceScreen
import com.example.workgraduateproject.viewModel.AllWorkViewModel
import com.example.workgraduateproject.viewModel.OrdersViewModel


fun NavGraphBuilder.bottomNavGraph(navController: NavController, myViewModel: AllWorkViewModel,viewModel: OrdersViewModel) {
    navigation(
        startDestination = Screens.BottomNavScreens.Service.route,
        route = Screens.BOTTOM_NAV_GRAPH.route
    ) {
        composable(Screens.BottomNavScreens.Service.route) {
            ServiceScreen(navController, myViewModel)
        }
        composable(Screens.BottomNavScreens.Orders.route) {
            OrdersScreen(viewModel)
        }
        composable(Screens.BottomNavScreens.Account.route) {
            ProfileScreen()
        }
        composable(Screens.BottomNavScreens.More.route) {
            MoreSettings()
        }

    }

}