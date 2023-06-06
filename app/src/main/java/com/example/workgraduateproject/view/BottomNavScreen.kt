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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.workgraduateproject.navigation.NavigationBuild
import com.example.workgraduateproject.navigation.Screens
import com.example.workgraduateproject.viewModel.AllWorkViewModel
import com.example.workgraduateproject.viewModel.OrdersViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavBar(
    myViewmodel: AllWorkViewModel,
    ordersViewModel: OrdersViewModel,
) {

    val controller = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route


    val screens = listOf(
        Screens.BottomNavScreens.Service,
        Screens.BottomNavScreens.Orders,
        Screens.BottomNavScreens.Account,
        Screens.BottomNavScreens.More
    )

    Scaffold(


        bottomBar = {
            if (currentRoute == Screens.BOTTOM_NAV_GRAPH.route || currentRoute == Screens.BottomNavScreens.Service.route
                || currentRoute == Screens.BottomNavScreens.More.route || currentRoute == Screens.BottomNavScreens.Account.route || currentRoute == Screens.BottomNavScreens.Orders.route
            ) {
                BottomNavigation(
                    backgroundColor = Color(0xFF6FC8FB),
                    modifier = Modifier.height(80.dp),


                    ) {

                    screens.forEach { item ->
                        BottomNavigationItem(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            selected = currentRoute == item.route,
                            unselectedContentColor = Color.LightGray,
                            selectedContentColor = Color.White,

                            onClick = {
                                controller.navigate(item.route)
                            },
                            label = { Text(text = item.lable) },
                            icon = {

                                Icon(
                                    modifier = Modifier.padding(7.dp),
                                    painter = (painterResource(id = item.icon)),
                                    contentDescription = null
                                )
                            })
                    }

                }

            }
        },

        )
    {

        NavigationBuild(controller, myViewmodel, ordersViewModel)

    }

}

