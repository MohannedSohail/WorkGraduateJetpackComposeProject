package com.example.workgraduateproject

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.workgraduateproject.navigation.NavigationBuild
import com.example.workgraduateproject.navigation.Screens
import com.example.workgraduateproject.ui.theme.WorkGraduateProjectTheme
import com.example.workgraduateproject.view.*
import com.example.workgraduateproject.viewModel.AllWorkViewModel
import com.example.workgraduateproject.viewModel.OrdersViewModel

class MainActivity : ComponentActivity() {

    private val allWorkViewModel by viewModels<AllWorkViewModel>()
    private val OrderViewModel by viewModels<OrdersViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            requestPermissions(
//                arrayOf(
//                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
//                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
//                ), 1
//            )
            WorkGraduateProjectTheme {
                BottomNavBar(allWorkViewModel, OrderViewModel)
            }
        }
    }
}

@Composable
fun Greeting() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkGraduateProjectTheme {
        Greeting()
    }
}

