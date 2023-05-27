package com.example.workgraduateproject.view

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workgraduateproject.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChoiceCardScreen() {

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
                                text = "Smith",
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

                val stroke = Stroke(
                    width = 2f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
                )

                Box(modifier = Modifier.fillMaxWidth()) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 8.dp, end = 8.dp)
                            .clickable(enabled = true, onClick = {}),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = ""
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Image Problem",
                            textAlign = TextAlign.Center
                        )

                    }


                    Canvas(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        drawRoundRect(
                            color = Color(0xff0E4DFB),
                            style = stroke,
                            cornerRadius = CornerRadius(x = 13F, y = 13F)
                        )

                    }


                }

                Text(modifier = Modifier.padding(vertical = 13.dp), text = "image must be no more than 2 MB Max 5 Image", color = Color(0xff7F8FA6), fontSize = 11.sp)

                Spacer(modifier = Modifier.height(40.dp))

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
                


            }

            Button(
                onClick = {
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