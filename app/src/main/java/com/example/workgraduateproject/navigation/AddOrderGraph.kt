package com.example.workgraduateproject.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.workgraduateproject.view.*

fun NavGraphBuilder.addOrderGraph(navController: NavController) {
    navigation(
        startDestination = Screens.AddOrderScreen.AddOrder.route,
        route = Screens.ADD_ORDER_GRAPH.route
    ) {
        composable(Screens.AddOrderScreen.OrderDone.route) {
            OrderDoneScreen(navController)
        }

        composable(
            Screens.AddOrderScreen.AddOrder.route + "/{data}",
            arguments = listOf(navArgument("data") { type = NavType.IntType })
        ) { backStackEntry ->

            val data = backStackEntry.arguments?.getInt("data")
            data?.let { screenData ->
                AddOrder(navController = navController, id = screenData)
            }
        }

        composable(
            Screens.AddOrderScreen.AddLocation.route + "/{id}" + "/{stringData}" + "/{uriList}",

            arguments = listOf(

                navArgument("uriList") { type = NavType.StringType },
                navArgument("id") { type = NavType.IntType },
                navArgument("stringData") { type = NavType.StringType },


                )
        ) { backStackEntry ->

            val data = backStackEntry.arguments?.getInt("id")
            val stringData = backStackEntry.arguments?.getString("stringData")
            val uriList = backStackEntry.arguments?.getString("uriList")


            data?.let { screenData ->
                stringData?.let {
                    uriList?.let { it1 ->
                        LocationScreen(
                            navController = navController, screenData, it,
                            it1
                        )
                    }

                }
            }
        }


    }

}