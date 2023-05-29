package com.example.workgraduateproject.view

import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.workgraduateproject.R
import com.example.workgraduateproject.navigation.Screens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }


    // AnimationEffect

    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 0.7f else 0f,

        animationSpec = tween(
            durationMillis = 2000,
        )
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screens.AuthScreens.OnBoarding.route)
    }




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
                .width(250.dp)
                .alpha(alphaAnimation.value),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterStart
        )
    }

}