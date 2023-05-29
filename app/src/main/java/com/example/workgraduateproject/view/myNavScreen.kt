package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.workgraduateproject.navigation.NavigationBuild
import com.example.workgraduateproject.navigation.Screens
import com.example.workgraduateproject.viewModel.AllWorkViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun myNavScreen() {
    val navController = rememberNavController()
//    Scaffold(
//        bottomBar = { BottomNavifation(navController = navController) }
//    ) {
//
////        NavigationBuild(navController,)
//    }
}


//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun BottomNavifation(navController: NavController) {
//
////    val controller = rememberNavController()
//
//
//    val screens = listOf(
//        Screens.Service,
//        Screens.Orders,
//        Screens.Account,
//        Screens.More
//    )
//
//
//    BottomNavigation(
//        backgroundColor = Color.LightGray,
//        contentColor = Color.Black
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//        screens.forEach { item ->
//            BottomNavigationItem(
//                icon = { Icon(painterResource(id = item.icon), contentDescription = "item.icon") },
//                label = { Text(text = item.iconLable,
//                    fontSize = 9.sp) },
//                selectedContentColor = Color.Black,
//                unselectedContentColor = Color.Black.copy(0.4f),
//                alwaysShowLabel = true,
//                selected = currentRoute == item.route,
//                onClick = {
//                    navController.navigate(item.route) {
//
//                        navController.graph.startDestinationRoute?.let { screen_route ->
//                            popUpTo(screen_route) {
//                                saveState = true
//                            }
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}