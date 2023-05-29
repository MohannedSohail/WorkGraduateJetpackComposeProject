package com.example.workgraduateproject.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.workgraduateproject.R
import com.example.workgraduateproject.navigation.Screens
import kotlinx.coroutines.launch


@Composable
fun OrderDoneScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.illustration),
            contentScale = ContentScale.Crop,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(70.dp))


        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Black, fontSize = 24.sp)) {
                append("ORDER")
            }
            withStyle(style = SpanStyle(color = Color.Blue, fontSize = 24.sp)) {
                append(" DONE!")
            }
        })

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "The ORDER has been sent. A technician will\n contact you",
            style = TextStyle(fontSize = 14.sp, textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {

                      navController.navigate(Screens.BOTTOM_NAV_GRAPH.route)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 15.dp)
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
                text = "GO TO HOME",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            )
        }


    }
}