package com.example.workgraduateproject.view

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import com.example.workgraduateproject.viewModel.SignUpViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.togitech.ccp.component.TogiCountryCodePicker
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignUpScreen(navController: NavController) {


    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    val pages = listOf("Customer", "Service provider")


    val signUpViewModel = viewModel<SignUpViewModel>()

    val customerEmail by remember { mutableStateOf(value = "") }
    val customerFullName by remember { mutableStateOf(value = "") }
    val customerPassword by remember { mutableStateOf(value = "") }
    val customerPhone by remember { mutableStateOf(value = "") }

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
                .padding(start = 5.dp)
                .weight(0.8f),
//            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
                    tint = Color.White
                )

            }

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f),
            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
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


                        CustomerSignUpScreen(
                            navController,
                            signUpViewModel,
                            customerFullName,
                            customerEmail,
                            customerPassword,
                            customerPhone,
                            LocalContext.current
                        )


                    } else {
                        ServiceProviderSignUpScreen()

                    }

                }

            }

        }

    }

}


@Composable
private fun CustomerSignUpScreen(

    navController: NavController,
    signUpViewModel: SignUpViewModel,
    name: String,
    email: String,
    password: String,
    phone: String,
    context: Context

) {
    var customerEmail by remember { mutableStateOf(value = "") }
    var customerFullName by remember { mutableStateOf(value = "") }
    var customerPassword by remember { mutableStateOf(value = "") }
    var customerShowPassword by remember { mutableStateOf(value = false) }
    var customerIsChecked by remember { mutableStateOf(value = false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true

                ),
            value = customerFullName, onValueChange = { value -> customerFullName = value },
            label = { Text(text = "Full Name") },
            placeholder = {
                Text(text = "Name")

            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff0E4DFB),
                unfocusedBorderColor = Color(0xffF0F0F0),
                unfocusedLabelColor = Color(0xffC2CECE),
                disabledPlaceholderColor = Color(0xffC2CECE),
                trailingIconColor = Color(0xffC2CECE)
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true

                ),
            value = customerEmail, onValueChange = { value -> customerEmail = value },
            label = { Text(text = "Email") },

            placeholder = { Text(text = "Email") },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff0E4DFB),
                unfocusedBorderColor = Color(0xffF0F0F0),
                unfocusedLabelColor = Color(0xffC2CECE),
                disabledPlaceholderColor = Color(0xffC2CECE),
                trailingIconColor = Color(0xffC2CECE)
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )


        Spacer(modifier = Modifier.height(10.dp))
        CountryCode()


        Spacer(modifier = Modifier.height(5.dp))



        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true
                ),
            value = customerPassword, onValueChange = { value -> customerPassword = value },
            label = { Text(text = "password") },

            placeholder = { Text(text = "password") },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff0E4DFB),
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


        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {

            CircleCheckbox(selected = customerIsChecked, onChecked = {
                customerIsChecked = !customerIsChecked
            })

            TextButton(onClick = {}) {
                Text(
                    text = "Home Service Terms&Conditions",
                    style = TextStyle(fontSize = 12.sp),
                    color = Color(0xff0E4DFB)
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
                    text = " Have Account?", style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                    )
                )
                TextButton(onClick = {}) {
                    Text(
                        text = "SIGN IN",
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

                          signUpViewModel.signUpPost("TheKing","mushtaha19118@gmail.com","123123","0594042996")
                    Toast
                        .makeText(
                            context,
                            " My SignUp token ==> ${signUpViewModel.signUpResponse}",
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
                    text = "SIGN UP",
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


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ServiceProviderSignUpScreen(

) {

    var serviceproviderFullName by remember { mutableStateOf(value = "") }
    var serviceproviderEmail by remember { mutableStateOf(value = "") }
    var serviceproviderPassword by remember { mutableStateOf(value = "") }
    var serviceproviderShowPassword by remember { mutableStateOf(value = false) }
    var serviceproviderIsChecked by remember { mutableStateOf(value = false) }


    val options = listOf("Carpenter", "blacksmith", "plumbing", "car mechanic")

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true

                ),
            value = serviceproviderFullName,
            onValueChange = { value -> serviceproviderFullName = value },
            label = { Text(text = "Full Name") },
            placeholder = {
                Text(text = "Name")

            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff0E4DFB),
                unfocusedBorderColor = Color(0xffF0F0F0),
                unfocusedLabelColor = Color(0xffC2CECE),
                disabledPlaceholderColor = Color(0xffC2CECE),
                trailingIconColor = Color(0xffC2CECE)
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true

                ),
            value = serviceproviderEmail, onValueChange = { value -> serviceproviderEmail = value },
            label = { Text(text = "Email") },

            placeholder = { Text(text = "Email") },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff0E4DFB),
                unfocusedBorderColor = Color(0xffF0F0F0),
                unfocusedLabelColor = Color(0xffC2CECE),
                disabledPlaceholderColor = Color(0xffC2CECE),
                trailingIconColor = Color(0xffC2CECE)
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )


        Spacer(modifier = Modifier.height(10.dp))

        CountryCode()

        Spacer(modifier = Modifier.height(5.dp))



        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 0.dp,
                    shape = RoundedCornerShape(6.dp),
                    clip = true
                ),
            value = serviceproviderPassword,
            onValueChange = { value -> serviceproviderPassword = value },
            label = { Text(text = "password") },

            placeholder = { Text(text = "password") },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color(0xffF2F6F6),
                focusedBorderColor = Color(0xff0E4DFB),
                unfocusedBorderColor = Color(0xffF0F0F0),
                unfocusedLabelColor = Color(0xffC2CECE),
                disabledPlaceholderColor = Color(0xffC2CECE),
                trailingIconColor = Color(0xffC2CECE)
            ),
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


        Spacer(modifier = Modifier.height(5.dp))



        ExposedDropdownMenuBox(

            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(

                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 0.dp,
                        shape = RoundedCornerShape(6.dp),
                        clip = true
                    ),

                value = selectedOptionText,
                onValueChange = { },
                readOnly = true,
                label = { Text("Service Type") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color(0xffF2F6F6),
                    focusedBorderColor = Color(0xff0E4DFB),
                    unfocusedBorderColor = Color(0xffF0F0F0),
                    unfocusedLabelColor = Color(0xffC2CECE),
                    disabledPlaceholderColor = Color(0xffC2CECE),
                    trailingIconColor = Color(0xffC2CECE)
                ),
            )

            ExposedDropdownMenu(

                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {

            CircleCheckbox(selected = serviceproviderIsChecked, onChecked = {
                serviceproviderIsChecked = !serviceproviderIsChecked
            })

            TextButton(onClick = {}) {
                Text(
                    text = "Home Service Terms&Conditions",
                    style = TextStyle(fontSize = 12.sp),
                    color = Color(0xff0E4DFB)
                )

            }


        }

        Spacer(modifier = Modifier.height(30.dp))

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
                    text = " Have Account?", style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                    )
                )
                TextButton(onClick = {}) {
                    Text(
                        text = "SIGN IN",
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
                    text = "SIGN UP",
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

        Text(text = "I Read and Accept", style = TextStyle(fontSize = 12.sp))


    }
}

@Composable
private fun CountryCode() {


    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
    var isNumberValid: Boolean by rememberSaveable { mutableStateOf(false) }


    TogiCountryCodePicker(
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xff0E4DFB),
            cursorColor = Color(0xffAF8344),
            backgroundColor = Color(0xffF2F6F6)
        ),
        shape = RoundedCornerShape(8.dp),
        showPlaceholder = true,
        onValueChange = { (code, phone), isValid ->
            Log.d("CCP", "onValueChange: $code $phone -> $isValid")
            phoneNumber.value = phone
            fullPhoneNumber.value = code + phone
            isNumberValid = isValid
        },

        )

}
