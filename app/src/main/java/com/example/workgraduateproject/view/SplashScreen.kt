package com.example.workgraduateproject.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.workgraduateproject.R


@Composable
fun SplashScreen(){
    Box(
        contentAlignment = Alignment.CenterEnd, modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(

                    colors = listOf(Color(0xff346EDF), Color(0xff346EDF), Color(0xff6FC8FB))
                )
            )
    ) {
        Image(
            modifier = Modifier
                .height(350.dp)
                .width(250.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterStart
        )
    }

}