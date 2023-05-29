package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.workgraduateproject.R
import com.example.workgraduateproject.navigation.Screens
import com.togitech.ccp.component.TogiCountryCodePicker

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LocationScreen(navController: NavController){

    Scaffold(

        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .paint(
                        painterResource(id = R.drawable.choicecardbackground),
                        contentScale = ContentScale.Crop
                    ),
                content = {
                    Box(contentAlignment = Alignment.CenterStart) {

                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Location",
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 20.sp),
                                color = Color.White
                            )
                        }


                        IconButton(modifier = Modifier,
                            onClick = {/* Do Something*/ }, content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.back),
                                    null,
                                    tint = Color.White
                                )
                            })

                    }

                },

                )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp, horizontal = 15.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {



                Image(modifier = Modifier.fillMaxWidth(),painter = painterResource(id = R.drawable.map), contentDescription = "", contentScale = ContentScale.Crop)

                Spacer(modifier = Modifier.height(25.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text ="More Details About Problem …..." ) },
                    minLines = 7,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color(0xff0E4DFB),
                        focusedBorderColor = Color(0xff0E4DFB),

                        ),
                    value = "", onValueChange = {},
                )

                Spacer(modifier = Modifier.height(25.dp))

                CountryCode()




            }

            Button(
                onClick = {
                          navController.navigate(Screens.AddOrderScreen.OrderDone.route)
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(50.dp)
                    .shadow(
                        elevation = 10.dp,
                        ambientColor = Color(0xffE9C75E),
                        spotColor = Color(0xffE9C75E),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .background(
                        color = Color(0xff222328)
                    ),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(0.dp, pressedElevation = 0.dp)

            ) {
                Text(
                    text = "NEXT",
                    color = Color.White,

                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
                )
            }

        }


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