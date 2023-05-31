package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.example.Data
import com.example.workgraduateproject.viewModel.AllWorkViewModel
import com.example.workgraduateproject.viewModel.OrdersViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrdersScreen(allWorkViewModel: AllWorkViewModel,viewModel: OrdersViewModel) {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val myTabs = listOf("Pending", "Underway", "Completed")

    viewModel.getCompleteOrderList()
    viewModel.getUnCompleteOrderList()
    viewModel.getPendingOrderList()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                contentColor = Color.White,
                modifier = Modifier
                    .height(88.dp)
                    .background(
                        brush = Brush.horizontalGradient(

                            colors = listOf(Color(0xff6FC8FB), Color(0xff0E4DFB))
                        )
                    ),
                title = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {

                        Text(text = "Item Details")
                    }
                },

                )


        },

        content = {


            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xffEAEFFF)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(Modifier.fillMaxWidth()) {

                    TabRow(
                        modifier = Modifier.height(50.dp),
                        selectedTabIndex = pagerState.currentPage,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                modifier = Modifier
                                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                                    .padding(horizontal = 25.dp),
                                color = Color(0xff0E4DFB),


                                )
                        },
                        backgroundColor = Color.White,
//                        divider = {
//                            TabRowDefaults.Divider(
////                                thickness = 1.dp,
////                                color = Color(0xffEAEFFF)
//
//                            )
//                        },
                    ) {
                        myTabs.forEachIndexed { index, title ->
                            Tab(
                                modifier = Modifier.zIndex(6f),
                                text = { Text(text = title) },
                                selected = pagerState.currentPage == index,
                                selectedContentColor = Color(0xff0E4DFB),
                                unselectedContentColor = Color(0xffAFAFAF),
                                onClick = {


                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(page = index)

                                    }

                                },
                            )
                        }
                    }


                }

                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    count = myTabs.size,
                    state = pagerState,
                    userScrollEnabled = true,
                ) { page ->

                    when (page) {
                        0 -> {


                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 3.dp, bottom = 83.dp),

                                    ) {
                                    items(viewModel.pendingOrderListResponse) {
                                        MyOrederItem(it)
                                    }
                                }


                            }


                        }
                        1 -> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 3.dp, bottom = 83.dp),

                                    ) {
                                    items(viewModel.unCompleteOrderListResponse) {
                                        MyOrederItem(it)
                                    }
                                }


                            }


                        }
                        2 -> {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                LazyColumn(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 3.dp, bottom = 83.dp),

                                    ) {
                                    items(viewModel.completeOrderListResponse) {
                                        MyOrederItem(it)
                                    }
                                }


                            }

                        }
                    }

                }

            }


        },
    )


}


@Composable
fun MyOrederItem(myData: Data) {

    Card(
        modifier = Modifier
            .padding(vertical = 3.dp)
            .height(100.dp)
            .fillMaxWidth()
            .clickable { },
        shape = RoundedCornerShape(5.dp),
        elevation = 0.dp

    ) {
        Column(


            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    text = "Order #52001",
                    color = Color(0xff272727),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    text = myData.createdAt.toString(),
                    color = Color(0xff7F8FA6),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    text = "Service Type :",
                    fontSize = 12.sp,
                    color = Color(0xff7F8FA6),

//                    color = colorResource(R.color.serviceTxt),

                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .padding(top = 15.dp),
                    text = myData.work?.name.toString(),
                    color = Color(0xff0E4DFB),

//                    color = colorResource(R.color.textColor),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )

            }

        }

    }
}