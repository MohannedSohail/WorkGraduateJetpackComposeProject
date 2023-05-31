package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.activity.viewModels
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.workgraduateproject.R
import com.example.workgraduateproject.model.WorkData
import com.example.workgraduateproject.navigation.Screens
import com.example.workgraduateproject.viewModel.AllWorkViewModel


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ServiceScreen(navController: NavController, viewModel: AllWorkViewModel) {

    viewModel.getItemsList()

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
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 10.dp),
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
                                    .width(300.dp)
                                    .height(90.dp),
                                border = BorderStroke(width = 0.5.dp, color = Color(0xffDE1487)),
                                shape = RoundedCornerShape(15.dp),
                                elevation = 10.dp,
                                onClick = {}

                            ) {
                                Column(


                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        painter = painterResource(id = R.drawable.selectimage),
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

        },
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
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .padding(top = 5.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.Center,
            ) {


                LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
                    items(viewModel.workListResponse) { it ->
                        MyItem(
                            myData = it,
                            LocalContext.current, navController
                        )
                    }
                })


            }


        }

    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyItem(myData: WorkData, context: Context, navController: NavController) {

    Card(
        modifier = Modifier
            .background(Color.White)
            .width(260.dp)
            .padding(10.dp)
            .height(100.dp), border = BorderStroke(width = 0.5.dp, color = Color(0xffDE1487)),
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp,
        onClick = {
            navController.navigate(Screens.AddOrderScreen.AddOrder.route + "/${myData.id}" )
            Toast
                .makeText(
                    context,
                    " my ID ${myData.id}",
                    Toast.LENGTH_LONG
                )
                .show()

        }

    ) {
        Column(


            verticalArrangement = Arrangement.Center
        ) {

//
//            Image(
//
//                modifier = Modifier
//                    .fillMaxWidth(),
//                painter = painterResource(id = R.drawable.carpenter),
//                contentDescription = "MyFirstImage",
//            )
            Icon(rememberAsyncImagePainter(myData.icon), contentDescription = "")

            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp),
                text = myData.name.toString(),
                color = Color(0xFF0E4DFB),
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )

        }

    }
}