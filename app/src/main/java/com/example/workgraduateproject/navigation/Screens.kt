package com.example.workgraduateproject.navigation

import com.example.workgraduateproject.R


sealed class Screens(var route: String) {


    object AUTH_GRAPH : Screens("authGraph")
    object BOTTOM_NAV_GRAPH : Screens("bottomNavScreens")
    object ADD_ORDER_GRAPH : Screens("addOrderGraph")


    sealed class BottomNavScreens(var lable: String, route: String, var icon: Int) :
        Screens(route) {

        object Service : BottomNavScreens("Service", "Service", R.drawable.servicebottomnav)
        object Orders : BottomNavScreens("Orders", "Orders", R.drawable.receipt)
        object Account : BottomNavScreens("Account", "Account", R.drawable.profile)
        object More : BottomNavScreens("More", "More", R.drawable.ic_more_horiz_24px)


//        object Done : Screens("Done", "Done", R.drawable.ic_more_horiz_24px)
//        object AddOrder : Screens("AddOrder", "AddOrder", R.drawable.ic_more_horiz_24px)
//


    }


    sealed class AuthScreens(route: String) : Screens(route) {

        object Splash : AuthScreens("Splash")
        object OnBoarding : AuthScreens("OnBoarding")
        object Login : AuthScreens("Login")
        object SignUp : AuthScreens("SignUp")


    }


    sealed class AddOrderScreen(route: String) : Screens(route) {

        object AddOrder : AddOrderScreen("AddOrder")
        object AddLocation : AddOrderScreen("AddLocation")
        object OrderDone : AddOrderScreen("OrderDone")


    }


}


