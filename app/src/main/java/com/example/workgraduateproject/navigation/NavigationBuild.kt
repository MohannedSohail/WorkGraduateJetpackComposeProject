package com.example.workgraduateproject.navigation

import android.content.ContentResolver
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.workgraduateproject.view.*
import com.example.workgraduateproject.viewModel.AllWorkViewModel
import com.example.workgraduateproject.viewModel.OrdersViewModel


@Composable
fun NavigationBuild(
    controller: NavHostController,
    myViewModel: AllWorkViewModel,
    viewModel: OrdersViewModel,
) {
    NavHost(navController = controller, startDestination = Screens.AUTH_GRAPH.route) {


        authGraph(controller)


        addOrderGraph(controller)


        bottomNavGraph(controller, myViewModel, viewModel)
    }
}