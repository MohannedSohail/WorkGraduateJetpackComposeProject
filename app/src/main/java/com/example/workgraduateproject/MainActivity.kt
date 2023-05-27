package com.example.workgraduateproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.workgraduateproject.ui.theme.WorkGraduateProjectTheme
import com.example.workgraduateproject.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkGraduateProjectTheme {
                // A surface container using the 'background' color from the theme
                LocationScreen()
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