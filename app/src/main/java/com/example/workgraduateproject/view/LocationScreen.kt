package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import android.net.Uri
import android.preference.PreferenceManager
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.workgraduateproject.R
import com.example.workgraduateproject.FileHelper
import com.example.workgraduateproject.navigation.Screens
import com.example.workgraduateproject.viewModel.AddOrderViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.togitech.ccp.component.TogiCountryCodePicker

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LocationScreen(navController: NavController, workId: Int, details: String, imagesGson: String) {

    val addOrder = viewModel<AddOrderViewModel>()

    val context = LocalContext.current
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    val token = sharedPreferences.getString("token", "")

    var locationDetails by remember { mutableStateOf(value = "") }
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
    var isNumberValid: Boolean by rememberSaveable { mutableStateOf(false) }


    val singapore = LatLng(312459.99, 341960.00)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 3f)
    }


//    Toast
//        .makeText(
//            LocalContext.current,
//            " Work ID; ${workId} \n details: ${details} \n Images: ${imagesGson}",
//            Toast.LENGTH_LONG
//        )
//        .show()


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
                            onClick = {
                                navController.popBackStack()

                            }, content = {
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


//                Image(
//                    modifier = Modifier.fillMaxWidth(),
//                    painter = painterResource(id = R.drawable.map),
//                    contentDescription = "",
//                    contentScale = ContentScale.Crop
//                )


                GoogleMap(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .shadow(0.dp, shape = RoundedCornerShape(15.dp), clip = true),
                    cameraPositionState = cameraPositionState,
                ) {
                    Marker(
                        state = MarkerState(position = singapore),
                        title = "Gaza",
                        snippet = "Marker"
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "More Details About Problem …...") },
                    minLines = 7,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color(0xff0E4DFB),
                        focusedBorderColor = Color(0xff0E4DFB),

                        ),
                    value = locationDetails, onValueChange = { value -> locationDetails = value },
                )

                Spacer(modifier = Modifier.height(25.dp))

//                CountryCode()

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

            Button(
                onClick = {
                    val imagesJson =
                        FileHelper.convertStringToList(Uri.decode(imagesGson))  //imagesGson
                    val imageFiles = FileHelper.mapPathsToFiles(imagesJson)

                    Log.d("imagesJson", imagesJson.joinToString())

                    if (token.toString().isNotEmpty() && token != null) {
                        if (locationDetails.isNotEmpty()){
                            if (phoneNumber.value.isNotEmpty()){
                                addOrder.addOrderPost(
                                    workId,
                                    details,
                                    locationDetails,
                                    imageFiles,
                                    phoneNumber.value,
                                    312459.99f,
                                    341960.00f,
                                    token.toString()

                                )

                                Toast.makeText(
                                    context,
                                    "Order Added Successfully",
                                    Toast.LENGTH_LONG
                                ).show()


                                navController.navigate(Screens.AddOrderScreen.OrderDone.route)
                            }else{
                                Toast.makeText(
                                    context,
                                    "Please Check Your Phone Number",
                                    Toast.LENGTH_LONG
                                ).show()

                            }

                        }else{

                            Toast.makeText(
                                context,
                                "Please Add Your Location Details",
                                Toast.LENGTH_LONG
                            ).show()

                        }



                    } else {

                        Toast.makeText(
                            context,
                            "If you need to create Order Please You need To Authentication ",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate(Screens.AuthScreens.Login.route)

                    }


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

                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                )
            }

        }


    }

}


//@Composable
//private fun CountryCode() {
//
//
//    val phoneNumber = rememberSaveable { mutableStateOf("") }
//    val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
//    var isNumberValid: Boolean by rememberSaveable { mutableStateOf(false) }
//
//
//    TogiCountryCodePicker(
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = Color(0xff0E4DFB),
//            cursorColor = Color(0xffAF8344),
//            backgroundColor = Color(0xffF2F6F6)
//        ),
//        shape = RoundedCornerShape(8.dp),
//        showPlaceholder = true,
//        onValueChange = { (code, phone), isValid ->
//            Log.d("CCP", "onValueChange: $code $phone -> $isValid")
//            phoneNumber.value = phone
//            fullPhoneNumber.value = code + phone
//            isNumberValid = isValid
//        },
//
//        )
//
//}