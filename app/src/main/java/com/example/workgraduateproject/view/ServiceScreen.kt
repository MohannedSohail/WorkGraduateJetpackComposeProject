package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workgraduateproject.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ServiceScreen() {

    Scaffold(


        topBar = {


            TopAppBar(

                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .paint(
                        painterResource(id = R.drawable.background),
                        contentScale = ContentScale.Crop
                    ),

                content = {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(contentAlignment = Alignment.CenterEnd) {

                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.logo1),
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .height(40.dp),
                                    contentDescription = "MyFirstImage",
                                    alignment = Alignment.Center
                                )

                            }


                            IconButton(modifier = Modifier,
                                onClick = {/* Do Something*/ }, content = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.shape),
                                        null,
                                        tint = Color.White
                                    )
                                })

                        }

                        Spacer(modifier = Modifier.height(40.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(), contentAlignment = Alignment.Center
                        ) {



                            Card(
                                modifier = Modifier
                                    .width(260.dp)
                                    .height(100.dp)
                                    .clickable { },
                                border = BorderStroke(width = 0.5.dp, color = Color.Red),
                                shape = RoundedCornerShape(15.dp),
                                elevation = 10.dp,

                                ) {
                                Column(


                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        painter = painterResource(id = R.drawable.profile),
                                        contentDescription = "MyFirstImage",
                                    )
                                    Text(
                                        modifier = Modifier
                                            .align(Alignment.CenterHorizontally)
                                            .padding(top = 15.dp),
                                        text = "My Card",
                                        color = Color(0xFF0E4DFB),
                                        fontSize = 10.sp,
                                        textAlign = TextAlign.Center
                                    )

                                }

                            }


                        }

                    }

                },

                )

        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                modifier = Modifier.padding(top = 30.dp, bottom = 10.dp),
                text = "Select Service",
                color = Color(0xFF0E4DFB),
                fontWeight = FontWeight.Bold,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .padding(top = 5.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.Center,
            ) {


                LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
                    items(MyList) { it -> MyItem(myData = it) }
                })


            }


        }

    }


}

@Composable
fun MyItem(myData: MyData) {

    Card(
        modifier = Modifier
            .background(Color.White)
            .width(260.dp)
            .padding(10.dp)
            .height(100.dp)
            .clickable { }, border = BorderStroke(width = 0.5.dp, color = Color.Red),
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp

    ) {
        Column(


            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = myData.img),
                contentDescription = "MyFirstImage",
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                text = myData.name,
                color = Color(0xFF0E4DFB),
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )

        }

    }
}


val MyList = listOf(
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),
    MyData(R.drawable.profile, "Carpenter"),


    )

data class MyData(val img: Int, val name: String)