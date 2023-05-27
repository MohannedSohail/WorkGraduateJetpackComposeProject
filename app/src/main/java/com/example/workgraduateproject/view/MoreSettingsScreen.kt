package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workgraduateproject.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MoreSettings(){
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
                                text = "More",
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
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 15.dp, horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MySettingsItem("Change Password",false)
            MySettingsItem("FAQ's",false)
            MySettingsItem("Terms & Conditions",false)
            MySettingsItem("Privacy Policy",false)
            MySettingsItem("Rate App",false)
            MySettingsItem("Delete Account",false)



        }

    }
}