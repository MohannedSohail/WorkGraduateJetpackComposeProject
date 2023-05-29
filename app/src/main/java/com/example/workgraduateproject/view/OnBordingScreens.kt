package com.example.workgraduateproject.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.workgraduateproject.R
import com.example.workgraduateproject.model.OnBordingContentData
import com.example.workgraduateproject.navigation.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBordingScreens(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val items = OnBordingItems()
        val pagerState = rememberPagerState()


        HorizontalPager(

            state = pagerState,
            count = items.size,
            modifier = Modifier
                .weight(1f),


            ) { currentPage ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(357.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = items[currentPage].image),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(30.dp))

                Text(

                    modifier = Modifier.fillMaxWidth(),
                    text = items[currentPage].title,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 21.sp),
                    color = Color(0xff0E9CF9)

                )
            }

        }

        val coroutineScope = rememberCoroutineScope()
        Button(
            onClick = {
                coroutineScope.launch {
                    if (pagerState.currentPage != 2) {
                        pagerState.animateScrollToPage(page = pagerState.currentPage + 1)

                    } else if (pagerState.currentPage == 2) {

                        navController.navigate(Screens.AuthScreens.Login.route)
                    }

                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(35.dp)
                .size(50.dp)
                .shadow(
                    elevation = 10.dp,
                    ambientColor = Color(0xffE9C75E),
                    spotColor = Color(0xffE9C75E),
                    shape = RoundedCornerShape(5.dp)
                )
                .background(
                    brush = Brush.horizontalGradient(

                        colors = listOf(Color(0xff346EDF), Color(0xff346EDF), Color(0xff6FC8FB))
                    )
                ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp)

        ) {
            Text(
                text = "NEXT",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            )
        }
    }

}

fun OnBordingItems() = listOf(
    OnBordingContentData(
        R.drawable.mobileapplicationcall, "Fast reservation with technicians \n" +
                "and craftsmen"
    ),
    OnBordingContentData(
        R.drawable.onbording, "Fast reservation with technicians \n" +
                "and craftsmen"
    ), OnBordingContentData(
        R.drawable.mobileapplicationcall, "Fast reservation with technicians \n" +
                "and craftsmen"
    )

)