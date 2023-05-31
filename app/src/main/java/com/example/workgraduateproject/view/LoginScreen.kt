package com.example.workgraduateproject.view

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workgraduateproject.R
import com.example.workgraduateproject.navigation.Screens
import com.example.workgraduateproject.viewModel.LoginViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun LoginScreen(navController: NavController) {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val pages = listOf("Customer", "Service provider")
    val userEmail by rememberSaveable { mutableStateOf("mushtaha98@gmail.com") }
    val password by rememberSaveable { mutableStateOf("123123") }


    val loginViewModel = viewModel<LoginViewModel>()




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(

                    colors = listOf(Color(0xff346EDF), Color(0xff6FC8FB))
                )
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.layer), contentDescription = "",
            )

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
        ) {

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(Modifier.fillMaxWidth()) {

                    TabRow(
                        modifier = Modifier.height(50.dp),
                        selectedTabIndex = pagerState.currentPage,
                        indicator = { tabPositions ->
                            TabRowDefaults.Indicator(
                                modifier = Modifier.customTabIndicatorOffset(
                                    currentTabPosition = tabPositions[pagerState.currentPage],
                                    tabWidth = 30.dp
                                ),
                                color = Color(0xff0E4DFB),
                                height = 3.dp,


//                                modifier = Modifier
//                                    .pagerTabIndicatorOffset(pagerState, tabPositions)
//                                    .width(10.dp)
//                                    .padding(start = 80.dp, end = 80.dp)
//                                    .height(2.dp),
//                                color = MaterialTheme.colors.secondary,
                            )
                        },
                        backgroundColor = Color.Transparent,
                        divider = {
                            TabRowDefaults.Divider(
                                thickness = 0.dp,
                                color = Color.Transparent

                            )
                        },
                    ) {
                        pages.forEachIndexed { index, title ->
                            Tab(
                                modifier = Modifier.zIndex(6f),
                                text = { Text(text = title) },
                                selected = pagerState.currentPage == index,
                                selectedContentColor = Color(0xff0E4DFB),
                                unselectedContentColor = Color(0xff646781),
                                onClick = {

                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(page = index)

                                    }

                                },
                            )
                            // For default tab background
                            // you can do something similar to that
                            // Sets a background to all tabs except the selected one
//            Tab(
//                modifier = Modifier.zIndex(6f),
//                text = {
//                    if (pagerState.currentPage != index) {
//                        Box(modifier = Modifier.background(Color.Red).padding(10.dp)) {
//                            Text(text = title)
//                        }
//                    } else {
//                        Text(text = title)
//                    }
//                },
//                selected = pagerState.currentPage == index,
//                onClick = { /* TODO */ },
//            )
                        }
                    }


                }

                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(15.dp),
                    count = pages.size,
                    state = pagerState,
                    userScrollEnabled = false,
                ) { page ->

                    if (page == 0) {


                        CustomerLoginScreen(
                            navController,
                            loginViewModel,
                            userEmail,
                            password,
                            LocalContext.current
                        )


                    } else {
                        ServiceProviderLoginScreen(navController)

                    }

                }


                TextButton(onClick = {

                    navController.navigate(Screens.BOTTOM_NAV_GRAPH.route)
                }) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(start = 3.dp, end = 3.dp),
                            text = "Get Start Now",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            ),
                            color = Color(0xff272727)
                        )

                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Filled.ArrowForward,
                            contentDescription = "",
                            tint = Color.Black
                        )


                    }

                }
            }

        }

    }
}

@Composable
private fun ServiceProviderLoginScreen(
    navController: NavController
) {

    var serviceproviderEmail by remember { mutableStateOf(value = "") }
    var serviceproviderPassword by remember { mutableStateOf(value = "") }
    var serviceproviderShowPassword by remember { mutableStateOf(value = false) }
    var serviceproviderIsChecked by remember { mutableStateOf(value = false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = serviceproviderEmail, onValueChange = { value -> serviceproviderEmail = value },
            placeholder = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = serviceproviderPassword,
            onValueChange = { value -> serviceproviderPassword = value },
            placeholder = { Text(text = "password") },
            trailingIcon = {
                if (serviceproviderShowPassword) {
                    IconButton(onClick = { serviceproviderShowPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { serviceproviderShowPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            },
            visualTransformation = if (serviceproviderShowPassword) {

                VisualTransformation.None

            } else {

                PasswordVisualTransformation()

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )


        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            CircleCheckbox(selected = serviceproviderIsChecked, onChecked = {
                serviceproviderIsChecked = !serviceproviderIsChecked
            })

            TextButton(onClick = {}) {
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(fontSize = 15.sp),
                    color = Color(0xff272727)
                )

            }


        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .height(60.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = " New Member?", style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                    )
                )
                TextButton(onClick = {

                    navController.navigate(Screens.AuthScreens.SignUp.route)
                }) {
                    Text(
                        text = "SIGN UP",
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color(0xff0E4DFB)
                    )

                }

            }

            Button(
                onClick = {
//                    navController.navigate(Screens.BOTTOM_NAV_GRAPH.route)


                },
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f)
                    .shadow(
                        elevation = 10.dp,
                        ambientColor = Color(0xffE9C75E),
                        spotColor = Color(0xffE9C75E),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .background(
                        brush = Brush.horizontalGradient(

                            colors = listOf(
                                Color(0xff346EDF),
                                Color(0xff346EDF),
                                Color(0xff6FC8FB)
                            )
                        )
                    ),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(
                    0.dp,
                    pressedElevation = 0.dp
                )

            ) {
                Text(
                    text = "LOGIN",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )
            }


        }


    }
}

@Composable
private fun CustomerLoginScreen(

    navController: NavController,
    loginViewModel: LoginViewModel,
    userEmail: String,
    password: String,
    context: Context

) {
    var customerEmail by remember { mutableStateOf(value = "") }
    var customerPassword by remember { mutableStateOf(value = "") }
    var customerShowPassword by remember { mutableStateOf(value = false) }
    var customerIsChecked by remember { mutableStateOf(value = false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true

                ),
            value = customerEmail, onValueChange = { value -> customerEmail = value },
            placeholder = { Text(text = "Email") },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff6236FF),
                unfocusedBorderColor = Color(0xffF0F0F0),
                unfocusedLabelColor = Color(0xffC2CECE),
                disabledPlaceholderColor = Color(0xffC2CECE),
                trailingIconColor = Color(0xffC2CECE)
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )


        Spacer(modifier = Modifier.height(32.dp))


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true
                ),
            value = customerPassword, onValueChange = { value -> customerPassword = value },
            placeholder = { Text(text = "password") },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff6236FF),
                unfocusedBorderColor = Color(0xffF0F0F0),
                unfocusedLabelColor = Color(0xffC2CECE),
                disabledPlaceholderColor = Color(0xffC2CECE),
                trailingIconColor = Color(0xffC2CECE)
            ),
            trailingIcon = {
                if (customerShowPassword) {
                    IconButton(onClick = { customerShowPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { customerShowPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            },
            visualTransformation = if (customerShowPassword) {

                VisualTransformation.None

            } else {

                PasswordVisualTransformation()

            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )


        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            CircleCheckbox(selected = customerIsChecked, onChecked = {
                customerIsChecked = !customerIsChecked
            })

            TextButton(onClick = {}) {
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(fontSize = 15.sp),
                    color = Color(0xff272727)
                )

            }


        }

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .height(60.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = " New Member?", style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                    )
                )
                TextButton(onClick = {

                    navController.navigate(Screens.AuthScreens.SignUp.route)
                }) {
                    Text(
                        text = "SIGN UP",
                        style = TextStyle(
                            textDecoration = TextDecoration.Underline,
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color(0xff0E4DFB)
                    )

                }

            }

            Button(
                onClick = {

                    navController.navigate(Screens.BOTTOM_NAV_GRAPH.route)

                    loginViewModel.loginPost("mushtaha98@gmail.com", "123123")
//                    loginViewModel.loginPost(userEmail, password)

                    Toast
                        .makeText(
                            context,
                            " my token ${loginViewModel.loginResponse}",
                            Toast.LENGTH_LONG
                        )
                        .show()


                },
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f)
                    .shadow(
                        elevation = 10.dp,
                        ambientColor = Color(0xffE9C75E),
                        spotColor = Color(0xffE9C75E),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .background(
                        brush = Brush.horizontalGradient(

                            colors = listOf(
                                Color(0xff346EDF),
                                Color(0xff346EDF),
                                Color(0xff6FC8FB)
                            )
                        )
                    ),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(
                    0.dp,
                    pressedElevation = 0.dp
                )

            ) {
                Text(
                    text = "LOGIN",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )
            }


        }


    }
}

private fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(

        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )


    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
        .shadow(10.dp, shape = RoundedCornerShape(30.dp))

}


@Composable
private fun CircleCheckbox(selected: Boolean, enabled: Boolean = true, onChecked: () -> Unit) {

    val imageVector = if (selected) Icons.Filled.CheckCircle else Icons.Outlined.Circle
    val tint = if (selected) Color(0xff0E4DFB) else Color.Gray.copy(alpha = 0.8f)
    val background = if (selected) Color.White else Color.Transparent


    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(
            onClick = { onChecked() },
            enabled = enabled
        ) {

            Icon(
                imageVector = imageVector, tint = tint,
                modifier = Modifier.background(background, shape = CircleShape),
                contentDescription = "checkbox"
            )
        }

        Text(text = "Remember me", style = TextStyle(fontSize = 12.sp))


    }
}
